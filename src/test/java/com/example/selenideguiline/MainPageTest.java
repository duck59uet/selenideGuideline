package com.example.selenideguiline;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    private static String mnemonic = "bless harvest huge empower join laundry toddler cheap glass crop deny anxiety";
    @BeforeAll
    public static void setUpAll() {
        // Setup extension
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:/Users/DucNV50/Downloads/extension_0_11_40_0.crx"));
        Configuration.browserCapabilities = options;

        Configuration.browser = "Chrome";
        Configuration.browserVersion = "109.0.5414.74";
        Configuration.pageLoadStrategy = "normal";
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.reportsFolder = "D:/AKC/selenide-guiline";
    }

    @BeforeEach
    public void setUpAccount() {
        open("chrome-extension://dmkamcknogkgcdfhhbddcghachkejeap/popup.html#/register");
        $(By.xpath("//button[text()='Import existing account']")).click();
        sleep(100);
        List<SelenideElement> passInputs = $$(By.xpath("//div[contains(@class, 'mnemonic-word-form-group')]//div[contains(@class, 'input-group')]//input[@type='password']"));

        String[] mnemonicArr = mnemonic.split(" ");
        for (int i = 0; i < passInputs.size(); i++) {
            passInputs.get(i).sendKeys(mnemonicArr[i]);
        }

        $(By.name("name")).sendKeys("TestAccount");

        $(By.xpath("//div[contains(@class, 'form-inner-container')]//input[@name='password']")).sendKeys("Test@123!");
        $(By.name("confirmPassword")).sendKeys("Test@123!");

        sleep(100);
        $(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    public void search() throws InterruptedException {
        open("https://serenity.aurascan.io/");
        $("app-wallet-connect").click();

        $(By.xpath("//li[@class='wallet-item']//span[contains(text(),'Keplr')]")).shouldBe(Condition.visible).click();

//        sleep(5000);
        switchTo().window("Keplr");
        $(By.xpath("//button[contains(text(), 'Approve')]")).wait(2000);
        $(By.xpath("//button[contains(text(), 'Approve')]")).click();
        sleep(1000);
        switchTo().window(0);
        screenshot("result");
    }

}

