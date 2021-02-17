package Gameplay;

import pc.Computer;
import trainers.Trainer;
import util.Input;
public class PlayerHouseDownstairs {
    Input io;
    public PlayerHouseDownstairs(){}

    public void navigateLowerFloor(Trainer player,Trainer rival, Computer computer){
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("You walk downstairs and see your mother seated at the table drinking some tea.");
        inspectDownstairsRoom(player);
    }

    public int inspectDownstairsRoom(Trainer player){
        io = new Input();
        System.out.println("Would you like to inspect \n TABLE -- TV -- WINDOW -- BOOKSHELF");
        String input = io.getString();
        switch(input.toUpperCase()){
            case "TABLE":
                System.out.println("Your mother is sitting at the table. Would you like to speak with her? Y/N");
                String answ = io.getString();
                if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                    convoWithMom();
                    System.out.println("Would you like to inspect something else in the room? Y/N");
                    answ = io.getString();
                    if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                        return inspectDownstairsRoom(player);
                    }else{
                        break;
                    }
                }else{
                    System.out.println("Would you like to inspect something else in the room? Y/N");
                    answ = io.getString();
                    if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                        return inspectDownstairsRoom(player);
                    }else{
                        break;
                    }
                }
            case "TV":
                System.out.println("Your mom's favorite show is on. It's really old. Why did everyone wear shoulder pads back then?");
                System.out.println(" ");
                System.out.println("Would you like to inspect something else in the room? Y/N");
                answ = io.getString();
                if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                    return inspectDownstairsRoom(player);
                }else{
                    break;
                }
            case "WINDOW":
                System.out.println("You go up to the window and look out");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("HOLY ARCEUS!!");
                System.out.println(" ! ! ! ! ! ! ! ");
                System.out.println("Your Mom's Mr.Mime is staring back at you thru the mirror");
                System.out.println(" ");
                System.out.println("Would you like to inspect something else in the room? Y/N");
                answ = io.getString();
                if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                    return inspectDownstairsRoom(player);
                }else{
                    break;
                }
            case "BOOKSHELF":
                System.out.println("You approach the bookshelf");
                System.out.println(" ");
                System.out.println("You see a picture of your dad and his CROAGUNK. You look a lot like him.");
                System.out.println(" . . . . . .");
                System.out.println("Would you like to inspect something else in the room? Y/N");
                    answ = io.getString();
                    if(answ.toLowerCase().equals("y")||answ.toLowerCase().equals("yes")){
                        return inspectDownstairsRoom(player);
                    }else{
                        break;
                    }
            default:
                return inspectDownstairsRoom(player);

        }
    return 1;
    }

    public void convoWithMom(){
        System.out.println("Mom: Right. All boys leave home some day. It said so on TV. \nPROF.OAK, next door, is looking for you.");
        System.out.println(" ");
        System.out.println("- - - - - - - - - - ");
    }
}
