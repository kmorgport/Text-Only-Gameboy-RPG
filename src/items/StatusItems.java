package items;

public class StatusItems extends Items{
    public StatusItems(String name, int price, int sellPrice, String statusRecovery) {
        super(name);
        this.price = price;
        this.sellPrice = sellPrice;
        this.statusRecovery = statusRecovery;
    }
}
