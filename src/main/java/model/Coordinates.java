package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Coordinates {
    @XStreamAlias("coordinatesX")
    private Integer x; //Поле не может быть null
    @XStreamAlias("coordinatesY")
    private Long y; //Поле не может быть null

    public Coordinates(Integer x, Long y) {
        this.setX(x);
        this.setY(y);
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Long y) {
        this.y = y;
    }

    /**
     *
     * @return
     */

    @Override
    public String toString() {
        return " " +
                "x=" + x +
                ", y=" + y ;
    }
}
