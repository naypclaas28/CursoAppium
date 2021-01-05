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

public class CrearProductoPage {

    private AppiumDriver driver;

    public CrearProductoPage() {
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**
     *
     */

    @AndroidFindBy(xpath = "//*[contains(@text,\"Crear Producto\")]")
    private MobileElement tituloVistaCrearProducto;

    @AndroidFindBy(id = "com.rodrigo.registro:id/action_producto")
    private MobileElement btnCrearProducto;

    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_producto")
    private MobileElement txtNombreProducto;

    @AndroidFindBy(id = "com.rodrigo.registro:id/precio")
    private MobileElement txtPrecioLista;

    @AndroidFindBy(id = "com.rodrigo.registro:id/confirmar")
    private MobileElement btnConfirmar;

    @AndroidFindBy(xpath = "//*[contains(@text,\"PRODUCTOS\")]")
    private MobileElement vistaProducto;

    @AndroidFindBy(id = "com.rodrigo.registro:id/precio_producto")
    private MobileElement txtPrecioProducto;

    public void tapBtnCrearProducto() throws FileNotFoundException {
        if (esperarObjeto(btnCrearProducto, 2)) {
            addStep("Tap al botón 'Crear Producto'", false, Status.PASSED, false);
            btnCrearProducto.click();
        } else {
            addStep("Botón 'Crear Producto' No encontrado", false, Status.FAILED, true);
        }
    }

    public void validarVistaDesplegadaProducto() throws FileNotFoundException {
        if (esperarObjeto(tituloVistaCrearProducto,5)){
            addStep("Validar Vista Crear Producto Desplegada",true, Status.PASSED,false);
        }else {
            addStep("Error, Validar Vista Crear Producto Desplegada", true, Status.FAILED, true);
        }
    }

    public void completarFormularioProducto(String name, String valor) throws FileNotFoundException {
        System.out.println("[CrearProducto Page] completar formulario producto");
        txtNombreProducto.setValue(name);
        this.driver.hideKeyboard();
        txtPrecioLista.click();
        txtPrecioLista.setValue(valor);
        this.driver.hideKeyboard();

        addStep("Completar Formulario de Creacion de Producto",true,Status.PASSED,false);
    }

    public void tapGuardar(){ btnConfirmar.click(); }

    public void validarVistaProducto() throws FileNotFoundException {
        if (esperarObjeto(vistaProducto,5)){
            addStep("Validar que se presente la vista del producto agregado",true,Status.PASSED,false);
        }else {
            addStep("Error, No se presenta la vista del producto agregado",true,Status.FAILED,true);
        }
    }

    public void validarNombreProducto() throws FileNotFoundException {
        if (esperarObjeto(txtNombreProducto,5)){
            addStep("Validar que se presente la vista el Nombre del Producto",true,Status.PASSED,false);
        }else {
            addStep("Error, No se presenta la vista el Nombre del Producto",true,Status.FAILED,true);
        }
    }

    public void validarPrecioProducto() throws FileNotFoundException {
        if (esperarObjeto(txtPrecioProducto,5)){
            addStep("Validar que se presente la vista del Precio del Producto",true,Status.PASSED,false);
        }else {
            addStep("Error, No se presenta la vista del Precio del Producto",true,Status.FAILED,true);
        }
    }

}
