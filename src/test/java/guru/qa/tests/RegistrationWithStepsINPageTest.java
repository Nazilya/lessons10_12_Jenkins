package guru.qa.tests;

import guru.qa.pages.RegistrationPage;
import guru.qa.testData.TestData;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class RegistrationWithStepsINPageTest extends BaseTest {
    private TestData studentsData = new TestData();
    private RegistrationPage registrationPage = new RegistrationPage();
    @Test
    @Tag("regress")
    void successfulRegistrationWithStepsInPageTest() {
        registrationPage.openPage()
                .setFirstName(studentsData.firstName)
                .setLastName(studentsData.lastName)
                .setUserEmail(studentsData.userEmail)
                .setGender(studentsData.gender)
                .setPhoneNumber(studentsData.userNumber)
                .setBirthDate(studentsData.dayBirth, studentsData.monthBirth, studentsData.yearBirth)
                .setSubject(studentsData.subject)
                .setHobbiesWrapper(studentsData.hobby)
                .uploadPictureFile(studentsData.fileName)
                .setCurrentAddress(studentsData.currentAddress)
                .setStateAndCity(studentsData.state, studentsData.city)
                .clickSubmit();
        registrationPage.verifyResultsModalAppears()
                .checkTableResult("Student Name", studentsData.firstName + " " + studentsData.lastName)
                .checkTableResult("Address", studentsData.currentAddress)
                .checkTableResult("Hobbies", studentsData.hobby)
                .checkTableResult("Student Email", studentsData.userEmail)
                .checkTableResult("Date of Birth", studentsData.dayBirth + " " + studentsData.monthBirth + "," + studentsData.yearBirth)
                .checkTableResult("State and City", studentsData.state + " " + studentsData.city);
    }
}

