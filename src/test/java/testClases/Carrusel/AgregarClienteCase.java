package testClases.Carrusel;

import pages.CarruselPage;
import pages.CrearClientePage;
import pages.RegistroPage;

import java.io.FileNotFoundException;

public class AgregarClienteCase {
    CarruselPage carruselPage = new CarruselPage();
    RegistroPage registroPage = new RegistroPage();
    CrearClientePage crearClientePage = new CrearClientePage();

    String nombre = "Nayp";
    String ID = "123456789";
    String fono = "1234567";
    String Direccion = "lorem ipsum 123";
    String notas = "curso appium";

    public void flujo() throws FileNotFoundException {
        carruselPage.validarVistaDesplegada();
        carruselPage.recorrerCarrusel();
        carruselPage.tapBtnHecho();

        registroPage.validarVistaDesplegada();
        registroPage.tapBtnMas();
        registroPage.tapBtnCrearCliente();

        crearClientePage.validarVistaDesplegada();
        crearClientePage.completarFormulario(nombre,ID,fono,Direccion,notas);
        crearClientePage.tapGuardar();

        registroPage.validarVistaDesplegada();
        registroPage.validarCliente(nombre);
    }

}
