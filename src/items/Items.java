package items;

public abstract class Items {
    protected String name;
    protected int price;
    protected int sellPrice;
    protected String statusRecovery;
    protected int healthRecoveryAmount;
    protected double captureRate;
    protected boolean keyItem;
    public Items(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getPrice(){
        return this.price;
    }

    public int getSellPrice(){
        return this.sellPrice;
    }

    public String getStatusRecovery(){
        return this.statusRecovery;
    }

    public int getHealthRecoveryAmount(){
        return this.healthRecoveryAmount;
    }

    public double getCaptureRate(){
        return this.captureRate;
    }

    public boolean getKeyItem(){
        return this.keyItem;
    }
}
