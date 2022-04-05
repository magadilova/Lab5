package Model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.UUID;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String passportID; //Значение этого поля должно быть уникальным, Поле не может быть null
    @XStreamAlias("eyeColor")
    private EyeColor eyeColor; //Поле не может быть null
    @XStreamAlias("hairColor")
    private HairColor hairColor; //Поле не может быть null
    @XStreamAlias("country")
    private Country nationality; //Поле может быть null
    @XStreamAlias("location")
    private Location location; //Поле может быть null

    public Person(String name, EyeColor eyeColor, HairColor hairColor, Country nationality, Location location) {
        this.setName(name);
        this.passportID = String.valueOf(this.uniqueId());
        this.setEyeColor(eyeColor);
        this.setHairColor(hairColor);
        this.setNationality(nationality);
        this.location = location;
    }

    /**
     *
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return passportID
     */
    private int uniqueId() {
        UUID uniqueKey = UUID.randomUUID();
        return Math.abs(uniqueKey.hashCode());
    }

    /**
     *
     * @param eyeColor
     */

    public void setEyeColor(EyeColor eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     *
     * @param hairColor
     */

    public void setHairColor(HairColor hairColor) {
        this.hairColor = hairColor;
    }

    /**
     *
     * @param nationality
     */

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }


    /**
     *
     * @return
     */

    @Override
    public String toString() {
        return "Person {" +
                "\n\tname = '" + name + '\'' +
                ",\n\t passportID = '" + passportID + '\'' +
                ",\n\t eyeColor = " + eyeColor +
                ",\n\t hairColor = " + hairColor +
                ",\n\t nationality = " + nationality +
                ",\n\t location = " + location.toString() +
                "\t}\n";
    }
}
