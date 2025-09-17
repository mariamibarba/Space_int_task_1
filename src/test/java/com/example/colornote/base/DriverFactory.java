package com.example.colornote.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class DriverFactory {
    private static AndroidDriver driver;
    private static final Properties props = new Properties();

    private static void loadPropsOnce() {
        if (!props.isEmpty()) return;
        // Load from classpath so it works in Maven/TestNG/IDE
        try (InputStream in = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("config.properties")) {
            if (in == null) {
                throw new RuntimeException("config.properties not found on classpath (expected in src/test/resources)");
            }
            props.load(in);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static AndroidDriver getDriver() {
        if (driver != null) return driver;
        loadPropsOnce();

        try {
            String server = System.getProperty("appium.server", props.getProperty("appium.server", "http://127.0.0.1:4723"));

            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName(props.getProperty("platformName", "Android"))
                    .setAutomationName(props.getProperty("automationName", "uaiutomator2"))
                    .setDeviceName(System.getProperty("deviceName", props.getProperty("deviceName", "emulator-5554")))
                    .setAppPackage(props.getProperty("appPackage"))
                    .setAppActivity(props.getProperty("appActivity"))
                    .amend("newCommandTimeout", Integer.parseInt(props.getProperty("newCommandTimeout", "120")))
                    .setNoReset(true)
                    .setFullReset(false);

            driver = new AndroidDriver(new URL(server), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            return driver;
        } catch (Exception e) {
            throw new RuntimeException("Failed to start AndroidDriver", e);
        }
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
