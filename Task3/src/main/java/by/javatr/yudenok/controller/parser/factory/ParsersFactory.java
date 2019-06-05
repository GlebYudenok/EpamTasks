package by.javatr.yudenok.controller.parser.factory;

import by.javatr.yudenok.controller.parser.*;
import by.javatr.yudenok.controller.parser.impl.DOMParser;
import by.javatr.yudenok.controller.parser.impl.JAXBParser;
import by.javatr.yudenok.controller.parser.impl.SAXParsers;
import by.javatr.yudenok.controller.parser.impl.StAXParser;

public class ParsersFactory {

    public static XMLParser parseXML(ParserKinds parserKinds){
        XMLParser parser = null;

        switch (parserKinds) {
            case DOM:
                parser = new DOMParser();
                break;
            case SAX:
                parser = new SAXParsers();
                break;
            case JAXB:
                parser = new JAXBParser();
                break;
            case StAX:
                parser = new StAXParser();
                break;
            default:
                //exception
        }
        return parser;
    }
}
