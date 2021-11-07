import java.math.BigDecimal;

public abstract class Buyer {

    private String name;
    private Jewellery jewellery;
    private BigDecimal price;
    private Mediator mediator;

    public Buyer(String name, Jewellery jewellery, BigDecimal price, Mediator mediator) {
        this.name = name;
        this.jewellery = jewellery;
        this.price = price;
        this.mediator = mediator;
    }
    public void buyJewellery(){
        mediator.sellToBuyer(this);
    }

    public String getName() {
        return name;
    }

    public  Jewellery getJewellery() {
        return jewellery;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
