package pokemon;

import moves.Attack;
import moves.BuffDeBuff;
import moves.Moves;

public class CharmanderMoves {
    public static Moves[] findCharmanderMoves(){
        return new Moves[]{
                new Attack("Scratch","Normal","Physical",35,100,40),
                new BuffDeBuff("Growl","Normal","Status",40,100,-1,"Attack",100),
                new Attack("Ember","Fire","Special",25,100,40)
        };
    }
}
