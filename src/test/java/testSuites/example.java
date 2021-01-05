package testSuites;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class example {
    private static SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void metodo1(){
        System.out.println("Inicio de Suite");

    }

    @AfterSuite
    public void metodo2(){
        System.out.println("Termino de Suite");
    }

    @Test(priority = 1 , description = "prueba 1")
    public void metodo3(){
        System.out.println("Test 1");
        softAssert.fail("Fail SOFT");
        System.out.println("Test 1");
        softAssert.assertAll();
    }

    @Test(priority = 2, description = "prueba 2")
    public void metodo4(){
        System.out.println("Test 2");
        Assert.assertTrue(true);
        Assert.assertTrue(false);
        Assert.assertEquals("1","0","Numeros no son iguales");

 //       Assert.fail("Fail");
        System.out.println("Test 2");


    }
    @AfterMethod
    public void metodo5(){
        System.out.println("Termino Test");
        Assert.assertTrue(true);

    }
}
