package tests;

import dto.StudentDto;
import enums.Gender;
import enums.Hobbies;
import manager.ApplicationManager;
import org.testng.annotations.Test;
import pages.AutomationPracticeFormPage;
import pages.FormsPage;
import pages.HomePage;

import java.util.ArrayList;
import java.util.List;

public class AutoPracticeFormTests extends ApplicationManager {

    AutomationPracticeFormPage automationPracticeFormPage;

    @Test
    public void fillAutoPracticeFormPositiveTest(){
        List<Hobbies> hobbies = new ArrayList<>(3);
        hobbies.add(Hobbies.MUSIC);
        hobbies.add(Hobbies.READING);
        StudentDto student = new StudentDto("Frodo", "Baggins",
                "bagginas@mail.com", Gender.FEMALE, "1234567890",
                "02 Sep 2000", "Maths,Physics,English,Chemistry",
                hobbies, "", "Haifa st.1 app.101");
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        automationPracticeFormPage = new AutomationPracticeFormPage(getDriver());
        automationPracticeFormPage.fillPracticeForm(student);
    }
}
