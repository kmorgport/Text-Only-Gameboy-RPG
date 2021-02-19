import Gameplay.*;
import items.Antidote;
import items.Items;
import items.Potion;
import moves.Moves;
import pc.Computer;
import pokemon.Bulbasaur;
import pokemon.Charmander;
import pokemon.Pokemon;
import pokemon.Squirtle;
import trainers.Protagonist;
import trainers.Rival;
import trainers.Trainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args){
        int random = (int) Math.floor(Math.random()*15)+1;
        Trainer red = new Protagonist("Red");
        Trainer blue = new Rival("Blue");
        Computer pc = new Computer();
//        NewGame newGame = new NewGame();
//        newGame.beginGame();
//        Hometown pallet = new Hometown();
//        pallet.returnToLab(red,blue,pc);
        Hometown test = new Hometown();
        test.homeTownFirstVisit(red, blue,pc);




        //BATTLE TESTING
//        Bulbasaur bulbasaur = new Bulbasaur(5,random,random,random,random,random,random);
//        Charmander charmander = new Charmander(5,random,random,random,random,random,random);
//        Squirtle squirtle = new Squirtle(5,random,random,random,random,random,random);
//        Battle battle = new Battle();
////        System.out.println(bulbasaur.pullMoveArrayList());
//        Trainer red = new Protagonist("Red");
//        Trainer blue = new Rival("Green");
//        red.addPokemonToTeam(charmander);
//        blue.addPokemonToTeam(bulbasaur);
//        Items potion = new Potion();
//        Items antidote = new Antidote();
////        potion.setQuantity(1);
//        red.addToMedicine(potion);
//        red.addToMedicine(antidote);
//        battle.battleCycle(red,blue);



    }
}
