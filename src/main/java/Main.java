import Model.*;
import Utils.XmlWorker;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Thomas","230", EyeColor.BLUE, HairColor.BLUE, Country.FRANCE,10,1.2,27);
        Product p1 = new Product("Ares",10,20,1.12,"gdhgs",100, UnitOfMeasure.MILLIGRAMS, person1);
        Person person2 = new Person("Thomas","230", EyeColor.BLUE, HairColor.BLUE, Country.FRANCE,10,1.2,27);
        Product p2 = new Product("Lara",10,20,1.12,"gdhgs",100, UnitOfMeasure.MILLIGRAMS, person2);
        Person person3 = new Person("Thomas","230", EyeColor.BLUE, HairColor.BLUE, Country.FRANCE,10,1.2,27);
        Product p3 = new Product("Clara",10,20,1.12,"gdhgs",100, UnitOfMeasure.MILLIGRAMS, person3);

        LinkedHashSet<Product> set = new LinkedHashSet<>();

        // Adding elements
        set.add(p1);
        set.add(p2);
        set.add(p3);

        TreeSet<Product> treeSet = new TreeSet<>(set);

        set.clear();
        set.addAll(treeSet);

        XmlWorker.toXml(set);
    }
}
