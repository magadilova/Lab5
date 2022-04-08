package options;

import model.*;
import com.thoughtworks.xstream.XStream;
import options.fileException.FileException;

import java.util.*;


public class XmlWorker {
    Class<? extends LinkedHashSet>  collectionClass;
    Class<Product> collectionElementClass;
    XStream xstream = new XStream();

    public XmlWorker(Class<? extends LinkedHashSet> collectionClass, Class<Product> collectionElementClass) {
        this.collectionClass = collectionClass;
        this.collectionElementClass = collectionElementClass;

        xstream.alias("Collection", collectionClass);
        xstream.processAnnotations(collectionElementClass);
    }

    public String toXml(LinkedHashSet<Product> collection, Class<?>[] classes) {
        xstream.allowTypes(classes);
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(collection);
    }

    public LinkedHashSet<Product> fromXML(String xmlString, Class<?>[] classes){
        try {
            if (xmlString.isEmpty()) throw new FileException("This file is empty !");
            if (!xmlString.isEmpty()){ xstream.allowTypes(classes); return (LinkedHashSet<Product>) xstream.fromXML(xmlString);}
            else throw new SecurityException("Permission denied");
        } catch (FileException | SecurityException e){
            System.out.println(e.getMessage());
        }
        System.exit(0);
        return null;
    }
}


