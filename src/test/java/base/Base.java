package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;


public class Base {
    public static WebDriver driver;
    public SoftAssertions soft = new SoftAssertions();


    public static void navigate(String url) {
        driver.get(url);
    }

    public static void click( By locator  ) {
        driver.findElement( locator ).click();
    }

    public static void sendKeys(By locator, String keys) {
        driver.findElement( locator ).sendKeys(keys);
    }

    public static String getText(By locator) {
        String s = driver.findElement(locator).getText();
        return s;


    }
    public static void dropDownText(By locator,String text) {
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(text);
    }
    public static void dropDownIndex(By locator,int index) {
        Select select = new Select(driver.findElement(locator));
        select.selectByIndex(index);
    }
    public static void dropDownValue(By locator,String value){
        Select select =new Select(driver.findElement(locator));
        select.selectByValue(value);
    }
    public static void clear (By locator){
        driver.findElement(locator).clear();
    }
    public static void screenShotWithName(WebDriver driver, String name) throws IOException {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(source, new File(".\\src\\test\\resources\\Capture\\"+name+".png"));
        FileUtils.copyFile(source,new File("/C:\\Java\\workspaceIntelliJ\\myFrameworkNew\\screenShort\\"+name+" .png"));
            //FileUtils.copyFile(source,new File("C:\\Users\\Tania Chowdhury\\Downloads\\sereenShot\\capture\\"+name+".png"));
        }
    }


