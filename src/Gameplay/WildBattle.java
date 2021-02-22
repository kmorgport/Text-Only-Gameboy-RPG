package Gameplay;

import items.Items;
import moves.Moves;
import pokemon.Pokemon;
import trainers.Trainer;
import util.Input;

import java.util.ArrayList;
import java.util.Scanner;

public class WildBattle {
    protected Input consoleEntry = new Input();
    protected Scanner scanner = new Scanner(System.in);
    public WildBattle(){};

    public boolean wildPokemonBattle(Trainer player, Pokemon pokemon){
        System.out.println("A wild " + pokemon.getName() + " appeared!!");
        Pokemon playerPokemon = player.retrieveTeamStarter();
        commenceBattle(player,pokemon);
        while(true){
            revisedBattleCycle(player, pokemon);
            if(playerPokemon.getHitPoints()<=0){
                System.out.println(playerPokemon.getName() + " fainted!");
                return false;
            }else if(pokemon.getHitPoints()<=0){
                playerPokemon.earnEVS(pokemon.getExpVal());
                int exp = Pokemon.calcExpGained(true,true,pokemon.getBaseExp(),pokemon.getLevel(),1);
                System.out.println(pokemon.getName() + " fainted!");
                System.out.println(playerPokemon.getName() + " earned "+exp+" experience points!");
                playerPokemon.levelUp(exp);
                return true;
            }
        }
    }

    public void commenceBattle(Trainer player, Pokemon pokemon){
        Pokemon playerPokemon = player.retrieveTeamStarter();
        resetBattleStatValue(playerPokemon);
        resetBattleStatValue(pokemon);
    }

    public void resetBattleStatValue(Pokemon pokemon){
        pokemon.setBattleAttack(pokemon.getAttack());
        pokemon.setBattleDefense(pokemon.getDefense());
        pokemon.setBattleSpecialAttack(pokemon.getSpecialAttack());
        pokemon.setBattleSpecialDefense(pokemon.getSpecialDefense());
        pokemon.setBattleSpeed(pokemon.getSpeed());
        pokemon.setBattleEvasion(100);
        pokemon.setBattleAccuracy(100);

    }

    public void revisedBattleCycle(Trainer player, Pokemon pokemon){
        Pokemon playerPokemon = player.retrieveTeamStarter();
        System.out.println("What will you do?");
        label:
        while(true){
            System.out.println("--FIGHT--ITEM--PKMN--RUN--");
            String answ = consoleEntry.getString();
            if(answ.isEmpty()){
                System.out.println("Please choose an option");
            }
            switch (answ.toUpperCase()) {
                case "ITEM":
                    boolean useItem = revisedRecoveryItem(player);
                    if (useItem) {
                        Moves npcMove = npcMoveSelection(pokemon);
                        wildPokemonTurn(pokemon, npcMove, player);
                        break label;
                    } else {
                        System.out.println("What will you do?");
                    }
                    break;
                case "PKMN":
                    System.out.println("You only have one POKEMON!");
                    System.out.println("What will you do?");
                    System.out.println(" ");
                    break;
                case "RUN":
                    System.out.println("You can't run from TRAINER battles!");
                    System.out.println("What will you do?");
                    System.out.println(" ");
                    break;
                case "FIGHT":
                    Moves playerMove = playerMoveSelection(player);
                    Moves npcMove = npcMoveSelection(pokemon);
                    if (playerMove == null) {
                        System.out.println("What will you do?");
                    } else if (playerMove.priority > npcMove.priority) {
                        revisedTurn(player, playerMove, pokemon);
                        if (playerPokemon.getHitPoints() <= 0 || pokemon.getHitPoints() <= 0) {
                            break label;
                        }
                        wildPokemonTurn(pokemon, npcMove, player);
                        System.out.println(" ");
                        break label;
                    } else if (npcMove.priority > playerMove.priority) {
                        wildPokemonTurn(pokemon, npcMove, player);
                        if (playerPokemon.getHitPoints() <= 0 || pokemon.getHitPoints() <= 0) {
                            break label;
                        }
                        revisedTurn(player, playerMove, pokemon);
                        System.out.println(" ");
                        break label;
                    } else if (player.retrieveTeamStarter().getBattleSpeed() > pokemon.getBattleSpeed()) {
                        revisedTurn(player, playerMove, pokemon);
                        if (playerPokemon.getHitPoints() <= 0 || pokemon.getHitPoints() <= 0) {
                            break label;
                        }
                       wildPokemonTurn(pokemon, npcMove, player);
                        break label;
                    } else if (pokemon.getBattleSpeed() > player.retrieveTeamStarter().getBattleSpeed()) {
                        wildPokemonTurn(pokemon, npcMove, player);
                        if (playerPokemon.getHitPoints() <= 0 || pokemon.getHitPoints() <= 0) {
                            break label;
                        }
                        revisedTurn(player, playerMove, pokemon);
                        break label;
                    }


                    break;
                default:
                    System.out.println("Ooops, there was a typo");
                    System.out.println("What will you do?");
                    break;
            }
        }
    }

