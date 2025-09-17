<div align="center">

# 📒 ColorNote UI Tests (Android)

**Java · Appium (UiAutomator2) · TestNG · Page Object Model (POM)**  
Automated UI tests for **ColorNote Notepad Notes** covering core user flows: **create, edit, delete, and search**.

[![Java](https://img.shields.io/badge/Java-17%2B-orange)](#)
[![Maven](https://img.shields.io/badge/Maven-3.8%2B-red)](#)
[![Appium](https://img.shields.io/badge/Appium-2.x-6C5CE7)](#)
[![Android](https://img.shields.io/badge/Android-SDK%20%2F%20adb-brightgreen)](#)
[![TestNG](https://img.shields.io/badge/TestNG-7.x-blue)](#)

</div>

---

## ℹ️ About the Project
This project is an **automated UI test suite** for the **ColorNote Notepad Notes Android application**.  
It demonstrates how to test a real-world mobile app using:
- **Appium (UiAutomator2)** for Android automation
- **Java + TestNG** for test execution
- **Page Object Model (POM)** for clean, maintainable test code

The goal is to validate essential app functionalities such as creating, editing, deleting, and searching notes, ensuring the app behaves correctly under different scenarios.

---

## ✅ Prerequisites
- **Java 17+**, **Maven 3.8+**
- **Node.js 18+**, **Appium 2.x**
  ```bash
  npm i -g appium appium-doctor
Android SDK / Platform Tools (adb must be on PATH)

Android emulator or real device with USB debugging enabled

ColorNote installed (from Google Play Store)

Quick checks:

java -version
mvn -v
node -v
adb devices -l

🗂 Project Structure
colornote-ui-tests/
├─ pom.xml
├─ testng.xml
└─ src/test
   ├─ java/com/example/colornote
   │  ├─ base/   (DriverFactory, BaseTest)
   │  ├─ pages/  (BasePage, HomePage, TextNoteEditorPage, SearchPage)
   │  └─ tests/  (CreateEditDeleteNoteTests, SearchTests)
   └─ resources/config.properties

⚙️ Configuration

Create src/test/resources/config.properties:

appium.server=http://127.0.0.1:4723
platformName=Android
automationName=UiAutomator2
deviceName=emulator-5554
appPackage=com.socialnmobile.dictapps.notepad.color.note
appActivity=.Main
newCommandTimeout=120
noReset=true


Find the correct appActivity if needed:

adb shell cmd package resolve-activity -c android.intent.category.LAUNCHER com.socialnmobile.dictapps.notepad.color.note

🚀 Setup & Run

Start emulator or connect a device:

adb devices -l


Start Appium server:

appium --log-level debug


Run tests:

mvn clean test


📂 Reports will be generated in:

target/surefire-reports/

🧪 What’s Covered

📝 Create a note → verify it appears in the list

✏️ Edit a note → verify the updated text is saved

🗑️ Delete a note → verify it is removed from the list

🔎 Search note by title → verify it appears in results

