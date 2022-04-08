package controller;

import model.*;
import model.fieldException.FieldException;
import view.commandException.WrongFieldComandException;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;


public class LinkedHashSetCollectionManager {
    private final LinkedHashSet<Product> set = new LinkedHashSet<>();
    private final LocalDateTime dateInitialization = LocalDateTime.now();


    public void add(Product product){
        try {
            if (checkUniqueId(product)) {
                throw new SecurityException("Fail !!!  Product id must be unique");
            }

            set.add(product);
            sortSet();

        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }

    }

    public void addUpdate(Product product, long id){
        try {
            if (checkUniqueId(product)) {
                throw new SecurityException("Fail !!!  Product id must be unique");
            }
            product.setId(id);
            set.add(product);
            sortSet();

        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }

    }

    public void load (LinkedHashSet<Product> linkedHashSet){
        if (set.size() == 0) {
            this.set.addAll(linkedHashSet);
            Set<Long> setOfId = new HashSet<>();
            for (Product p : this.set) {
                setOfId.add(p.getId());
            }
            for (Long id : setOfId) {
                try {
                    int fieldC = 0;
                    for (Product p : this.set) {
                        if (id.equals(p.getId()))
                            fieldC = fieldC + 1;
                    }
                    if (fieldC > 1) {
                        throw new FieldException("Product id must be unique");
                    }
                } catch (FieldException e) {
                    deleteByID(id);
                    System.out.println(e.getMessage());
                }
            }
        } else {
            for (Iterator<Product> iterator = set.iterator(); iterator.hasNext(); ) {
                try {
                    Product p = iterator.next();
                    if (checkUniqueId(p)) {
                        throw new FieldException("Product id must be unique, this object will not be added to collection.\n" + p.toString());
                    }
                } catch (FieldException e) {
                    System.out.println(e.getMessage());
                    iterator.remove();
                }
            }
        }
    }

    public LinkedHashSet<Product> getSet() {
        return set;
    }

    public void clear(){
        set.clear();
    }

    public String getDateInitialization() {
        return dateInitialization.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
    }

    public void deleteByID(Long id) {
        if (!set.removeIf(element -> element.getId().equals(id)))
            throw new WrongFieldComandException("There is no element with the given \"id\" value");

    }

    public void deleteByPN(String partNumber) {
        if (!set.removeIf(item -> item.getPartNumber().equals(partNumber)))
            throw new WrongFieldComandException("There is no element with the given \" part number \" value");

    }


    private boolean checkUniqueId(Product product) {
        for (Product item : set) {
            if (item.getId().equals(product.getId()))
                return true;
        }
        return false;
    }

    public void deleteObject(Product product){
        set.remove(product);
        sortSet();
    }

    public void sortSet(){
        TreeSet<Product> treeSet = new TreeSet<>(set);
        set.clear();
        set.addAll(treeSet);
    }

}
