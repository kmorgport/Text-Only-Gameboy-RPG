package trainers;

import items.Items;
import pokemon.Pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Protagonist extends Trainer {
    protected String trainerName;
    protected int money;
    protected LinkedHashMap<String,LinkedHashMap<String, Items>> inventory;
    public Protagonist(String name){
        this.trainerName = name;
        money = 500;
        pokemonTeam = new ArrayList<>();
    }

}
