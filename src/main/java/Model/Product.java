package Model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.time.LocalDate;
import java.util.UUID;
@XStreamAlias("product")
public class Product implements Comparable<Product> {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XStreamAlias("coordinates")
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double price; //Значение поля должно быть больше 0
    private String partNumber; //Поле может быть null
    private long manufactureCost;
    @XStreamAlias("unitOfMeasure")
    private UnitOfMeasure unitOfMeasure; //Поле может быть null
    @XStreamAlias("person")
    private Person owner; //Поле не может быть null

    public Product(String name, int coordinatesX,long coordinatesY, double price, String partNumber, long manufactureCost, UnitOfMeasure unitOfMeasure, Person person1) {
        this.id = this.uniqueId();
        this.name = name;
        this.coordinates = new Coordinates(coordinatesX,coordinatesY);
        this.creationDate = LocalDate.now();
        this.price = price;
        this.partNumber = partNumber;
        this.manufactureCost = manufactureCost;
        this.unitOfMeasure = unitOfMeasure;
        this.owner = person1;
    }

    /**
     *
     * @return id
     */
    private int uniqueId() {
        UUID uniqueKey = UUID.randomUUID();
        return Math.abs(uniqueKey.hashCode());
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }



    @Override
    public int compareTo(Product o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates.toString() +
                ", creationDate=" + creationDate.toString() +
                ", price=" + price +
                ", partNumber='" + partNumber + '\'' +
                ", manufactureCost=" + manufactureCost +
                ", unitOfMeasure=" + unitOfMeasure +
                ", owner=" + owner +
                '}';
    }


}
