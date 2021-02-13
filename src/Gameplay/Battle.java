package Gameplay;

import moves.Moves;
import pokemon.Pokemon;
import trainers.Trainer;
import util.Input;

import java.util.ArrayList;
import java.util.Objects;

public class Battle {
    protected Input consoleEntry = new Input();
    public Battle(){

    }

    public void startBattle(Trainer player, Trainer npc){
        Pokemon playerPokemon = player.retrieveTeamStarter();
        Pokemon rivalPokemon = npc.retrieveTeamStarter();
        int playerHp = playerPokemon.getHitPoints();
        int rivalHp = rivalPokemon.getHitPoints();
        battleCycle(playerPokemon,rivalPokemon);
    }

    public void battleCycle(Pokemon player, Pokemon npc){
        boolean fighting = true;
        boolean winner = true;
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
                playerTurn(player, npc);
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
                playerTurn(player, npc);
            }
        }
//        return winner;
    }

    public void playerTurn(Pokemon player, Pokemon npc){
        Moves[] moveList = player.pullMoveList();
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
                            playerAttack(player, move, npc);
                            break;
                        }else if(move.category.equals("Special")){
                            playerSpecialAttack(player,move,npc);
                            break;
                        }else if(move.category.equals("Debuff")){
                            buffDeBuff(npc,move);
                        }else if(move.category.equals("Buff")){
                            buffDeBuff(player,move);
                        }
                    }
//                    else{
//                        System.out.println(player.getName() + " does not know a move named " + answ + "!");
////                        return playerTurn();  -- once finished out, fill in with arguments to create recursion
//                    }
                }
                break;
            case "item":
                break;
            case "pkmn":
                break;
            case "run":
                break;
        }
    }

    public void npcTurn(Pokemon player, Pokemon npc){
        Moves[] moveList = npc.pullMoveList();
        int moveRandom = (int) Math.floor(Math.random()*3);
        Moves npcMove = moveList[moveRandom];
        if(npcMove.category.equals("Buff")){
            buffDeBuff(player,npcMove);
        }else if(npcMove.category.equals("Physical")){
            playerAttack(npc,npcMove,player);
        }else if(npcMove.category.equals("Special")){
            playerSpecialAttack(npc,npcMove,player);
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

    public void buffDeBuff(Pokemon pokemon, Moves move){
        double modifier = 1;
        switch(move.buffDebuffType){
            case "Attack":
                if(pokemon.getAttackInteger()==-6){
                    System.out.println(pokemon.getName() + "'s " + move.buffDebuffType + " can't be lowered any further!"); }
                if(pokemon.getAttackInteger()==6){
                    System.out.println(pokemon.getName() + "'s " + move.buffDebuffType + " can't be raised any further!"); }
                pokemon.setAttackInteger(pokemon.getAttackInteger()+move.buffDebuffInteger);
                modifier = integerConverter(pokemon.getAttackInteger());
                pokemon.setBattleAttack((int) (pokemon.getAttack()*modifier));
                break;
            case "Defense":
                if(pokemon.getDefenseInteger()==-6){
                    System.out.println(pokemon.getName() + "'s " + move.buffDebuffType + " can't be lowered any further!"); }
                if(pokemon.getDefenseInteger()==6){
                    System.out.println(pokemon.getName() + "'s " + move.buffDebuffType + " can't be raised any further!"); }
                pokemon.setDefenseInteger(pokemon.getDefenseInteger()+move.buffDebuffInteger);
                modifier = integerConverter(pokemon.getDefenseInteger());
                pokemon.setBattleDefense((int) (pokemon.getDefense()*modifier));
                break;
            case "SpecAttack":
                if(pokemon.getSpecialAttackInteger()==-6){
                    System.out.println(pokemon.getName() + "'s " + move.buffDebuffType + " can't be lowered any further!"); }
                if(pokemon.getSpecialAttackInteger()==6){
                    System.out.println(pokemon.getName() + "'s " + move.buffDebuffType + " can't be raised any further!"); }
                pokemon.setSpecialAttackInteger(pokemon.getSpecialAttackInteger()+move.buffDebuffInteger);
                modifier = integerConverter(pokemon.getSpecialAttackInteger());
                pokemon.setBattleSpecialAttack((int) (pokemon.getSpecialAttack()*modifier));
                break;
            case "SpecDefense":
                if(pokemon.getSpecialDefenseInteger()==-6){
                    System.out.println(pokemon.getName() + "'s " + move.buffDebuffType + " can't be lowered any further!"); }
                if(pokemon.getSpecialDefenseInteger()==6){
                    System.out.println(pokemon.getName() + "'s " + move.buffDebuffType + " can't be raised any further!"); }
                pokemon.setSpecialDefenseInteger(pokemon.getSpecialDefenseInteger()+move.buffDebuffInteger);
                modifier = integerConverter(pokemon.getSpecialAttackInteger());
                pokemon.setBattleSpecialDefense((int) (pokemon.getSpecialDefense()*modifier));
                break;
            case "Speed":
                if(pokemon.getSpeedInteger()==-6){
                    System.out.println(pokemon.getName() + "'s " + move.buffDebuffType + " can't be lowered any further!"); }
                if(pokemon.getSpeedInteger()==6){
                    System.out.println(pokemon.getName() + "'s " + move.buffDebuffType + " can't be raised any further!"); }
                pokemon.setSpeedInteger((pokemon.getSpeedInteger()+move.buffDebuffInteger));
                modifier = integerConverter(pokemon.getSpeedInteger());
                pokemon.setBattleSpeed((int) (pokemon.getSpeed()*modifier));
                break;
            case "Evasion":
                if(pokemon.getEvasionInteger()==-6){
                    System.out.println(pokemon.getName() + "'s " + move.buffDebuffType + " can't be lowered any further!"); }
                if(pokemon.getEvasionInteger()==6){
                    System.out.println(pokemon.getName() + "'s " + move.buffDebuffType + " can't be raised any further!"); }
                pokemon.setSpeedInteger((pokemon.getEvasionInteger()+move.buffDebuffInteger));
                modifier = evasionConverter(pokemon.getEvasionInteger());
                pokemon.setBattleEvasion((int) (pokemon.getEvasion()*modifier));
                break;
            case "Accuracy":
                if(pokemon.getAccuracyInteger()==-6){
                    System.out.println(pokemon.getName() + "'s " + move.buffDebuffType + " can't be lowered any further!"); }
                if(pokemon.getAccuracyInteger()==6){
                    System.out.println(pokemon.getName() + "'s " + move.buffDebuffType + " can't be raised any further!"); }
                pokemon.setAccuracyInteger((pokemon.getAccuracyInteger()+move.buffDebuffInteger));
                modifier = accuracyConverter(pokemon.getAccuracyInteger());
                pokemon.setBattleAccuracy((int) (pokemon.getAccuracy()*modifier));
                break;

        }
    }

    public void accuracyAndEvasion(Pokemon pokemon, Moves move){

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
