import Gameplay.Battle;
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
        Trainer green = new Rival("Blue");
        red.addPokemonToTeam(charmander);
        green.addPokemonToTeam(bulbasaur);
        battle.battleCycle(red,green);

    }
}
