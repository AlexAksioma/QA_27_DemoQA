package tests;

import dto.StudentDto;
import enums.Gender;
import manager.ApplicationManager;
import org.testng.annotations.Test;
import pages.AutomationPracticeFormPage;
import pages.FormsPage;
import pages.HomePage;

public class AutoPracticeFormTests extends ApplicationManager {

    AutomationPracticeFormPage automationPracticeFormPage;

    @Test
    public void fillAutoPracticeFormPositiveTest(){
        StudentDto student = new StudentDto("Frodo", "Baggins",
                "bagginas@mail.com", Gender.FEMALE, "1234567890",
                "02 Sep 2000", "Maths,Physics,English,Chemistry");
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        automationPracticeFormPage = new AutomationPracticeFormPage(getDriver());
        automationPracticeFormPage.fillPracticeForm(student);
    }
}
