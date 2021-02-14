package items;

public abstract class Items {
    protected String name;
    protected int price;
    protected int sellPrice;
    protected String statusRecovery;
    protected int healthRecoveryAmount;
    protected double captureRate;
    public Items(String name){
        this.name = name;
    }
}
