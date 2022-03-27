package Model;

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
        if(x == null){
            throw new FieldException("Exception: Field 'x' can not be null");
        }
        this.x = x;
    }

    public void setY(Long y) {
        if(y == null){
            throw new FieldException("Exception: Field 'y' can not be null");
        }
        this.y = y;
    }

    /**
     *
     * @return
     */

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
