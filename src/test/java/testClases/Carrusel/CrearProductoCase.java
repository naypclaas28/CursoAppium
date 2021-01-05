package testClases.Carrusel;

import pages.CarruselPage;
import pages.CrearProductoPage;
import pages.RegistroPage;

import java.io.FileNotFoundException;

public class CrearProductoCase {

    CarruselPage carruselPage = new CarruselPage();
    RegistroPage registroPage = new RegistroPage();
    CrearProductoPage crearProductoPage = new CrearProductoPage();

    String name = "Juego llaves";
    String valor = "30000";

    public void flujoTestCase1() throws FileNotFoundException {

        carruselPage.validarVistaDesplegada();
        carruselPage.recorrerCarrusel();
        carruselPage.tapBtnHecho();

        registroPage.validarVistaDesplegada();
        registroPage.tapBtnMas();

        crearProductoPage.tapBtnCrearProducto();
        crearProductoPage.validarVistaDesplegadaProducto();
        crearProductoPage.completarFormularioProducto(name,valor);
        crearProductoPage.tapGuardar();
        crearProductoPage.validarVistaProducto();
        crearProductoPage.validarNombreProducto();
        crearProductoPage.validarPrecioProducto();
    }
}
