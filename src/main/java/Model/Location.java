package Model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Location {
    @XStreamAlias("locationX")
    private float x;
    @XStreamAlias("locationY")
    private double y;
    @XStreamAlias("locationZ")
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

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
