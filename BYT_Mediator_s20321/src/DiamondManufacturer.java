import java.math.BigDecimal;

public class DiamondManufacturer extends Manufacturer {
    public DiamondManufacturer(String name, BigDecimal price, Mediator mediator) {
        super(name, Jewellery.DIAMOND, price, mediator);
    }
}
