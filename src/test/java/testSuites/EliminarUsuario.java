package testSuites;

import conexion.DriverContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testClases.Carrusel.EliminarUsuarioCase;

import java.io.FileNotFoundException;

import static conexion.DriverContext.setUP;

public class EliminarUsuario {

    @BeforeMethod
    public void iniciarSession(){
        setUP("R9YNB06KBKJ","Android","C:\\Users\\Nayp.Marambio\\Downloads\\registroDeUsuarios.apk","R9YNB06KBKJ",false);
    }

    @AfterMethod
    public void cerrarSession(){
        DriverContext.getDriver();
    }

    @Test
    public void EliminarUsuario() throws FileNotFoundException {
        EliminarUsuarioCase test = new EliminarUsuarioCase();
        test.flujoTestCase3();
    }
}
