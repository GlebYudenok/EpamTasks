package by.javatr.yudenok.controller;

import by.javatr.yudenok.bean.Candy;
import by.javatr.yudenok.bean.Ingredient;
import by.javatr.yudenok.controller.parser.ParserKinds;
import by.javatr.yudenok.controller.parser.XMLParser;
import by.javatr.yudenok.controller.parser.factory.ParsersFactory;
import by.javatr.yudenok.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class WebController extends HttpServlet {

    Logger logger = LogManager.getLogger(WebController.class);
    /**
     * path of file which will parse.
     */
    private static String path =
            "D:\\Epam\\EpamTasks\\Task3\\src\\main\\resources\\Candies.xml";

    /**
     * get method, which allows transfer
     * parameters in URL.
     * @param request request from user
     * @param response response from server
     */
    @Override
    public void doGet(final HttpServletRequest request,
                      final HttpServletResponse response) {

    }

    /**
     * post method, which allows transfer
     * parameters in URL and forms.
     * @param request request from user
     * @param response response from server
     * @throws IOException input/output exception
     */
    @Override
    public void doPost(final HttpServletRequest request,
                       final HttpServletResponse response)
            throws IOException {
        logger.info("log");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List<Candy> candyList = new ArrayList<>();

        XMLParser parser = null;
        switch (request.getParameter("parser")) {
            case "DOM":
                parser = ParsersFactory.parseXML(ParserKinds.DOM);
                try {
                    candyList = parser.parseXML(path);
                } catch (JAXBException | ParserException
                        | ParserConfigurationException
                        | SAXException
                        | XMLStreamException
                        | ParseException e) {
                    e.printStackTrace();
                }
            break;
            case "SAX":
                parser = ParsersFactory.parseXML(ParserKinds.SAX);
                try {
                    candyList = parser.parseXML(path);
                } catch (JAXBException | ParserException
                        | ParserConfigurationException
                        | SAXException
                        | XMLStreamException
                        | ParseException e) {
                    e.printStackTrace();
                }
            break;
            case "StAX":
                parser = ParsersFactory.parseXML(ParserKinds.StAX);
                try {
                    candyList = parser.parseXML(path);
                } catch (JAXBException | ParserException
                        | ParserConfigurationException
                        | SAXException
                        | XMLStreamException
                        | ParseException e) {
                    e.printStackTrace();
                }
            break;
            case "JAXB":
                parser = ParsersFactory.parseXML(ParserKinds.JAXB);
                try {
                    candyList = parser.parseXML(path);
                } catch (JAXBException | ParserException
                        | ParserConfigurationException
                        | SAXException
                        | XMLStreamException
                        | ParseException e) {
                    e.printStackTrace();
                }
            break;
            default:
                out.println("Error");
        }

        out.println("<html><title>task3</title><head>"
                + "<form action='index.jsp' method='GET'>"
                + "<input type='submit' value='Choose other parser'/>"
                + "</form></head>"
                + "<style>"
                + "body {"
                + "background-color: pink;"
                + "}</style>"
                + "<body><table border='2' align = 'center'><tr>"
                + "<td>Id</td>"
                + "<td>title</td>"
                + "<td>type of candy</br>"
                + "<td>energy</td>"
                + "<td>ingredient</td>"
                + "<td>producer</td>"
                + "<td>value</td>"
                + "</tr>");

        for (Candy candy : candyList) {

            out.println("<tr><td>" + candy.getId() + "</td>"
                    + "<td>" + candy.getTitle() + "</td>"
                    + "<td>" + candy.getCandyType() + "</td>"
                    + "<td>" + candy.getEnergy() + "</td> "
                    + "<td>");
            for (Ingredient e : candy.getIngredients().getIngredients()) {
                out.println(e);
            }
            out.println(
                            "</td>"
                                    + "<td>" + candy.getProducer() + "</td>"
                                    + "<td>" + candy.getValue() + "</td>"
                                    + "</tr>");
        }
        out.println("</table></body></html>");
    }
}