    public void revisedTurn(Trainer attacker, Moves playerMove, Pokemon pokemon){
        Pokemon attackingPokemon = attacker.retrieveTeamStarter();
        int accuracyRandom = (int) Math.floor(Math.random()*125);
        switch (playerMove.category) {
            case "Physical":
                if (accuracyRandom <= calculateAccuracy(attackingPokemon, playerMove, pokemon)) {
                    playerAttack(attackingPokemon, playerMove, pokemon);
                } else {
                    System.out.println(attackingPokemon.getName() + " used " + playerMove.name + "!");
                    System.out.println("The attack missed!");
                    scanner.nextLine();
                }
                break;
            case "Special":
                if (accuracyRandom <= calculateAccuracy(attackingPokemon, playerMove, pokemon)) {
                    playerSpecialAttack(attackingPokemon, playerMove, pokemon);
                } else {
                    System.out.println(attackingPokemon.getName() + " used " + playerMove.name + "!");
                    System.out.println("The attack missed!");
                    scanner.nextLine();
                }
                break;
            case "Debuff":
                buffDeBuff(attackingPokemon, playerMove, pokemon);
                break;
            case "Buff":
                buffDeBuff(attackingPokemon, playerMove, attackingPokemon);
                break;
        }
    }

    public void wildPokemonTurn(Pokemon attacker, Moves playerMove, Trainer defender){
        Pokemon defendingPokemon = defender.retrieveTeamStarter();
        int accuracyRandom = (int) Math.floor(Math.random()*125);
        switch (playerMove.category) {
            case "Physical":
                if (accuracyRandom <= calculateAccuracy(attacker, playerMove, defendingPokemon)) {
                    playerAttack(attacker, playerMove, defendingPokemon);
                } else {
                    System.out.println(attacker.getName() + " used " + playerMove.name + "!");
                    System.out.println("The attack missed!");
                    scanner.nextLine();
                }
                break;
            case "Special":
                if (accuracyRandom <= calculateAccuracy(attacker, playerMove, defendingPokemon)) {
                    playerSpecialAttack(attacker, playerMove, defendingPokemon);
                } else {
                    System.out.println(attacker.getName() + " used " + playerMove.name + "!");
                    System.out.println("The attack missed!");
                    scanner.nextLine();
                }
                break;
            case "Debuff":
                buffDeBuff(attacker, playerMove, defendingPokemon);
                break;
            case "Buff":
                buffDeBuff(attacker, playerMove, attacker);
                break;
        }
    }

    public Moves npcMoveSelection(Pokemon pokemon){
        int lengthOfNpcMoveList = pokemon.pullMoveArrayList().size();
        int moveRandom = (int) Math.floor(Math.random()*lengthOfNpcMoveList);
        return pokemon.pullMoveArrayList().get(moveRandom);
    }

    public Moves playerMoveSelection(Trainer player){
        Moves playerMove;
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Moves> moveList = player.retrieveTeamStarter().pullMoveArrayList();
        StringBuilder printMoves = new StringBuilder();
        for (Moves move : moveList) {
            printMoves.append("---").append(move.name.toUpperCase());
            names.add(move.name.toLowerCase());
        }
        printMoves.append("---BACK");
        while(true){
            System.out.println(printMoves.toString());
            String answ = consoleEntry.getString();
            if(answ.isEmpty()){
            }
            if(answ.toLowerCase().equals("back")){
                return null;
            }
            if(!names.contains(answ.toLowerCase())){
                System.out.println("PROF LIVEOAK: " + player.retrieveTeamStarter().getName() + " doesn't understand that command! Try again!");
            }else{
                for(Moves move: moveList){
                    if(move.name.toLowerCase().contains(answ.toLowerCase())){
                        playerMove = move;
                        return playerMove;
                    }
                }
            }
        }
    }

