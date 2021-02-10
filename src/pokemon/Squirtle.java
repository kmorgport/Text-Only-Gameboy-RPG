package pokemon;

import moves.Moves;

public class Squirtle extends Pokemon{
    protected final static String name = "Squirtle";
    protected final static int baseHP = 44;
    protected final static int baseAttack = 48;
    protected final static int baseDefense = 65;
    protected final static int baseSpecialAttack = 50;
    protected final static int baseSpecialDefense = 64;
    protected final static int baseSpeed = 43;
    protected int currentExpTotal;
    protected int expToNextLevel;
    protected final static String type1 = "Water";
    protected final static String type2 = null;
    public Squirtle(int level, int hpIV, int attackIV, int defenseIV, int specAttIV, int specDefIV, int speedIV) {
        super(level, hpIV, attackIV, defenseIV, specAttIV, specDefIV, speedIV);
        this.currentExpTotal = 0;
        this.hitPoints = findHP(baseHP,hpIV,0,level);
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

    @Override
    public Moves[] pullMoveList() {
        Moves[] allmoves = SquirtleMoves.findSquirtleMoves();
        Moves[] moveset = new Moves[3];
        for(int i=0; i<allmoves.length; i++){
            moveset[i]= allmoves[i];
        }
        return moveset;
    }
}
