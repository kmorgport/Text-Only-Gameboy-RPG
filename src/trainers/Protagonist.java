package trainers;

import pokemon.Pokemon;

import java.util.ArrayList;

public class Protagonist extends Trainer {
    protected String trainerName;
    protected int money;
    protected ArrayList<Pokemon> pokemonTeam;
    public Protagonist(String name){
        this.trainerName = name;
        pokemonTeam = null;
        money = 500;
    }

    public Pokemon retrieveTeamStarter(){
        return this.pokemonTeam.get(0);
    }
}
