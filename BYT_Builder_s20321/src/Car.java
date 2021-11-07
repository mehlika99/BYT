public class Car implements CarSkeleton {
    private String carDoors;
    private String carSteering;
    private String carMirrors;
    private String carWheels;

    @Override
    public void setCarDoors(String doors) {
        carDoors = doors;

    }
    public String getCarDoors() {
        return carDoors;

    }

    @Override
    public void setCarSteering(String steering) {
        carSteering = steering;

    }
    public String getCarSteering() {
        return carSteering;

    }

    @Override
    public void setCarMirrors(String mirrors) {
        carMirrors=mirrors;
    }
    public String getCarMirrors() {
        return carMirrors;

    }


    @Override
    public void setCarWheels(String wheels) {
        carWheels=wheels;
    }
    public String getCarWheels() {
        return carWheels;

    }
}
