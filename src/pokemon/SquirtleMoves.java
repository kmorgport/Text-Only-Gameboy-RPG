package pokemon;

import moves.Attack;
import moves.BuffDeBuff;
import moves.Moves;

import java.util.ArrayList;
import java.util.Arrays;

public class SquirtleMoves {
    public static ArrayList<Moves> findSquirtleMovesArrayList(){
        return new ArrayList<>(Arrays.asList(
                new Attack("Tackle","Normal","Physical",35,95,0,35),
                new BuffDeBuff("Tail Whip","Normal","Debuff",30,100,0,-1,"Defense",100),
                new Attack("Water Gun","Water","Special",25,100,0,40)));

    }
}