    public boolean revisedRecoveryItem(Trainer player){
        player.mapIterator(player.getMedicine());
        System.out.println("\n");
        System.out.println("Which recovery item would you like to use?");
        System.out.println(" ");
        while(true){
            String answ = consoleEntry.getString().toUpperCase();
            Items item = player.getMedicine().get(answ);
            if(answ.isEmpty()){
                System.out.println("Which recovery item would you like to use?");
            }else if(answ.equals("BACK")){
                return false;
            }else if(item.getHealthRecoveryAmount()>0){
                Pokemon currentPokemon = player.retrieveTeamStarter();
                if(currentPokemon.getHitPoints()==currentPokemon.getMaxHitPoints()){
                    //prevents HP from being healed higher than max HP for current level
                    System.out.println(currentPokemon.getName() + "is at max HP, cannot heal any further!");
                    return false;
                }
                if(currentPokemon.getHitPoints()+item.getHealthRecoveryAmount()>=currentPokemon.getMaxHitPoints()){
                    currentPokemon.setHitPoints(currentPokemon.getMaxHitPoints());
                    System.out.println("You used " + item.getName() + "!");
                    System.out.println(currentPokemon.getName() + " has been recovered to max health!");
                    item.setQuantity(-1);
                    if(item.getQuantity()<=0){
                        //removes item from inventory if quantity is less or equal to 0;
                        player.getMedicine().remove(answ);
                    }
                    return true;
                }else{
                    currentPokemon.setHitPoints(currentPokemon.getHitPoints()+ item.getHealthRecoveryAmount());
                    System.out.println("You used " + item.getName() + "!");
                    System.out.println(currentPokemon.getName() + "has been healed for " + item.getHealthRecoveryAmount());
                    System.out.println(currentPokemon.getName() + " has " + currentPokemon.getHitPoints() + "!");
                    item.setQuantity(-1);
                    if(item.getQuantity()<=0){
                        //removes item from inventory if quantity is less or equal to 0;
                        player.getMedicine().remove(answ);
                    }
                    return true;
                }
            }
            //else{status recovery here}
        }
    }

    public void playerAttack(Pokemon attacker, Moves move , Pokemon defender){
        int type = (int) moveTypeDeterminer(move.type,defender);
        double stab = determineStab(attacker.types,move.type);
        double critRando = Math.floor(Math.random()*100);
        int crit = determineCriticalHit(critRando);
        double random =  (Math.random()*.15)+.85;
        double burn = 1.0;
        double modifier = getModifier(crit,random,stab,type,burn);
        //need to code modifier to 'super effective' message
        System.out.println(attacker.getName() + " used " + move.name + "!");
        if(type>1){
            System.out.println("It was super effective!");
        }else if(type<1){
            System.out.println("It wasn't very effective...");
        }
        int damage = (int) Math.round(calculateDamage(attacker.getLevel(),move.power,attacker.getAttack(),defender.getDefense(),modifier)+1);
        System.out.println(attacker.getName() + " hit " + defender.getName() + " for " + damage + " points of damage!");
        defender.setHitPoints(defender.getHitPoints()-damage);
//        npc.setHitPoints(npc.getHitPoints()-damage);
        if(defender.getHitPoints()<=0){

        }else {
            System.out.println(defender.getName() + " has " + defender.getHitPoints() + " remaining!");
        }
    }

