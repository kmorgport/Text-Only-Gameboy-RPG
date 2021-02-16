package pokemon;

import moves.Moves;

import java.util.ArrayList;

public class Charmander extends Pokemon{
    protected int currentExpTotal;
    protected int expToNextLevel;

    public Charmander(int level, int hpIV, int attackIV, int defenseIV, int specAttIV, int specDefIV, int speedIV) {
        super(level, hpIV, attackIV, defenseIV, specAttIV, specDefIV, speedIV);
        this.currentExpTotal = 0;
        name = "Charmander";
        baseHP = 39;
        baseAttack = 52;
        baseDefense = 43;
        baseSpecialAttack = 60;
        baseSpecialDefense = 50;
        baseSpeed = 65;
        types = new ArrayList<>();
        types.add("Fire");
        types.add(null);
        this.maxHitPoints = findHP(baseHP,hpIV,0,level);
        this.hitPoints = this.maxHitPoints;
        this.attack = findStat(baseAttack,attackIV,0,level);
        this.defense = findStat(baseDefense,defenseIV,0,level);
        this.specialAttack = findStat(baseSpecialAttack,specAttIV,0,level);
        this.specialDefense = findStat(baseSpecialDefense,specDefIV,0,level);
        this.speed = findStat(baseSpeed,speedIV,0,level);
        baseExp = 62;
        experienceBaseLineForNewPokemon(level);
        setExpToNextLevel(expToNextLevel(level));
    }


    @Override
    public int expToNextLevel(int level) {
        return (int) (((6/5)*Math.pow((level+1),3))-(15*Math.pow((level+1),2))+(100*(level+1))-140);
    }

    @Override
    public Moves[] pullMoveList() {
        Moves[] allmoves = CharmanderMoves.findCharmanderMoves();
        Moves[] moveset = new Moves[3];
        for(int i=0; i<allmoves.length; i++){
            moveset[i]= allmoves[i];
        }
        return moveset;
    }
}
