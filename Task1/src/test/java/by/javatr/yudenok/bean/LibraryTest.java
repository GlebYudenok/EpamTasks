package by.javatr.yudenok.bean;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void createInstance(){
        Library library1 = Library.getInstance();
        Library library2 = Library.getInstance();
        assertEquals(library1,library2);
    }
}
