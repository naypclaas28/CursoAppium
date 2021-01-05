package testSuites;

//import com.sun.org.apache.xerces.internal.util.Status;
import io.qameta.allure.model.Status;
import conexion.DriverContext;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reports.Reports;
import testClases.Carrusel.Test_Carrusel;

import java.io.FileNotFoundException;
import static reports.Reports.addStep;
import static reports.Reports.finalAssert;

public class example2 {

    @BeforeMethod
    public void iniciarSession(){

    }

    @AfterMethod
    public void cerraSsion(){
      //  Reports.finalAssert();
        DriverContext.quitDriver();
    }

    @Test
    public void Test1() throws FileNotFoundException {

        MobileElement butonNext = (MobileElement) DriverContext.getDriver().findElementById("com.rodrigo.registro:id/next");
        butonNext.click();
        butonNext.click();
        addStep("Validar tercera vista del carrusel", true, Status.FAILED,false);
    }

    @Test(description = "Validacion Carrusel")
    public void Test_Carrusel() throws FileNotFoundException {
        Test_Carrusel test = new Test_Carrusel();
        test.validaciones();
        finalAssert();
    }
}
