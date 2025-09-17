ColorNote UI Tests (Android)

Java · Appium (UiAutomator2) · TestNG · Page Object Model (POM)

Automated UI tests for ColorNote Notepad Notes covering create, edit, delete, and search flows.

Prerequisites

Java 17+, Maven 3.8+

Node.js 18+, Appium 2.x (npm i -g appium appium-doctor)

Android SDK / Platform Tools (adb on PATH)

Android emulator/real device with USB debugging

ColorNote installed on device (from Play Store)

Project Structure
colornote-ui-tests/
├─ pom.xml
├─ testng.xml
└─ src/test
   ├─ java/com/example/colornote
   │  ├─ base/ (DriverFactory, BaseTest)
   │  ├─ pages/ (BasePage, HomePage, TextNoteEditorPage, SearchPage)
   │  └─ tests/ (CreateEditDeleteNoteTests, SearchTests)
   └─ resources/config.properties

Configuration

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

Setup & Run

Start device/emulator:

adb devices -l


Start Appium server:

appium --log-level debug


Run tests:

mvn clean test


Reports: target/surefire-reports/

What’s Covered

Create text note → verify in list

Edit note → save

Delete note → verify removed

Search note by title → verify result

Minimal Troubleshooting

config.properties not found → ensure file exists at src/test/resources/ (classpath).

App won’t launch → set exact appActivity using the resolve-activity command above.

Device offline/unauthorized → adb kill-server && adb start-server, reconnect, accept RSA prompt.
