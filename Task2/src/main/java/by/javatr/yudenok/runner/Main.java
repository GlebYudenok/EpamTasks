package by.javatr.yudenok.runner;

import by.javatr.yudenok.bean.Text;
import by.javatr.yudenok.composite.CompositeElement;
import by.javatr.yudenok.controller.*;
import by.javatr.yudenok.dao.TextDAO;
import by.javatr.yudenok.dao.TextDAOimpl;
import by.javatr.yudenok.exception.ControllerException;
import by.javatr.yudenok.exception.DAOException;
import by.javatr.yudenok.exception.ParserException;
import by.javatr.yudenok.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(final String[] args) {
        Controller controller = new Controller();

        try {
            try {
                controller.executeTask("read");
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        } catch (ControllerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserException e) {
            e.printStackTrace();
        } catch (DAOException e) {
            System.err.println("Error at the time of reading from file");
            LOGGER.error("Error at the time of reading from file");
        }

        try {
            try {
                controller.executeTask("SORT");
            } catch (ServiceException e) {

            }
        } catch (ControllerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserException e) {
            e.printStackTrace();
        } catch (DAOException e) {
            System.err.println("Error at the time of reading from file");
        }

        try {
            try {
                controller.executeTask("RECOVER");
            } catch (ServiceException e) {
                LOGGER.error("The object contains nothing");
                System.err.println("The object contains nothing");
            }
        } catch (ControllerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserException e) {
            e.printStackTrace();
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public static void maybeneed(){

/*String s = "fsd fjdsf sdfj s
    jdaa fkja skfskdjfkjnasdfj sadkj fjs dfj sdakjf kjsdjkfn sjdaknfj
    k adsjkfkjsa dnfkj nsdkjnf kjsdna fjknsadkjf nkjsdnfkj nsdkjfn" +
                "sdf nsdafklnsdfnsdf klsdlkf skldaf lksndlfn slkdnf
                 sandlkfn sldknf klasdnflk nsdlkf";

            s = s.replaceAll("(.{50})","$1\n");
        System.out.println(s);*/
    }
}
