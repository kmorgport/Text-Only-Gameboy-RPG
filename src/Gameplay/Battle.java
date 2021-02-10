package Gameplay;

import moves.Moves;
import pokemon.Pokemon;
import trainers.Trainer;
import util.Input;

public class Battle {
    protected Input consoleEntry = new Input();
    Battle(){

    }

    public void startBattle(Trainer player, Trainer npc){
        Pokemon playerPokemon = player.retrieveTeamStarter();
        Pokemon rivalPokemon = npc.retrieveTeamStarter();

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

                    }
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

    public void playerAttackCombat(Pokemon player,Moves move ,Pokemon npc){
        int playerHP = player.getAttack();
        int npcHP = npc.getHitPoints();
        double modifier = moveTypeDeterminer(move.type,npc);
        //need to code modifier to 'super effective' message
        System.out.println(player.getName() + "used " + move.name + "!");
        int damage = (int) Math.round(calculateDamage(player.getLevel(),move.power,player.getAttack(),player.getDefense(),modifier));
        System.out.println(player.getName() + "hit " + npc.getName() + " for " + damage + " points of damage!");
        npcHP-=damage;
        npc.setHitPoints(npcHP);
        System.out.println(npc.getName() + "has " + npc.getHitPoints() + " remaining!");
    }

    public double moveTypeDeterminer(String moveType, Pokemon npc){
        switch(moveType.toLowerCase()){
            case "grass":
                return grassTypeMultiplier(npc.types.get(0),npc.types.get(1));
            case "fire":
                return fireTypeMultiplier(npc.types.get(0));
            case "water":
                return waterTypeMultiplier(npc.types.get(0));
            case "normal":
                return normalTypeMultiplier(npc.types.get(0));
            case "flying":
                return flyingTypeMultiplier(npc.types.get(0));
            default:
                return 1;

        }
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
        if(type2.equals("Poison")){
            multiplier -=.25;
        }
        return multiplier;
    }

    public double fireTypeMultiplier(String type){
        switch(type){
            case "Rock":
            case "Fire":
            case "Water":
            case "Dragon":
                return .5;
            case "Bug":
            case "Steel":
            case "Grass":
            case "Ice":
                return 2;
            default:
                return 1;

        }
    }

    public double waterTypeMultiplier(String type){
        switch(type){
            case "Water":
            case "Grass":
            case "Dragon":
                return .5;

            case "Ground":
            case "Rock":
            case "Fire":
                return 2;
            default:
                return 1;
        }
    }

    public double normalTypeMultiplier(String type){
        switch(type){
            case "Ghost":
                return 0;
            case "Rock":
            case "Steel":
                return .5;
            default:
                return 1;
        }
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

    public double getModifier(int critical, int random, int stab, int type, int burn){
        return critical*random*stab*type*burn;
    }

    public double determineStab(String monType, String attackType){
        if(monType.equals(attackType)){
            return 1.5;
        }else{
            return 1;
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
