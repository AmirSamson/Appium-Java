### APPIUM project -> Java 

How to install and use Appium (using JAVA) on your VScode and windows machine. This is the right place to be. \n
please read the following material for understanding the project. 


# 📱 Appium Android Automation – Complete Setup Guide (Java)

This README is a **step-by-step, beginner-friendly guide** to set up a **full Android automation stack with Appium + Java**, from zero to first successful session 🚀
It’s written so *any QA engineer* can follow it without guessing.

---

## 🧠 Big Picture – Automation Stack Mind Map

```
Android Automation (Appium)
│
├── System Requirements
│   ├── Java (JDK)
│   ├── Node.js & NPM
│   └── Environment Variables
│
├── Appium Stack
│   ├── Appium Server
│   ├── UIAutomator2 Driver
│   └── Appium Inspector
│
├── Android Stack
│   ├── Android Studio
│   ├── SDK & Platform Tools
│   ├── Emulator (AVD)
│   └── adb
│
├── Test Project
│   ├── Java + Maven
│   ├── Selenium
│   └── Appium Java Client
│
└── Debugging & Validation
    ├── appium-doctor
    ├── adb devices
    └── Inspector Session
```

---

## 1️⃣ System Requirements

### ✅ Java (JDK)

* Install **JDK 11 or 17** (recommended)
* Verify:

```bash
java -version
```

### ✅ Environment Variable

Set:

* `JAVA_HOME`
* Add `%JAVA_HOME%\\bin` to `PATH`

---

## 2️⃣ Node.js & NPM

### Install

* Download **LTS version** from Node.js official website

### Verify

```bash
node -v
npm -v
```

---

## 3️⃣ Appium Installation

### Install Appium (Global)

```bash
npm install -g appium
```

### Verify

```bash
appium -v
```

---

## 4️⃣ Appium Doctor (Health Check)

### Install Doctor

```bash
npm install -g @appium/doctor
```

### Run Android Check

```bash
appium-doctor --android
```

✔ Fix all ❌ errors before continuing

---

## 5️⃣ UIAutomator2 Driver

### Install Driver

```bash
appium driver install uiautomator2
```

### Verify

```bash
appium driver list
```

---

## 6️⃣ Android Studio Setup

### Install Android Studio

* Install latest stable version

### Required Components (SDK Manager)

✔ Android SDK Platform
✔ Android SDK Platform-Tools
✔ Android SDK Build-Tools
✔ Android Emulator

---

## 7️⃣ Android Emulator (AVD)

### Create Virtual Device

1. Open **AVD Manager**
2. Create new device (Pixel recommended)
3. Choose system image:

   * Android 11+ (Google APIs)
4. Start emulator

### Verify via adb

```bash
adb devices
```

Expected:

```
emulator-5554   device
```

---

## 8️⃣ Android Environment Variables

Set:

* `ANDROID_HOME`

Add to `PATH`:

```
%ANDROID_HOME%\\platform-tools
%ANDROID_HOME%\\emulator
```

Verify:

```bash
adb version
```

---

## 9️⃣ Appium Inspector

### Install

* Download Appium Inspector (Desktop app)

### Purpose

* Inspect elements
* Validate capabilities
* Debug locator strategies

---

## 🔗 Connecting Appium Inspector to Emulator

### Capability Mind Map

```
Desired Capabilities
│
├── platformName: Android
├── automationName: UiAutomator2
├── deviceName: emulator-5554
├── appPackage: com.example
├── appActivity: .MainActivity
└── noReset: true
```

### Sample Inspector Capabilities

```json
{
  "platformName": "Android",
  "automationName": "UiAutomator2",
  "deviceName": "emulator-5554",
  "appPackage": "com.android.settings",
  "appActivity": ".Settings",
  "noReset": true
}
```

### Steps

1. Start emulator
2. Start Appium server
3. Open Appium Inspector
4. Paste capabilities
5. Click **Start Session**

---

## 🔟 Java + Maven Test Project

### Maven Dependencies

```xml
<dependencies>
  <dependency>
    <groupId>io.appium</groupId>
    <artifactId>java-client</artifactId>
    <version>9.0.0</version>
  </dependency>
  <dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.17.0</version>
  </dependency>
</dependencies>
```

---

## ▶️ First Appium Test Flow (Mental Model)

```
Test Start
│
├── Start Emulator
├── Start Appium Server
├── Load Capabilities
├── Create AndroidDriver
├── Perform Actions
└── Quit Driver
```

---

## 🧪 Common Debug Commands

```bash
adb devices
adb kill-server
adb start-server
appium-doctor --android
```

---

## ❗ Common Issues & Fixes

| Issue                   | Fix                          |
| ----------------------- | ---------------------------- |
| Emulator not detected   | Check adb + PATH             |
| Inspector won’t connect | Appium server not running    |
| Session timeout         | Wrong appPackage/appActivity |
| UIAutomator error       | Reinstall driver             |

---

## ✅ Final Validation Checklist

* [ ] Java installed & JAVA_HOME set
* [ ] Node & NPM installed
* [ ] Appium running
* [ ] UIAutomator2 installed
* [ ] Android Emulator running
* [ ] adb detects emulator
* [ ] Inspector session works

---

## 🎯 Result

You now have a **fully working Appium Android automation environment** ready for:

* Manual inspection
* Automated tests
* CI/CD integration

Happy testing 🤖🚀
