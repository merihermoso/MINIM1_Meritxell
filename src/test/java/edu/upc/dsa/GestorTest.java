package edu.upc.dsa;

import org.junit.After;
import org.junit.Before;

public class GestorTest {
    Covid19Manager ge;
    @Before
    public void setUp() throws Exception {
        ge = Covid19ManagerImpl.getInstance();

        //this.ge.addOrder("Pagado","2");
    }

    @After
    public void tearDown() throws Exception {
    }
}