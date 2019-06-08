package by.javatr.yudenok.controller.parser.factory;

import by.javatr.yudenok.controller.parser.ParserKinds;
import by.javatr.yudenok.controller.parser.XMLParser;
import by.javatr.yudenok.controller.parser.impl.DOMParser;
import by.javatr.yudenok.controller.parser.impl.JAXBParser;
import by.javatr.yudenok.controller.parser.impl.SAXParsers;
import by.javatr.yudenok.controller.parser.impl.StAXParser;

public final class ParsersFactory {

    /**
     * private constructor.
     */
    private ParsersFactory() {

    }

    /**
     * simple factory, by which return
     * object depends of enumeration field.
     * @param parserKinds enumeration type field
     * @return one of parsers which implements interface
     */
    public static XMLParser parseXML(final ParserKinds parserKinds) {
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
        }
        return parser;
    }
}