    public void playerSpecialAttack(Pokemon attacker, Moves move , Pokemon defender){
        double type = moveTypeDeterminer(move.type,defender);
        double stab = determineStab(attacker.types,move.type);
        double critRando = Math.floor(Math.random()*100);
        int crit = determineCriticalHit(critRando);
        double random =  (Math.random()*.15)+.85;
        double burn = 1.0;
        double modifier = getModifier(crit,random,stab,type,burn);
        //need to code modifier to 'super effective' message
        System.out.println(attacker.getName() + " used " + move.name + "!");
        if(type>1){
            System.out.println("It was super effective!");
        }else if(type<1){
            System.out.println("It wasn't very effective...");
        }
        int damage = (int) Math.round(calculateDamage(attacker.getLevel(),move.power,attacker.getSpecialAttack(),defender.getSpecialDefense(),modifier)+1);
        System.out.println(attacker.getName() + " hit " + defender.getName() + " for " + damage + " points of damage!");
        defender.setHitPoints(defender.getHitPoints()-damage);
//        npc.setHitPoints(npc.getHitPoints()-damage);
        if(defender.getHitPoints()<=0){

        }else {
            System.out.println(defender.getName() + " has " + defender.getHitPoints() + " remaining!");
        }
    }


    //agent and patient are similar to ergative grammatical concepts so that this method can be used in both stat buffing and stat debuffing Scenarios. For buffing, agent and patient are identical, for debuffing agent and patient are the attacker and defender respectively.
    public void buffDeBuff(Pokemon agent, Moves move, Pokemon patient){
        double modifier = 1;
        System.out.println(agent.getName() + " used " + move.getName());
        switch(move.buffDebuffType){
            case "Attack":
                if(patient.getAttackInteger()==-6){
                    System.out.println(patient.getName() + "'s " + move.buffDebuffType + " can't be lowered any further!"); }
                if(patient.getAttackInteger()==6){
                    System.out.println(patient.getName() + "'s " + move.buffDebuffType + " can't be raised any further!"); }
                patient.setAttackInteger(patient.getAttackInteger()+move.buffDebuffInteger);
                System.out.println(patient.getName() + "'s attack" + buffDebuffMessage(move.buffDebuffInteger));
                modifier = integerConverter(patient.getAttackInteger());
                patient.setBattleAttack((int) (patient.getAttack()*modifier));
                break;
            case "Defense":
                if(patient.getDefenseInteger()==-6){
                    System.out.println(patient.getName() + "'s " + move.buffDebuffType + " can't be lowered any further!"); }
                if(patient.getDefenseInteger()==6){
                    System.out.println(patient.getName() + "'s " + move.buffDebuffType + " can't be raised any further!"); }
                patient.setDefenseInteger(patient.getDefenseInteger()+move.buffDebuffInteger);
                System.out.println(patient.getName() + "'s defense" + buffDebuffMessage(move.buffDebuffInteger));
                modifier = integerConverter(patient.getDefenseInteger());
                patient.setBattleDefense((int) (patient.getDefense()*modifier));
                break;
            case "SpecAttack":
                if(patient.getSpecialAttackInteger()==-6){
                    System.out.println(patient.getName() + "'s " + move.buffDebuffType + " can't be lowered any further!"); }
                if(patient.getSpecialAttackInteger()==6){
                    System.out.println(patient.getName() + "'s " + move.buffDebuffType + " can't be raised any further!"); }
                patient.setSpecialAttackInteger(patient.getSpecialAttackInteger()+move.buffDebuffInteger);
                System.out.println(patient.getName() + "'s special attack" + buffDebuffMessage(move.buffDebuffInteger));
                modifier = integerConverter(patient.getSpecialAttackInteger());
                patient.setBattleSpecialAttack((int) (patient.getSpecialAttack()*modifier));
                break;
            case "SpecDefense":
                if(patient.getSpecialDefenseInteger()==-6){
                    System.out.println(patient.getName() + "'s " + move.buffDebuffType + " can't be lowered any further!"); }
                if(patient.getSpecialDefenseInteger()==6){
                    System.out.println(patient.getName() + "'s " + move.buffDebuffType + " can't be raised any further!"); }
                patient.setSpecialDefenseInteger(patient.getSpecialDefenseInteger()+move.buffDebuffInteger);
                System.out.println(patient.getName() + "'s special defense" + buffDebuffMessage(move.buffDebuffInteger));
                modifier = integerConverter(patient.getSpecialAttackInteger());
                patient.setBattleSpecialDefense((int) (patient.getSpecialDefense()*modifier));
                break;
            case "Speed":
                if(patient.getSpeedInteger()==-6){
                    System.out.println(patient.getName() + "'s " + move.buffDebuffType + " can't be lowered any further!"); }
                if(patient.getSpeedInteger()==6){
                    System.out.println(patient.getName() + "'s " + move.buffDebuffType + " can't be raised any further!"); }
                patient.setSpeedInteger((patient.getSpeedInteger()+move.buffDebuffInteger));
                System.out.println(patient.getName() + "'s speed" + buffDebuffMessage(move.buffDebuffInteger));
                modifier = integerConverter(patient.getSpeedInteger());
                patient.setBattleSpeed((int) (patient.getSpeed()*modifier));
                break;
            case "Evasion":
                if(patient.getEvasionInteger()==-6){
                    System.out.println(patient.getName() + "'s " + move.buffDebuffType + " can't be lowered any further!"); }
                if(patient.getEvasionInteger()==6){
                    System.out.println(patient.getName() + "'s " + move.buffDebuffType + " can't be raised any further!"); }
                patient.setSpeedInteger((patient.getEvasionInteger()+move.buffDebuffInteger));
                System.out.println(patient.getName() + "'s evasion" + buffDebuffMessage(move.buffDebuffInteger));
                modifier = evasionConverter(patient.getEvasionInteger());
                patient.setBattleEvasion((int) (patient.getEvasion()*modifier));
                break;
            case "Accuracy":
                if(patient.getAccuracyInteger()==-6){
                    System.out.println(patient.getName() + "'s " + move.buffDebuffType + " can't be lowered any further!"); }
                if(patient.getAccuracyInteger()==6){
                    System.out.println(patient.getName() + "'s " + move.buffDebuffType + " can't be raised any further!"); }
                patient.setAccuracyInteger((patient.getAccuracyInteger()+move.buffDebuffInteger));
                System.out.println(patient.getName() + "'s accuracy" + buffDebuffMessage(move.buffDebuffInteger));
                modifier = accuracyConverter(patient.getAccuracyInteger());
                patient.setBattleAccuracy((int) (patient.getAccuracy()*modifier));
                break;

        }
    }


