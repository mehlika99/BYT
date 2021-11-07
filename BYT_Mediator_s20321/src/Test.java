import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {

        MediatorModel mediatorModel = new MediatorModel();

        DiamondManufacturer manufacturerMehlika = new DiamondManufacturer("mehlika", BigDecimal.valueOf(4000), mediatorModel);
        DiamondManufacturer manufacturerYavuz = new DiamondManufacturer("yavuz", BigDecimal.valueOf(3000), mediatorModel);

        DiamondBuyer buyerAlex = new DiamondBuyer("alex", BigDecimal.valueOf(5000), mediatorModel);
        DiamondBuyer buyerMax = new DiamondBuyer("max", BigDecimal.valueOf(7000), mediatorModel);

        mediatorModel.enterManufacturer(manufacturerMehlika);
        mediatorModel.enterManufacturer(manufacturerYavuz);

        mediatorModel.enterBuyer(buyerAlex);
        mediatorModel.enterBuyer(buyerMax);

        manufacturerMehlika.sellJewellery();
        buyerMax.buyJewellery();
    }
}
