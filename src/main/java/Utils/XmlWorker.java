package Utils;

import Model.*;
import com.thoughtworks.xstream.XStream;

import java.util.*;

public class XmlWorker {
    static public <T> String toXml(Collection<T> collection) {
        List<Collection<?>> list = List.of(collection);
        XStream xstream = new XStream();
        Class<?>[] classes = new Class[]{
                Person.class,
                Product.class,
                Coordinates.class,
                EyeColor.class,
                HairColor.class,
                Country.class,
                UnitOfMeasure.class,
                Location.class,
                collection.getClass()
        };
        xstream.alias("Collection", collection.getClass());
        xstream.processAnnotations(Product.class);
        xstream.allowTypes(classes);
        String xml = xstream.toXML(collection);
        System.out.println(xml);
        Collection<T> product = (Collection<T>) xstream.fromXML(xml);
        System.out.println(product.toString());
        return xml;
    }
}


