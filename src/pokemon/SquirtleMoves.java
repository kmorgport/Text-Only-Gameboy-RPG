package pokemon;

import moves.Attack;
import moves.BuffDeBuff;
import moves.Moves;

public class SquirtleMoves {
    public static Moves[] findSquirtleMoves(){
        return new Moves[]{
                new Attack("Tackle","Normal","Physical",35,95,35),
                new BuffDeBuff("Tail Whip","Normal","Status",30,100,-1,"Defense",100),
                new Attack("Water Gun","Water","Special",25,100,40)
        };
    }
}
