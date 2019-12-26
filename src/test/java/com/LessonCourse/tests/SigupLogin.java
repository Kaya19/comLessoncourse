package com.LessonCourse.tests;

import Common.Driver;
import Common.TestBase;
import Pages.SignupLoginPage;
import Utils.SeleniumUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SigupLogin  extends TestBase {

    SeleniumUtil su = new SeleniumUtil();
    SignupLoginPage slp = new SignupLoginPage();

    @Test(groups = {"All","Smoke","Regression"})
    public void YK001() throws IOException, InterruptedException {
        su.goToPage("ykmainurl");
        slp.clikOnSignUp();
        Assert.assertEquals(su.getUrl(), Driver.getProp("yksignupurl"));
    }

    @Test(groups = {"All","Smoke"})
    public void YK002() throws IOException, InterruptedException {
        su.goToPage("yksignupurl");
        By[] signUpElements = slp.signUpElements();
        for (By i : signUpElements) {
            Assert.assertTrue(su.isDisplayed(i));

        }
    }

    @Test(groups = {"All","Smoke","Regression"})
    public void YK003() throws IOException, InterruptedException {
        su.goToPage("yksignupurl");
        Assert.assertTrue(su.isClickable(slp.getSignUpCheckBox(), 2000));
        su.click(slp.getSignUpCheckBox());
        su.getThread(2000);
        //System.out.println(su.getAttribute(slp.getSignUpCheckBox(),"aria-checked"));
        Assert.assertEquals(su.getAttribute(slp.getSignUpCheckBox(), "aria-checked"), "true");
    }

    @Test(groups = {"All","Regression"})
    public void YK004() throws IOException, InterruptedException {
        su.goToPage("yksignupurl");
        By[] signUpElements = slp.signUpElements();
        for (By i : signUpElements) {
            su.click(i);
            su.getThread(2000);
            su.click(slp.getEmptyClick());
            if (i == slp.getFullName())
                Assert.assertTrue(su.isDisplayed(slp.getFullNameError()));
            if (i == slp.getEmail())
                Assert.assertTrue(su.isDisplayed(slp.getEmailError()));
            if (i == slp.getPassword())
                Assert.assertTrue(su.isDisplayed(slp.getPasswordError()));
            su.getThread(1000);
        }
    }
    @Test(groups = {"All","Regression"})
    public void YK005() throws IOException {
        su.goToPage("yksignupurl");
        su.sendKeys(slp.getFullName(),Driver.getProp("ykfullnamesample"));
        //System.out.println(su.isPresent(slp.getFullNameError()));
        Assert.assertFalse(su.isPresent(slp.getFullNameError()));

    }
    @Test(groups = {"All"})
    public void YK006() throws IOException, InterruptedException {
        su.goToPage("yksignupurl");
        su.sendKeys(slp.getEmail(),Driver.getProp("no@Email"));
        su.click(slp.getEmptyClick());
        su.getThread(1000);
        Assert.assertTrue(su.isPresent(slp.getEmailError()));
        su.clear(slp.getEmail());
        su.refreshPage();
/*
        su.sendKeys(slp.getEmail(),Driver.getProp("multiple@email"));
        su.click(slp.getEmptyClick());
        su.getThread(1000);
        Assert.assertTrue(su.isPresent(slp.getEmailError()));
        su.clear(slp.getEmail());
        su.refreshPage();
*/
        su.sendKeys(slp.getEmail(),Driver.getProp("positiveEmail"));
        su.click(slp.getEmptyClick());
        su.getThread(1000);
        Assert.assertFalse(su.isPresent(slp.getEmailError()));
        //System.out.println(su.isPresent(slp.getEmailError()));
        su.clear(slp.getEmail());
        su.refreshPage();

    }
    @Test
    public void YK006_1() throws IOException, InterruptedException {
        String[] emails = new String[3];
        emails[0] = Driver.getProp("no@Email");
        emails[1] = Driver.getProp("multiple@email");
        emails[2] = Driver.getProp("positiveEmail");
        su.goToPage("yksignupurl");
        for (int i = 0; i < 3; i++) {
            su.sendKeys(slp.getEmail(), emails[i]);
            su.click(slp.getEmptyClick());
            su.getThread(1000);
            if (i == 2)
                Assert.assertFalse(su.isPresent(slp.getEmailError()));
            Assert.assertTrue(su.isPresent(slp.getEmailError()));
            su.clear(slp.getEmail());
            su.refreshPage();
        }
    }
    @Test(groups = {"All","Smoke"})
    public void YK007() throws IOException, InterruptedException {
        String[] emails = new String[4];
        emails[0] = Driver.getProp("test1");
        emails[1] = Driver.getProp("test2");
        emails[2] = Driver.getProp("test3");
       // emails[3] = Driver.getProp("positiveEmail");
        su.goToPage("yksignupurl");
        for (int i = 0; i < 3; i++) {
            su.sendKeys(slp.getEmail(),emails[i]);
            su.click(slp.getEmptyClick());
            su.getThread(1000);
            if (i == 3) {
                System.out.println(su.isPresent(slp.getEmailError()));
                Assert.assertFalse(su.isPresent(slp.getEmailError()));
            }
            Assert.assertTrue(su.isPresent(slp.getEmailError()));
            su.refreshPage();
        }
        }


    }
