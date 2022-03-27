package Controller;

import Model.*;
import Utils.XmlWorker;
import java.util.LinkedHashSet;
import java.util.TreeSet;


public class LinkedHashSetCollectionManager {
    private final LinkedHashSet<Product> set = new LinkedHashSet<>();

    public void add(Product product){
        set.add(product);
        TreeSet<Product> treeSet = new TreeSet<>(set);
        set.clear();
        set.addAll(treeSet);
    }

    public void addAll(LinkedHashSet<Product> linkedHashSet){
        TreeSet<Product> treeSet = new TreeSet<>(set);
        set.clear();
        set.addAll(treeSet);
    }

    public LinkedHashSet<Product> getSet() {
        return set;
    }

    public void clear(){
        set.clear();
    }

    public LinkedHashSet collectionDo(Product p1, Product p2, Product p3) {



        // Adding elements
        set.add(p1);
        set.add(p2);


        XmlWorker xmlWorker = new XmlWorker(set.getClass(),Product.class);

        String xml = xmlWorker.toXml(set,new Class[]{
                Person.class,
                Product.class,
                Coordinates.class,
                EyeColor.class,
                HairColor.class,
                Country.class,
                UnitOfMeasure.class,
                Location.class,
                set.getClass()
        });


        xmlWorker.fromXML(xml,new Class[]{
                Person.class,
                Product.class,
                Coordinates.class,
                EyeColor.class,
                HairColor.class,
                Country.class,
                UnitOfMeasure.class,
                Location.class,
                set.getClass()}
                );
        return set;
    }

}
