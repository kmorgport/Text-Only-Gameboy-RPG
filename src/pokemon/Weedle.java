package pokemon;

import moves.Moves;

import java.util.ArrayList;
import java.util.HashMap;

public class Weedle extends Pokemon{

    public Weedle(int level, int hpIV, int attackIV, int defenseIV, int specAttIV, int specDefIV, int speedIV) {
        super(level, hpIV, attackIV, defenseIV, specAttIV, specDefIV, speedIV);
        this.currentExpTotal = 0;
        name = "Weedle";
        baseHP = 40;
        baseAttack = 35;
        baseDefense = 30;
        baseSpecialAttack = 20;
        baseSpecialDefense = 20;
        baseSpeed = 50;
        types = new ArrayList<>();
        types.add("Bug");
        types.add("Poison");
        this.maxHitPoints = findHP(baseHP,hpIV,0,level);
        this.hitPoints = this.maxHitPoints;
        this.attack = findStat(baseAttack,attackIV,0,level);
        this.defense = findStat(baseDefense,defenseIV,0,level);
        this.specialAttack = findStat(baseSpecialAttack,specAttIV,0,level);
        this.specialDefense = findStat(baseSpecialDefense,specDefIV,0,level);
        this.speed = findStat(baseSpeed,speedIV,0,level);
        baseExp = 39;
        experienceBaseLineForNewPokemon(level);
        setExpToNextLevel(expToNextLevel(level));
        ArrayList<Moves> moves = WeedleMoves.findWeedleMovesArrayList();
    }
    @Override
    public int expToNextLevel(int level) {
        return (int) Math.pow(level, 3);
    }

    @Override
    public ArrayList<Moves> pullMoveArrayList() {
        return WeedleMoves.findWeedleMovesArrayList();
    }

    @Override
    public void learnNewMove(HashMap<Integer, Moves> moves) {
        if(moves.containsKey(this.level)&&moves.size()<4){
            this.moves.add(moves.get(this.level));
        }
    }
}
