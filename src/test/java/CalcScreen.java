import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalcScreen {
    @FindBy(id="com.google.android.calculator:id/op_add")
    WebElement btnPlus;
    @FindBy(id = "com.google.android.calculator:id/op_sub")
    WebElement btnMinus;
    @FindBy(id="com.google.android.calculator:id/op_mul")
    WebElement btnMul;
    @FindBy(id="com.google.android.calculator:id/op_div")
    WebElement btnDiv;
    @FindBy(id="com.google.android.calculator:id/result_final")
    WebElement txtResult;
    @FindBy(id = "com.google.android.calculator:id/eq")
    WebElement btnEqual;
    @FindBy(id = "com.google.android.calculator:id/clr")
    WebElement btnClear;
    AndroidDriver driver;
    public CalcScreen(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver) ,this);
    }
    public String calcuateSeries(String s){
        for(int i=0; i <s.length ();i++){
            char c = s.charAt (i);
            if(c=='+'){
                btnPlus.click ();
            }
            else if(c=='-'){
                btnMinus.click ();
            }
            else if (c=='*'){
                btnMul.click ();
            } else if (c=='/') {
                btnDiv.click ();
            } else {
                driver.findElement (By.id ("com.google.android.calculator:id/digit_"+c)).click ();
            }
        }
        btnEqual.click ();
        return txtResult.getText ();
    }
}
