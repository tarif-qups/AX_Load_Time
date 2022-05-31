package loadtimetest;

import base.BaseTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NotewriterPage;
import utils.WriteIntoExcel;

public class TestTime extends BaseTests {
    protected NotewriterPage notewriterPage;

    public static long initialTime;
    long loginPageLoadTime;

    @BeforeMethod
    public void getUrl(){
        initialTime = System.currentTimeMillis();
        System.out.println("initial time: "+ initialTime);

        driver.get("https://dev2.augmedix.com:8191/");
        notewriterPage = new NotewriterPage(driver);
        notewriterPage.addToList("Initial Time", initialTime, 0L);
    }

    @Test
    public void testTime(){
        loginPageLoadTime = notewriterPage.getLoginPageLoadTime();
        System.out.println("load time for login page: " + (loginPageLoadTime - initialTime));
        notewriterPage.addToList("Loading Login Page", loginPageLoadTime, (loginPageLoadTime - initialTime));

        notewriterPage.enterEmail();
        notewriterPage.enterPassword();
        notewriterPage.clickLoginButton();
        System.out.println("dashboard page load time: "+ (notewriterPage.getDashboardPageLoadTime()));

        notewriterPage.selectProvider();
        notewriterPage.clickConnectBtn();
        System.out.println("role dialog box load time: " + notewriterPage.getRoleDialogBoxLoadTime());
        System.out.println("notewriter page load time: " + notewriterPage.getNotewriterPageLoadTime());
        notewriterPage.clickAddPatient();
        System.out.println("shorthand tab load time: " + notewriterPage.getShorthandNoteTabLoadTime());
        System.out.println("organize tab load time: " + notewriterPage.getOrganizeTabLoadTime());
        notewriterPage.inputDataToOrganizeTab();
        notewriterPage.getBuildTabLoadTime();
        notewriterPage.getMedicationListLoadTime();
        notewriterPage.getPETabLoadTime();
        notewriterPage.getAPTabLoadTime();
        notewriterPage.getAPMedicationListLoadTime();
        notewriterPage.getReviewTabLoadTime();

        try {
            WriteIntoExcel writeIntoExcel = new WriteIntoExcel();
            writeIntoExcel.writeData(notewriterPage.eventsName, notewriterPage.timestamps, notewriterPage.durations);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
