package pokemon;

import moves.Moves;

import java.util.ArrayList;

public abstract class Pokemon {
    protected String name;
    protected int level;
    protected int hitPoints;
    protected int baseHP;
    protected int hpIV;
    protected int hpEV;
    protected int attack;
    protected int battleAttack;
    protected int attackInteger;
    protected int baseAttack;
    protected int attackIV;
    protected int attackEV;
    protected int defense;
    protected int battleDefense;
    protected int defenseInteger;
    protected int baseDefense;
    protected int defenseIV;
    protected int defenseEV;
    protected int specialAttack;
    protected int battleSpecialAttack;
    protected int specialAttackInteger;
    protected int baseSpecialAttack;
    protected int specAttIV;
    protected int specAttEV;
    protected int specialDefense;
    protected int battleSpecialDefense;
    protected int specialDefenseInteger;
    protected int baseSpecialDefense;
    protected int specDefIV;
    protected int specDefEV;
    protected int speed;
    protected int battleSpeed;
    protected int speedInteger;
    protected int evasion;
    protected int battleEvasion;
    protected int evasionInteger;
    protected int accuracy;
    protected int battleAccuracy;
    protected int accuracyInteger;
    protected int speedIV;
    protected int speedEV;
    protected int baseSpeed;
    protected double critHitRate;
    protected int currentExpTotal;
    protected int expToNextLevel;
    protected int baseExp;
    protected int buffDebuffStage;
    public ArrayList<String> types;


    Pokemon(int level, int hpIV, int attackIV, int defenseIV, int specAttIV, int specDefIV, int speedIV){
        this.level = level;
        this.hpIV = hpIV;
        this.attackIV = attackIV;
        this.defenseIV = defenseIV;
        this.specAttIV = specAttIV;
        this.specDefIV = specDefIV;
        this.speedIV =  speedIV;
        attackInteger = 0;
        defenseInteger = 0;
        specialAttackInteger = 0;
        specialDefenseInteger = 0;
        speedInteger = 0;
        evasion = 100;
        accuracy = 100;
        evasionInteger = 0;
        accuracyInteger = 0;


    }

    public int findHP(int base, int iv, int ev, int level){
        return (int) Math.round(((((base+iv)*2+(Math.sqrt(ev)/4))*level)/100)+level+10);
    }

    public int findStat(int base, int iv, int ev, int level){
        return (int) Math.round(((((base+iv)*2+(Math.sqrt(ev)/4))*level)/100)+5);
    }

    public String getName(){return this.name;}

