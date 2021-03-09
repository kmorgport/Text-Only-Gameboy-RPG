package pokemon;

import moves.Attack;
import moves.BuffDeBuff;
import moves.Moves;
import moves.StatusEffect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BulbasaurMoves {

    public static ArrayList<Moves> findBulbasaurMovesArrayList(){
        return new ArrayList<>(Arrays.asList(new Attack("Tackle","Normal","Physical",35,95,0,35),new BuffDeBuff("Growl","Normal","Debuff",40,100,0,-1,"Attack",100),new Attack("Vine Whip","Grass","Physical",25,100,0,45),new StatusEffect("Poison Powder","Grass","Status",35,75,0,"Poison",100)));
    }

    public static HashMap<Integer,Moves> levelUpNewMoves(){
        HashMap<Integer, Moves> moveList = new HashMap<>();
//        moveList.put(1, new Attack("Tackle","Normal","Physical",35,95,0,35));
//        moveList.put(2,new BuffDeBuff("Tail Whip","Normal","Debuff",30,100,0,-1,"Defense",100));
        moveList.put(7, new StatusEffect("Poison Powder","Grass","Status",35,75,0,"Poison",100));
        moveList.put(14,new Attack("Hyper Fang","Normal","Physical",15,90,0,80));

        return moveList;
    }

}
