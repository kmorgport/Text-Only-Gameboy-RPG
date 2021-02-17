package pokemon;

import moves.Moves;

import java.util.ArrayList;

public class Pidgey extends Pokemon{
    Pidgey(int level, int hpIV, int attackIV, int defenseIV, int specAttIV, int specDefIV, int speedIV) {
        super(level, hpIV, attackIV, defenseIV, specAttIV, specDefIV, speedIV);
        this.currentExpTotal = 0;
        name = "Pidgey";
        baseHP = 40;
        baseAttack = 45;
        baseDefense = 40;
        baseSpecialAttack = 35;
        baseSpecialDefense = 35;
        baseSpeed = 56;
        types = new ArrayList<>();
        types.add("Flying");
        types.add("Normal");
        this.maxHitPoints = findHP(baseHP,hpIV,0,level);
        this.hitPoints = this.maxHitPoints;
        this.attack = findStat(baseAttack,attackIV,0,level);
        this.defense = findStat(baseDefense,defenseIV,0,level);
        this.specialAttack = findStat(baseSpecialAttack,specAttIV,0,level);
        this.specialDefense = findStat(baseSpecialDefense,specDefIV,0,level);
        this.speed = findStat(baseSpeed,speedIV,0,level);
        baseExp = 50;
        experienceBaseLineForNewPokemon(level);
        setExpToNextLevel(expToNextLevel(level));
    }

    @Override
    //medium-slow group
    public int expToNextLevel(int level) {
        return (int) (((6/5)*Math.pow((level+1),3))-(15*Math.pow((level+1),2))+(100*(level+1))-140);
    }


    public ArrayList<Moves> pullMoveArrayList() {
        return BulbasaurMoves.findBulbasaurMovesArrayList();
    }
}
