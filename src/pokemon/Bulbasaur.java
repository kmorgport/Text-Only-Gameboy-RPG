package pokemon;

import moves.Moves;

import java.util.ArrayList;

public class Bulbasaur extends Pokemon{
    protected int currentExpTotal;
    protected int expToNextLevel;

    public Bulbasaur(int level, int hpIV, int attackIV, int defenseIV, int specAttIV, int specDefIV, int speedIV) {
        super(level, hpIV, attackIV, defenseIV, specAttIV, specDefIV, speedIV);
        this.currentExpTotal = 0;
        name = "Bulbasaur";
        baseHP = 45;
        baseAttack = 49;
        baseDefense = 49;
        baseSpecialAttack = 65;
        baseSpecialDefense = 65;
        baseSpeed = 45;
        types = new ArrayList<>();
        types.add("Grass");
        types.add("Poison");
        this.hitPoints = findHP(baseHP,hpIV,0,level);
        this.attack = findStat(baseAttack,attackIV,0,level);
        this.defense = findStat(baseDefense,defenseIV,0,level);
        this.specialAttack = findStat(baseSpecialAttack,specAttIV,0,level);
        this.specialDefense = findStat(baseSpecialDefense,specDefIV,0,level);
        this.speed = findStat(baseSpeed,speedIV,0,level);
        baseExp = 64;
        experienceBaseLineForNewPokemon(level);
        setExpToNextLevel(expToNextLevel(level));
    }

    public int expToNextLevel(int level) {
       return (int) (((6/5)*Math.pow((level+1),3))-(15*Math.pow((level+1),2))+(100*(level+1))-140);
    }


    public Moves[] pullMoveList() {
        Moves[] allmoves = BulbasaurMoves.findBulbasaurMoves();
        Moves[] moveset = new Moves[3];
        for(int i=0; i<allmoves.length; i++){
            moveset[i]= allmoves[i];
        }
        return moveset;
    }


}
