package items;

public class Potions extends Items{
    public Potions(String name, int price, int sellPrice, int healthRecoveryAmount) {
        super(name);
        this.price = price;
        this.sellPrice = sellPrice;
        this.healthRecoveryAmount = healthRecoveryAmount;
    }
}
