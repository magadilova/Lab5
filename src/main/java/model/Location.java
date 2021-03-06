package model;

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

    /**
     *
     * @return
     */

    @Override
    public String toString() {
        return
                "x=" + x +
                ", y=" + y +
                ", z=" + z ;
    }
}
