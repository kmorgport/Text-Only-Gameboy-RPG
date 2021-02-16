package Gameplay;

import items.Items;
import moves.Moves;
import pokemon.Pokemon;
import trainers.Trainer;
import util.Input;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;

public class Battle {
    protected Input consoleEntry = new Input();
    public Battle(){

    }

    public void startBattle(Trainer player, Trainer npc){
        Pokemon playerPokemon = player.retrieveTeamStarter();
        Pokemon rivalPokemon = npc.retrieveTeamStarter();
        battleCycle(player,npc);
    }

    public void battleCycle(Trainer protagonist, Trainer rival){
        Pokemon player = protagonist.retrieveTeamStarter();
        Pokemon npc = rival.retrieveTeamStarter();
        System.out.println(rival.getName() + " sent out " + npc.getName() + "!");
        System.out.println("Go! " + player.getName() + "!");
        while(true) {
            if(npc.getHitPoints()<=0){
                System.out.println(npc.getName() + " fainted!");
                break;
            }
            if(player.getHitPoints()<=0){
                System.out.println(player.getName() + " fainted!");
                break;
            }
            if (player.getSpeed() > npc.getSpeed()) {
                playerTurn(protagonist, rival);
                if (player.getHitPoints() <= 0) {
                    System.out.println(player.getName() + " fainted!");
                    break;
                } else if (npc.getHitPoints() <= 0) {
                    System.out.println(npc.getName() + " fainted!");
                    break;
                }
                npcTurn(player, npc);
            } else if(player.getSpeed() < npc.getSpeed()){
                npcTurn(player, npc);
                if (player.getHitPoints() <= 0) {
                    System.out.println(player.getName() + " fainted!");
                    break;
                } else if (npc.getHitPoints() <= 0) {
                    System.out.println(npc.getName() + " fainted!");
                    break;
                }
                playerTurn(protagonist, rival);
            }
        }
//        return winner;
    }

    public void playerTurn(Trainer protagonist, Trainer rival){
        Pokemon player = protagonist.retrieveTeamStarter();
        Pokemon npc = rival.retrieveTeamStarter();
        Moves[] moveList = player.pullMoveList();
        int accuracyRandom = (int) Math.floor(Math.random()*125);
        System.out.println("What would you like to do?");
        System.out.println("");
        System.out.println("---FIGHT---ITEM---PKMN---RUN---");
        String answ = consoleEntry.getString();
        switch(answ.toLowerCase()){
            case "fight":
                System.out.println("---" + moveList[0].name + "---" + moveList[1].name + "---" + moveList[2].name + "---");
                answ = consoleEntry.getString();
                for(Moves move: moveList){
                    if(move.name.toLowerCase().contains(answ.toLowerCase())){
                        if(move.category.equals("Physical")) {
                            if(accuracyRandom<=calculateAccuracy(player,move,npc)){
                                playerAttack(player, move, npc);
                            }else{
                                System.out.println(player.getName() + " used " + move.getName() + "!");
                                System.out.println("The attack missed!");
                            }
                            break;
                        }else if(move.category.equals("Special")){
                            if(accuracyRandom<=calculateAccuracy(player,move,npc)){
                                playerSpecialAttack(player,move,npc);
                            }else{
                                System.out.println(player.getName() + " used " + move.getName() + "!");
                                System.out.println("The attack missed!");
                            }
                            break;
                        }else if(move.category.equals("Debuff")){
                            buffDeBuff(player,move, npc);
                        }else if(move.category.equals("Buff")){
                            buffDeBuff(player,move, player);
                        }
                    }
//                    else{
//                        System.out.println(player.getName() + " does not know a move named " + answ + "!");
////                        return playerTurn();  -- once finished out, fill in with arguments to create recursion
//                    }
                }
                break;
            case "item":
                useRecoveryItems(protagonist,rival);
                break;
            case "pkmn":
                System.out.println("You only have " + player.getName() + "!");
                playerTurn(protagonist,rival);
            case "run":
                System.out.println("You can't run from Trainer battles!");
                playerTurn(protagonist,rival);
        }
    }

    public void viewItems(Trainer protagonist){

    }

    public void useRecoveryItems(Trainer protagonist, Trainer rival){
        protagonist.mapIterator(protagonist.getMedicine());
        System.out.println("\n");
        System.out.println("Which recovery item would you like to use?");
        System.out.println(" ");
        String answ = consoleEntry.getString().toUpperCase();
        Items item = protagonist.getMedicine().get(answ);
        if(item.getHealthRecoveryAmount()>0){
            Pokemon currentPokemon = protagonist.retrieveTeamStarter();
            if(currentPokemon.getHitPoints()==currentPokemon.getMaxHitPoints()){
                System.out.println(currentPokemon.getName() + "is at max HP, cannot heal any further!");
                playerTurn(protagonist,rival);
            }
            if(currentPokemon.getHitPoints()+item.getHealthRecoveryAmount()>=currentPokemon.getMaxHitPoints()){
                currentPokemon.setHitPoints(currentPokemon.getMaxHitPoints());
                System.out.println(currentPokemon.getName() + "has been recovered to max health!");
                item.setQuantity(-1);
                System.out.println(item.getQuantity());
                if(item.getQuantity()<=0){
                    protagonist.getMedicine().remove(answ);
                }
            }else{
                currentPokemon.setHitPoints(currentPokemon.getHitPoints()+ item.getHealthRecoveryAmount());
                System.out.println(currentPokemon.getName() + "has been healed for " + item.getHealthRecoveryAmount());
                System.out.println(currentPokemon.getName() + " has " + currentPokemon.getHitPoints() + "!");
                item.setQuantity(-1);
                if(item.getQuantity()<=0){
                    protagonist.getMedicine().remove(answ);
                }
            }
        }else{
            System.out.println(item.getStatusRecovery());}


    }


    public void npcTurn(Pokemon player, Pokemon npc){
        int accuracyRandom = (int) Math.floor(Math.random()*125);
        Moves[] moveList = npc.pullMoveList();
        int moveRandom = (int) Math.floor(Math.random()*3);
        Moves npcMove = moveList[moveRandom];
        if(npcMove.category.equals("Buff")){
            buffDeBuff(npc,npcMove,npc);
        }else if(npcMove.category.equals("Debuff")){
            buffDeBuff(npc,npcMove,player);
        }
        else if(npcMove.category.equals("Physical")){
            if(accuracyRandom<=calculateAccuracy(npc,npcMove,player)) {
                playerAttack(npc, npcMove, player);
            }else{
                System.out.println(npc.getName() + " used " + npcMove.getName() + "!");
                System.out.println("The attack missed!");
            }
        }else if(npcMove.category.equals("Special")){
            if(accuracyRandom<=calculateAccuracy(npc,npcMove,player)){
                playerSpecialAttack(npc,npcMove,player);
            }else{
                System.out.println(npc.getName() + " used " + npcMove.getName() + "!");
                System.out.println("The attack missed!");
            }
        }


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

    public int calculateAccuracy(Pokemon attacker, Moves move, Pokemon defender){
        return (int) (move.getAccuracy()*accuracyConverter(attacker.getAccuracyInteger())*evasionConverter(defender.getEvasionInteger()));

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

//    public int calculatePhysicalOrSpecial(Moves move, Pokemon pokemon){
//        if(move.getCategory().equals("Physical")){
//            double rando
//            double modifier = getModifier()
//            calculateDamage(pokemon.getLevel(),move.getPower(),pokemon.getAttack(),pokemon.getDefense(), modifier);
//        }
//    }
}
