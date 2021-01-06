package testSuites;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import reports.Reports;
import testClases.Carrusel.AgregarClienteCase;
import testClases.Carrusel.CrearProductoCase;
import testClases.Carrusel.EliminarUsuarioCase;

import java.io.FileNotFoundException;

public class EjecucionCasosValueAppium {

    private static SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void inicioSesion(){
        System.out.println("Inicio de Suite");

    }

    @AfterSuite
    public void cerrarSesion(){
        Reports.finalAssert();
        System.out.println("Termino de Suite");
    }


    @Test (priority = 1,description = "Prueba flujo Agregar Cliente")
        public void AgregarCliente() throws FileNotFoundException {
        AgregarClienteCase test = new AgregarClienteCase();
        test.flujo();
        System.out.println("Prueba flujo Agregar Cliente");
        softAssert.fail("Fail Prueba flujo Agregar Cliente");
        System.out.println("Prueba flujo Agregar Cliente");
        softAssert.assertAll();
    }


    @Test(priority = 2,description = "Prueba flujo Crear Producto testCase1")
    public void AgregarProducto() throws FileNotFoundException {
        CrearProductoCase test = new CrearProductoCase();
        test.flujoTestCase1();
        System.out.println("TestCase1");
        Assert.assertTrue(true);
        Assert.assertTrue(false);
        System.out.println("TestCase1");
        softAssert.assertAll();

    }

    @AfterMethod
    @Test(priority = 3,description = "Prueba flujo Eliminar Producto testCase2")
    public void EliminarUsuario() throws FileNotFoundException {
        EliminarUsuarioCase test = new EliminarUsuarioCase();
        test.flujoTestCase3();
        System.out.println("TestCase3");
        Assert.assertTrue(true);
        Assert.assertTrue(false);
        System.out.println("TestCase3");
        softAssert.assertAll();
    }
}
