package Gameplay;

import items.Items;
import items.Potion;
import pc.Computer;
import trainers.Trainer;
import util.Input;

import java.util.Scanner;

public class PlayerHouse {
    Input io;
    Scanner scanner = new Scanner(System.in);
    public PlayerHouse(){
    }

    public void navigateHouse(Trainer player, Trainer rival,Computer computer){
        PlayerHouseDownstairs downstairs = new PlayerHouseDownstairs();
        System.out.println(" ");
        boolean loop = true;
        while(loop){
            System.out.println("What would you like to do?");
            System.out.println(" - - - INSPECT - - - LEAVE - - -");
            io = new Input();
            String answ = io.getString();
            if(answ.toLowerCase().equals("inspect")){
                System.out.println("You look around your room");
                inspectRoom(player, rival, computer);

            }else if(answ.toLowerCase().equals("leave")){
                System.out.println("Would you like to go downstairs? Y/N");
                answ = io.getString();
                while(true){
                    if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")) {
                        System.out.println("You head down the stairs. Pictures of your family from when you were little are on the hallway. It seems so long ago since you were all together...");
                        scanner.nextLine();
                        System.out.println("You walk downstairs and see your mother seated at the table drinking some tea.");
                        scanner.nextLine();
                        downstairs.navigateLowerFloor(player, rival, computer);
                        loop = false;
                        break;
                    }else if(answ.toLowerCase().equals("n")||answ.toLowerCase().equals("no")){
                        break;
                    }else{
                        System.out.println("Ooops, there was a typo");
                    }
                }
            }else{
                System.out.println("Ooops, there was a typo");
            }
        }
    }

    public void inspectRoom(Trainer player, Trainer rival, Computer computer){
        io = new Input();
        boolean loop = true;
        while(loop){System.out.println("What would you like to inspect \n BED -- TV -- PLANT -- COMPUTER -- BACK");
            String input = io.getString();
            switch(input.toUpperCase()){
                case "BED":
                    System.out.println("Yup, it's a bed! You should take better care of it! It's the only bed in the house!");
                    scanner.nextLine();
                    while(true){
                        System.out.println("Would you like to inspect something else in the room? Y/N");
                        String answ = io.getString();
                        if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                            break;
                        }else if(answ.toLowerCase().equals("n")||answ.toLowerCase().equals("no")){
                            loop = false;
                            break;
                        }else{
                            System.out.println("Ooops, there was a typo");
                        }
                    }
                    break;
                case "TV":
                    System.out.println("There's a show about crying rocks on. It's kinda weird, but somehow, still fun?");
                    scanner.nextLine();
                    System.out.println("It's an SNES! Kind of an odd console for a ten year old in 202x to own, but you do you!");
                    scanner.nextLine();
                    while(true){
                        System.out.println("Would you like to inspect something else in the room? Y/N");
                        String answ = io.getString();
                        if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                            break;
                        }else if(answ.toLowerCase().equals("n")||answ.toLowerCase().equals("no")){
                            loop = false;
                            break;
                        }else{
                            System.out.println("Ooops, there was a typo");
                        }
                    }
                    break;
                case "PLANT":
                    System.out.println("It's your plant! MOM said we couldn't have our first pokemon until we could keep a plant alive!");
                    scanner.nextLine();
                    while(true){
                        System.out.println("Would you like to inspect something else in the room? Y/N");
                        String answ = io.getString();
                        if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                            break;
                        }else if(answ.toLowerCase().equals("n")||answ.toLowerCase().equals("no")){
                            loop = false;
                            break;
                        }else{
                            System.out.println("Ooops, there was a typo");
                        }
                    }
                    break;
                case "COMPUTER":
                    boolean compLoop = true;
                    while(compLoop){
                        System.out.println("It's your LEPPA BERRY Laptop! Would you like to use it? Y/N");
                        String answ = io.getString();
                        if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                            compLoop = false;
                        accessPersonalComputer(player);
                        System.out.println(" ");
                        while(true){
                            System.out.println("Would you like to inspect something else in the room? Y/N");
                            answ = io.getString();
                            if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                                break;
                            }else if(answ.toLowerCase().equals("n")||answ.toLowerCase().equals("no")){
                                loop = false;
                                break;
                            }else{
                                System.out.println("Ooops, there was a typo");
                            }
                        }
                    }else if(answ.toLowerCase().equals("n")||answ.toLowerCase().equals("no")){
                            compLoop=false;
                            System.out.println(" ");
                            while(true){
                            System.out.println("Would you like to inspect something else in the room? Y/N");
                            answ = io.getString();
                            if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                                break;
                            }else if(answ.toLowerCase().equals("n")||answ.toLowerCase().equals("no")){
                                break;
                            }else{
                                System.out.println("Ooops, there was a typo");
                            }
                        }
                    }else{
                            System.out.println("Ooops, there was a typo");
                        }
                    }
                case "BACK":
                    loop = false;
                    break;

                default:
                    System.out.println("Ooops, there was a typo");

            }}

    }

    public void accessPersonalComputer(Trainer player){
        System.out.println("What would you like to withdraw?");
        while(true){
            System.out.println("--POTION--BACK--");
            String answ = io.getString();
            if(answ.toLowerCase().equals("potion")){
                Items potion = new Potion();
                player.addToMedicine(potion);
                System.out.println(player.getName() + " withdrew a " + potion.getName() + "!");
                scanner.nextLine();
                break;
            }else if(answ.toLowerCase().equals("back")){
                System.out.println("Would you like to continue using the computer? Y?N");
                answ = io.getString();
                if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                    System.out.println("What would you like to withdraw?");
                }else{
                    System.out.println(player.getName() + " logged out of the computer!");
                    break;
                }
            }else{
                System.out.println("Ooops, there was a typo");
            }
        }
    }
}
