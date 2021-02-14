package trainers;

import pokemon.Pokemon;

import java.util.ArrayList;

public class Rival extends Trainer{
    public Rival(String name){
        this.name = name;
        money = 500;
        pokemonTeam = new ArrayList<>();
    }

}
