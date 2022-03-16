package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Junit4Page {

    public SelenideElement switchBranchesButton() {
        return $(".btn.css-truncate").as("кнопка выбора ветки");
    }

    public ElementsCollection availableBranchesList() {
        return $$("a.SelectMenu-item span");
    }

    public SelenideElement currentBranch() {
        return $("#branch-select-menu .css-truncate-target");
    }

    public SelenideElement releasesLink() {
        return $("[data-pjax='#repo-content-pjax-container'] .Link--primary");
    }
}
