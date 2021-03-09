package Gameplay;

import items.Items;
import moves.Moves;
import pokemon.Pokemon;
import trainers.Trainer;
import util.Input;

import java.lang.reflect.Field;
import java.util.*;

public class Battle {
    protected Input consoleEntry = new Input();
    protected Scanner scanner = new Scanner(System.in);
    public Battle(){

    }

    public boolean revisedPokemonBattle(Trainer player, Trainer npc){
        Pokemon playerPokemon = player.retrieveTeamStarter();
        Pokemon npcPokemon = npc.retrieveTeamStarter();
        System.out.println(npc.getName() + " sent out " + npc.retrieveTeamStarter().getName() + "!");
        scanner.nextLine();
        System.out.println("Go! " + player.retrieveTeamStarter().getName() + "!");
        commenceBattle(player,npc);
        while(true){
            revisedBattleCycle(player, npc);
            if(playerPokemon.getHitPoints()<=0){
                System.out.println(playerPokemon.getName() + " fainted!");
                return false;
            }else if(npcPokemon.getHitPoints()<=0){
                playerPokemon.earnEVS(npcPokemon.getExpVal());
                System.out.println(npcPokemon.getName() + " fainted!");
                System.out.println(playerPokemon.getName() + " earned 140 experience points!");
                playerPokemon.levelUp(140);
                return true;
            }
        }
    }


