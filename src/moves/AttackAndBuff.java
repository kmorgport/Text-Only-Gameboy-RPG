package moves;

public class AttackAndBuff extends Moves{
    protected int power;
    protected int buffDebuffInteger;
    protected String buffDebuffType;
    protected int buffDebuffChance;

    public AttackAndBuff(String name, String type, String category, int powerPoints, int accuracy,int priority, int power, int buffDebuffInteger, String buffDebuffType, int buffDebuffChance) {
        super(name, type, category, powerPoints, accuracy, priority);
        this.power = power;
        this.buffDebuffInteger = buffDebuffInteger;
        this.buffDebuffType = buffDebuffType;
        this.buffDebuffChance = buffDebuffChance;
    }

    public int getPower(){
        return this.power;
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
}
