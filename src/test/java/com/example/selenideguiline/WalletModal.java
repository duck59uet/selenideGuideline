package com.example.selenideguiline;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WalletModal {

    public SelenideElement getInputGroup() {
        return $(".input-group");
    }

}
