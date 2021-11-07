public interface Mediator {

    void enterManufacturer(Manufacturer manufacturer);
    void enterBuyer(Buyer buyer);

    void takeFromManufacturer(Manufacturer manufacturer);
    void sellToBuyer(Buyer buyer);


}
