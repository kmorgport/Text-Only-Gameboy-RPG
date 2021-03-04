package pokemon;

import moves.Attack;
import moves.BuffDeBuff;
import moves.Moves;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BulbasaurMoves {

    public static ArrayList<Moves> findBulbasaurMovesArrayList(){
        return new ArrayList<>(Arrays.asList(new Attack("Tackle","Normal","Physical",35,95,0,35),new BuffDeBuff("Growl","Normal","Debuff",40,100,0,-1,"Attack",100),new Attack("Vine Whip","Grass","Physical",25,100,0,45)));
    }

}
