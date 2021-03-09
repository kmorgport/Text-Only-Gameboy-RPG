package pokemon;

import moves.Attack;
import moves.BuffDeBuff;
import moves.Moves;
import moves.StatusEffect;

import java.util.ArrayList;
import java.util.Arrays;

public class CharmanderMoves {
    public static ArrayList<Moves> findCharmanderMovesArrayList(){
        return new ArrayList<>(Arrays.asList(
                new Attack("Scratch","Normal","Physical",35,100,0,40),
                new BuffDeBuff("Growl","Normal","Debuff",40,100,0,-1,"Attack",100),
                new Attack("Ember","Fire","Special",25,100,0,40),
                new StatusEffect("Will-O-Wisp","Fire","Status",35,75,0,"Burn",100)));

    }
}
