package trainers;

import pokemon.Pokemon;

import java.util.ArrayList;

public class Protagonist implements Trainers {
    protected String trainerName;
    protected int money;
    protected ArrayList<Pokemon> pokemonTeam;
    public Protagonist(String name){
        this.trainerName = name;
        pokemonTeam = null;
        money = 500;
    }
}
