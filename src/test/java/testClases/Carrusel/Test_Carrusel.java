package testClases.Carrusel;

import pages.CarruselPage;

import java.io.FileNotFoundException;

public class Test_Carrusel {

    CarruselPage carruselPage = new CarruselPage();

    public void validaciones() throws FileNotFoundException {

        carruselPage.validarVistaDesplegada();
        carruselPage.validarTextoVista1Carrusel();
    }
}
