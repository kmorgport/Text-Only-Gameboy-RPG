package trainers;

import items.Items;
import pokemon.Pokemon;

import java.util.*;

public class Protagonist extends Trainer {
    protected String trainerName;
    protected int money;
    protected LinkedHashMap<String,LinkedHashMap<String, Items>> inventory;
    protected LinkedHashMap<String, Items> items;
    protected LinkedHashMap<String, Items> medicine;
    protected LinkedHashMap<String, Items> battleItems;
    protected LinkedHashMap<String, Items> tms;
    protected LinkedHashMap<String, Items> keyItems;
    public Protagonist(String name){
        this.trainerName = name;
        money = 500;
        pokemonTeam = new ArrayList<>();
        inventory = new LinkedHashMap<>();
        items = new LinkedHashMap<>();
        inventory.put("Items",items);
        medicine = new LinkedHashMap<>();
        inventory.put("Medicine", medicine);
        battleItems = new LinkedHashMap<>();
        inventory.put("Battle-Items", battleItems);
        tms = new LinkedHashMap<>();
        inventory.put("TMs/HMs",tms);
        keyItems = new LinkedHashMap<>();
        inventory.put("Key Items", keyItems);

    }

    public LinkedHashMap<String,Items> getItems(){
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



    public void mapIterator(Map<String,Items>map){
        Iterator<Map.Entry<String,Items>> itr = map.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<String,Items>entry = itr.next();
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

}
