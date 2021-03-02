package Gameplay;

import pc.Computer;
import trainers.Trainer;
import util.Input;

import java.util.Scanner;

public class FirstMetropolis {
    boolean oaksPackage = false;
    Input io = new Input();
    Scanner scanner = new Scanner(System.in);
    public FirstMetropolis(){
    }

    public void navigateFirstMetropolisFirstTime(Trainer player, Trainer rival, Computer computer){
        System.out.println("You've arrived at Viridian City!");
        southFirstMetroCenter(player, rival, computer);
    }

    public void southFirstMetroCenter(Trainer player, Trainer rival, Computer computer){
        System.out.println("You are in the southern half of Viridian City");
        scanner.nextLine();
        System.out.println("To the NORTH you see the main road leading to the norther center of town.");
        scanner.nextLine();
        System.out.println("To the EAST you see the POKE MART and the POKEMON CENTER");
        scanner.nextLine();
        System.out.println("To the WEST you see a road leaving town heading towards ARGENTUM RANGE");
        scanner.nextLine();
        System.out.println("To the SOUTH is ROUTE 1");
        scanner.nextLine();
        boolean choice = true;
        while(choice){
            System.out.println("Which path do you choose?");
            scanner.nextLine();
            System.out.println("NORTH--EAST--SOUTH--WEST");
            String answ = io.getString();
            if(answ.isEmpty()){
                System.out.println("Oops, there was a typo!");
            }else{
                switch(answ.toUpperCase()){
                    case "NORTH":
                        northernNexusFirstTimeFirstMetro(player,rival,computer);
                        choice = false;
                        break;
                    case "EAST":
//                        tallFieldNavigation(player);
                        System.out.println("You return to the path");
                        choice = false;
                        break;
                    case "WEST":
//                        tallFieldNavigation(player);
//                        System.out.println("You continue walking thru the tall grass...");
//                        tallFieldNavigation(player);
//                        middleRoute1Nexus(player, rival, computer);
                        choice = false;
                        break;
                    case "SOUTH":
                        Route1 route1 = new Route1();
                        route1.navigateRoute1FirstTime(player,rival,computer);
                        choice = false;
                        break;
                    default:
                        System.out.println("Oops, there was a typo!");

                }
            }

        }

    }

    public void amenitiesDistrict(Trainer player, Trainer rival, Computer computer){
        System.out.println("You arrive in the Amenities District");
        scanner.nextLine();
        System.out.println("You see a POKEMART and a POKECENTER.");
        scanner.nextLine();
        boolean choice = true;
        while(choice){
            System.out.println("Which one would you like to enter?");
            scanner.nextLine();
            System.out.println("MART-CENTER-RETURN");
            String answ = io.getString();
            if(answ.isEmpty()){
                System.out.println("Oops, there was a typo!");
            }else{
                switch(answ.toUpperCase()){
                    case "MART":
                        if(!oaksPackage){
                            oaksPackage = marketFirstVisit();
                        }else{
                            System.out.println("You need to deliver PROF LIVEOAK's package. Better get it back to him!");
                            scanner.nextLine();
                        }
                        choice = false;
                        break;
                    case "CENTER":
                        firstMetroRestCenterFirstVisit(player, rival, computer);
                        System.out.println("You return to the path");
                        choice = false;
                        break;
                    case "RETURN":
                        southFirstMetroCenter(player,rival,computer);
                        choice = false;
                        break;
                    default:
                        System.out.println("Oops, there was a typo!");

                }
            }


        }
    }

