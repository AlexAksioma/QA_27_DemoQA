package pages;

import dto.StudentDto;
import enums.Gender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AutomationPracticeFormPage extends BasePage{
    public AutomationPracticeFormPage(WebDriver driver) {
        setDriver(driver);
        hideFooter();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(id = "firstName")
    WebElement inputName;
    @FindBy(id = "lastName")
    WebElement inputLastName;
    @FindBy(id ="userEmail")
    WebElement inputEmail;
    public void fillPracticeForm(StudentDto student) {
        inputName.sendKeys(student.getName());
        inputLastName.sendKeys(student.getLastName());
        inputEmail.sendKeys(student.getEmail());

        clickGender(student.getGender());
    }

    private void clickGender(Gender gender) {
        WebElement elementGender = driver.findElement(By.xpath(gender.getLocator()));
        elementGender.click();
    }
}
