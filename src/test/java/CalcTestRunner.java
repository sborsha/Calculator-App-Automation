import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CalcTestRunner extends Setup{
    @Test
    public void doSeries(){
        CalcScreen calcScreen = new CalcScreen (driver);
        int resActual = Integer.parseInt (calcScreen.calcuateSeries ("100/10*5-10+60"));
        int expectedRes = 100;
        Assert.assertEquals (resActual,expectedRes);
    }
    @AfterMethod
    public void clear(){
        CalcScreen calcScreen=new CalcScreen(driver);
        calcScreen.btnClear.click();
    }
}
