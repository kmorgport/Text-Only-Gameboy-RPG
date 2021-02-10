package moves;

public class AttackAndStatus extends Moves{
    protected int power;
    protected String status;
    protected int statusChance;

    public AttackAndStatus(String name, String type, String category, int powerPoints, int accuracy, int power, String status, int statusChance) {
        super(name, type, category, powerPoints, accuracy);
        this.power = power;
        this.status = status;
        this.statusChance = statusChance;
    }

    public int getPower(){
        return this.power;
    }

    public String getStatus(){
        return this.status;
    }

    public int getStatusChance(){
        return this.statusChance;
    }
}