    public int getLevel(){
        return this.level;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public int getHitPoints(){
        return this.hitPoints;
    }

    public void setHitPoints(int hp){
        this.hitPoints = hp;
    }

    public int getHitPointsEV(){
        return this.hpEV;
    }

    public void increaseHpEv(int hpEv){
        this.hpEV += hpEv;
    }

    public int getAttack(){
        return this.attack;
    }

    public int getAttackEV(){return this.attackEV;}

    public void setAttack(int attack){
        this.attack = attack;
    }

    public int getBattleAttack(){return this.battleAttack;}

    public void setBattleAttack(int battleAttack){this.battleAttack = battleAttack;}

    public int getAttackInteger(){return this.attackInteger;}

    public void setAttackInteger(int attackInteger){this.attackInteger = attackInteger;}

    public void increaseAttackEV(int attackEv){
        this.attackEV += attackEv;
    }

    public int getDefense(){
        return this.defense;
    }

    public int getDefenseEV(){return this.defenseEV;}

    public void setDefense(int defense){
        this.defense = defense;
    }

    public int getBattleDefense(){return this.battleDefense;}

    public void setBattleDefense(int battleDefense){this.battleDefense = battleDefense;}

    public int getDefenseInteger(){return this.defenseInteger;}

    public void setDefenseInteger(int defenseInteger){this.defenseInteger = defenseInteger;}

    public void increaseDefenseEV(int defenseEv){
        this.defenseEV += defenseEv;
    }

    public int getSpecialAttack(){
        return this.specialAttack;
    }

    public void setSpecialAttack(int specialAttack){
        this.specialAttack = specialAttack;
    }

    public int getBattleSpecialAttack(){
        return this.battleSpecialAttack;
    }

    public void setBattleSpecialAttack(int battleSpecialAttack){
        this.battleSpecialAttack = battleSpecialAttack;
    }

    public int getSpecialAttackInteger(){return this.specialAttackInteger;}

    public void setSpecialAttackInteger(int specialAttackInteger){this.specialAttackInteger = specialAttackInteger;}

    public void increaseSpecialAttackEV(int specialAttackEv){
        this.specAttEV += specialAttackEv;
    }

    public int getSpecialDefense(){
        return this.specialDefense;
    }

    public void setSpecialDefense(int specialDefense){
        this.specialDefense = specialDefense;
    }

    public int getBattleSpecialDefense(){
        return this.battleSpecialDefense;
    }

    public int getSpecialDefenseInteger(){return this.specialDefenseInteger;}

    public void setSpecialDefenseInteger(int specialDefenseInteger){this.specialDefenseInteger = specialDefenseInteger;}

    public void setBattleSpecialDefense(int battleSpecialDefense){
        this.battleSpecialDefense = battleSpecialDefense;
    }

    public void increaseSpecialDefenseEV(int specialDefenseEv){
        this.specDefEV += specialDefenseEv;
    }

    public int getSpeed(){
        return this.speed;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    public int getBattleSpeed(){return this.battleSpeed;}

    public void setBattleSpeed(int battleSpeed){this.battleSpeed = battleSpeed;}

    public int getSpeedInteger(){return this.speedInteger;}

    public void setSpeedInteger(int speedInteger){this.speedInteger = speedInteger;}

    public void increaseSpeedEV(int speedEv){
        this.speedEV += speedEv;
    }

    public int getEvasion(){return this.evasion;}

    public int getEvasionInteger(){return this.evasionInteger;}

    public void setEvasionInteger(int evasionInteger){this.evasionInteger = evasionInteger;}

    public int getAccuracy(){return this.accuracy;}

    public int getAccuracyInteger(){return this.accuracyInteger;}

    public void setAccuracyInteger(int accuracyInteger){this.accuracyInteger = accuracyInteger;}

    public int getBuffDebuffStage(){return this.buffDebuffStage;}

    public void setBuffDebuffStage(int buffDebuffStage){this.buffDebuffStage = buffDebuffStage;}

    public int getBattleEvasion(){return this.battleEvasion;}
    public void setBattleEvasion(int battleEvasion){this.battleEvasion = battleEvasion;}

    public int[] getExpVal(){
        int [] evs = new int[6];
        evs[0] = baseHP;
        evs[1] = baseAttack;
        evs[2] = baseDefense;
        evs[3] = baseSpecialAttack;
        evs[4] = baseSpecialDefense;
        evs[5] = baseSpeed;
        return evs;
    }

    public void earnEVS(int[]evs){
        increaseHpEv(evs[0]);
        increaseAttackEV(evs[1]);
        increaseDefenseEV(evs[2]);
        increaseSpecialAttackEV(evs[3]);
        increaseSpecialDefenseEV(evs[4]);
        increaseSpeedEV(evs[5]);
    }

    public void setBattleStats(){

    }

    public int calcExpGained(boolean wild, boolean owner, int baseEx, int lev, int s){
        if(!wild && !owner){
            return (int) Math.round((1.5*1.5*baseEx*1*lev)/7*s);
        }else if(wild && !owner){
            return (int) Math.round((1*1.5*baseEx*1*lev)/7*s);
        }else if(!wild){
            return (int) Math.round((1.5*1*baseEx*1*lev)/7*s);
        }else {
            return Math.round((baseEx * lev)/7*s);
        }
    }

    public int getBaseExp(){
        return baseExp;
    }

    public int getCurrentExpTotal(){
        return this.currentExpTotal;
    }

    public int getExpToNextLevel(){
        return this.expToNextLevel;
    }

    public abstract int expToNextLevel(int level);

    public void setExpToNextLevel(int exp){
        this.expToNextLevel = currentExpTotal+exp;
    }

    public void experienceBaseLineForNewPokemon(int level) {
        int baseExp = 0;
        for(int i =1; i<=level; i++){
            int levelExp = expToNextLevel(level);
            baseExp += levelExp;
        }
        this.currentExpTotal = baseExp;
    }

    abstract public Moves[] pullMoveList();


}
