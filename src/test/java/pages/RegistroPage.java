package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.util.List;

import static reports.Reports.addStep;
import static utils.Utils.esperarObjeto;

public class RegistroPage {

    private AppiumDriver driver;

    public RegistroPage() {
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[contains(@text,\"Registro\")]")
    private MobileElement tituloVistaRegistro;

    @AndroidFindBy(id = "com.rodrigo.registro:id/fab_expand_menu_button")
    private MobileElement btnMas;

    @AndroidFindBy(id = "com.rodrigo.registro:id/action_cliente")
    private MobileElement btnCrearCliente;

    @AndroidFindBy(id = "com.rodrigo.registro:id/action_producto")
    private List<MobileElement> labelsClientes;


    public void validarVistaDesplegada() throws FileNotFoundException {
        if (esperarObjeto(tituloVistaRegistro, 2)) ;
        addStep("Validar Vista 1 de Carrusel- Descripcion", true, Status.PASSED, false);
        btnMas.click();
    }

    public void tapBtnMas() throws FileNotFoundException {
        if (esperarObjeto(btnMas, 2)) {
            addStep("Tap al boton Mas", false, Status.PASSED, false);
        } else {
            addStep("Error, el boton '+' no se encuentra", true, Status.FAILED, true);
        }

    }

    public void tapBtnCrearCliente() throws FileNotFoundException {
        if (esperarObjeto(btnCrearCliente, 2)) {
            addStep("Tap al botón 'Crear Cliente'", false, Status.PASSED, false);
            btnCrearCliente.click();
        } else {
            addStep("Botón 'Crear Cliente' No encontrado", false, Status.FAILED, true);
        }
    }

    public void validarCliente(String nombreCliente) throws FileNotFoundException {
        System.out.println("[RegistroCliente] Valida Cliente");
        boolean clienteEncontrado = false;
        for (int i = 0; i <= labelsClientes.size(); i++) {
            String nombreClienteActual = labelsClientes.get(i).getText();
            if (nombreClienteActual.equals(nombreCliente)) {
                clienteEncontrado = true;
                break;
            }
        }
        if (clienteEncontrado) {
            addStep("Cliente: " + nombreCliente + " registrado exitosamente.", true, Status.PASSED, false);
        } else {
            addStep("Cliente: " + nombreCliente + " No encontrado:", true, Status.FAILED, true);
        }
    }

//        MobileElement cliente = (MobileElement) DriverContext.getDriver().findElements(By.xpath("//*[contains(@text,\""+nombreClinete+"\")]"));
//        if (cliente.getText().equals(nombreClinete)) {
//            cliente.click();
//            addStep("Cliente: "+nombreClinete+" registrado exitosamente.",true,Status.PASSED,false);
//        }else{
//           addStep("Cliente: "+nombreClinete+" No encontrado:",true,Status.FAILED,true);
//        }
    

}
