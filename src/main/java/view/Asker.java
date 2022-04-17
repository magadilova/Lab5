package view;

import model.*;
import model.fieldException.FieldException;

import java.io.Console;
import java.util.Scanner;


/**
 * Класс, отвечающий за добавления элемента в коллекцию
 */

public class Asker {
    private Scanner scanner = null;

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
                name = scanner.nextLine().trim();
                if (name.isEmpty()){
                    throw new FieldException("Product's name can not be empty \nPlease try again");
                }
                break;
            } catch (FieldException e) {
                System.out.println(e.getMessage());
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
                System.out.println("Enter X coordinate (integer):");
                strX = scanner.nextLine().trim();
                if (strX.isEmpty()){
                    throw new FieldException("X coordinate can not be null \nPlease try again");
                }
                x = Integer.parseInt(strX);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format! Format must be integer.");

            } catch (FieldException e) {
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
                System.out.println("Enter Y coordinate (long)");
                strY = scanner.nextLine().trim();
                if (strY.isEmpty()){
                    throw new FieldException("Y coordinates can not be null \nPlease try again");
                }
                y = Long.parseLong(strY);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format! Format must be long.");
            } catch (FieldException e) {
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
                System.out.println("Enter price (double)");
                strPrice = scanner.nextLine().trim();
                price = Double.parseDouble(strPrice);
                if(price <= 0){
                    throw new FieldException("Price can not be less or equal zero \nPlease try again");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format! Format must be double.");
            } catch (FieldException e) {
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
                partNumber = scanner.nextLine().trim();
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
                System.out.println("Enter manufacture cost (long)");
                strCost = scanner.nextLine().trim();
                cost = Long.parseLong(strCost);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format! Format must be double.");
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
                strUnit = scanner.nextLine().trim().toUpperCase();
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
                System.out.println("Enter owner's name");
                nameOwner = scanner.nextLine().trim();
                if (nameOwner.isEmpty()){
                    throw new FieldException("Owner can not be null \nPlease try again");
                }
                break;
            } catch (FieldException e) {
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
                strColor = scanner.nextLine().trim().toUpperCase();
                if (strColor.isEmpty()){
                    throw new FieldException("Eye color can not be null \n Please try again");
                }
                color = EyeColor.valueOf(strColor);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Eyes color wasn't found. \n"
                        + "Please try again. Must be entered as shown in the list.");
            } catch (FieldException e) {
                System.out.println(e.getMessage());
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
                strColor = scanner.nextLine().trim().toUpperCase();
                if (strColor.isEmpty()){
                    throw new FieldException("Hair color can not be null \n Please try again");
                }
                color = HairColor.valueOf(strColor);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Hairs color wasn't found. \n"
                        + "Please try again. Must be entered as shown in the list.");
            } catch (FieldException e) {
                System.out.println(e.getMessage());
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
                strCountry = scanner.nextLine().trim().toUpperCase();
                if (strCountry.isEmpty()){strCountry = null;}
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
                System.out.println("Enter X coordinate (float)");
                strX= scanner.nextLine().trim();
                x = Float.parseFloat(strX);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format! Format must be float.");
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
                System.out.println("Enter Y coordinate (double)");
                strY = scanner.nextLine().trim();
                y = Double.parseDouble(strY);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format! Format must be double.");
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
                System.out.println("Enter Z coordinate (double)");
                strZ = scanner.nextLine().trim();
                z = Double.parseDouble(strZ);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format! Format must be double.");
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
        double price = askPrice();
        String partNumber = askPartNumber();
        long manufactureCost = askManufactureCost();
        UnitOfMeasure unitOfMeasure = askUnitOfMeasure();
        Person owner = owner();
        return new Product(name,coordinates,price,partNumber,manufactureCost,unitOfMeasure,owner);
    }
}
