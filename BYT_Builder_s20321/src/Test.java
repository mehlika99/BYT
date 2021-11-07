public class Test {

    public static void main(String[] args){
        //getting first version of car
        CarBuilder firstFeatures = new CarFeatures();

        //passing car features to maker to creat a car
        CarMaker carMaker = new CarMaker(firstFeatures);
        //telling the maker to amke a car as we wanted like specified CarFeatures class
        carMaker.makeCar();

        Car firstCar = carMaker.getCar();

        System.out.println("Your Car Is Ready :)");
        System.out.println("Car with " + firstCar.getCarDoors() + " "+", " + firstCar.getCarSteering() + " "+", " + firstCar.getCarMirrors() + " "+"and with " + firstCar.getCarWheels()+" ... as you want :):):)");


    }
}
