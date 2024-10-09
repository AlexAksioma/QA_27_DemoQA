package pages;

import dto.StudentDto;
import enums.Gender;
import enums.Hobbies;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.File;
import java.util.List;

public class AutomationPracticeFormPage extends BasePage {
    public AutomationPracticeFormPage(WebDriver driver) {
        setDriver(driver);
        hideFooter();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(id = "firstName")
    WebElement inputName;
    @FindBy(id = "lastName")
    WebElement inputLastName;
    @FindBy(id = "userEmail")
    WebElement inputEmail;
    @FindBy(id = "userNumber")
    WebElement inputMobileNumber;
    @FindBy(id = "dateOfBirthInput")
    WebElement inputDateOfBirth;
    @FindBy(id = "subjectsInput")
    WebElement inputSubjects;
    @FindBy(id = "uploadPicture")
    WebElement inputPicture;
    @FindBy(id = "currentAddress")
    WebElement inputCurrentAddress;
    @FindBy(id = "react-select-3-input")
    WebElement inputState;
    @FindBy(id = "react-select-4-input")
    WebElement inputCity;
    @FindBy(id = "submit")
    WebElement btnSubmit;
    //======================= modal
    @FindBy(xpath = "//tbody/tr[2]/td[last()]")
    WebElement modalEmail;

    public void fillPracticeForm(StudentDto student) {
        inputName.sendKeys(student.getName());
        inputLastName.sendKeys(student.getLastName());
        inputEmail.sendKeys(student.getEmail());

        clickGender(student.getGender());
        inputMobileNumber.sendKeys(student.getMobile());
        //inputDateOfBirth.sendKeys(student.getDateOfBirth());
        typeFieldDateOfBirth(student.getDateOfBirth());
        typeFieldSubjects(student.getSubjects());
        typeFieldHobbies(student.getHobbies());
        //====================================
        File file = new File("src/main/resources/photos/qa_blue.jpg");
        String filePath = file.getAbsolutePath();
        inputPicture.sendKeys(filePath);
        //====================================
        inputCurrentAddress.sendKeys(student.getCurrentAddress());
        inputState.sendKeys(student.getState());
        inputState.sendKeys(Keys.ENTER);
        inputCity.sendKeys(student.getCity());
        inputCity.sendKeys(Keys.ENTER);
    }

    private void typeFieldHobbies(List<Hobbies> hobbies) {
        for (Hobbies h : hobbies) {
            switch (h) {
                case MUSIC -> driver.findElement(By.xpath(h.getLocator())).click();
                case SPORTS -> driver.findElement(By.xpath(h.getLocator())).click();
                case READING -> driver.findElement(By.xpath(h.getLocator())).click();
            }
        }

    }

    private void typeFieldSubjects(String subjects) { //Maths,Physics,English,Chemistry
        String[] splitArray = subjects.split(",");
        inputSubjects.click();
        for (String str : splitArray) {
            inputSubjects.sendKeys(str);
            inputSubjects.sendKeys(Keys.ENTER);
        }
    }

    private void typeFieldDateOfBirth(String dateOfBirth) {  // 02 Sep 2000
        inputDateOfBirth.click();
        String operationSystem = System.getProperty("os.name");
        if (operationSystem.startsWith("Win"))
            inputDateOfBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        else if (operationSystem.startsWith("Mac"))
            inputDateOfBirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        inputDateOfBirth.sendKeys(dateOfBirth);
        inputDateOfBirth.sendKeys(Keys.ENTER);
    }

    private void clickGender(Gender gender) {
        WebElement elementGender = driver.findElement(By.xpath(gender.getLocator()));
        elementGender.click();
    }

    public void clickBtnSubmit() {
        btnSubmit.click();
    }
}
