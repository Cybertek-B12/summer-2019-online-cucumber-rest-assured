package com.bookit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyTeamPage extends BasePage {

    @FindBy(xpath = "//p[.='name']/../p[1]")
	public List<WebElement> allNames;

	@FindBy(xpath = "//p[.='role']/../p[1]")
	public List<WebElement> allRoles;


}
