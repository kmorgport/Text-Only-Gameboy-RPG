package pokemon;

import moves.Attack;
import moves.AttackAndBuff;
import moves.BuffDeBuff;
import moves.Moves;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SquirtleMoves {
    public static ArrayList<Moves> findSquirtleMovesArrayList(){
        return new ArrayList<>(Arrays.asList(
                new Attack("Tackle","Normal","Physical",35,95,0,35),
                new BuffDeBuff("Tail Whip","Normal","Debuff",30,100,0,-1,"Defense",100),
                new Attack("Water Gun","Water","Special",25,100,0,40)));
    }

    public static HashMap<Integer,Moves> levelUpNewMoves(){
        HashMap<Integer, Moves> moveList = new HashMap<>();
//        moveList.put(1, new Attack("Tackle","Normal","Physical",35,95,0,35));
//        moveList.put(2,new BuffDeBuff("Tail Whip","Normal","Debuff",30,100,0,-1,"Defense",100));
        moveList.put(8, new AttackAndBuff("Bubble","Water","AttackDeBuffSpec",30,100,0,20,-1,"Speed",30));

        return moveList;
    }
}
