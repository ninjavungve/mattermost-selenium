package com.mattermost.selenium.tests;

import com.mattermost.selenium.DriverBase;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class AccountSettingsDisplayIT extends DriverBase {

    @Test
    public void testAccountSettingsDisplayIT() throws Exception {        // Using test5@test.com to isolate display changes from test@ account in case of failure
        // LOG IN
        driver.get(baseUrl + "/login");
        // DisableAnimations
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("button.btn.btn-primary"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.name("loginId")).clear();
        driver.findElement(By.name("loginId")).sendKeys("test5@test.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("passwd");
        driver.findElement(By.id("loginButton")).click();
        // Sleep
        // Sleep
        // Sleep
        driver.findElement(By.id("sidebarHeaderDropdownButton")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#accountSettings > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#accountSettings > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("button:contains('Display')"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("button:contains('Display')")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Open to manage your theme".equals(driver.findElement(By.cssSelector("#ThemeDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("12-hour clock (example: 4:00 PM)".equals(driver.findElement(By.cssSelector("#Clock_DisplayDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Clock Display
        driver.findElement(By.cssSelector("#Clock_DisplayEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("clockFormat24h"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("clockFormat24h")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Select how you prefer time displayed.".equals(driver.findElement(By.xpath("//li/div/div[3]/span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Clock_DisplayCancel > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("12-hour clock (example: 4:00 PM)".equals(driver.findElement(By.cssSelector("#Clock_DisplayDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Clock_DisplayEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("clockFormat12h"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("clockFormat24h")).click();
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("24-hour clock (example: 16:00)".equals(driver.findElement(By.cssSelector("#Clock_DisplayDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#Clock_DisplayEdit > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Clock_DisplayEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("clockFormat12h"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("clockFormat12h")).click();
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("12-hour clock (example: 4:00 PM)".equals(driver.findElement(By.cssSelector("#Clock_DisplayDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Default appearance of image link previews
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Expanded".equals(driver.findElement(By.cssSelector("#Default_appearance_of_image_link_previewsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Default_appearance_of_image_link_previewsEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Set whether previews of image links show as expanded or collapsed by default. This setting can also be controlled using the slash commands /expand and /collapse.".equals(driver.findElement(By.xpath("//li/div/div[3]/span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("collapseFormatOff"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("collapseFormatOff")).click();
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Collapsed".equals(driver.findElement(By.cssSelector("#Default_appearance_of_image_link_previewsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Default_appearance_of_image_link_previewsEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("collapseFormat"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("collapseFormat")).click();
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Expanded".equals(driver.findElement(By.cssSelector("#Default_appearance_of_image_link_previewsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Message Display
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Standard".equals(driver.findElement(By.cssSelector("#Message_DisplayDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Message_DisplayEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Select how messages in a channel should be displayed.".equals(driver.findElement(By.xpath("//li/div/div[3]/span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("messageFormatCompact"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("messageFormatCompact")).click();
        driver.findElement(By.cssSelector("#Message_DisplayCancel > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Standard".equals(driver.findElement(By.cssSelector("#Message_DisplayDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Message_DisplayEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("messageFormatCompact"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("messageFormatCompact")).click();
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Expanded".equals(driver.findElement(By.cssSelector("#Default_appearance_of_image_link_previewsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Compact".equals(driver.findElement(By.cssSelector("#Message_DisplayDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Message_DisplayEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("messageFormatStandard"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("messageFormatStandard")).click();
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Standard".equals(driver.findElement(By.cssSelector("#Message_DisplayDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Channel Display Mode
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Full width".equals(driver.findElement(By.cssSelector("#Channel_Display_ModeDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Channel_Display_ModeEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("channelDisplayFormatCentered"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("channelDisplayFormatCentered")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Select the width of the center channel.".equals(driver.findElement(By.xpath("//li/div/div[3]/span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Channel_Display_ModeCancel > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Full width".equals(driver.findElement(By.cssSelector("#Channel_Display_ModeDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Channel_Display_ModeEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("channelDisplayFormatCentered"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("channelDisplayFormatCentered")).click();
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Fixed width, centered".equals(driver.findElement(By.cssSelector("#Channel_Display_ModeDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Channel_Display_ModeEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("channelDisplayFormatFullScreen"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("channelDisplayFormatFullScreen")).click();
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Full width".equals(driver.findElement(By.cssSelector("#Channel_Display_ModeDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Language covered in IDE-only test
        // LOG OUT
        driver.navigate().refresh();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("Town Square"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("sidebarHeaderDropdownButton")).click();
        driver.findElement(By.cssSelector("#logout > span")).click();
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.name("loginId"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

    }
}
