package Gameplay;

import util.Input;

public class NewGame {

    Input input = new Input();

    public NewGame(){}
    public void beginGame(){
        System.out.println(" ");
        System.out.println("LIVEOAK: Hello there! Welcome to the world of POKEMON! My name is LIVEOAK! People call me the POKEMON PROF!");
        //sandshrew/or ponyta ascii art appears
        System.out.println(" ");
        System.out.println("LIVEOAK: This world is inhabited by creatures called POKEMON! For some people, POKEMON are pets. Others use them for fights. \nMyself...I study POKEMON as a profession.");
        System.out.println(" ");
        System.out.println("LIVEOAK: First, what is your name?...");
        String name = input.getString();
        if(name.isEmpty()) {
            name = "RED";
        }
        System.out.println("LIVEOAK: Right! So your name is " + name + "!");
    }
}
