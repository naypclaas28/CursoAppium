package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

import static reports.Reports.addStep;
import static utils.Utils.esperarObjeto;
import static utils.Utils.swipeAbajo;

public class EliminarPage {

    private AppiumDriver driver;

    public EliminarPage() {
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[contains(@text,\"Registro\")]")
    private MobileElement tituloVistaRegistro;

    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_cliente")
    private MobileElement labelNombre;

    @AndroidFindBy(id = "com.rodrigo.registro:id/eliminar_cliente")
    private MobileElement btnEliminar;

    @AndroidFindBy(id = "com.rodrigo.registro:id/editTextDialogUserInput")
    private MobileElement labelBorrar;

    @AndroidFindBy(id = "com.rodrigo.registro:id/editTextDialogUserInput")
    private MobileElement popUpText;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement btnOK;

    public void validarVistaDesplegada() throws FileNotFoundException {
        if (esperarObjeto(tituloVistaRegistro, 2)) ;
        addStep("Validar Vista desplegada del Cliente", true, Status.PASSED, false);
        labelNombre.click();
    }

    public void scroll() throws FileNotFoundException {
        swipeAbajo();
        addStep("Valida",true,Status.PASSED,false);
    }

    public void validarEliminarCliente() throws FileNotFoundException {
        System.out.println("[Eliminar Page] eliminar Cliente");
        addStep("Validar que se presenta la opcion Eliminar cliente",true,Status.PASSED,false);
        btnEliminar.click();
    }

    public void completarPopUp(String borrar) throws FileNotFoundException {
        System.out.println("[Eliminar Page] completar popUp");
        popUpText.setValue(borrar);
        this.driver.hideKeyboard();
    }

    public void validarBtnOK() throws FileNotFoundException {
        if (esperarObjeto(btnOK,5));
        addStep("Validar que se presente la opcion OK",true,Status.PASSED,false);
        btnOK.click();
    }

}
