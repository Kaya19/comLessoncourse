package Pages;

import Common.PageBase;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

public class SignupLoginPage extends PageBase {

    private By mainPageSignupButton=By.id("btn-signup");

    public void clikOnSignUp(){
        su.click(mainPageSignupButton);

    }
    private By fullName=By.name("fullname");
    private By email=By.name("em");
    private By password=By.name("password");
    private By checkBox=By.name("terms");
    //private By signUpCheckBox=By.xpath("//div[@class='md-container md-ink-ripple']");
    public By getFullName() {
        return fullName;
    }
    public By getEmail() {
        return email;
    }
    public By getPassword() {
        return password;
    }
    public By getSignUpCheckBox() {
        return checkBox;
    }


    public By []signUpElements() throws IOException {
        By [] signUpElements=new By[3];
        signUpElements[0]=fullName;
        signUpElements[1]=email;
        signUpElements[2]=password;
        return signUpElements;
    }
    private By fullNameError=By.xpath("//*[@id='register-form']/div[2]/form/md-input-container[1]/div[2]/div");
    private By emailError=By.xpath("//*[@id='register-form']/div[2]/form/md-input-container[2]/div[2]/div");
    private By passwordError=By.xpath("//*[@id='register-form']/div[2]/form/md-input-container[3]/div[2]/div");

    public By getFullNameError() {
        return fullNameError;
    }
    public By getEmailError() {
        return emailError;
    }
    public By getPasswordError() {
        return passwordError;
    }

    public By getEmptyClick() {
        return emptyClick;
    }

    private By emptyClick=By.xpath("//body");

    }











