package reports;

//import com.sun.org.apache.xerces.internal.util.Status;
import conexion.DriverContext;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

public class Reports {

    private static SoftAssert softAssert = new SoftAssert();

    public static void addStep(String descripcion, Boolean screenshot, Status status,Boolean fatal) throws FileNotFoundException {

        String uuid = UUID.randomUUID().toString();
        StepResult result = new StepResult().setName(descripcion).setStatus(status);
         Allure.getLifecycle().startStep(uuid,result);
         if(screenshot){
             reportScreenShot();
         }
         Allure.getLifecycle().stopStep(uuid);
         if(status.equals(Status.FAILED)){
             softAssert.fail(descripcion);
         }

         if(fatal){
             Assert.fail(descripcion);
         }

        System.out.println("[Report] "+descripcion);
    }

    private static void reportScreenShot() throws FileNotFoundException {
      File srcFile;
      srcFile = (File) DriverContext.getDriver().getScreenshotAs(OutputType.FILE);
      File foto = new File(srcFile.getPath());
      InputStream image;
      try {
          image = new FileInputStream(foto);
          Allure.addAttachment("Imagen Adjunta",image);
      } catch (FileNotFoundException e){
          e.printStackTrace();
      }
    }

    public  static void finalAssert(){
        softAssert.assertAll();
    }
}