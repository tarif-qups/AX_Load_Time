package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class NotewriterPage extends BasePage {
    private WebDriver driver;

    /**
     * variables for load times of elements in milliseconds.
     */
    long loginPageLoadTime;
    long timeBeforeClickingLoginBtn;
    long dashboardPageLoadTime;
    long timeBeforeClickingConnectBtn;
    long roleDialogBoxLoadTime;
    long timeBeforeClickingPrimaryScribeBtn;
    long notewriterPageLoadTime;
    long timeBeforeClickingAddPatient;
    long shorthandNoteTabLoadTime;
    long organizeTabLoadTime;
    long visitTypeListLoadTime;
    long complaintListLoadTime;
    long buildTabLoadTime;
    long medicationListLoadTime;
    long peTabLoadTime;
    long apTabLoadTime;
    long apMedicationLoadTime;
    long reviewModalLoadTime;
    long reviewTextEditorLoadTime;

    public NotewriterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * @return load time for login page
     */
    public long getLoginPageLoadTime() {
        waitUntilVisibilityOfElement(15, loginContainer);
        if (driver.findElement(loginContainer).isDisplayed()) {
            loginPageLoadTime = System.currentTimeMillis();
            System.out.println("Login page loading timestamp: " + loginPageLoadTime);
            return loginPageLoadTime;
        }
        return -1;
    }

    public void enterEmail() {
        waitUntilVisibilityOfElement(5, emailField);
        if (driver.findElement(emailField).isDisplayed()) {
            driver.findElement(emailField).click();
            driver.findElement(emailField).sendKeys("test_account_scribe_dev_22@augmedix.com");
        } else {
            System.out.println("Element not displayed");
        }
    }

    public void enterPassword() {
        waitUntilVisibilityOfElement(5, passwordField);
        if (driver.findElement(passwordField).isDisplayed()) {
            driver.findElement(passwordField).click();
            driver.findElement(passwordField).sendKeys("Asdfgh#12345");
        } else {
            System.out.println("Element not displayed");
        }
    }

    public void clickLoginButton() {
        waitUntilVisibilityOfElement(5, loginButton);
        timeBeforeClickingLoginBtn = System.currentTimeMillis();

        addToList("Time before clicking login button", timeBeforeClickingLoginBtn, (timeBeforeClickingLoginBtn - timestamps.get(1)));

        System.out.println("Time before clicking login button: " + timeBeforeClickingLoginBtn);
        driver.findElement(loginButton).click();
    }

    public long getDashboardPageLoadTime() {
        waitUntilVisibilityOfElement(15, dashboardPageAlert);
        if (driver.findElement(dashboardPageAlert).isDisplayed()) {
            long dashboardPageTimestamp = System.currentTimeMillis();
            dashboardPageLoadTime = dashboardPageTimestamp - timeBeforeClickingLoginBtn;

            addToList("Loading dashboard page", dashboardPageTimestamp, dashboardPageLoadTime);

            System.out.println("Dashboard page loading timestamp: " + dashboardPageTimestamp);
            return dashboardPageLoadTime;
        } else {
            System.out.println("Element not found");
            return -1;
        }
    }

    public void selectProvider() {
        if (driver.findElement(dashboardPageAlert).isDisplayed()) {
            Select provider = new Select(driver.findElement(providerListDropdown));
            driver.findElement(providerListDropdown).click();
            provider.selectByVisibleText(" Gd, Stg Doc2 ");
        } else {
            waitUntilVisibilityOfElement(10, dashboardPageAlert);
        }
    }

    public void clickConnectBtn() {
        timeBeforeClickingConnectBtn = System.currentTimeMillis();

        addToList("Time before clicking connect button", timeBeforeClickingConnectBtn, (timeBeforeClickingConnectBtn - timestamps.get(timestamps.size()-1)));

        System.out.println("time before clicking connect button: " + timeBeforeClickingConnectBtn);

        driver.findElement(connectButton).click();
    }

    public long getRoleDialogBoxLoadTime() {
        if (driver.findElement(roleDialogBox).isDisplayed()) {
            long roleDialogBoxTimestamp = System.currentTimeMillis();

            roleDialogBoxLoadTime = roleDialogBoxTimestamp - timeBeforeClickingConnectBtn;

            addToList("Loading Role Dialog Box", roleDialogBoxTimestamp, roleDialogBoxLoadTime);
            System.out.println("Role dialog box loading timestamp: " + roleDialogBoxTimestamp);
            return (roleDialogBoxLoadTime);
        } else {
            return -1;
        }
    }

    public long getNotewriterPageLoadTime() {
        if (driver.findElement(roleDialogBox).isDisplayed()) {
            timeBeforeClickingPrimaryScribeBtn = System.currentTimeMillis();

            addToList("Time before clicking primary scribe button", timeBeforeClickingPrimaryScribeBtn, (timeBeforeClickingPrimaryScribeBtn - timestamps.get(timestamps.size()-1)));

            System.out.println("time before clicking primary scribe button: " + timeBeforeClickingPrimaryScribeBtn);
            driver.findElement(primaryScribeBtn).click();

            waitUntilVisibilityOfElement(20, notewriterSecondaryMessage);
            waitUntilVisibilityOfElement(20, pageSectionContainer);
            waitUntilVisibilityOfElement(20, notewriterPrimarySection);

            WebElement notewriterPrimary = driver.findElement(notewriterPrimarySection);
            WebElement notewriterSecondary = driver.findElement(notewriterSecondaryMessage);
            WebElement notewriterPageSection = driver.findElement(pageSectionContainer);

            if (notewriterPrimary.isDisplayed() && notewriterSecondary.isDisplayed() && notewriterPageSection.isDisplayed()) {
                long notewriterPageTimestamp = System.currentTimeMillis();
                notewriterPageLoadTime = notewriterPageTimestamp - timeBeforeClickingPrimaryScribeBtn;
                addToList("Loading Notewriter page", notewriterPageTimestamp, notewriterPageLoadTime);

                System.out.println("notewriter page loading timestamp: " + notewriterPageTimestamp);
                return notewriterPageLoadTime;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public void clickAddPatient() {
        waitUntilVisibilityOfElement(20, notewriterPrimarySection);
        if (driver.findElement(addPatientIcon).isDisplayed()) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            timeBeforeClickingAddPatient = System.currentTimeMillis();

            addToList("Time before clicking add patient", timeBeforeClickingAddPatient, (timeBeforeClickingAddPatient - timestamps.get(timestamps.size()-1)));

            System.out.println("Time before clicking add patient: " + timeBeforeClickingAddPatient);
            WebElement element = driver.findElement(addPatientIcon);
            element.click();

//            JavascriptExecutor executor = (JavascriptExecutor)driver;
//            executor.executeScript("arguments[0].click();", element);
        } else {
            System.out.println("element not found.");
        }
    }

    public long getShorthandNoteTabLoadTime() {
        waitUntilVisibilityOfElement(30, shorthandNoteTab);
        if (driver.findElement(shorthandNoteTab).isDisplayed()) {
            long shorthandNoteTabTimestamp = System.currentTimeMillis();
            shorthandNoteTabLoadTime = shorthandNoteTabTimestamp - timeBeforeClickingAddPatient;

            addToList("Loading shorthand note tab", shorthandNoteTabTimestamp, shorthandNoteTabLoadTime);

            System.out.println("Shorthand tab loading timestamp: " + shorthandNoteTabTimestamp);
            return shorthandNoteTabLoadTime;
        } else return -1;
    }

    public long getOrganizeTabLoadTime() {
        waitUntilVisibilityOfElement(30, organizeTab);
        if (driver.findElement(organizeTab).isDisplayed()) {
            long organizeTabTimestamp = System.currentTimeMillis();
            organizeTabLoadTime = organizeTabTimestamp - timeBeforeClickingAddPatient;

            addToList("Loading Organize tab", organizeTabTimestamp, organizeTabLoadTime);
            System.out.println("Organize tab loading timestamp: " + organizeTabLoadTime);
            return organizeTabLoadTime;
        } else return -1;
    }

    public void inputDataToOrganizeTab() {
        if (driver.findElement(organizeTab).isDisplayed()) {
            driver.findElement(nameInputField).click();
            driver.findElement(nameInputField).sendKeys("Tom");
            driver.findElement(genderOptionMale).click();
            driver.findElement(ageInputField).click();
            driver.findElement(ageInputField).sendKeys("30");
            driver.findElement(typeNew).click();
            driver.findElement(startTime).sendKeys("17:30");
            driver.findElement(serviceTypeInPerson).click();

            long timeBeforeClickingVisitType = System.currentTimeMillis();

            addToList("Time before clicking visit type", timeBeforeClickingVisitType, (timeBeforeClickingVisitType-timestamps.get(timestamps.size()-1)));

            System.out.println("time before clicking visit type: " + timeBeforeClickingVisitType);
            driver.findElement(visitType).click();
            waitUntilVisibilityOfElement(10, visitTypeList);
            if (driver.findElement(visitTypeList).isDisplayed()) {
                long visitTypeListTimestamp = System.currentTimeMillis();
                visitTypeListLoadTime = visitTypeListTimestamp - timeBeforeClickingVisitType;

                addToList("Loading visit type list", visitTypeListTimestamp, visitTypeListLoadTime);

                System.out.println("visit type load timestamp: " + visitTypeListTimestamp);
                System.out.println("visit type load time: " + (visitTypeListLoadTime));
                driver.findElement(visitTypeListItem).click();
            }

            long timeBeforeClickingComplaint = System.currentTimeMillis();
            addToList("Time before clicking complaint", timeBeforeClickingComplaint, (timeBeforeClickingComplaint-timestamps.get(timestamps.size()-1)));

            System.out.println("time before clicking complaint: " + timeBeforeClickingComplaint);
            driver.findElement(complaint).click();
            waitUntilVisibilityOfElement(10, complaintList);

            if (driver.findElement(complaintList).isDisplayed()) {
                long complaintListTimestamp = System.currentTimeMillis();
                complaintListLoadTime = complaintListTimestamp - timeBeforeClickingComplaint;

                addToList("Loading complaint list", complaintListTimestamp, complaintListLoadTime);

                System.out.println("complaint list load timestamp: " + complaintListTimestamp);
                System.out.println("complaint list load time: " + (complaintListLoadTime));
                driver.findElement(complaintListItem).click();
            }
        }
    }

    public void getBuildTabLoadTime() {
        long timeBeforeClickingBuildTab = System.currentTimeMillis();

        addToList("Time before clicking build tab", timeBeforeClickingBuildTab, (timeBeforeClickingBuildTab - timestamps.get(timestamps.size()-1)));
        System.out.println("time before clicking build tab: " + timeBeforeClickingBuildTab);

        driver.findElement(buildTabButton).click();

        waitUntilVisibilityOfElement(20, buildTabSection);
        waitUntilVisibilityOfElement(20, accompaniedByOptions);
        waitUntilVisibilityOfElement(20, selectedComplaints);

        WebElement buildTabSections = driver.findElement(buildTabSection);
        WebElement acOptions = driver.findElement(accompaniedByOptions);
        WebElement selComplaints = driver.findElement(selectedComplaints);

        if (buildTabSections.isDisplayed() && acOptions.isDisplayed() && selComplaints.isDisplayed()) {
            long buildTabTimestamp = System.currentTimeMillis();
            buildTabLoadTime = buildTabTimestamp - timeBeforeClickingBuildTab;

            addToList("Loading Build tab", buildTabTimestamp, buildTabLoadTime);

            System.out.println("Build tab load timestamp: " + buildTabTimestamp);
            System.out.println("Build tab load time: " + (buildTabLoadTime));
        }
    }

    public void getMedicationListLoadTime() {
        long timeBeforeClickingMedication = System.currentTimeMillis();
        addToList("Time before clicking medication", timeBeforeClickingMedication, (timeBeforeClickingMedication - timestamps.get(timestamps.size()-1)));

        System.out.println("time before clicking medication: " + timeBeforeClickingMedication);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(medicationText).click();
        driver.findElement(medicationInputField).sendKeys("a");

        waitUntilVisibilityOfElement(15, medicationList);

        if (driver.findElement(medicationList).isDisplayed()) {
            long medicationListTimestamp = System.currentTimeMillis();
            medicationListLoadTime = medicationListTimestamp - timeBeforeClickingMedication;

            addToList("Loading medication list", medicationListTimestamp, medicationListLoadTime);

            System.out.println("medication list loading timestamp: " + medicationListTimestamp);
            System.out.println("medication list load time: " + (medicationListLoadTime));
        }
    }

    public void getPETabLoadTime() {
        long timeBeforeClickingPETab = System.currentTimeMillis();
        addToList("Time before clicking PE tab", timeBeforeClickingPETab, (timeBeforeClickingPETab - timestamps.get(timestamps.size()-1)));
        System.out.println("time Before Clicking PE Tab: " + timeBeforeClickingPETab);

        driver.findElement(peTab).click();

        waitUntilVisibilityOfElement(15, peSection);

        if (driver.findElement(peSection).isDisplayed()) {
            long peTabTimestamp = System.currentTimeMillis();
            peTabLoadTime = peTabTimestamp - timeBeforeClickingPETab;

            addToList("Loading PE Tab", peTabTimestamp, peTabLoadTime);
            System.out.println("pe tab timestamp: " + peTabTimestamp);
            System.out.println("pe tab load time: " + (peTabLoadTime));
        }
    }

    public void getAPTabLoadTime() {
        long timeBeforeClickingAPTab = System.currentTimeMillis();
        addToList("Time before clicking A/P tab", timeBeforeClickingAPTab, (timeBeforeClickingAPTab - timestamps.get(timestamps.size()-1)));
        System.out.println("time Before Clicking AP Tab: " + timeBeforeClickingAPTab);

        driver.findElement(apTab).click();

        waitUntilVisibilityOfElement(15, apSection);

        if (driver.findElement(apSection).isDisplayed()) {
            long apTabTimestamp = System.currentTimeMillis();
            apTabLoadTime = apTabTimestamp - timeBeforeClickingAPTab;

            addToList("Loading A/P Tab", apTabTimestamp, apTabLoadTime);

            System.out.println("ap tab timestamp: " + apTabTimestamp);
            System.out.println("ap tab load time: " + (apTabLoadTime));
        }
    }

    public void getAPMedicationListLoadTime() {
        long timeBeforeClickingMedication = System.currentTimeMillis();
        addToList("Time before clicking medication(A/P)", timeBeforeClickingMedication, (timeBeforeClickingMedication - timestamps.get(timestamps.size()-1)));
        System.out.println("time before clicking medication(A/P): " + timeBeforeClickingMedication);

        driver.findElement(apMedicationText).click();
        driver.findElement(apMedicationInputField).sendKeys("a");
        waitUntilVisibilityOfElement(15, apMedicationList);

        if (driver.findElement(apMedicationList).isDisplayed()) {
            long apMedicationTimestamp = System.currentTimeMillis();
            apMedicationLoadTime = apMedicationTimestamp - timeBeforeClickingMedication;

            addToList("Loading A/P Tab medication list", apMedicationTimestamp, apMedicationLoadTime);

            System.out.println("medication list loading timestamp: " + apMedicationLoadTime);
            System.out.println("medication list load time: " + (apMedicationLoadTime - timeBeforeClickingMedication));
        }
    }

    public void getReviewTabLoadTime() {
        long timeBeforeClickingReviewTab = System.currentTimeMillis();
        addToList("Time before clicking Review tab", timeBeforeClickingReviewTab, (timeBeforeClickingReviewTab - timestamps.get(timestamps.size()-1)));
        System.out.println("time Before Clicking Review Tab: " + timeBeforeClickingReviewTab);
        long reviewModalTimestamp;
        long reviewTextEditorTimestamp;

        driver.findElement(reviewTab).click();

        waitUntilVisibilityOfElement(10, reviewModal);

        if (driver.findElement(reviewModal).isDisplayed()) {
            reviewModalTimestamp = System.currentTimeMillis();
            System.out.println("review Modal Timestamp: "+ reviewModalTimestamp);
            reviewModalLoadTime = reviewModalTimestamp - timeBeforeClickingReviewTab;

            addToList("Review Modal Load Time", reviewModalTimestamp, reviewModalLoadTime);
            System.out.println("review Modal Load Time: " + reviewModalLoadTime);
            driver.findElement(reviewModalYesBtn).click();

            waitUntilVisibilityOfElement(15, reviewTextEditor);

            if (driver.findElement(reviewTextEditor).isDisplayed()) {
                reviewTextEditorTimestamp = System.currentTimeMillis();
                System.out.println("review Text Editor Timestamp: " + reviewTextEditorTimestamp);
                reviewTextEditorLoadTime = reviewTextEditorTimestamp - reviewModalTimestamp;

                addToList("Review Text Editor Load Time", reviewTextEditorTimestamp, reviewTextEditorLoadTime);
                System.out.println("review Text Editor Load Time: " + reviewTextEditorLoadTime);
            }
        }
    }

}
