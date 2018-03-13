package axcontrol.po;

import com.mentProject.gmail.core.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Axcontrol extends PageObject {

    @FindBy(linkText = "Reliance Electric")
    private WebElement relianceElectric;

    @FindBy(className = "manufacturer_title")
    private List<WebElement> productTitle;
    @FindBy(className = "manufacturer_description")
    private List<WebElement> productDescription;

    public void clickRelianceElectric() {
        relianceElectric.click();
    }

    public List<WebElement> getProductTitle() {
        return productTitle;
    }

    public List<WebElement> getProductDescription() {
        return productDescription;
    }
}