    public String buffDebuffMessage(int number){
        switch(number){
            case 1:
                return " rose!";
            case 2:
                return " greatly rose!";
            case -1:
                return " fell!";
            case -2:
                return " greatly fell!";
            default:
                return " you should never see this";
        }
    }

    public double integerConverter(int buffDeBuffInteger){
        double modifier = 0.0;
        switch(buffDeBuffInteger){
            case -6:
                modifier = 0.25;
                break;
            case -5:
                modifier = 0.28;
                break;
            case -4:
                modifier = 0.33;
                break;
            case -3:
                modifier = 0.40;
                break;
            case -2:
                modifier = 0.50;
                break;
            case -1:
                modifier = 0.66;
                break;
            case 0:
                modifier = 1;
                break;
            case 1:
                modifier = 1.5;
                break;
            case 2:
                modifier = 2;
                break;
            case 3:
                modifier = 2.5;
                break;
            case 4:
                modifier = 3;
                break;
            case 5:
                modifier = 3.5;
                break;
            case 6:
                modifier = 4;
                break;
        }
        return modifier;
    }


    public int calculateAccuracy(Pokemon attacker, Moves move, Pokemon defender){
        return (int) (move.getAccuracy()*accuracyConverter(attacker.getAccuracyInteger())*evasionConverter(defender.getEvasionInteger()));

    }

    public double evasionConverter(int buffDeBuffInteger){
        double modifier = 1;
        switch(buffDeBuffInteger){
            case -6:
                modifier = 3.0;
                break;
            case -5:
                modifier = 2.66;
                break;
            case -4:
                modifier = 2.33;
                break;
            case -3:
                modifier = 2.0;
                break;
            case -2:
                modifier = 1.66;
                break;
            case -1:
                modifier = 1.33;
                break;
            case 0:
                modifier = 1;
                break;
            case 1:
                modifier = 0.75;
                break;
            case 2:
                modifier = 0.6;
                break;
            case 3:
                modifier = 0.5;
                break;
            case 4:
                modifier = 0.43;
                break;
            case 5:
                modifier = 0.36;
                break;
            case 6:
                modifier = 0.33;
                break;
        }
        return modifier;
    }

