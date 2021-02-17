package pokemon;

import moves.Attack;
import moves.BuffDeBuff;
import moves.Moves;

import java.util.ArrayList;
import java.util.Arrays;

public class BulbasaurMoves {
    public static Moves[] findBulbasaurMoves(){
        return new Moves[]{
                new Attack("Tackle","Normal","Physical",35,95,35),
                new BuffDeBuff("Growl","Normal","Debuff",40,100,-1,"Attack",100),
                new Attack("Vine Whip","Grass","Physical",25,100,45)
        };
    }

    public static ArrayList<Moves> findBulbasaurMovesArrayList(){
        return new ArrayList<>(Arrays.asList(new Attack("Tackle","Normal","Physical",35,95,35),new BuffDeBuff("Growl","Normal","Debuff",40,100,-1,"Attack",100),new Attack("Vine Whip","Grass","Physical",25,100,45)));

    }
}
