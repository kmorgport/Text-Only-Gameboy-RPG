package pokemon;

import moves.Attack;
import moves.AttackAndStatus;
import moves.BuffDeBuff;
import moves.Moves;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class WeedleMoves {

    public static ArrayList<Moves> findWeedleMovesArrayList(){
        return new ArrayList<>(Arrays.asList(
                new AttackAndStatus("Poison Sting","Poison","AttackStatusPhys",35,100,0,15,"Poison",20),
                new BuffDeBuff("Tail Whip","Normal","Debuff",30,100,0,-1,"Defense",100)));

    }

    public static HashMap<Integer,Moves> levelUpNewMoves(){
        HashMap<Integer, Moves> moveList = new HashMap<>();
//        moveList.put(1, new Attack("Tackle","Normal","Physical",35,95,0,35));
//        moveList.put(2,new BuffDeBuff("Tail Whip","Normal","Debuff",30,100,0,-1,"Defense",100));
        moveList.put(7, new Attack("Quick Attack","Normal","Physical",35,100,1,40));
        moveList.put(14,new Attack("Hyper Fang","Normal","Physical",15,90,0,80));

        return moveList;
    }


}
