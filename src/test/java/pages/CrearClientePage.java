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

public class CrearClientePage {

    private AppiumDriver driver;
    public CrearClientePage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "//*[contains(@text,\"Crear Cliente\")]")
    private MobileElement tituloVistaCrearCliente;

    @AndroidFindBy(id = "com.rodrigo.registro:id/ac_nombre")
    private MobileElement txtNombre;

    @AndroidFindBy(id = "com.rodrigo.registro:id/ruc")
    private MobileElement txtID;

    @AndroidFindBy(id = "com.rodrigo.registro:id/tel")
    private MobileElement txtTelefono;

    @AndroidFindBy(id = "com.rodrigo.registro:id/dir")
    private MobileElement txtDireccion;

    @AndroidFindBy(id = "com.rodrigo.registro:id/notas")
    private MobileElement txtNotas;

    @AndroidFindBy(id = "com.rodrigo.registro:id/guardar")
    private MobileElement btnGuardar;


    public void validarVistaDesplegada() throws FileNotFoundException {
        if (esperarObjeto(tituloVistaCrearCliente,5)){
                addStep("Validar Vista Crear Cliente Desplegada",true, Status.PASSED,false);
            }else {
                addStep("Error, Validar Vista Crear Cliente Desplegada", true, Status.FAILED, true);
            }
    }

    public void completarFormulario(String name, String ID, String fono,String Dir, String notas) throws FileNotFoundException {
        System.out.println("[CrearCliente Page] completar formulario");
        txtNombre.setValue(name);
        this.driver.hideKeyboard();
        txtID.click();
        txtID.setValue(ID);
        this.driver.hideKeyboard();
        txtTelefono.click();
        txtTelefono.setValue(fono);
        this.driver.hideKeyboard();
        txtDireccion.click();
        txtDireccion.setValue(Dir);
        this.driver.hideKeyboard();
        txtNotas.click();
        txtNotas.setValue(notas);
        this.driver.hideKeyboard();

        addStep("Completar Formulario de Creacion de Cliente",true,Status.PASSED,false);
    }

    public void tapGuardar(){
        btnGuardar.click();
    }
}
