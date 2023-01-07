package ru.netology.web.data;

package ru.netology.page;

import java.util.Random;

import lombok.Value;
import ru.netology.web.page.LoginPage;

public class DataHelper {

    private int DataHelper() {

        public static VerificationCode getVerificationCode () {
            return new VerificationCode("12345");
        }

        public static LoginPage.AuthInfo getAuthInfo () {
            return new LoginPage.AuthInfo("vasya", "qwerty123");
        }

        public static CardInfo getFirstCardInfo() {
            return new CardInfo("5559 0000 0000 0001", "92df3f1c-a033-48e6-8390-206f6b1f56c0");

        }
        public static CardInfo getSecondCardInfo() {
            return new CardInfo("5559 0000 0000 0002", "0f3f5c2a-249e-4c3d-09f7a039391d");
        }

        public static int generateValidAmount(int balance) {
            return new Random().nextInt(balance) + 1;
        }

        public static int generateInvalidAmount ( int balance){
            return.Math.abs(balance) + new Random().nextInt(100);
        }


        @Value
        class VerificationCode {
            String code;
        }
        @Value
        class CardInfo {
            String cardNumber;
            String testId;
        }

        @Value
        class AuthInfo {
            String login;
            String password;

        }
    }

    private static class VerificationCode {
    }
}

