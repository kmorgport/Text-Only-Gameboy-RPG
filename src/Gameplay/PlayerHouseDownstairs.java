package Gameplay;

import pc.Computer;
import trainers.Trainer;
import util.Input;

import java.util.Scanner;

public class PlayerHouseDownstairs {
    Input io;
    Scanner scanner = new Scanner(System.in);
    public PlayerHouseDownstairs(){}

    public void navigateLowerFloor(Trainer player,Trainer rival, Computer computer){
        System.out.println(" ");
        boolean loop = true;
        while(loop){
            System.out.println("What would you like to do?");
            System.out.println(" - - - INSPECT - - - UPSTAIRS - - - LEAVE - - -");
            io = new Input();
            String answ = io.getString();
            if(answ.toLowerCase().equals("inspect")){
                inspectDownstairsRoom(player);
            }else if(answ.toLowerCase().equals("upstairs")){
                System.out.println("You head upstairs to go back to your room");
                PlayerHouse playerHouse = new PlayerHouse();
                playerHouse.navigateHouse(player,rival,computer);
                loop = false;
            }else if(answ.toLowerCase().equals("leave")){
                leaveDownstairsRoom(player,rival,computer);
                loop = false;
            }else{
                System.out.println("Ooops, there was a typo");
            }
        }

    }

    public void navigateLowerFloor2(Trainer player, Trainer rival, Computer computer){
        System.out.println(" ");
        boolean loop = true;
        while(loop){
            System.out.println("What would you like to do?");
            System.out.println(" - - - INSPECT - - - UPSTAIRS - - - LEAVE - - -");
            io = new Input();
            String answ = io.getString();
            if(answ.toLowerCase().equals("inspect")){
                inspectDownstairsRoom2(player);
            }else if(answ.toLowerCase().equals("upstairs")){
                System.out.println("You head upstairs to go back to your room");
                PlayerHouse playerHouse = new PlayerHouse();
                playerHouse.navigateHouse(player,rival,computer);
                loop = false;
            }else if(answ.toLowerCase().equals("leave")){
                leaveDownstairsRoom(player,rival,computer);
                loop = false;
            }else{
                System.out.println("Ooops, there was a typo");
            }
        }
    }

    public void leaveDownstairsRoom(Trainer player, Trainer rival, Computer computer){
        boolean loop = true;
        while(loop){
            System.out.println("Where would you like to go?");
            System.out.println(" - - - UPSTAIRS - - - OUTSIDE - - -STAY");
            String answ = io.getString();
            switch(answ.toLowerCase()){
                case "upstairs":
                    System.out.println(" - - - - - - - -");
                    System.out.println("You head upstairs to go back to your room");
                    PlayerHouse playerHouse = new PlayerHouse();
                    playerHouse.navigateHouse(player,rival,computer);
                    loop = false;
                    break;
                case "outside":
                    System.out.println("You leave your house, to go find Professor LIVEOAK!");
                    scanner.nextLine();
                    Hometown palletteTown = new Hometown();
                    palletteTown.homeTownFirstVisit(player, rival, computer);
                    loop = false;
                    break;
                case "stay":
                    navigateLowerFloor(player,rival,computer);
                    loop = false;
                    break;
                default:
                    System.out.println("Ooops, there was a typo");

            }}
    }

    public void inspectDownstairsRoom(Trainer player){
        io = new Input();
        boolean loop = true;
        while(loop){
            System.out.println("Would you like to inspect \n TABLE -- TV -- WINDOW -- BOOKSHELF");
            String input = io.getString();
            switch(input.toUpperCase()){
                case "TABLE":
                    boolean momLoop = true;
                    while(momLoop){
                        System.out.println("Your mother is sitting at the table. Would you like to speak with her? Y/N");
                        String answ = io.getString();
                        if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                            momLoop = false;
                            convoWithMom();
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
                            break;
                        }else if(answ.toLowerCase().equals("n")||answ.toLowerCase().equals("no")){
                            momLoop = false;
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
                            break;
                        }else{
                            System.out.println("Ooops, there was a typo");
                        }
                    }
                    break;
                case "TV":
                    System.out.println("Your mom's favorite show is on. It's really old. Why did everyone wear shoulder pads back then?");
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
                case "WINDOW":
                    System.out.println("You go up to the window and look out");
                    scanner.nextLine();
                    System.out.println("HOLY ARCEUS!!");
                    System.out.println(" ! ! ! ! ! ! ! ");
                    scanner.nextLine();
                    System.out.println("Your Mom's Mr.Mime is staring back at you thru the mirror");
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
                case "BOOKSHELF":
                    System.out.println("You approach the bookshelf");
                    scanner.nextLine();
                    System.out.println("You see a picture of your dad and his CROAGUNK. You look a lot like him.");
                    scanner.nextLine();
                    System.out.println(" . . . . . .");
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
                default:
                    System.out.println("Ooops, there was a typo");

            }
        }
    }

    //cycle to use after player returns from the lab and first Battle
    public void inspectDownstairsRoom2(Trainer player){
        io = new Input();
        boolean loop = true;
        while(loop){
            System.out.println("Would you like to inspect \n TABLE -- TV -- WINDOW -- BOOKSHELF");
            String input = io.getString();
            switch(input.toUpperCase()){
                case "TABLE":
                    while(true){
                        System.out.println("Your mother is sitting at the table. Would you like to speak with her? Y/N");
                        String answ = io.getString();
                        if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                            convoWithMom2(player);
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
                            break;
                        }else if(answ.toLowerCase().equals("n")||answ.toLowerCase().equals("no")){
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
                            break;
                        }else{
                            System.out.println("Ooops, there was a typo");
                        }
                    }
                    break;
                case "TV":
                    System.out.println("The news is on. Something about roaming youth gangs near CELADON CITY.");
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
                case "WINDOW":
                    System.out.println("You go up to the window and look out");
                    scanner.nextLine();
                    System.out.println("You don't see anything outside");
                    System.out.println(" ! ! ! ! ! ! ! ");
                    scanner.nextLine();
                    System.out.println("MR.MIME is STANDING RIGHT BEHIND YOU!!!!");
                    scanner.nextLine();
                    System.out.println("aww, he pats you on the head and wobbles off (he's still kinda creepy tho...)");
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
                case "BOOKSHELF":
                    System.out.println("You approach the bookshelf");
                    scanner.nextLine();
                    System.out.println("You see a picture of your dad and his CROAGUNK. You look a lot like him.");
                    scanner.nextLine();
                    System.out.println(" . . . . . .");
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
                default:
                    System.out.println("Ooops, there was a typo");

            }
        }
    }

    public void convoWithMom(){
        System.out.println("Mom: Right. All boys leave home some day. It said so on TV. \nPROF.LIVEOAK, next door, is looking for you.");
        scanner.nextLine();
    }

    public void convoWithMom2(Trainer player){
        System.out.println("MOM: Oh! Is this the new POKEMON that PROF LIVEOAK gave you? Let's take a look at them!");
        scanner.nextLine();
        System.out.println("MOM: What a handsome looking " + player.retrieveTeamStarter().getName() + "!");
        scanner.nextLine();
        System.out.println("PROF LIVEOAK asked you to run an errand for him in VIRIDIAN CITY? Well now that you have your own POKEMON partner it shouldn't be a problem!");
        scanner.nextLine();
        System.out.println("If your POKEMON is ever tired come home and take a rest!");
    }
}
