package trainers;

import items.Items;
import pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

abstract public class Trainer {
    protected String name;
    protected int money;
    protected ArrayList<Pokemon> pokemonTeam;
    protected LinkedHashMap<String,LinkedHashMap<String, Items>> inventory;
    protected LinkedHashMap<String, Items> items;
    protected LinkedHashMap<String, Items> medicine;
    protected LinkedHashMap<String, Items> battleItems;
    protected LinkedHashMap<String, Items> tms;
    protected LinkedHashMap<String, Items> keyItems;
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

    public LinkedHashMap<String, Items> getItems(){
        return this.items;
    }
    public void addToItems(Items item){
        items.put(item.getName(),item);
    }

    public LinkedHashMap<String,Items> getMedicine(){
        return this.medicine;
    }
    public void addToMedicine(Items item){
        medicine.put(item.getName(),item);
    }

    public LinkedHashMap<String,Items> getBattleItems(){
        return this.battleItems;
    }
    public void addToBattleItems(Items item){
        battleItems.put(item.getName(), item);
    }

    public LinkedHashMap<String,Items> getTms(){
        return this.tms;
    }
    public void addToTMs(Items item){
        tms.put(item.getName(),item);
    }

    public LinkedHashMap<String,Items> getKeyItems(){
        return this.keyItems;
    }
    public void addToKeyItems(Items item){
        keyItems.put(item.getName(), item);
    }



    public void mapIterator(Map<String,Items> map) {
        Iterator<Map.Entry<String, Items>> itr = map.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, Items> entry = itr.next();
            System.out.println(entry.getKey() + " " + entry.getValue().getQuantity());
        }
    }
}
