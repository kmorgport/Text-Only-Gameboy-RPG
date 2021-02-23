package Gameplay;

import items.Items;
import items.Potion;
import pc.Computer;
import pokemon.Pidgey;
import pokemon.Pokemon;
import pokemon.Rattata;
import trainers.Trainer;
import util.Input;

import java.util.Scanner;

public class Route1 {
    Input io = new Input();
    Scanner scanner = new Scanner(System.in);
    public Route1(){};

    public void navigateRoute1FirstTime(Trainer player, Trainer rival, Computer computer){
        System.out.println("The first steps of a new adventure await!!");
//        scanner.nextLine();
        System.out.println("You head into the tall grass leaving Pallet Town");
        southernHalfRoute1NexusFirstTime(player, rival, computer);

    }

    public void southernHalfRoute1NexusFirstTime(Trainer player,Trainer rival,Computer computer){
        scanner.nextLine();
        boolean choice = true;
        while(choice){
            System.out.println("There are three paths before you. To the EAST is a tall patch of grass. To the WEST is more grass,\nbeyond which you can see the road leading to\nVIRIDIN CTY. To the SOUTH is PALLET TOWN.");
            scanner.nextLine();
            System.out.println("Which direction do you choose?");
            String answ = io.getString();
            if(answ.isEmpty()){
                System.out.println("Oops, there was a typo!");
            }else{
                switch(answ.toUpperCase()){
                    case "EAST":
                        tallFieldNavigation(player);
                        System.out.println("You return to the path");
                        choice = true;
                        break;
                    case "WEST":
                        tallFieldNavigation(player);
                        System.out.println("You continue walking thru the tall grass...");
                        tallFieldNavigation(player);
                        middleRoute1Nexus(player, rival, computer);
                        choice = false;
                        break;
                    case "SOUTH":
                        Hometown hometown = new Hometown();
                        hometown.centerOfTown2(player, rival, computer);
                        choice = false;
                        break;
                    default:
                        System.out.println("Oops, there was a typo!");

                }
            }

        }

    }

    public void middleRoute1Nexus(Trainer player, Trainer rival, Computer computer){
        System.out.println("You reach a signpost...");
        scanner.nextLine();
        System.out.println("It appears you are half way between VIRIDIAN CITY and PALLET TOWN.");
        scanner.nextLine();
        System.out.println("You see a person sitting on a bench, they are dressed like a store clerk. Do you approach them? Y/N");
        while(true){
            String answ = io.getString();
            if(answ.isEmpty()){
                System.out.println("Oops, you didn't enter anything! Do you approach them? Y/N");
            }else if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                System.out.println("You approach the sales clerk.");
                scanner.nextLine();
                System.out.println("CLERK: Why hello there!");
                scanner.nextLine();
                System.out.println("CLERK: I decided to take a walk on my break and I got lost in thought!");
                scanner.nextLine();
                System.out.println("CLERK: You look like a new TRAINER, you ever been to a POKEMART? They have useful items that can\nhelp you raise your POKEMON!");
                scanner.nextLine();
                System.out.println("CLERK: Here, I think I have a free sample on me...");
                Items potion = new Potion();
                player.addToMedicine(potion);
                System.out.println("The CLERK handed you a POTION");
                scanner.nextLine();
                System.out.println("All right, I better be heading back to work, hope to see you soon!");
                scanner.nextLine();
                break;
            }else if(answ.toLowerCase().equals("n")||answ.toLowerCase().equals("no")){
                System.out.println("They seem to be resting, let's not bother them.");
                scanner.nextLine();
                break;
            }else{
                System.out.println("Oops, there was a typo! Do you approach them? Y/N");
            }
        }
        System.out.println("There are two paths. To the NORTH is the way forward to VIRIDIAN CITY, to the SOUTH is the direction you came.");
        scanner.nextLine();
        System.out.println("Which direction do you choose? NORTH/SOUTH");
        boolean loop = true;
        while(loop){
            String answ = io.getString();
            switch(answ.toUpperCase()){
                case "NORTH":
                    tallFieldNavigation(player);
                    System.out.println("Your almost out of the field! Just one more stretch and you'll be at VIRIDIAN CITY!");
                    tallFieldNavigation(player);
                    System.out.println("You've made it thru the tall grass! You come upon the boulevard leading into VIRIDIAN CITY!");
                    FirstMetropolis viridian = new FirstMetropolis();
                    viridian.navigateFirstMetropolisFirstTime(player, rival, computer);
                    loop = false;
                    break;
                case "SOUTH":
                    tallFieldNavigation(player);
                    southernHalfRoute1NexusFirstTime(player, rival, computer);
                    loop = false;
                    break;
                default:
                    System.out.println("Oops! there was a typo! Which direction do you choose? NORTH or SOUTH?");

            }
        }

    }



    public void tallFieldNavigation(Trainer player){
        boolean loop = true;
        while(loop){
            int random = (int) Math.floor(Math.random()*99)+1;
            if(random<=18){
                encounterMonster(player);
            }
            boolean confirm = true;
            while(confirm){
                System.out.println("Would you like to circle back around in this section of tall grass? Y/N");
                String answ = io.getString();
                if(answ.isEmpty()){
                    System.out.println("Oops, you didn't enter anything");
                }
                if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                    confirm = false;
                }else if(answ.toLowerCase().equals("n")||answ.toLowerCase().equals("no")){
                    loop = false;
                    confirm = false;
                }
            }
        }
    }

    public void encounterMonster(Trainer player){
        WildBattle battle = new WildBattle();
        int random = (int) Math.floor(Math.random()*99)+1;
        int wildLevel = (int) Math.floor(Math.random()*4)+1;
        int wildHpRandom = (int) Math.floor(Math.random()*15)+1;
        int wildAttRandom = (int) Math.floor(Math.random()*15)+1;
        int wildDefRandom = (int) Math.floor(Math.random()*15)+1;
        int wildSpAttRandom = (int) Math.floor(Math.random()*15)+1;
        int wildSpDefRandom = (int) Math.floor(Math.random()*15)+1;
        int wildSpeedRandom = (int) Math.floor(Math.random()*15)+1;
        if(random>=1&&random<=55){
            Pokemon pidgey = new Pidgey(wildLevel,wildHpRandom,wildAttRandom,wildDefRandom,wildSpAttRandom,wildSpDefRandom,wildSpeedRandom);
            battle.wildMonsterBattle(player,pidgey);
        }else if(random>=56&&random<=100){
            Pokemon rattata = new Rattata(wildLevel,wildHpRandom,wildAttRandom,wildDefRandom,wildSpAttRandom,wildSpDefRandom,wildSpeedRandom);
            battle.wildMonsterBattle(player,rattata);
        }
    }
}
