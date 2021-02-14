package trainers;

import items.Items;
import pokemon.Pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Protagonist extends Trainer {
    protected String trainerName;
    protected int money;
    protected ArrayList<Pokemon> pokemonTeam;
    protected LinkedHashMap<String,LinkedHashMap<String, Items>> inventory;
    public Protagonist(String name){
        this.trainerName = name;
        pokemonTeam = null;
        money = 500;
    }

    public Pokemon retrieveTeamStarter(){
        return this.pokemonTeam.get(0);
    }
}
