package pokemon;

import moves.Moves;

import java.util.ArrayList;

public class Rattata extends Pokemon {

    public Rattata(int level, int hpIV, int attackIV, int defenseIV, int specAttIV, int specDefIV, int speedIV) {
        super(level, hpIV, attackIV, defenseIV, specAttIV, specDefIV, speedIV);
        this.currentExpTotal = 0;
        name = "Rattata";
        baseHP = 30;
        baseAttack = 56;
        baseDefense = 35;
        baseSpecialAttack = 25;
        baseSpecialDefense = 35;
        baseSpeed = 72;
        types = new ArrayList<>();
        types.add("Normal");
        types.add(null);
        this.maxHitPoints = findHP(baseHP,hpIV,0,level);
        this.hitPoints = this.maxHitPoints;
        this.attack = findStat(baseAttack,attackIV,0,level);
        this.defense = findStat(baseDefense,defenseIV,0,level);
        this.specialAttack = findStat(baseSpecialAttack,specAttIV,0,level);
        this.specialDefense = findStat(baseSpecialDefense,specDefIV,0,level);
        this.speed = findStat(baseSpeed,speedIV,0,level);
        baseExp = 51;
        experienceBaseLineForNewPokemon(level);
        setExpToNextLevel(expToNextLevel(level));
    }

    @Override
    //medium-fast group
    public int expToNextLevel(int level) {
        return (int) Math.pow(level, 3);
    }

    public ArrayList<Moves> pullMoveArrayList() {
        return RattataMoves.findRattataMovesArrayList();
    }
}
