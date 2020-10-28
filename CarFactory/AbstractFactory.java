public class AbstractFactory {
    public static void main(String[] args) throws NoSuchMethodException {
        Car car = new GetMemberOf(GetMemberOf.cars.BMV).getCar();
        Car car1 = new GetMemberOf(GetMemberOf.cars.VOLVO).getCar();
        System.out.println("" + car.body().getOwner()+ "'s wheels and " + car.wheels().getOwner() + "'s body");
        System.out.println("" + car1.body().getOwner()+ "'s wheels and " + car1.wheels().getOwner() + "'s body");
    }
}

class GetMemberOf {
    Car car = null;
    enum cars{
        VOLVO,
        BMV
    }

    public GetMemberOf(cars c) throws NoSuchMethodException {
        switch (c) {
            case BMV -> car = new Bmv();
            case VOLVO -> car = new Volvo();
            default -> throw new NoSuchMethodException("No such car implemented " + c);
        }
    }

    public Car getCar() {
        return car;
    }
}

interface Car {
    Wheel wheels();

    Body body();
}

class Wheel {
    private String owner;

    public Wheel(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }
}

class Body {
    private String owner;

    public Body(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }
}

class Volvo implements Car {

    @Override
    public Wheel wheels() {

        System.out.println("Volvo's wheels in ");
        return new Wheel("Volvo");
    }

    @Override
    public Body body() {
        System.out.println("Volvo's body in ");
        return new Body("Volvo");
    }

}

class Bmv implements Car {
    @Override
    public Wheel wheels() {
        System.out.println("bmv's wheel in ");
        return new Wheel("BMV");
    }

    @Override
    public Body body() {
        System.out.println("bmv's body in ");
        return new Body("BMV");
    }
}

