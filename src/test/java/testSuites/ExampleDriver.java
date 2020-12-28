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

public class ExampleDriver {

    @BeforeMethod
    public void inicioSesion(){
        AppiumDriver driver;
        URL server = null;
        try {
            server = new URL("http://127.0.01:4723/WD/HUB");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName","WGGECABMAUDELJ99");
        cap.setCapability("platformName","android");
        cap.setCapability("app","C:\\Users\\Nayp.Marambio\\Downloads\\registroDeUsuarios.apk");
        cap.setCapability("udid","WGGECABMAUDELJ99");
        driver = new AndroidDriver(server,cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void Test1(){
        System.out.println("PRUEBA");

    }
}
