public class CarMaker {

    private CarBuilder carBuilder;

    public CarMaker(CarBuilder carBuilder){

        this.carBuilder=carBuilder;
    }

    public Car getCar(){

        return this.carBuilder.getCar();
    }

    public void makeCar(){
        this.carBuilder.buildCarDoors();
        this.carBuilder.buildCarMirrors();
        this.carBuilder.buildCarWheels();
        this.carBuilder.buildCarSteering();
    }


}
//class creat a car which is defined  CarFeatures class
