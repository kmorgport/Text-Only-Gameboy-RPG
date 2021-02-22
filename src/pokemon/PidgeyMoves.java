package pokemon;

import moves.Attack;
import moves.BuffDeBuff;
import moves.Moves;

import java.util.ArrayList;
import java.util.Arrays;

public class PidgeyMoves {
    public static ArrayList<Moves> findPidgeyMovesArrayList(){
        return new ArrayList<>(Arrays.asList(
                new Attack("Tackle","Normal","Physical",35,95,0,35),
                new BuffDeBuff("Sand-Attack","Ground","Debuff",15,100,0,-1,"Accuracy",100),
                new Attack("Gust","Flying","Special",35,100,0,40)));

    }
}
