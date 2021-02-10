import pokemon.Bulbasaur;
import pokemon.Charmander;
import pokemon.Squirtle;

import java.util.Arrays;

public class main {
    public static void main(String[] args){
        int random = (int) Math.floor(Math.random()*15)+1;
        Bulbasaur bulbasaur = new Bulbasaur(5,random,random,random,random,random,random);
        Charmander charmander = new Charmander(5,random,random,random,random,random,random);
        Squirtle squirtle = new Squirtle(5,random,random,random,random,random,random);
        int[] evs = bulbasaur.getExpVal();
        System.out.println(Arrays.toString(evs));
        charmander.earnEVS(evs);
        charmander.earnEVS(evs);
        System.out.println(charmander.getAttackEV());

    }
}