    public void healthCenterVisit(Trainer player, Trainer rival, Computer computer){
        System.out.println("You walk into the POKECENTER and look around");
        scanner.nextLine();
        System.out.println("On the WEST side of the room is a man sitting on a couch.");
        scanner.nextLine();
        System.out.println("On the NORTH side of the room is the clinic attendant healing a patient's POKEMON.");
        scanner.nextLine();
        System.out.println("On the EAST side of the building is the public PC");
        scanner.nextLine();
        System.out.println("The exit is on the SOUTH side of the building.");
        boolean loop = true;
        while(loop){
            System.out.println("Which direction do you choose?");
            scanner.nextLine();
            System.out.println("--WEST--NORTH--EAST--SOUTH--");
            String answ = io.getString();
            if(answ.isEmpty()){
                System.out.println("Oops, there was a typo!");
            }else{
                switch(answ.toUpperCase()){
                    case "WEST":
                        System.out.println("You walk up to the man sitting on the bench");
                        scanner.nextLine();
                        while(true){
                            System.out.println("Would you like to speak to the man? Y/N");
                            answ = io.getString();
                            if(answ.isEmpty()){
                                System.out.println("Oops, there was a typo!");
                            }else if(answ.equalsIgnoreCase("y")||answ.equalsIgnoreCase("yes")){
                                System.out.println("OLDER MAN: Oh hello there! I'm waiting for my granddaughter to heal her POKEMON!");
                                scanner.nextLine();
                                System.out.println("OLDER MAN: Did you know you can use the PCs here? They're free to the public!");
                                scanner.nextLine();
                                System.out.println("The man's phone starts ringing.");
                                scanner.nextLine();
                                System.out.println("OLDER MAN: Oh! Excuse me, I need to take this.");
                                scanner.nextLine();
                                System.out.println("He's talking to the person on the other end.");
                                scanner.nextLine();
                                System.out.println("It seems to be about the road closure leading out of the city.");
                                scanner.nextLine();
                                System.out.println("You should leave him be...");
                                break;
                            }else if(answ.equalsIgnoreCase("n")||answ.equalsIgnoreCase("no")){
                                System.out.println("He appears busy, let's not bother him...");
                                break;
                            }else{
                                System.out.println("Oops, there was a typo!");
                            }
                        }
                        break;
                    case "NORTH":
                        System.out.println("You approach the clinic desk.");
                        scanner.nextLine();
                        System.out.println("The vet technician is finishing up with the young woman in front of you.");
                        scanner.nextLine();
                        while(true){
                            System.out.println("Would you like to heal your POKEMON?");
                            answ = io.getString();
                            if(answ.isEmpty()){
                                System.out.println("Oops, there was a typo!");
                            }else if(answ.equalsIgnoreCase("y")||answ.equalsIgnoreCase("yes")){
                                System.out.println("You approach the front desk");
                                scanner.nextLine();
                                System.out.println("The technician greets you....their hair matches the CHANSEY that is assisting them.");
                                scanner.nextLine();
                                System.out.println("TECH: Welcome to the POKECENTER! We can heal your POKEMON back to perfect health!");
                                scanner.nextLine();
                                System.out.println("You hand over your POKEMON to the technician.");
                                scanner.nextLine();
                                System.out.println("One moment please!");
                                scanner.nextLine();
                                player.retrieveTeamStarter().healPokemon();
                                System.out.println("You hand the technician your POKEMON.");
                                scanner.nextLine();
                                System.out.println("They place them inside a large machine that comes down and bathes the POKEBALLS in a vibrant blue light for several minutes.");
                                scanner.nextLine();
                                System.out.println("TECH: OK! Your POKEMON are healed! We hope you have a pleasant day!");
                                scanner.nextLine();
                                System.out.println("You leave the front desk");
                                break;
                            }else if(answ.equalsIgnoreCase("n")||answ.equalsIgnoreCase("no")){
                                System.out.println(player.retrieveTeamStarter().getName() + " is in good health, you can always come back later!");
                                scanner.nextLine();
                                break;
                            }else{
                                System.out.println("Oops, there was a typo!");
                            }
                        }
                        break;
                    case "EAST":
                        System.out.println("You approach the Computer.");
                        scanner.nextLine();
                        System.out.println("Wow, the line looks really long!");
                        scanner.nextLine();
                        System.out.println("Let's try and come back and use it later!");
                        scanner.nextLine();
                        break;
                    case "SOUTH":
                        System.out.println("Are you ready to leave the POKECENTER?");
                    default:
                        System.out.println("Oops, there was a typo!");

                }
            }
        }

    }

    public void firstMetroRestCenterFirstVisit(Trainer player, Trainer rival, Computer computer){
        System.out.println("You walk inside the POKECENTER.");
    }

    public boolean marketFirstVisit(){
        System.out.println("You enter the POKEMART");
        scanner.nextLine();
        System.out.println("The store clerk sees you and waves you over");
        scanner.nextLine();
        System.out.println("CLERK: Hey! Your the youngin' I saw on ROUTE 1!");
        scanner.nextLine();
        System.out.println("CLERK:You're from PALLET TOWN aren't you?");
        scanner.nextLine();
        System.out.println("CLERK: This is excellent!");
        scanner.nextLine();
        System.out.println("CLERK: We finally recieved a part in that PROF LIVEOAK has been asking for!\nHere! Can you take it back?");
        scanner.nextLine();
        System.out.println("You don't really seem to have the option to say no...");
        scanner.nextLine();
        System.out.println("You accept PROF LIVEOAK's PACKAGE!");
        scanner.nextLine();
        System.out.println("CLERK: He's been waiting for that part for a while! Better hurry up and take it back to him!");
        scanner.nextLine();
        System.out.println("The clerk begins to help another customer, guess you better take this package back!");
        return true;
    }

    public void northernNexusFirstTimeFirstMetro(Trainer player,Trainer rival, Computer computer){
        System.out.println("You arrive at the Norther center of VIRIDIAN CITY");
        scanner.nextLine();
        System.out.println("It looks like there was some sort of protest that recently ended");
        scanner.nextLine();
        System.out.println("It looks like it might be difficult to make it further NORTH but you can try?");
        scanner.nextLine();
        System.out.println("To the EAST you see some residential houses and beyond that an enormous building\nThat must be the gym!");
        scanner.nextLine();
        System.out.println("To the SOUTH is the path back to the South side of VIRIDIAN CITY");
        scanner.nextLine();
        boolean choice = true;
        while(choice){
            System.out.println("Which direction do you choose?");
            scanner.nextLine();
            System.out.println("NORTH--EAST--SOUTH");
            String answ = io.getString();
            if(answ.isEmpty()){
                System.out.println("Oops, there was a typo!");
            }else{
                switch(answ.toUpperCase()){
                    case "NORTH":

                        choice = false;
                        break;
                    case "EAST":
//                        tallFieldNavigation(player);
                        System.out.println("You return to the path");
                        choice = false;
                        break;
                    case "SOUTH":
                        southFirstMetroCenter(player,rival,computer);
                        choice = false;
                        break;
                    default:
                        System.out.println("Oops, there was a typo!");

                }
            }

        }

    }
}
