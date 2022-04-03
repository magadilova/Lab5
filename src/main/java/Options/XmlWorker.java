package Options;

import Model.*;
import com.thoughtworks.xstream.XStream;
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
        xstream.allowTypes(classes);
        return (LinkedHashSet<Product>) xstream.fromXML(xmlString);
    }
}


