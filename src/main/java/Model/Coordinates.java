package Model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Coordinates {
    @XStreamAlias("coordinatesX")
    private Integer x; //Поле не может быть null
    @XStreamAlias("coordinatesY")
    private Long y; //Поле не может быть null

    public Coordinates(Integer x, Long y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Long getY() {
        return y;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Long y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
