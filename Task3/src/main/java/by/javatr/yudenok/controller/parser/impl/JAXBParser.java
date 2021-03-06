package by.javatr.yudenok.controller.parser.impl;

import by.javatr.yudenok.bean.Candy;
import by.javatr.yudenok.bean.wrapper.Candies;
import by.javatr.yudenok.controller.parser.XMLParser;
import by.javatr.yudenok.exception.ParserException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class JAXBParser implements XMLParser {

     /**
     * function that parse from xml-document to object
     * via JAXB.
     * @param path path of file which will parse
     * @return list of objects
     * @throws ParserException exception if in file will invalid data
     */
    @Override
    public List<Candy> parseXML(final String path) throws ParserException {
        File file = new File(path);

        JAXBContext jaxbContext = null;
        Candies candies = null;

        try {
            jaxbContext = JAXBContext.newInstance(Candies.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            candies = (Candies) jaxbUnmarshaller.unmarshal(file);
            return candies.getCandyList();
        } catch (JAXBException e) {
            throw new ParserException(e);
        }
    }
}
