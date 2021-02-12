import Gameplay.Battle;
import moves.Moves;
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
        Battle battle = new Battle();
        battle.battleCycle(charmander,bulbasaur);
//        Moves[] moveList = squirtle.pullMoveList();
//        System.out.println(moveList[0].type);
//        System.out.println(charmander.getAttackEV());

    }
}
