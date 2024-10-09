package tests;

import dto.StudentDto;
import enums.Gender;
import enums.Hobbies;
import enums.StateCity;
import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationPracticeFormPage;
import pages.FormsPage;
import pages.HomePage;

import java.util.ArrayList;
import java.util.List;

public class AutoPracticeFormTests extends ApplicationManager {

    SoftAssert softAssert = new SoftAssert();
    AutomationPracticeFormPage automationPracticeFormPage;

    @Test
    public void fillAutoPracticeFormPositiveTest() {
        List<Hobbies> hobbies = new ArrayList<>(3);
        hobbies.add(Hobbies.MUSIC);
        hobbies.add(Hobbies.READING);
        StudentDto student = new StudentDto("Frodo", "Baggins",
                "bagginas@mail.com", Gender.FEMALE, "1234567890",
                "02 Sep 2000", "Maths,Physics,English,Chemistry",
                hobbies, "", "Haifa st.1 app.101",
                StateCity.RAJASTHAN.getState(), StateCity.RAJASTHAN.getCity()[1]);
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        automationPracticeFormPage = new AutomationPracticeFormPage(getDriver());
        automationPracticeFormPage.fillPracticeForm(student);
        automationPracticeFormPage.clickBtnSubmit();
        //=====================================
        softAssert.assertEquals("email",
                getDriver().findElement(By.xpath("//tbody/tr[2]/td[last()]")).getText(),
                "validate email");

        softAssert.assertEquals(student.getMobile(),
                getDriver().findElement(By.xpath("//tbody/tr[4]/td[last()]")).getText(),
                "validate mobile");

        softAssert.assertAll();
    }

    @Test
    public void fillAutoPracticeFormPositiveTest_validateStudent() {
        List<Hobbies> hobbies = new ArrayList<>(3);
        hobbies.add(Hobbies.MUSIC);
        hobbies.add(Hobbies.READING);
        StudentDto student = new StudentDto("Frodo",
                "Baggins",
                "bagginas@mail.com",
                Gender.FEMALE,
                "1234567890",
                "02 Sep 2000",
                "Maths,Physics,English,Chemistry",
                hobbies,
                "",
                "Haifa st.1 app.101",
                StateCity.RAJASTHAN.getState(),
                StateCity.RAJASTHAN.getCity()[1]);
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        automationPracticeFormPage = new AutomationPracticeFormPage(getDriver());
        automationPracticeFormPage.fillPracticeForm(student);
        automationPracticeFormPage.clickBtnSubmit();
        //=====================================
        StudentDto resultStudent = new StudentDto(
                getDriver().findElement(By.xpath("//tbody/tr[1]/td[last()]")).getText().split(" ")[0],
                getDriver().findElement(By.xpath("//tbody/tr[1]/td[last()]")).getText().split(" ")[1],
                getDriver().findElement(By.xpath("//tbody/tr[2]/td[last()]")).getText(),
                Gender.FEMALE,
                getDriver().findElement(By.xpath("//tbody/tr[4]/td[last()]")).getText(),
                getDriver().findElement(By.xpath("//tbody/tr[5]/td[last()]")).getText(),
                getDriver().findElement(By.xpath("//tbody/tr[6]/td[last()]")).getText(),
                hobbies,
                getDriver().findElement(By.xpath("//tbody/tr[9]/td[last()]")).getText(),
                getDriver().findElement(By.xpath("//tbody/tr[9]/td[last()]")).getText(),
                getDriver().findElement(By.xpath("//tbody/tr[10]/td[last()]")).getText().split(" ")[0],
                getDriver().findElement(By.xpath("//tbody/tr[10]/td[last()]")).getText().split(" ")[1]
                );
        System.out.println(resultStudent.toString());
        Assert.assertEquals(student, resultStudent);
    }
}
