package moves;

public class BuffDeBuff extends Moves{


    public BuffDeBuff(String name, String type, String category, int powerPoints, int accuracy,int priority, int buffDebuffInteger, String buffDebuffType, int buffDebuffChance) {
        super(name, type, category, powerPoints, accuracy, priority);
        this.buffDebuffInteger = buffDebuffInteger;
        this.buffDebuffType = buffDebuffType;
        this.buffDebuffChance = buffDebuffChance;
    }

    public int getBuffDebuffInteger(){
        return this.buffDebuffInteger;
    }

    public String getBuffDebuffType(){
        return this.buffDebuffType;
    }

    public int getBuffDebuffChance(){
        return this.buffDebuffChance;
    }

    @Override
    public int getPower() {
        return 0;
    }
}
