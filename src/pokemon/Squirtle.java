package pokemon;

import moves.Moves;

import java.util.ArrayList;
import java.util.HashMap;

public class Squirtle extends Pokemon{
    protected int currentExpTotal;
    protected int expToNextLevel;
    public Squirtle(int level, int hpIV, int attackIV, int defenseIV, int specAttIV, int specDefIV, int speedIV) {
        super(level, hpIV, attackIV, defenseIV, specAttIV, specDefIV, speedIV);
        this.currentExpTotal = 0;
        name = "Squirtle";
        baseHP = 44;
        baseAttack = 48;
        baseDefense = 65;
        baseSpecialAttack = 50;
        baseSpecialDefense = 64;
        baseSpeed = 43;
        types = new ArrayList<>();
        types.add("Water");
        types.add(null);
        this.maxHitPoints = findHP(baseHP,hpIV,0,level);
        this.hitPoints = this.maxHitPoints;
        this.attack = findStat(baseAttack,attackIV,0,level);
        this.defense = findStat(baseDefense,defenseIV,0,level);
        this.specialAttack = findStat(baseSpecialAttack,specAttIV,0,level);
        this.specialDefense = findStat(baseSpecialDefense,specDefIV,0,level);
        this.speed = findStat(baseSpeed,speedIV,0,level);
        baseExp = 63;
        experienceBaseLineForNewPokemon(level);
        setExpToNextLevel(expToNextLevel(level));
    }

    @Override
    public int expToNextLevel(int level) {
        return (int) (((6/5)*Math.pow((level+1),3))-(15*Math.pow((level+1),2))+(100*(level+1))-140);
    }


    public ArrayList<Moves> pullMoveArrayList() {
        return SquirtleMoves.findSquirtleMovesArrayList();
    }

    @Override
    public void learnNewMove(HashMap<Integer,Moves> moves) {

    }
}
