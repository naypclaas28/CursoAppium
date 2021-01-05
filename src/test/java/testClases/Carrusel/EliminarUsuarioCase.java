package testClases.Carrusel;

import pages.CarruselPage;
import pages.EliminarPage;
import pages.RegistroPage;

import java.io.FileNotFoundException;

public class EliminarUsuarioCase {

    CarruselPage carruselPage = new CarruselPage();
    RegistroPage registroPage = new RegistroPage();
    EliminarPage eliminarPage = new EliminarPage();

    String text = "Lorem Ipsum";

    public void flujoTestCase3() throws FileNotFoundException {
        carruselPage.validarVistaDesplegada();
        carruselPage.recorrerCarrusel();
        carruselPage.tapBtnHecho();

        registroPage.validarVistaDesplegada();

        eliminarPage.validarVistaDesplegada();
        eliminarPage.scroll();
        eliminarPage.validarEliminarCliente();
        eliminarPage.completarPopUp(text);
        eliminarPage.validarBtnOK();
        registroPage.validarVistaDesplegada();
    }

}
