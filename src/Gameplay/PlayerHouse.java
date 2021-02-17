package Gameplay;

import trainers.Trainer;
import util.Input;

public class PlayerHouse {
    Input io;
    public PlayerHouse(Trainer player,Trainer rival){
    }

    public void navigateHouse(Trainer player, Trainer rival){
        System.out.println("You look around your room");
        inspectRoom();

    }

    public int inspectRoom(){
        io = new Input();
        System.out.println("Would you like to inspect \n BED -- TV -- PLANT -- COMPUTER");
        String input = io.getString();
        switch(input.toUpperCase()){
            case "BED":
                System.out.println("Yup, it's a bed! You should take better care of it! It's the only bed in the house!");
                System.out.println("Would you like to inspect something else in the room? Y/N");
                String answ = io.getString();
                if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                    return inspectRoom();
                }else{
                    break;
                }
            case "TV":
                System.out.println("There's a show about crying rocks on. It's kinda weird, but somehow, still fun?");
                System.out.println("It's an SNES! Kind of an odd console for a ten year old in 202x to own, but you do you!");
                System.out.println("Would you like to inspect something else in the room? Y/N");
                answ = io.getString();
                if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                    return inspectRoom();
                }else{
                    break;
                }
            case "PLANT":
                System.out.println("It's your plant! MOM said we couldn't have our first pokemon until we could keep a plant alive!");
                System.out.println("Would you like to inspect something else in the room? Y/N");
                answ = io.getString();
                if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                    return inspectRoom();
                }else{
                    break;
                }
            case "COMPUTER":
                System.out.println("It's your LEPPA BERRY Laptop! Would you like to use it? Y/N");
                answ = io.getString();
                if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                    //open computer
                }else{
                    System.out.println("Would you like to inspect something else in the room? Y/N");
                    answ = io.getString();
                    if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                        return inspectRoom();
                    }else{
                        break;
                    }
                }
            default:
                return inspectRoom();

        }
        return 1;
    }
}
