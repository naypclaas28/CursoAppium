package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

import static org.aspectj.bridge.Version.getText;
import static reports.Reports.addStep;
import static utils.Utils.esperarObjeto;

public class CarruselPage {

    private AppiumDriver driver;

    public CarruselPage() {
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    /**
     * Objetos
     */

    @AndroidFindBy(id = "com.rodrigo.registro:id/imageView2")
    private MobileElement iconoVista1;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[1]")
    private MobileElement tituloVista;

    @AndroidFindBy(id = "com.rodrigo.registro:id/textView")
    private MobileElement descripcionVista;

    @AndroidFindBy(id = "com.rodrigo.registro:id/next")
    private MobileElement btnFlecha;

    @AndroidFindBy(id = "com.rodrigo.registro:id/done")
    private MobileElement btnHecho;
    /**
    ** POPUP ANDROID
     */

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement btnPermitir;

    public void recorrerCarrusel(){
        System.out.println("[CarruselPage] recorrerCarrusel");
        int cont = 0;
        do {
            cont++;
            btnFlecha.click();
        }while (cont<3);

    }

    public void tapBtnHecho(){
        btnPermitir.click();
        btnHecho.click();
    }

    public void validarVistaDesplegada() throws FileNotFoundException {

        if (iconoVista1.isDisplayed()){
            addStep("Validar Vista 1 de Carrusel desplegada",true, Status.PASSED, false);
        }else{
            addStep("Validar Vista 1 de Carrusel desplegada",true, Status.FAILED, true);
        }
    }

    public void validarTextoVista1Carrusel() throws FileNotFoundException {
        if (esperarObjeto(descripcionVista,5)){
            String textoDescripcionVista1 = descripcionVista.getText();
            if(textoDescripcionVista1.equals("Con Registro podrás guardar de forma fácil y segura todo lo relacionado a la venta de productos o servicios.")){
                addStep("Validar Vista 1 de Carrusel- Descripcion",true, Status.PASSED,false);
            }else {
                addStep("Validar Vista 1 de Carrusel- Descripcion", true, Status.FAILED, true);
            }

        }
    }


}
