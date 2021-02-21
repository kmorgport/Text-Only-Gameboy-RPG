package moves;

public class Attack extends Moves{
    public int power;

    public Attack(String name, String type, String category, int powerPoints, int accuracy,int priority, int power) {
        super(name, type, category, powerPoints, accuracy, priority);
        this.power = power;
    }

    public int getPower(){
        return this.power;
    }
}
