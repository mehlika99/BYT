public class CarFeatures implements CarBuilder {
    private Car car;

    public CarFeatures(){
        this.car = new Car();
    }
    @Override
    public void buildCarDoors() {

        car.setCarDoors("Red Doors");

    }

    @Override
    public void buildCarSteering() {

        car.setCarSteering("Leather Steering");

    }

    @Override
    public void buildCarMirrors() {
        car.setCarMirrors("Black Mirrors");

    }

    @Override
    public void buildCarWheels() {
        car.setCarWheels("Winter Wheels");

    }

    public Car getCar(){
        return this.car;
    }
}
//every time when i want to creat new robot i will creta concret car calss to difine whic kind of car i want
//show finished car objects
