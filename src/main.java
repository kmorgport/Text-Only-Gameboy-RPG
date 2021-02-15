import Gameplay.Battle;
import items.Antidote;
import items.Items;
import items.Potion;
import moves.Moves;
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
        Bulbasaur bulbasaur = new Bulbasaur(5,random,random,random,random,random,random);
        Charmander charmander = new Charmander(5,random,random,random,random,random,random);
        Squirtle squirtle = new Squirtle(5,random,random,random,random,random,random);
        Battle battle = new Battle();
        Trainer red = new Protagonist("Red");
        Items potion = new Potion();
        Items antidote = new Antidote();
        potion.setQuantity(2);
        red.addToItems(potion);
        red.addToItems(antidote);
        red.mapIterator(red.getItems());


    }
}
