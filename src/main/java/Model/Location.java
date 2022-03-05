package Model;

public class Location {
    private float x;
    private double y;
    private double z;

    public Location(float x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
