import java.math.BigDecimal;

public class DiamondBuyer extends Buyer {


    public DiamondBuyer(String name, BigDecimal price, Mediator mediator) {
        super(name, Jewellery.DIAMOND, price, mediator);
    }
}
