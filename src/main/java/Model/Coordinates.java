package Model;

public class Coordinates {
    private Integer x; //Поле не может быть null
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
}
