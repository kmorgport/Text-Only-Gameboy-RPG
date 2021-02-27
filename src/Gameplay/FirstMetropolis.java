package Gameplay;

import pc.Computer;
import trainers.Trainer;
import util.Input;

import java.util.Scanner;

public class FirstMetropolis {
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

                        choice = false;
                        break;
                    case "EAST":
                        tallFieldNavigation(player);
                        System.out.println("You return to the path");
                        choice = false;
                        break;
                    case "WEST":
                        tallFieldNavigation(player);
                        System.out.println("You continue walking thru the tall grass...");
                        tallFieldNavigation(player);
                        middleRoute1Nexus(player, rival, computer);
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
                        tallFieldNavigation(player);
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
