package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    @FindBy(css = "[data-test-id=login] input")
    private static SelenideElement loginField;
    @FindBy(css = "data-test-id=password] input")
    private SelenideElement passwordField;
    @FindBy(css = "data-test-id=action-login]")
    private SelenideElement loginButton;

    public static VerificationPage validLogin(AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return page(VerificationPage.class);
    }

    public static class AuthInfo {
        public String getLogin() {
            return getLogin();
        }

        public String getPassword() {
            return getPassword();
        }
    }
}
