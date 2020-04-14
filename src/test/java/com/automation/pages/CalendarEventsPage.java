package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CalendarEventsPage extends AbstractPageBase {


    @FindBy(xpath = "//td[text()='Testers Meeting']//..//td[@class='action-cell grid-cell grid-body-cell']")
    private WebElement threeDots;

    @FindBy(xpath = "//li[@class='launcher-item']//a[@title='View']")
    private WebElement viewOption;

    @FindBy(xpath = "//li[@class='launcher-item']//a[@title='Edit']")
    private WebElement editOption;

    @FindBy(xpath = "//li[@class='launcher-item']//a[@title='Delete']")
    private WebElement deleteOption;

    @FindBy(xpath = "//a[@title='Grid Settings']")
    private WebElement gridBtn;

    @FindBy(xpath = "//thead[@class='grid-header']//span[@class='grid-header-cell__label']")
    private WebElement title;

    @FindBy(css = "[class='btn main-group btn-primary pull-right ']")
    private WebElement createCalendarEventBtn;

    @FindBy(xpath = "//a[@class='btn-success btn dropdown-toggle']")
    private WebElement saveAndCloseExpansion;

    @FindBy(xpath = "//ul//button[contains(text(),'Save and Close')]")
    private WebElement saveAndCloseMenu;

    @FindBy(xpath = "//ul//button[contains(text(),'Save and New')]")
    private WebElement saveAndNewMenu;

    @FindBy(xpath = "(//ul//button[contains(text(),'Save')])[3]")
    private WebElement saveMenu;

    @FindBy(css = "[class='btn back icons-holder-text ']")
    private WebElement cancelBtn;

    @FindBy(css = "[class='oro-subtitle']")
    private WebElement allCalendarEventsTitle;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start-uid']")
    private WebElement startTime;

    @FindBy(className="ui-timepicker-list")
    private WebElement startTimeDropdown;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end-uid']")
    private WebElement endTime;

    @FindBy(css = "[id^='oro_calendar_event_form_allDay-uid']")
    private WebElement allDayEventCheckbox;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start-uid']")
    private WebElement startDate;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_end-uid']")
    private WebElement endDate;

    @FindBy(css = "[id^='recurrence-repeat-view']")
    private WebElement repeatCheckBox;

    @FindBy(css = "select[id^='recurrence-repeats-view']")
    private WebElement repeatsDropdown;

    @FindBy(xpath = "//div[@class='controls recurrence-subview-control__items']//label[@class='fields-row']/input[1]")
    private WebElement repeatEveryRadioBtn;

    @FindBy(xpath = "//div[@class='controls recurrence-subview-control recurrence-subview-control__items']/div[1]//input[1]")
    private WebElement neverRadioBtn;

    @FindBy(xpath = "//div[@class='control-group recurrence-summary alert-info']//label")
    private WebElement summaryMessagePart1;

    @FindBy(xpath = "//div[@data-name='recurrence-summary']//span")
    private WebElement summaryMessagePart2;

    @FindBy(xpath = "(//div[@data-name='recurrence-summary']//span)[2]")
    private WebElement summaryMessagePart3;

    @FindBy(xpath = "(//div[@class='recurrence-subview-control__item']//label[@class='fields-row']//input[@type='radio'])[2]")
    private WebElement afterRadioBtn;

    @FindBy(xpath = "(//div[@class='recurrence-subview-control__item']//label[@class='fields-row']//input[@type='text'])[2]")
    private WebElement afterInputBox;

    @FindBy(xpath = "//div[@class='recurrence-subview-control__item recurrence-subview-control__item-datetime']//input[@type='radio']")
    private WebElement byRadioBtn;

    @FindBy(xpath = "//span[@class='recurrence-subview-control__datetime-wrapper']//input[@placeholder=\"Choose a date\"]")
    private WebElement dateBy;

    @FindBy(xpath = "//div[@class='ui-datepicker-title']//select[@class='ui-datepicker-month']")
    private WebElement monthDropdown;

    @FindBy(xpath = "//div[@class='ui-datepicker-title']//select[@class='ui-datepicker-year']")
    private WebElement yearDropdown;

    @FindBy(css = "[class='multi-checkbox-control']")
    private WebElement repeatOnCheckboxes;






    public void hoverOverThreeDots(){
        Actions actions=new Actions(driver);
        actions.moveToElement(threeDots).pause(2000).perform();
        BrowserUtils.wait(3);
    }

    public WebElement getViewOption(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(viewOption));
        return viewOption;
    }

    public WebElement getEditOption(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(editOption));
        return editOption;
    }

    public WebElement getDeleteOption(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(deleteOption));
        return deleteOption;
    }

    public void clickGridBtn(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(gridBtn)).click();
    }

    public WebElement getCheckBoxElement(String name){
        String xpath="//td[@class='title-cell']//label[text()='"+name+"']//..//following-sibling::td[@class='visibility-cell']//input";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement getTitle(){
        BrowserUtils.waitForPageToLoad(10);
        return title;
    }

    public void clickCreateCalendarEventBtn(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(createCalendarEventBtn)).click();
        BrowserUtils.wait(3);
    }

    public void clickExpansion(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(saveAndCloseExpansion)).click();
    }

    public WebElement getSaveAndCloseMenu(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(saveAndCloseMenu));
        return saveAndCloseMenu;
    }
    public WebElement getSaveAndNewMenu(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(saveAndNewMenu));
        return saveAndNewMenu;
    }

    public WebElement getSaveMenu(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(saveMenu));
        return saveMenu;
    }

    public void clickCancelBtn(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(cancelBtn)).click();
        BrowserUtils.wait(3);
    }

    public String getAllCalendarEventsTitle(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(allCalendarEventsTitle));
        return allCalendarEventsTitle.getText();
    }

    public String getStartTimeValue(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(startTime));
        return startTime.getAttribute("value");
    }

    public String getEndTimeValue(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(endTime));
        return endTime.getAttribute("value");
    }

    public String getStartDateValue(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(startDate));
        return startDate.getAttribute("value");
    }

    public String getEndDateValue(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(endDate));
        return endDate.getAttribute("value");
    }

    public void setStartTime(String time){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(startTime));
        startTime.click();
        String xpath="//li[@class='ui-timepicker-pm' and contains(text(), '"+time+"')]";
        driver.findElement(By.xpath(xpath)).click();
        BrowserUtils.wait(3);
    }

    public void clickAllDayEventChkBox(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(allDayEventCheckbox)).click();
        BrowserUtils.wait(3);
    }


    public WebElement getStartTime(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(startTime));
        return startTime;
    }

    public WebElement getEndTime(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(endTime));
        return endTime;
    }

    public WebElement getStartDate(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(startDate));
        return startDate;
    }

    public WebElement getEndDate(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(endDate));
        return endDate;
    }

    public void clickRepeatCheckbox(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(repeatCheckBox)).click();
        BrowserUtils.wait(3);
    }

    public void clickRepeatsDropdown(){
        BrowserUtils.waitForPageToLoad(10);
        //wait.until(ExpectedConditions.elementToBeClickable(repeatsDropdown));
        repeatsDropdown.click();
    }

    public String getRepeatsDropdown(){
        BrowserUtils.waitForPageToLoad(10);
        //wait.until(ExpectedConditions.elementToBeClickable(repeatsDropdown));
        return repeatsDropdown.getText();
    }

    public String getDefaultForRepeatsDropdown(){
        BrowserUtils.waitForPageToLoad(10);
        //wait.until(ExpectedConditions.elementToBeClickable(repeatsDropdown));
        Select select=new Select(repeatsDropdown);
         return select.getFirstSelectedOption().getText();

    }

    public void setRepeatsDropdown(String recurrence){
        BrowserUtils.waitForPageToLoad(10);
        //wait.until(ExpectedConditions.elementToBeClickable(repeatsDropdown));
        Select select=new Select(repeatsDropdown);
        select.selectByValue(recurrence);
        BrowserUtils.wait(3);
    }

    public void setRepeatOnCheckboxes(String day){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(repeatOnCheckboxes));
        String xpath="//label[@class='multi-checkbox-control__item']//input[@value='"+day+"']";
        driver.findElement(By.xpath(xpath)).click();
    }

    public WebElement getRepeatOnCheckboxes(String day){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(repeatOnCheckboxes));
        String xpath="//label[@class='multi-checkbox-control__item']//input[@value='"+day+"']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement getRepeatCheckBox(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(repeatCheckBox));
        return repeatCheckBox;
    }

    public WebElement getRepeatEveryRadioBtn(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(repeatEveryRadioBtn));
        return repeatEveryRadioBtn;
    }

    public WebElement getNeverRadioBtn(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(neverRadioBtn));
        return neverRadioBtn;
    }

    public String getSummaryMessageFor2Parts(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(summaryMessagePart1));
        wait.until(ExpectedConditions.visibilityOf(summaryMessagePart2));
        return summaryMessagePart1.getText()+" "+summaryMessagePart2.getText();
    }
    public String getSummaryMessageFor3Parts(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(summaryMessagePart1));
        wait.until(ExpectedConditions.visibilityOf(summaryMessagePart2));
        return summaryMessagePart1.getText()+" "+summaryMessagePart2.getText()+summaryMessagePart3.getText();
    }


    public void clickAfterRadioBtn(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(afterRadioBtn)).click();
        BrowserUtils.wait(3);
    }

    public void setAfterInputBox(String occurences){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(afterInputBox));
        afterInputBox.sendKeys(occurences,Keys.ENTER);
        BrowserUtils.wait(5);
    }

    public void setByDate(String year, String month, String day){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(byRadioBtn));
        Select selectMonth=new Select(monthDropdown);
        selectMonth.selectByValue(month);
        Select selectYear=new Select(yearDropdown);
        selectYear.selectByValue(year);
        String xpathForDate="//td[@data-handler='selectDay']//a[text()='"+day+"']";
        driver.findElement(By.xpath(xpathForDate)).click();
        BrowserUtils.wait(5);

    }

    public void clickByRadioBtn(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(byRadioBtn)).click();
        BrowserUtils.wait(3);
    }

    public void clickByDate(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(dateBy)).click();
        BrowserUtils.wait(3);
    }






}
