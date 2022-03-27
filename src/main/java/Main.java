import Controller.LinkedHashSetCollectionManager;
import Model.*;
import View.Asker;
import View.Commands.AddCommand;
import View.Commands.ClearCommand;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Coordinates coordinates = new Coordinates(23, 201L);
        Location location = new Location(10,1.2,23);
        Person person1 = new Person("Thomas", EyeColor.BROWN, HairColor.BLACK, Country.FRANCE, location);
        Product p1 = new Product("Ares", coordinates, 1.12, "263517", 100, UnitOfMeasure.MILLIGRAMS, person1);
        Person person2 = new Person("Thomas", EyeColor.BROWN, HairColor.BLACK, Country.FRANCE, location);
        Product p2 = new Product("Lara", coordinates, 1.12, "6248", 100, UnitOfMeasure.MILLIGRAMS, person2);
        Person person3 = new Person("Liam", EyeColor.BROWN, HairColor.BLACK, Country.FRANCE, location);
        Product p3 = new Product("Clara", coordinates, 1.12, "2498", 100, UnitOfMeasure.MILLIGRAMS, person3);

        LinkedHashSetCollectionManager linkedHashSetCollectionManager = new LinkedHashSetCollectionManager();
        linkedHashSetCollectionManager.collectionDo(p1, p2, p3);

//        LinkedHashSet<Product> set = new LinkedHashSet<>();
//
//        // Adding elements
//        set.add(p1);
//        set.add(p2);
//        set.add(p3);
//
//        TreeSet<Product> treeSet = new TreeSet<>(set);
//
//        set.clear();
//        set.addAll(treeSet);

//        Asker asker = new Asker(new Scanner(System.in));
//        asker.startAsker();

//        AddCommand addCommand = new AddCommand(asker,linkedHashSetCollectionManager);
//        addCommand.execute("");
        System.out.println(linkedHashSetCollectionManager.getSet());

        ClearCommand clearCommand = new ClearCommand(linkedHashSetCollectionManager);
        clearCommand.execute("");

        System.out.println(linkedHashSetCollectionManager.getSet());
    }
}
