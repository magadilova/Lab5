package Utils;

import Model.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.StringWriter;
import java.util.Collection;
import java.util.TreeSet;

public class XmlWorker {
//    static public String toXml(Collection<?> collection){
//        Person person1 = new Person("Thomas","230", EyeColor.BLUE, HairColor.BLUE, Country.FRANCE,10,1.2,27);
//        Product p1 = new Product("Ares",10,20,1.12,"gdhgs",100, UnitOfMeasure.MILLIGRAMS, person1);
//        String xmlString = "";
//        try {
//            JAXBContext context = JAXBContext.newInstance(Product.class);
//            Marshaller m = context.createMarshaller();
//
//            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML
//
//            StringWriter sw = new StringWriter();
//            m.marshal(p1, sw);
//            xmlString = sw.toString();
//
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//        System.out.println(xmlString);
//        return xmlString;
//
//    }
}