    public void commenceBattle(Trainer player, Trainer npc){
        Pokemon playerPokemon = player.retrieveTeamStarter();
        Pokemon npcPokemon = npc.retrieveTeamStarter();
        resetBattleStatValue(playerPokemon);
        resetBattleStatValue(npcPokemon);

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


    public void revisedBattleCycle(Trainer player, Trainer npc){
        Pokemon playerPokemon = player.retrieveTeamStarter();
        Pokemon npcPokemon = npc.retrieveTeamStarter();
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
                        Moves npcMove = npcMoveSelection(npc);
                        if(!paralysis(npc)){
                            if(!confusionDamage(npc)) {
                                revisedTurn(npc, npcMove, player);
                            }
                        }
                        leechSeedDamage(player,npc);
                        leechSeedDamage(npc,player);
                        statusDamage(player, npc);
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
                    Moves npcMove = npcMoveSelection(npc);
                    if (playerMove == null) {
                        System.out.println("What will you do?");
                    } else if (playerMove.priority > npcMove.priority) {
                        if(!paralysis(player)){
                            if(!confusionDamage(player)) {
                                revisedTurn(player, playerMove, npc);
                            }
                        }
                        if (playerPokemon.getHitPoints() <= 0 || npcPokemon.getHitPoints() <= 0) {
                            break label;
                        }
                        if(!paralysis(npc)) {
                            if (!confusionDamage(npc)) {
                                revisedTurn(npc, npcMove, player);
                            }
                        }
                        leechSeedDamage(player,npc);
                        leechSeedDamage(npc,player);
                        statusDamage(player,npc);
                        System.out.println(" ");
                        break label;
                    } else if (npcMove.priority > playerMove.priority) {
                        if(!paralysis(npc)) {
                            if (!confusionDamage(npc)) {
                                revisedTurn(npc, npcMove, player);
                            }
                        }
                        if (playerPokemon.getHitPoints() <= 0 || npcPokemon.getHitPoints() <= 0) {
                            break label;
                        }
                        if(!paralysis(player)) {
                            if (!confusionDamage(player)) {
                                revisedTurn(player, playerMove, npc);
                            }
                        }
                        leechSeedDamage(player,npc);
                        leechSeedDamage(npc,player);
                        statusDamage(player,npc);
                        System.out.println(" ");
                        break label;
                    } else if (player.retrieveTeamStarter().getBattleSpeed() >= npc.retrieveTeamStarter().getBattleSpeed()) {
                        if(!paralysis(player)) {
                            if (!confusionDamage(player)) {
                                revisedTurn(player, playerMove, npc);
                            }
                        }
                        if (playerPokemon.getHitPoints() <= 0 || npcPokemon.getHitPoints() <= 0) {
                            break label;
                        }
                        if(!paralysis(npc)) {
                            if (!confusionDamage(npc)) {
                                revisedTurn(npc, npcMove, player);
                            }
                        }
                        leechSeedDamage(player,npc);
                        leechSeedDamage(npc,player);
                        statusDamage(player,npc);
                        break label;
                    } else if (npc.retrieveTeamStarter().getBattleSpeed() > player.retrieveTeamStarter().getBattleSpeed()) {
                        if(!paralysis(npc)) {
                            if (!confusionDamage(npc)) {
                                revisedTurn(npc, npcMove, player);
                            }
                        }
                        if (playerPokemon.getHitPoints() <= 0 || npcPokemon.getHitPoints() <= 0) {
                            break label;
                        }
                        if(!paralysis(player)) {
                            if (!confusionDamage(player)) {
                                revisedTurn(player, playerMove, npc);
                            }
                        }
                        leechSeedDamage(player,npc);
                        leechSeedDamage(npc,player);
                        statusDamage(player,npc);
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

    public void revisedTurn(Trainer attacker, Moves playerMove, Trainer defender){
        Pokemon attackingPokemon = attacker.retrieveTeamStarter();
        Pokemon defendingPokemon = defender.retrieveTeamStarter();
        int accuracyRandom = (int) Math.floor(Math.random()*125);
//        int extraEffect = (int) Math.floor(Math.random()*99)+1;
        int extraEffect = 20;
        switch (playerMove.category) {
            case "Physical":
                if (accuracyRandom <= calculateAccuracy(attackingPokemon, playerMove, defendingPokemon)) {
                    playerAttack(attackingPokemon, playerMove, defendingPokemon);
                } else {
                    System.out.println(attackingPokemon.getName() + " used " + playerMove.name + "!");
                    System.out.println("The attack missed!");
                    scanner.nextLine();
                }
                break;
            case "Special":
                if (accuracyRandom <= calculateAccuracy(attackingPokemon, playerMove, defendingPokemon)) {
                    playerSpecialAttack(attackingPokemon, playerMove, defendingPokemon);
                } else {
                    System.out.println(attackingPokemon.getName() + " used " + playerMove.name + "!");
                    System.out.println("The attack missed!");
                    scanner.nextLine();
                }
                break;
            case "AttackDeBuffPhys":
                if (accuracyRandom <= calculateAccuracy(attackingPokemon, playerMove, defendingPokemon)) {
                    playerAttack(attackingPokemon, playerMove, defendingPokemon);
                    if(extraEffect<=playerMove.getBuffDebuffChance()){
                        buffDeBuff(attackingPokemon, playerMove, defendingPokemon);
                    }

                } else {
                    System.out.println(attackingPokemon.getName() + " used " + playerMove.name + "!");
                    System.out.println("The attack missed!");
                    scanner.nextLine();
                }
                break;
            case "AttackDeBuffSpec":
                if (accuracyRandom <= calculateAccuracy(attackingPokemon, playerMove, defendingPokemon)) {
                    playerSpecialAttack(attackingPokemon, playerMove, defendingPokemon);
                    if(extraEffect<=playerMove.getBuffDebuffChance()){
                        buffDeBuff(attackingPokemon, playerMove, defendingPokemon);
                    }

                } else {
                    System.out.println(attackingPokemon.getName() + " used " + playerMove.name + "!");
                    System.out.println("The attack missed!");
                    scanner.nextLine();
                }
                break;
            case "AttackStatusPhys":
                if (accuracyRandom <= calculateAccuracy(attackingPokemon, playerMove, defendingPokemon)) {
                    playerAttack(attackingPokemon, playerMove, defendingPokemon);
                    if(extraEffect<=playerMove.getStatusChance()){
                        statusMoves(attackingPokemon, playerMove, defendingPokemon);
                    }

                } else {
                    System.out.println(attackingPokemon.getName() + " used " + playerMove.name + "!");
                    System.out.println("The attack missed!");
                    scanner.nextLine();
                }
                break;
            case "AttackStatusSpec":
                if (accuracyRandom <= calculateAccuracy(attackingPokemon, playerMove, defendingPokemon)) {
                    playerSpecialAttack(attackingPokemon, playerMove, defendingPokemon);
                    if(extraEffect<=playerMove.getStatusChance()){
                        statusMoves(attackingPokemon, playerMove, defendingPokemon);
                    }

                } else {
                    System.out.println(attackingPokemon.getName() + " used " + playerMove.name + "!");
                    System.out.println("The attack missed!");
                    scanner.nextLine();
                }
                break;
            case "Debuff":
                buffDeBuff(attackingPokemon, playerMove, defendingPokemon);
                break;
            case "Buff":
                buffDeBuff(attackingPokemon, playerMove, attackingPokemon);
                break;
            case "Status":
                statusMoves(attackingPokemon,playerMove,defendingPokemon);
                break;
        }
    }

    public Moves npcMoveSelection(Trainer npc){
        int lengthOfNpcMoveList = npc.retrieveTeamStarter().pullMoveArrayList().size();
        int moveRandom = (int) Math.floor(Math.random()*lengthOfNpcMoveList);
         return npc.retrieveTeamStarter().pullMoveArrayList().get(moveRandom);
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

    public void statusMoves(Pokemon agent,Moves agentMove, Pokemon patient){
        System.out.println(agent.getName() + " used " + agentMove.getName() + "!");
        scanner.nextLine();
        switch(agentMove.getStatus()){
            case "Poison":
                inflictPoison(patient);
                break;
            case "Paralysis":
                inflictParalysis(patient);
                break;
            case "Sleep":
                break;
            case "Burn":
                inflictBurn(patient);
                break;
            case "Frozen":
                break;
            case "Leech":
                inflictSeed(patient);
                break;
            case "Wrap":
                break;
            case "Confusion":
                inflictConfusion(patient);

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

//    public int useRecoveryItems(Trainer protagonist, Trainer rival){
//        protagonist.mapIterator(protagonist.getMedicine());
//        System.out.println("\n");
//        System.out.println("Which recovery item would you like to use?");
//        System.out.println(" ");
//        String answ = consoleEntry.getString().toUpperCase();
//        Items item = protagonist.getMedicine().get(answ);
//        if(answ.isEmpty()){
//            return playerTurn(protagonist,rival);
//        }
//        if(answ.equals("BACK")){
//            //allows player to back out of item menu
//            return playerTurn(protagonist,rival);
//        }
//        if(item.getHealthRecoveryAmount()>0){
//            Pokemon currentPokemon = protagonist.retrieveTeamStarter();
//            if(currentPokemon.getHitPoints()==currentPokemon.getMaxHitPoints()){
//                //prevents HP from being healed higher than max HP for current level
//                System.out.println(currentPokemon.getName() + "is at max HP, cannot heal any further!");
//                return useRecoveryItems(protagonist,rival);
//            }
//            if(currentPokemon.getHitPoints()+item.getHealthRecoveryAmount()>=currentPokemon.getMaxHitPoints()){
//                currentPokemon.setHitPoints(currentPokemon.getMaxHitPoints());
//                System.out.println("You used " + item.getName() + "!");
//                System.out.println(currentPokemon.getName() + " has been recovered to max health!");
//                item.setQuantity(-1);
//                if(item.getQuantity()<=0){
//                    //removes item from inventory if quantity is less or equal to 0;
//                    protagonist.getMedicine().remove(answ);
//                }
//            }else{
//                currentPokemon.setHitPoints(currentPokemon.getHitPoints()+ item.getHealthRecoveryAmount());
//                System.out.println("You used " + item.getName() + "!");
//                System.out.println(currentPokemon.getName() + "has been healed for " + item.getHealthRecoveryAmount());
//                System.out.println(currentPokemon.getName() + " has " + currentPokemon.getHitPoints() + "!");
//                item.setQuantity(-1);
//                if(item.getQuantity()<=0){
//                    //removes item from inventory if quantity is less or equal to 0;
//                    protagonist.getMedicine().remove(answ);
//                }
//            }
//        }else{
//            System.out.println(item.getStatusRecovery());}
//        return 1;
//
//
//    }

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
        switch(move.getBuffDebuffType()){
            case "Attack":
                if(patient.getAttackInteger()==-6){
                    System.out.println(patient.getName() + "'s " + move.getBuffDebuffType() + " can't be lowered any further!"); }
                if(patient.getAttackInteger()==6){
                    System.out.println(patient.getName() + "'s " + move.getBuffDebuffType() + " can't be raised any further!"); }
                patient.setAttackInteger(patient.getAttackInteger()+move.getBuffDebuffInteger());
                System.out.println(patient.getName() + "'s attack" + buffDebuffMessage(move.getBuffDebuffInteger()));
                modifier = integerConverter(patient.getAttackInteger());
                patient.setBattleAttack((int) (patient.getAttack()*modifier));
                break;
            case "Defense":
                if(patient.getDefenseInteger()==-6){
                    System.out.println(patient.getName() + "'s " + move.getBuffDebuffType() + " can't be lowered any further!"); }
                if(patient.getDefenseInteger()==6){
                    System.out.println(patient.getName() + "'s " + move.getBuffDebuffType() + " can't be raised any further!"); }
                patient.setDefenseInteger(patient.getDefenseInteger()+move.getBuffDebuffInteger());
                System.out.println(patient.getName() + "'s defense" + buffDebuffMessage(move.getBuffDebuffInteger()));
                modifier = integerConverter(patient.getDefenseInteger());
                patient.setBattleDefense((int) (patient.getDefense()*modifier));
                break;
            case "SpecAttack":
                if(patient.getSpecialAttackInteger()==-6){
                    System.out.println(patient.getName() + "'s " + move.getBuffDebuffType() + " can't be lowered any further!"); }
                if(patient.getSpecialAttackInteger()==6){
                    System.out.println(patient.getName() + "'s " + move.getBuffDebuffType() + " can't be raised any further!"); }
                patient.setSpecialAttackInteger(patient.getSpecialAttackInteger()+move.getBuffDebuffInteger());
                System.out.println(patient.getName() + "'s special attack" + buffDebuffMessage(move.getBuffDebuffInteger()));
                modifier = integerConverter(patient.getSpecialAttackInteger());
                patient.setBattleSpecialAttack((int) (patient.getSpecialAttack()*modifier));
                break;
            case "SpecDefense":
                if(patient.getSpecialDefenseInteger()==-6){
                    System.out.println(patient.getName() + "'s " + move.getBuffDebuffType() + " can't be lowered any further!"); }
                if(patient.getSpecialDefenseInteger()==6){
                    System.out.println(patient.getName() + "'s " + move.getBuffDebuffType() + " can't be raised any further!"); }
                patient.setSpecialDefenseInteger(patient.getSpecialDefenseInteger()+move.getBuffDebuffInteger());
                System.out.println(patient.getName() + "'s special defense" + buffDebuffMessage(move.getBuffDebuffInteger()));
                modifier = integerConverter(patient.getSpecialAttackInteger());
                patient.setBattleSpecialDefense((int) (patient.getSpecialDefense()*modifier));
                break;
            case "Speed":
                if(patient.getSpeedInteger()==-6){
                    System.out.println(patient.getName() + "'s " + move.getBuffDebuffType() + " can't be lowered any further!"); }
                if(patient.getSpeedInteger()==6){
                    System.out.println(patient.getName() + "'s " + move.getBuffDebuffType() + " can't be raised any further!"); }
                patient.setSpeedInteger((patient.getSpeedInteger()+move.getBuffDebuffInteger()));
                System.out.println(patient.getName() + "'s speed" + buffDebuffMessage(move.getBuffDebuffInteger()));
                modifier = integerConverter(patient.getSpeedInteger());
                patient.setBattleSpeed((int) (patient.getSpeed()*modifier));
                break;
            case "Evasion":
                if(patient.getEvasionInteger()==-6){
                    System.out.println(patient.getName() + "'s " + move.getBuffDebuffType() + " can't be lowered any further!"); }
                if(patient.getEvasionInteger()==6){
                    System.out.println(patient.getName() + "'s " + move.getBuffDebuffType() + " can't be raised any further!"); }
                patient.setSpeedInteger((patient.getEvasionInteger()+move.getBuffDebuffInteger()));
                System.out.println(patient.getName() + "'s evasion" + buffDebuffMessage(move.getBuffDebuffInteger()));
                modifier = evasionConverter(patient.getEvasionInteger());
                patient.setBattleEvasion((int) (patient.getEvasion()*modifier));
                break;
            case "Accuracy":
                if(patient.getAccuracyInteger()==-6){
                    System.out.println(patient.getName() + "'s " + move.getBuffDebuffType() + " can't be lowered any further!"); }
                if(patient.getAccuracyInteger()==6){
                    System.out.println(patient.getName() + "'s " + move.getBuffDebuffType() + " can't be raised any further!"); }
                patient.setAccuracyInteger((patient.getAccuracyInteger()+move.getBuffDebuffInteger()));
                System.out.println(patient.getName() + "'s accuracy" + buffDebuffMessage(move.getBuffDebuffInteger()));
                modifier = accuracyConverter(patient.getAccuracyInteger());
                patient.setBattleAccuracy((int) (patient.getAccuracy()*modifier));
                break;

        }
    }

    public void statusDamage(Trainer player, Trainer npc){
        burnDamage(player,npc);
        poisonDamage(player, npc);
    }

    public void inflictConfusion(Pokemon monster){
        if(monster.getConfusion()){
            System.out.println(monster.getName() + " is already confused!");
            scanner.nextLine();
        }else if(!monster.getActiveLeech()) {
            monster.setConfusion(true);
            System.out.println(monster.getName() + " has been confused! It may hurt itself!");
            scanner.nextLine();
        }
    }

    public boolean confusionDamage(Trainer trainer){
        Pokemon victim = trainer.retrieveTeamStarter();
        boolean confusion = victim.getConfusion();
        int breakConfusion = (int) Math.floor(Math.random()*100)+1;
        victim.setConfusionCounter((short) 1);
        if(!confusion)return false;
        if(breakConfusion >= 80){
            System.out.println(victim.getName() + " snapped out of confusion!");
            scanner.nextLine();
            victim.resetConfusionCounter();
            victim.setConfusion(false);
            return false;
        }else {
            int random = (int) Math.floor(Math.random()*100)+1;
            if(random<=50){
                int damage = (int) Math.round(calculateDamage(victim.getLevel(),40,victim.getAttack(),victim.getDefense(),1)+1);
                victim.setHitPoints(victim.getHitPoints()-damage);
                victim.setConfusionCounter((short) 1);
                System.out.println(victim.getName() + " hurt itself in confusion!");
                scanner.nextLine();
                if(victim.getConfusionCounter()>=5){
                    victim.setConfusion(false);
                    victim.resetConfusionCounter();
                    System.out.println(victim.getName() + " snapped out of confusion!");
                    scanner.nextLine();
                }
                return true;
            }else{
                return false;
            }
        }
    }

    public void leechSeedDamage(Trainer drainer, Trainer drainee){
        int damage;
        if(drainee.retrieveTeamStarter().getActiveLeech()){
            damage = (int) Math.floor(drainee.retrieveTeamStarter().getMaxHitPoints()*0.0625);
            //drains the opponent
            drainee.retrieveTeamStarter().setHitPoints(drainee.retrieveTeamStarter().getHitPoints()-damage);
            System.out.println(drainee.getName() + "'s " + drainee.retrieveTeamStarter().getName() + "'s health was sapped!");
            scanner.nextLine();
            //healsThePlayer
            drainer.retrieveTeamStarter().setHitPoints(drainer.retrieveTeamStarter().getHitPoints()+damage);
            System.out.println(drainer.retrieveTeamStarter().getName() + "'s health was healed!");
        }
    }

    public void inflictSeed(Pokemon monster){
        if(monster.getActiveLeech()){
            System.out.println(monster.getName() + " is already seeded!");
            scanner.nextLine();
        }else if(!monster.getActiveLeech()) {
            monster.setActiveLeech(true);
            System.out.println(monster.getName() + " has been seeded!");
            scanner.nextLine();
        }
    }

    public boolean paralysis(Trainer agent){
        if(agent.retrieveTeamStarter().getStatus()==null)return false;
        if(agent.retrieveTeamStarter().getStatus().equalsIgnoreCase("Paralysis")){
            int random = (int) Math.floor(Math.random()*100)+1;
            if(random >= 66){
                System.out.println(agent.retrieveTeamStarter().getName() + " is paralyzed! It can't move!");
                scanner.nextLine();
                return true;
            }else{
                return false;
            }

        }
        return false;
    }

    public void inflictParalysis(Pokemon monster){
        if(monster.getStatus().equalsIgnoreCase("paralysis")){
            System.out.println(monster.getName() + " is already paralyzed!");
            scanner.nextLine();
        }else if(monster.getStatus().equalsIgnoreCase("none")){
            monster.setStatus("Paralysis");
            monster.setBattleSpeed(monster.getBattleSpeed()/2);
            System.out.println(monster.getName() + " is paralyzed! It may not attack!");
            scanner.nextLine();
        }else{
            System.out.println(monster.getName() + " is already afflicted!");
            scanner.nextLine();
        }
    }

    public void inflictPoison(Pokemon monster){
        if(monster.getStatus().equalsIgnoreCase("poisoned")){
            System.out.println(monster.getName() + " is already poisoned!");
            scanner.nextLine();
        }else if(monster.getStatus().equalsIgnoreCase("none")){
            monster.setStatus("Poison");
            System.out.println(monster.getName() + " is poisoned!");
            scanner.nextLine();
        }else{
            System.out.println(monster.getName() + " is already afflicted!");
            scanner.nextLine();
        }
    }

    public void poisonDamage(Trainer player, Trainer npc){
        int damage;
        if(player.retrieveTeamStarter().getStatus()==null)return;
        if(player.retrieveTeamStarter().getStatus().equalsIgnoreCase("Poison")){
            damage = (int) Math.floor(player.retrieveTeamStarter().getMaxHitPoints()*0.0625);
            player.retrieveTeamStarter().setHitPoints(player.retrieveTeamStarter().getHitPoints()-damage);
            System.out.println(player.retrieveTeamStarter().getName() + "'s hurt by poison!");
            scanner.nextLine();
            System.out.println(player.retrieveTeamStarter().getName() + " loses " + damage + " HP!");
            scanner.nextLine();
            System.out.println(player.retrieveTeamStarter().getName() + " has " + player.retrieveTeamStarter().getHitPoints() + " remaining!");
            scanner.nextLine();
        }
        if(player.retrieveTeamStarter().getStatus()==null)return;
        if(npc.retrieveTeamStarter().getStatus().equalsIgnoreCase("Poison")){
            damage = (int) Math.floor(npc.retrieveTeamStarter().getMaxHitPoints()*0.0625);
            npc.retrieveTeamStarter().setHitPoints(npc.retrieveTeamStarter().getHitPoints()-damage);
            System.out.println(npc.retrieveTeamStarter().getName() + "'s hurt by poison!");
            scanner.nextLine();
            System.out.println(npc.retrieveTeamStarter().getName() + " loses " + damage + " HP!");
            scanner.nextLine();
            System.out.println(npc.retrieveTeamStarter().getName() + " has " + npc.retrieveTeamStarter().getHitPoints() + " remaining!");
            scanner.nextLine();
        }
    }

    public void burnDamage(Trainer player, Trainer npc){
        int damage;
        if(player.retrieveTeamStarter().getStatus()==null)return;
        if(player.retrieveTeamStarter().getStatus().equalsIgnoreCase("Burn")){
            damage = (int) Math.floor(player.retrieveTeamStarter().getMaxHitPoints()*0.0625);
            player.retrieveTeamStarter().setHitPoints(player.retrieveTeamStarter().getHitPoints()-damage);
            System.out.println(player.retrieveTeamStarter().getName() + "'s hurt by its burn!");
            scanner.nextLine();
            System.out.println(player.retrieveTeamStarter().getName() + " loses " + damage + " HP!");
            scanner.nextLine();
            System.out.println(player.retrieveTeamStarter().getName() + " has " + player.retrieveTeamStarter().getHitPoints() + " remaining!");
            scanner.nextLine();
        }
        if(player.retrieveTeamStarter().getStatus()==null)return;
        if(npc.retrieveTeamStarter().getStatus().equalsIgnoreCase("Burn")){
            damage = (int) Math.floor(npc.retrieveTeamStarter().getMaxHitPoints()*0.0625);
            npc.retrieveTeamStarter().setHitPoints(npc.retrieveTeamStarter().getHitPoints()-damage);
            System.out.println(npc.retrieveTeamStarter().getName() + "'s hurt by its burn!");
            scanner.nextLine();
            System.out.println(npc.retrieveTeamStarter().getName() + " loses " + damage + " HP!");
            scanner.nextLine();
            System.out.println(npc.retrieveTeamStarter().getName() + " has " + npc.retrieveTeamStarter().getHitPoints() + " remaining!");
            scanner.nextLine();
        }
    }

    public void inflictBurn(Pokemon monster){
        if(monster.getStatus().equalsIgnoreCase("burned")){
            System.out.println(monster.getName() + " is already burned!");
            scanner.nextLine();
        }else if(monster.getStatus().equalsIgnoreCase("none")){
            monster.setStatus("Burn");
            monster.setBattleAttack(monster.getBattleAttack()/2);
            System.out.println(monster.getName() + " is burned!");
            scanner.nextLine();
        }else{
            System.out.println(monster.getName() + " is already afflicted!");
            scanner.nextLine();
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

//    public int calculatePhysicalOrSpecial(Moves move, Pokemon pokemon){
//        if(move.getCategory().equals("Physical")){
//            double rando
//            double modifier = getModifier()
//            calculateDamage(pokemon.getLevel(),move.getPower(),pokemon.getAttack(),pokemon.getDefense(), modifier);
//        }
//    }
}
