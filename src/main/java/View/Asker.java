package View;

import Model.*;

import java.util.Scanner;


public class Asker {
    private final Scanner scanner;

    public Asker(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     *
     * @return name
     */
    private String askName() {
        String name;
        while (true) {
            try {
                System.out.println("Enter product's name");
                name = scanner.next().trim();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Please try again");
            }
        }
        return name;
    }

    /**
     *
     * @return x
     */

    private Integer askX() {
        String strX;
        Integer x;
        while (true) {
            try {
                System.out.println("Enter X coordinate");
                strX = scanner.next().trim();
                x = Integer.parseInt(strX);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Please try again");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }
        }
        return x;
    }

    /**
     *
     * @return y
     */

    private Long askY() {
        String strY;
        Long y;
        while (true) {
            try {
                System.out.println("Enter Y coordinate");
                strY = scanner.next().trim();
                y = Long.parseLong(strY);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Please try again");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }
        }
        return y;
    }

    private Coordinates coordinates() {
        Integer x = askX();
        Long y = askY();
        return new Coordinates(x, y);
    }

    /**
     *
     * @return price
     */

    private double askPrice() {
        String strPrice;
        double price;
        while (true) {
            try {
                System.out.println("Enter price");
                strPrice = scanner.next().trim();
                price = Double.parseDouble(strPrice);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Please try again");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }
        }
        return price;
    }

    /**
     *
     * @return partNumber
     */

    private String askPartNumber() {
        String partNumber;
        while (true) {
            try {
                System.out.println("Enter part number");
                partNumber = scanner.next().trim();
                if (partNumber == ""){
                    partNumber = null;
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Please try again");
            }
        }
        return partNumber;
    }

    /**
     *
     * @return cost
     */

    private long askManufactureCost() {
        String strCost;
        long cost;
        while (true) {
            try {
                System.out.println("Enter manufacture cost");
                strCost = scanner.next().trim();
                cost = Long.parseLong(strCost);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Please try again");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return cost;
    }

    /**
     *
     * @return unit
     */

    private UnitOfMeasure askUnitOfMeasure() {
        String strUnit;
        UnitOfMeasure unit;
        while (true) {
            try {
                System.out.println("Choose unit of measure: ");
                UnitOfMeasure.showUnitOfMeasureList();
                strUnit = scanner.next().trim().toUpperCase();
                unit = UnitOfMeasure.valueOf(strUnit);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Unit of measure wasn't found. \n "
                        + "Please try again. Must be entered as shown in the list.");
            }
        }
        return unit;
    }

    /**
     *
     * @return nameOwner
     */

    private String askOwnerName() {
        String nameOwner;
        while (true) {
            try {
                System.out.println("Enter person's name");
                nameOwner = scanner.next().trim();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return nameOwner;
    }

    /**
     *
     * @return color
     */

    private EyeColor askOwnerEyeColor() {
        String strColor;
        EyeColor color;
        while (true) {
            try {
                System.out.println("Choose eyes' color: ");
                EyeColor.showEyeColorsList();
                strColor = scanner.next().trim().toUpperCase();
                color = EyeColor.valueOf(strColor);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Eyes color wasn't found. \n"
                        + "Please try again. Must be entered as shown in the list.");
            }
        }
        return color;
    }

    /**
     *
     * @return color
     */

    private HairColor askOwnerHairColor() {
        String strColor;
        HairColor color;
        while (true) {
            try {
                System.out.println("Choose hairs' color:");
                HairColor.showHairColorList();
                strColor = scanner.next().trim().toUpperCase();
                color = HairColor.valueOf(strColor);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Hairs color wasn't found. \n"
                        + "Please try again. Must be entered as shown in the list.");
            }
        }
        return color;
    }

    /**
     *
     * @return country
     */

    private Country askOwnerCountry() {
        String strCountry;
        Country country;
        while (true) {
            try {
                System.out.println("Choose country:");
                Country.showCountryList();
                strCountry = scanner.next().trim().toUpperCase();
                country = Country.valueOf(strCountry);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Country wasn't found. \n"
                + "Please try again. Must be entered as shown in the list.");
            }
        }
        return country;
    }

    /**
     *
     * @return x
     */

    private float askOwnerX() {
        String strX;
        float x;
        while (true) {
            try {
                System.out.println("Enter X coordinate");
                strX = scanner.next().trim();
                x = Float.parseFloat(strX);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Please try again");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return x;
    }

    /**
     *
     * @return y
     */

    private double askOwnerY() {
        String strY;
        double y;
        while (true) {
            try {
                System.out.println("Enter Y coordinate");
                strY = scanner.next().trim();
                y = Double.parseDouble(strY);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Please try again");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return y;
    }

    /**
     *
     * @return z
     */

    private double askOwnerZ() {
        String strZ;
        double z;
        while (true) {
            try {
                System.out.println("Enter Z coordinate");
                strZ = scanner.next().trim();
                z = Double.parseDouble(strZ);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Please try again");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return z;
    }

    private Location location() {
        float x = askOwnerX();
        double y = askOwnerY();
        double z = askOwnerZ();
        return new Location(x, y, z);
    }
    private Person owner(){
        String name = askOwnerName();
        EyeColor eyeColor = askOwnerEyeColor();
        HairColor hairColor = askOwnerHairColor();
        Country country = askOwnerCountry();
        Location location = location();
        return new Person(name,eyeColor,hairColor,country,location);
    }

    public Product startAsker(){
        String name = askName();
        Coordinates coordinates = coordinates();
        Double price = askPrice();
        String partNumber = askPartNumber();
        Long manufactureCost = askManufactureCost();
        UnitOfMeasure unitOfMeasure = askUnitOfMeasure();
        Person owner = owner();
        return new Product(name,coordinates,price,partNumber,manufactureCost,unitOfMeasure,owner);
    }
}
