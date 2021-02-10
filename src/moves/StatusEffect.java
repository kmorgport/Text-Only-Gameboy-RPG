package moves;

public class StatusEffect extends Moves{
    protected String status;
    protected int statusChance;

    public StatusEffect(String name, String type, String category, int powerPoints, int accuracy, String status, int statusChance) {
        super(name, type, category, powerPoints, accuracy);
        this.status = status;
        this.statusChance = statusChance;
    }

    public String getStatus(){
        return this.status;
    }

    public int getStatusChance(){
        return this.statusChance;
    }

    @Override
    public int getPower() {
        return 0;
    }
}
