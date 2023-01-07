package ru.netology.web.test;


import org.junit.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTransferTest {


    @Test
    void shouldTransferFromFirstToSecond() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = LoginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCode();
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var firstCardInfo = getFirstCardInfo();
        var secondCardInfo = getSecondCardInfo();
        var firstCardBalance = dashboardPage.getCardBalance(firstCardInfo);
        var secondCardBalance = dashboardPage.getCardBalance(secondCardInfo);
        var amount = generateValidAmount(firstCardBalance);
        var expectedBalanceFirstCard = firstCardBalance - amount;
        var expectedBalanceSecondCard = secondCardBalance + amount;
        var transferPage = dashboardPage.selectCardToTransfer(secondCardInfo);
        dashboardPage = transferPage.makeValidTransfer(String.valueOf(amount), firstCardInfo);
        var actualBalanceFirstCard = dashboardPage.getCardBalance(firstCardInfo);
        var actualBalanceSecondCard = dashboardPage.getCardBalance(secondCardInfo);
        assertEquals(expectedBalanceFirstCard, actualBalanceFirstCard);
        assertEquals(expectedBalanceSecondCard, actualBalanceSecondCard);


    }

    private void getFirstCardInfo() {
    }

    @Test
        void shouldGetErrorMessageIfAmountMoreBalance() {
            var loginPage = open("http://localhost:9999", loginPage.class);
            var authInfo = DataHelper.getAuthInfo();
            var verificationPage = loginPage.validLogin(authInfo);
            var verificationCode = DataHelper.getVerificationCode();
            var dashboardPage = verificationPage.validVerify(verificationCode);
            var firstCardInfo = getFirstCardInfo();
            var secondCardInfo = getSecondCardInfo();
            var firstCardBalance = dashboardPage.getCardBalance(firstCardInfo);
            var secondCardBalance = dashboardPage.getCardBalance(secondCardInfo);
            var amount = generateInvalidAmount(secondCardBalance);
            var expectedBalanceFirstCard = firstCardBalance - amount;
            var expectedBalanceSecondCard = secondCardBalance + amount;
            var transferPage = dashboardPage.selectCardToTransfer(firstCardInfo);
            transferPage.makeTransfer(String.valueOf(amount), secondCardInfo);
            trancferPage.findErrorMessage("Выполнена попытка перевода суммы, превышающий остаток на карте списания");
            var actualBalanceFirstCard = dashboardPage.getCardBalance(firstCardInfo);
            var actualBalanceSecondCard = dashboardPage.getCardBalance(secondCardInfo);
            assertEquals(firstCardBalance, actualBalanceFirstCard);
            assertEquals(secondCardBalance, actualBalanceSecondCard);




        }

}
