package trainers;

import items.Items;
import pokemon.Pokemon;

import java.util.*;

public class Protagonist extends Trainer {
    public Protagonist(String name){
        this.name = name;
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

}
