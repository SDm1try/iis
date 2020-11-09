package AbstractFactoryAndBuilder;

public class AbstractFactory {
    public static void main(String[] args) throws NoSuchMethodException {
        Car carBMV = CarFactory.create("BMV");
        Car carVolvo = CarFactory.create("VOLVO");
        System.out.println("" + carVolvo.body() + carVolvo.wheels());
        System.out.println("" + carBMV.body() + carBMV.wheels());
    }
}

class CarFactory {

    public static Car create(String carName) throws NoSuchMethodException {
        Car car;
        switch (carName) {
            case "BMV" -> car = new Bmv();
            case "VOLVO" -> car = new Volvo();
            default -> throw new NoSuchMethodException("No such car implemented " + carName);
        }
        return car;
    }
}

interface Car {
    Wheel wheels();

    Body body();
}

class Wheel {
    private final String owner;

    public Wheel(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "owner='" + owner + '\'' +
                '}';
    }

    public String getOwner() {
        return owner;
    }
}

class Body {
    private String owner;
    private int numDoors = 4;
    private String seats = "standard";
    private String kit = "standard";
    private String engine = "standard";

    private Body() {
    }

    @Override
    public String toString() {
        return "Body{" +
                "owner='" + owner + '\'' +
                ", numDoors=" + numDoors +
                ", seats='" + seats + '\'' +
                ", kit='" + kit + '\'' +
                ", engine='" + engine + '\'' +
                '}';
    }

    public static Builder newBuilder() {
        return new Body().new Builder();
    }

    public String getOwner() {
        return owner;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public String getSeats() {
        return seats;
    }

    public String getKit() {
        return kit;
    }

    public String getEngine() {
        return engine;
    }

    public class Builder {
        private Builder() {
        }

        public Builder setOwner(String owner) {
            Body.this.owner = owner;
            return this;
        }

        public Builder setNumDoors(int numDoors) {
            Body.this.numDoors = numDoors;
            return this;
        }

        public Builder setSeats(String seats) {
            Body.this.seats = seats;
            return this;
        }

        public Builder setKit(String kit) {
            Body.this.kit = kit;
            return this;
        }

        public Builder setEngine(String engine) {
            Body.this.engine = engine;
            return this;
        }

        public Body build() {
            return Body.this;
        }
    }
}

class Volvo implements Car {

    @Override
    public Wheel wheels() {
        return new Wheel("Volvo,s wheels");
    }

    @Override
    public Body body() {
        return Body.newBuilder()
                .setOwner("Volvo")
                .setEngine("powerful engine")
                .setNumDoors(4)
                .setSeats("comfort seats")
                .setKit("tipical Volvo kit")
                .build();
    }

}

class Bmv implements Car {
    @Override
    public Wheel wheels() {
        return new Wheel("BMV's wheels");
    }

    @Override
    public Body body() {
        return Body.newBuilder()
                .setOwner("BMV")
                .setNumDoors(2)
                .setKit("Sport kit")
                .setSeats("Sport uncomfortable seats")
                .setEngine("Loud sport engine")
                .build();
    }
}

