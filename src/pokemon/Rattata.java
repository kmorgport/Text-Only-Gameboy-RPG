package pokemon;

import moves.Moves;

import java.util.ArrayList;
import java.util.HashMap;

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
        ArrayList<Moves> moves = RattataMoves.findRattataMovesArrayList();
    }

    @Override
    //medium-fast group
    public int expToNextLevel(int level) {
        return (int) Math.pow(level, 3);
    }

    public ArrayList<Moves> pullMoveArrayList() {
        return RattataMoves.findRattataMovesArrayList();
    }

    @Override
    public void learnNewMove(HashMap<Integer,Moves> moves){
        if(moves.containsKey(this.level)&&moves.size()<4){
            this.moves.add(moves.get(this.level));
        }
    }
}
