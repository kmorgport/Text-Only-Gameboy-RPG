package moves;

public class BuffDeBuff extends Moves{
    protected int buffDebuffInteger;
    protected String buffDebuffType;
    protected int buffDebuffChance;

    public BuffDeBuff(String name, String type, String category, int powerPoints, int accuracy, int buffDebuffInteger, String buffDebuffType, int buffDebuffChance) {
        super(name, type, category, powerPoints, accuracy);
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
