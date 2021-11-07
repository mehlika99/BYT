import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MediatorModel implements Mediator {
    //everything will be here
    //so we make every func here
    //so mediator model can fnd the best jewelelrly for manufactorer and also for buyer

    private List<Manufacturer> manufacturerList;
    private List<Buyer> buyerList;

    public MediatorModel() {
        manufacturerList = new ArrayList<>();
        buyerList = new ArrayList<>();
    }
    @Override
    public void enterManufacturer(Manufacturer manufacturer) {
        manufacturerList.add(manufacturer);
    }

    @Override
    public void enterBuyer(Buyer buyer) {
        buyerList.add(buyer);
    }


    @Override
    public void takeFromManufacturer(Manufacturer manufacturer) {

        Buyer buyer = findTheBestBuyer(manufacturer.getJewellery());
        System.out.println(manufacturer.getName()+" "+"get the best profit for "+manufacturer.getJewellery()+" "+"from"+" "+buyer.getName());


    }
    private Buyer findTheBestBuyer(Jewellery jewellery){
        Buyer theBestBuyer = null;

        for (Buyer buyer : buyerList) {
            if (jewellery.equals(buyer.getJewellery())){

                BigDecimal buyerPrice = buyer.getPrice();

                if (theBestBuyer == null ||
                        theBestBuyer.getPrice().compareTo(buyerPrice) < 0){
                    theBestBuyer = buyer;
                }
            }
        }

        return theBestBuyer;
    }


    @Override
    public void sellToBuyer(Buyer buyer) {
        Manufacturer manufacturer = findTheBestMannufacturer(buyer.getJewellery());
        System.out.println(manufacturer.getName()+" "+"get the best profit for "+manufacturer.getJewellery()+" "+"from"+" "+buyer.getName());

    }

    private Manufacturer findTheBestMannufacturer(Jewellery jewellery) {
        Manufacturer theBestMannufacturer = null;

        for (Manufacturer manufacturer : manufacturerList) {
            if (jewellery.equals(manufacturer.getJewellery())){


                BigDecimal manufacturerPrice = manufacturer.getPrice();

                if (theBestMannufacturer == null ||
                        theBestMannufacturer.getPrice().compareTo(manufacturerPrice) > 0){
                    theBestMannufacturer = manufacturer;
                }
            }
        }

        return theBestMannufacturer;
    }
}
