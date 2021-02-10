package moves;

public class Attack extends Moves{
    protected int power;

    public Attack(String name, String type, String category, int powerPoints, int accuracy, int power) {
        super(name, type, category, powerPoints, accuracy);
        this.power = power;
    }

    public int getPower(){
        return this.power;
    }
}
