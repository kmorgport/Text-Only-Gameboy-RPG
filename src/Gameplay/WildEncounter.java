package Gameplay;

import moves.Moves;
import pokemon.Pokemon;
import trainers.Trainer;
import util.Input;

import java.util.ArrayList;

public class WildEncounter {
    protected Input consoleEntry = new Input();
    public WildEncounter(){}

    public boolean startWildEncounter(Trainer player, Pokemon npc){
        Pokemon playerPokemon = player.retrieveTeamStarter();
//        Pokemon rivalPokemon = npc.retrieveTeamStarter();
//        battleCycle(player,npc);
        if(playerPokemon.getHitPoints()<=0){
            return false;
        }else if(npc.getHitPoints()<=0){
            playerPokemon.earnEVS(npc.getExpVal());
            int exp =Pokemon.calcExpGained(true,true,npc.getBaseExp(),npc.getLevel(),1);
            System.out.println(playerPokemon.getName() + " earned "+exp+ " experience points!");
            playerPokemon.levelUp(exp);
            return true;
        }else{
            return true;
        }
    }

    public void battleCycle(Trainer protagonist, Pokemon npc){
        Pokemon player = protagonist.retrieveTeamStarter();
        System.out.println("A wild "+npc.getName()+" appeared!");
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
                playerTurn(protagonist, npc);
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
                playerTurn(protagonist, npc);
            }
        }
//        return winner;
    }

    public int playerTurn(Trainer protagonist, Pokemon npc){
        Pokemon player = protagonist.retrieveTeamStarter();
        ArrayList<Moves> moveList2 = player.pullMoveArrayList();
        int accuracyRandom = (int) Math.floor(Math.random()*125);
        System.out.println("What would you like to do?");
        System.out.println("");
        System.out.println("---FIGHT---ITEM---PKMN---RUN---");
        String answ = consoleEntry.getString();
        switch(answ.toLowerCase()){
            case "fight":
                System.out.println("---" + moveList2.get(0).name + "---" + moveList2.get(1).name + "---" + moveList2.get(2).name + "---"+"Back");
                answ = consoleEntry.getString();
                if(answ.toLowerCase().equals("back")){
                    return playerTurn(protagonist,npc);
                }
                ArrayList<String> moveName = new ArrayList<>();
                for(Moves move: moveList2){
                    moveName.add(move.name.toLowerCase());
                }
                for(Moves move: moveList2){
                    if(!moveName.contains(answ)){
                        System.out.println("Professor Oak: " + player.getName() + " doesn't understand that command! Try again!");
                        return playerTurn(protagonist,npc);
                    }
                    if(move.name.toLowerCase().contains(answ.toLowerCase())){
                        if(move.category.equals("Physical")) {
                            if(accuracyRandom<=calculateAccuracy(player,move,npc)){
                                playerAttack(player, move, npc);
                                break;
                            }else{
                                System.out.println(player.getName() + " used " + move.getName() + "!");
                                System.out.println("The attack missed!");
                                break;
                            }
                        }else if(move.category.equals("Special")){
                            if(accuracyRandom<=calculateAccuracy(player,move,npc)){
                                playerSpecialAttack(player,move,npc);
                                break;
                            }else{
                                System.out.println(player.getName() + " used " + move.getName() + "!");
                                System.out.println("The attack missed!");
                                break;
                            }
                        }else if(move.category.equals("Debuff")){
                            buffDeBuff(player,move, npc);
                            break;
                        }else if(move.category.equals("Buff")){
                            buffDeBuff(player,move, player);
                            break;
                        }
                    }
                }
                break;
            case "item":
                useRecoveryItems(protagonist,npc);
                break;
            case "pkmn":
                System.out.println("You only have " + player.getName() + "!");
                return playerTurn(protagonist,npc);
            case "run":
//                System.out.println("You can't run from Trainer battles!");
//                return playerTurn(protagonist,rival);
            default:
                System.out.println(" ");
                System.out.println("That's not a valid entry: ");
                System.out.println(" ");
                return playerTurn(protagonist,npc);
        }
        return 1;
    }

}
