package Gameplay;

import pc.Computer;
import trainers.Protagonist;
import trainers.Rival;
import trainers.Trainer;
import util.Input;

import java.util.Scanner;

public class NewGame {
    protected Trainer player;
    protected Trainer rival;
    Input input = new Input();
    Scanner scanner = new Scanner(System.in);

    public NewGame(){}
    public void beginGame(){
        System.out.println(" ");
        System.out.println("LIVEOAK: Hello there! Welcome to the world of POKEMON! My name is LIVEOAK! People call me the POKEMON PROF!");
        scanner.nextLine();
        //sandshrew/or ponyta ascii art appears
        System.out.println("LIVEOAK: This world is inhabited by creatures called POKEMON! For some people, POKEMON are pets. Others use them for fights. \nMyself...I study POKEMON as a profession.");
        scanner.nextLine();
        System.out.println("LIVEOAK: First, what is your name?...");
        String name = input.getString();
        if(name.isEmpty()) {
            name = "RED";
        }
        System.out.println("LIVEOAK: Right! So your name is " + name + "!");
        scanner.nextLine();
        System.out.println("LIVEOAK: Oh that's right, you grew up with my grandson! Y'all have been rivals since you were youngin's.\n...Erm, what is his name again?");
        String rivalName = input.getString();
        if(rivalName.isEmpty()) {
            rivalName = "BLUE";
        }
        System.out.println("LIVEOAK: That's right! I remember now! His name is " + rivalName + "!");
        scanner.nextLine();
        System.out.println("LIVEOAK: " + name + "! Your very own POKEMON legend is about to unfold! A world of\n" +
                "            dreams and adventures with POKEMON awaits! Let's go!");
        scanner.nextLine();
        Trainer protagonist = new Protagonist(name);
        Trainer rival = new Rival(rivalName);
        Computer computer = new Computer();
        PlayerHouse playerHouse = new PlayerHouse();
        playerHouse.navigateHouse(protagonist,rival,computer);

    }
}
