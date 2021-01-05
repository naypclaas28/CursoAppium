package testSuites;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static conexion.DriverContext.setUP;

public class ExampleDriver {

    @BeforeMethod
    public void inicioSesion(){
        setUP("R9YNB06KBKJ","Android","C:\\Users\\Nayp.Marambio\\Downloads\\registroDeUsuarios.apk","R9YNB06KBKJ",false);
    /*
        AppiumDriver driver;
        URL server = null;
        try {
            server = new URL("http://127.0.01:4723/WD/HUB");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName","R9YNB06KBKJ");
        cap.setCapability("platformName","android");
        cap.setCapability("app","C:\\Users\\Nayp.Marambio\\Downloads\\registroDeUsuarios.apk");
        cap.setCapability("udid","R9YNB06KBKJ");
        driver = new AndroidDriver(server,cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     */

   // setUP("R9YNB06KBKJ");

    }

    @Test
    public void Test1(){
        System.out.println("PRUEBA");

    }
}
