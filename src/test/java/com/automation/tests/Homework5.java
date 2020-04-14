package com.automation.tests;

import com.automation.pages.CalendarEventsPage;
import com.automation.pages.LoginPage;
import com.automation.utilities.DateTimeUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework5 extends AbstractTestBase {


    @Test
   public void testCase1() {
        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.hoverOverThreeDots();

        Assert.assertTrue(calendarEventsPage.getViewOption().isDisplayed());
        Assert.assertTrue(calendarEventsPage.getEditOption().isDisplayed());
        Assert.assertTrue(calendarEventsPage.getDeleteOption().isDisplayed());

   }

   @Test
   public void testCase2(){

       test=report.createTest("Verify title column is displayed");

       LoginPage loginPage=new LoginPage();
       CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

       loginPage.login();
       calendarEventsPage.navigateTo("Activities","Calendar Events");
       calendarEventsPage.clickGridBtn();
       calendarEventsPage.getCheckBoxElement("Calendar").click();
       calendarEventsPage.getCheckBoxElement("Start").click();
       calendarEventsPage.getCheckBoxElement("End").click();
       calendarEventsPage.getCheckBoxElement("Recurrent").click();
       calendarEventsPage.getCheckBoxElement("Recurrence").click();
       calendarEventsPage.getCheckBoxElement("Invitation status").click();

       Assert.assertTrue(calendarEventsPage.getTitle().isDisplayed());

       test.pass("Title column is verified");

   }

   @Test
   public void testCase3(){

       test=report.createTest("Verify save and close options are displayed");

       LoginPage loginPage=new LoginPage();
       CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

       loginPage.login();
       calendarEventsPage.navigateTo("Activities","Calendar Events");
       calendarEventsPage.clickCreateCalendarEventBtn();
       calendarEventsPage.clickExpansion();

       Assert.assertTrue(calendarEventsPage.getSaveAndCloseMenu().isDisplayed());
       Assert.assertTrue(calendarEventsPage.getSaveAndNewMenu().isDisplayed());
       Assert.assertTrue(calendarEventsPage.getSaveMenu().isDisplayed());

       test.pass("Options are displayed successfully");

   }

    @Test
    public void testCase4(){

        test=report.createTest("Verify All Calendar Events title");

        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.clickCreateCalendarEventBtn();
        calendarEventsPage.clickCancelBtn();

        Assert.assertEquals(calendarEventsPage.getAllCalendarEventsTitle(), "All Calendar Events");

        test.pass("All Calendar Events title is displayed successfully");

    }

    @Test
    public void testCase5(){

        test=report.createTest("Verify that difference between end and start time is 1 hour");

        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.clickCreateCalendarEventBtn();

        String startTime=calendarEventsPage.getStartTimeValue();
        String endTime=calendarEventsPage.getEndTimeValue();

        Assert.assertEquals(DateTimeUtilities.getTimeDifference(startTime, endTime, "h:m a"),1);

        test.pass("1 hour time difference is verified");
    }

    @Test
    public void testCase6(){

        test=report.createTest("Verify that end time is 10:00 PM");

        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.clickCreateCalendarEventBtn();
        calendarEventsPage.setStartTime("9:00 PM");
        String endTime=calendarEventsPage.getEndTimeValue();
        Assert.assertEquals(endTime,"10:00 PM");

        test.pass("End time 10:00 PM is verified");
    }

    @Test
    public void testCase7(){

        //dont forget to disable wait for getStartTime and getEndTime
        test=report.createTest("Verify input boxes");

        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.clickCreateCalendarEventBtn();
        calendarEventsPage.clickAllDayEventChkBox();

        Assert.assertFalse(calendarEventsPage.getStartTime().isDisplayed());
        Assert.assertFalse(calendarEventsPage.getEndTime().isDisplayed());
        Assert.assertTrue(calendarEventsPage.getStartDate().isDisplayed());
        Assert.assertTrue(calendarEventsPage.getEndDate().isDisplayed());

        test.pass("Input boxes are verified");
    }

    @Test
    public void testCase8(){

        test=report.createTest("Verify repeat dropdown");

        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.clickCreateCalendarEventBtn();
        calendarEventsPage.clickRepeatCheckbox();
        Assert.assertEquals(calendarEventsPage.getDefaultForRepeatsDropdown(),"Daily");

        calendarEventsPage.setRepeatsDropdown("weekly");
        Assert.assertEquals(calendarEventsPage.getDefaultForRepeatsDropdown(),"Weekly");
        calendarEventsPage.setRepeatsDropdown("monthly");
        Assert.assertEquals(calendarEventsPage.getDefaultForRepeatsDropdown(),"Monthly");
        calendarEventsPage.setRepeatsDropdown("yearly");
        Assert.assertEquals(calendarEventsPage.getDefaultForRepeatsDropdown(),"Yearly");

        test.pass("Repeat dropdown is verified");
    }

    @Test
    public void testCase9(){


        test=report.createTest("Verify summary message");

        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.clickCreateCalendarEventBtn();
        calendarEventsPage.clickRepeatCheckbox();
        Assert.assertTrue(calendarEventsPage.getRepeatCheckBox().isSelected());
        Assert.assertTrue(calendarEventsPage.getRepeatEveryRadioBtn().isSelected());
        Assert.assertTrue(calendarEventsPage.getNeverRadioBtn().isSelected());
        String expectedMessage="Summary: Daily every 1 day";
        String actualMessage=calendarEventsPage.getSummaryMessageFor2Parts();

        Assert.assertEquals(actualMessage,expectedMessage);


        test.pass("Message is verified");
    }

    @Test
    public void testCase10(){

        test=report.createTest("Verify summary message");

        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.clickCreateCalendarEventBtn();
        calendarEventsPage.clickRepeatCheckbox();
        calendarEventsPage.clickAfterRadioBtn();
        calendarEventsPage.setAfterInputBox("10");
        String expected="Summary: Daily every 1 day, end after 10 occurrences";
        String actual=calendarEventsPage.getSummaryMessageFor3Parts();

        Assert.assertEquals(expected,actual);

        test.pass("Message is verified");
    }

    @Test
    public void testCase11(){

        test=report.createTest("Verify summary message");

        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.clickCreateCalendarEventBtn();
        calendarEventsPage.clickRepeatCheckbox();
        calendarEventsPage.clickByRadioBtn();
        calendarEventsPage.clickByDate();
        calendarEventsPage.setByDate("2021","10","18");

        String expected="Summary: Daily every 1 day, end by Nov 18, 2021";
        String actual=calendarEventsPage.getSummaryMessageFor3Parts();

        Assert.assertEquals(actual,expected);

        test.pass("Message is verified");
    }

    @Test
    public void testCase12(){

        test=report.createTest("Verify summary message");

        LoginPage loginPage=new LoginPage();
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        loginPage.login();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.clickCreateCalendarEventBtn();
        calendarEventsPage.clickRepeatCheckbox();
        calendarEventsPage.setRepeatsDropdown("weekly");
        calendarEventsPage.setRepeatOnCheckboxes("monday");
        calendarEventsPage.setRepeatOnCheckboxes("friday");
        Assert.assertTrue(calendarEventsPage.getRepeatOnCheckboxes("monday").isSelected());
        Assert.assertTrue(calendarEventsPage.getRepeatOnCheckboxes("friday").isSelected());

        String expected="Summary: Weekly every 1 week on Monday, Friday";
        String actual=calendarEventsPage.getSummaryMessageFor2Parts();

        Assert.assertEquals(actual,expected);

        test.pass("Message is verified");
    }

}