    public double accuracyConverter(int buffDeBuffInteger){
        double modifier = 1;
        switch(buffDeBuffInteger){
            case -6:
                modifier = 0.33;
                break;
            case -5:
                modifier = 0.36;
                break;
            case -4:
                modifier = 0.43;
                break;
            case -3:
                modifier = 0.5;
                break;
            case -2:
                modifier = 0.6;
                break;
            case -1:
                modifier = 0.75;
                break;
            case 0:
                modifier = 1;
                break;
            case 1:
                modifier = 1.33;
                break;
            case 2:
                modifier = 1.66;
                break;
            case 3:
                modifier = 2.0;
                break;
            case 4:
                modifier = 2.33;
                break;
            case 5:
                modifier = 2.66;
                break;
            case 6:
                modifier = 3;
                break;
        }
        return modifier;
    }

    public double moveTypeDeterminer(String moveType, Pokemon npc){
        double type = 0.0;
        switch(moveType.toLowerCase()){
            case "grass":
                type += grassTypeMultiplier(npc.types.get(0),npc.types.get(1));
                break;
            case "fire":
                type += fireTypeMultiplier(npc.types.get(0));
                break;
            case "water":
                type += waterTypeMultiplier(npc.types.get(0));
                break;
            case "normal":
                type += normalTypeMultiplier(npc.types.get(0));
                break;
            case "flying":
                type += flyingTypeMultiplier(npc.types.get(0));
                break;
            default:
                type += 1;

        }
        return type;
    }

    public double grassTypeMultiplier(String type, String type2 ){
        double multiplier = 0;
        switch (type){
            case "Flying":
            case "Poison":
            case "Bug":
            case "Steel":
            case "Fire":
            case "Grass":
            case "Electric":
            case "Dragon":
                multiplier += .5;
                break;
            case "Ground":
            case "Rock":
            case "Water":
                multiplier += 2;
                break;
            default:
                multiplier+= 1;
                break;
        }

        if(type2==null){
            multiplier += 0;
        }else if(type2.equals("Poison")){
            multiplier -=.25;
        }
        return multiplier;
    }

    public double fireTypeMultiplier(String type){
        double multiplier = 0;
        switch(type){
            case "Rock":
            case "Fire":
            case "Water":
            case "Dragon":
                multiplier += 0.5;
                break;
            case "Bug":
            case "Steel":
            case "Grass":
            case "Ice":
                multiplier += 2.0;
                break;
            default:
                multiplier += 1.0;
                break;

        }
        return multiplier;
    }

    public double waterTypeMultiplier(String type){
        double multiplier = 0;
        switch(type){
            case "Water":
            case "Grass":
            case "Dragon":
                multiplier += 0.5;
                break;

            case "Ground":
            case "Rock":
            case "Fire":
                multiplier += 2.0;
                break;
            default:
                multiplier += 1.0;
                break;
        }
        return multiplier;
    }

    public double normalTypeMultiplier(String type){
        double multiplier = 0.0;
        switch(type){
            case "Ghost":
                multiplier += 0.0;
            case "Rock":
            case "Steel":
                multiplier += 0.5;
            default:
                multiplier += 1.0;
        }
        return multiplier;
    }

    public double flyingTypeMultiplier(String type){
        switch(type){
            case "Rock":
            case "Steel":
            case "Electric":
                return .5;
            case "Fighting":
            case "Bug":
            case "Grass":
                return 2;
            default:
                return 1;
        }
    }

    public double calculateDamage(int level,int power, int attack, int defense, double modifier){
        return (((((2*level)/5)+2)*power*(attack/defense)/50)+2)*modifier;
    }

    public double getModifier(int critical, double random, double stab, double type, double burn){
        return critical*random*stab*type*burn;
    }

    public double determineStab(ArrayList<String> types, String attackType){
        if(types.contains(attackType)){
            return 1.5; }
        else {
            return 1.0;
        }
    }

    public int determineCriticalHit(double rando){
        if(rando>0 && rando<=12.5){
            System.out.println("Critical hit!");
            return 2;
        }else{
            return 1;
        }
    }

    public double determineBurn(boolean burn){
        if(burn){
            return .5;
        }else{
            return 1;
        }
    }

}
