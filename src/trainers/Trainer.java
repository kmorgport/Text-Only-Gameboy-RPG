package trainers;

import pokemon.Pokemon;

import java.util.ArrayList;

abstract public class Trainer {
    protected String name;
    protected int money;
    protected ArrayList<Pokemon> pokemonTeam;
    public Trainer(){
    }

    public Pokemon retrieveTeamStarter(){
        return this.pokemonTeam.get(0);
    }

    public void addPokemonToTeam(Pokemon pokemon){
        this.pokemonTeam.add(pokemon);
    };

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getMoney(){
        return this.money;
    }

    public void setMoney(int money){
        this.money = money;
    }

    public ArrayList<Pokemon> getPokemonTeam(){
        return this.pokemonTeam;
    }

}
