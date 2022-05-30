package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    WebDriver driver;
    public List<String> eventsName = new ArrayList<String>();
    public List<Long> timestamps = new ArrayList<Long>();
    public List<Long> durations = new ArrayList<Long>();


    /**
     * locators
     */
    By loginContainer = By.xpath("//section[@class=\"login__container\"]");
    By emailField = By.id("ajs-login-email");
    By passwordField = By.id("ajs-login-password");
    By loginButton = By.id("ajs-login-submit-btn");
    By dashboardPageAlert = By.xpath("//div[@class=\"alert alert--hero\"]");
    By providerListDropdown = By.id("ajs-header-provider-list");
    By connectButton = By.id("ajs-header-provider-connect-cta");
    By roleDialogBox = By.xpath("//div[@role=\"dialog\"]");
    By primaryScribeBtn = By.id("ajs-scribe-connect-list-primary");
    By notewriterPrimarySection = By.xpath("//section[@class=\"notewriter__primary is--empty\"]");
    By notewriterSecondaryMessage = By.xpath("//section[@class=\"notewriter__secondary__message ng-star-inserted\"]");
    By pageSectionContainer = By.xpath("//section[@class=\"page__section__container\"]");
    By addPatientIcon = By.id("ajs-notewriter-add-new-patient-cta");
    By shorthandNoteTab = By.xpath("//div[@class=\"nbcanvas-accordion__item__header\"]");
    By organizeTab = By.xpath("//div[@class=\"nbroot__secondary\"]");
    By nameInputField = By.xpath("(//input[@type=\"text\"])[3]");
    By genderOptionMale = By.xpath("(//span[contains(text(),\"male\")])[1]");
    By ageInputField = By.xpath("//input[@type='number']");
    By typeNew = By.xpath("//span[contains(text(),\"new\")]");
    By startTime = By.xpath("(//input[@type='time'])[2]");
    By serviceTypeInPerson = By.xpath("//span[contains(text(),\"In-person\")]");
    By visitType = By.xpath("(//input[@type=\"text\"])[7]");
    By visitTypeList = By.xpath("//ul[@class=\"nbdropdown ng-star-inserted\"]");
    By visitTypeListItem = By.xpath("//li[@data-item=\"nb-dropdown-item-0\"]");
    By complaint = By.xpath("(//input[@type=\"text\"])[8]");
    By complaintList = By.xpath("//ul[@class=\"nbdropdown ng-star-inserted\"]");
    By complaintListItem = By.xpath("//li[@data-item=\"nb-dropdown-item-0\"]");
    By buildTabButton = By.xpath("//span[contains(text(),\"build\")]");
    By buildTabSection = By.xpath("//app-nb-hpi[@class=\"ng-star-inserted\"]");
    By accompaniedByOptions = By.xpath("//ul[@class=\"nbtag ng-star-inserted\"]");
    By selectedComplaints = By.xpath("//ul[@class=\"nbtag nbtag--hr nbtag--edit-enabled\"]");
    By medicationText = By.xpath("(//div[@class=\"nbblock__item nbblock__item--primary\"])[2]");
    By medicationInputField = By.xpath("(//input[@type=\"text\"])[4]");
    By medicationList = By.xpath("//ul[@class=\"nbdropdown ng-star-inserted\"]");
    By peTab = By.xpath("//span[contains(text(), \"PE\")]");
    By peSection = By.xpath("//app-nb-pe[@class=\"ng-star-inserted\"]");
    By apTab = By.xpath("//span[contains(text(), \"A/P\")]");
    By apSection = By.xpath("//app-nb-ap[@class=\"ng-star-inserted\"]");
    By apMedicationText = By.xpath("(//div[@class=\"nbblock__item nbblock__item--primary\"])[2]");
    By apMedicationInputField = By.xpath("(//input[@type=\"text\"])[4]");
    By apMedicationList = By.xpath("//ul[@class=\"nbdropdown ng-star-inserted\"]");
    By reviewTab = By.xpath("//span[contains(text(), \"review\")]");
    By reviewModal = By.xpath("//div[@class=\"nbmodal__content\"]");
    By reviewModalYesBtn = By.xpath("//button[@class=\"nbmodal__action__cta nbmodal__action__cta--primary\"]");
    By reviewTextEditor = By.id("richtexteditor");


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilVisibilityOfElement(int duration, By locatorName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorName));
    }

    public void addToList(String event, long timestamp, long duration) {
        eventsName.add(event);
        timestamps.add(timestamp);
        durations.add(duration);
    }
}
