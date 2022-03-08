package rentcar;

public class Sonata extends Car {
    private static final double DISTANCE_PER_LITER = 10;

    private final int tripDistance;

    public Sonata(int tripDistance) {
        super(tripDistance);
        this.tripDistance = tripDistance;
    }

    @Override
    public double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    @Override
    public double getTripDistance() {
        return tripDistance;
    }
}
