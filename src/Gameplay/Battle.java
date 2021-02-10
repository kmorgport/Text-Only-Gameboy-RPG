package Gameplay;

public class Battle {
    Battle(){

    }

    public double grassTypeMultiplier(String type, String type2 ){
        double multiplier = 0;
        switch (type){
            case "Flying":
            case "Poison":
            case "Bug":
            case "Steel":
            case "Fire":
            case "Grass":
            case "Electric":
            case "Dragon":
                multiplier += .5;
                break;
            case "Ground":
            case "Rock":
            case "Water":
                multiplier += 2;
                break;
            default:
                multiplier+= 1;
                break;
        }
        if(type2.equals("Poison")){
            multiplier -=.25;
        }
        return multiplier;
    }

    public double fireTypeMultiplier(String type){
        switch(type){
            case "Rock":
            case "Fire":
            case "Water":
            case "Dragon":
                return .5;
            case "Bug":
            case "Steel":
            case "Grass":
            case "Ice":
                return 2;
            default:
                return 1;

        }
    }

    public double waterTypeMultiplier(String type){
        switch(type){
            case "Water":
            case "Grass":
            case "Dragon":
                return .5;

            case "Ground":
            case "Rock":
            case "Fire":
                return 2;
            default:
                return 1;
        }
    }

    public double normalTypeMultiplier(String type){
        switch(type){
            case "Ghost":
                return 0;
            case "Rock":
            case "Steel":
                return .5;
            default:
                return 1;
        }
    }

    public double flyingTypeMultiplier(String type){
        switch(type){
            case "Rock":
            case "Steel":
            case "Electric":
                return .5;
            case "Fighting":
            case "Bug":
            case "Grass":
                return 2;
            default:
                return 1;
        }
    }
    public double calculateDamage(int level,int power, int attack, int defense, double modifier){
        return (((((2*level)/5)+2)*power*(attack/defense)/50)+2)*modifier;
    }

    public double getModifier(int critical, int random, int stab, int type, int burn){
        return critical*random*stab*type*burn;
    }

    public double determineStab(String monType, String attackType){
        if(monType.equals(attackType)){
            return 1.5;
        }else{
            return 1;
        }
    }

    public int determineCriticalHit(double rando){
        if(rando>0 && rando<=12.5){
            return 2;
        }else{
            return 1;
        }
    }

    public double determineBurn(boolean burn){
        if(burn){
            return .5;
        }else{
            return 1;
        }
    }

//    public int calculatePhysicalOrSpecial(Moves move, Pokemon pokemon){
//        if(move.getCategory().equals("Physical")){
//            double rando
//            double modifier = getModifier()
//            calculateDamage(pokemon.getLevel(),move.getPower(),pokemon.getAttack(),pokemon.getDefense(), modifier);
//        }
//    }
}
