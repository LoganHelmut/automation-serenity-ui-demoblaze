# Serenity BDD Test Project (POM Design Pattern)

A UI test automation framework (Serenity BDD + Selenium + Java + POM) using **Java 20** and **Gradle 8.10 (via wrapper)**.

## 🚀 Video Results

1. Link to video with results IU Testing:
   ```bash
   https://jam.dev/c/95e859f1-dddb-49ae-941a-5e49aafc89c5

## ✅ Requirements

- Java 20 installed (`java -version`)
- Git installed (optional)
- Gradle is not required (uses wrapper)

## 🛠 Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/LoganHelmut/automation-serenity-ui-demoblaze.git
   cd serenity-project

## 🚀 Running Tests

1. Clean the project:
   ```bash
   ./gradlew clean
2. Run tests and generate the Serenity report:
   ```bash
   ./gradlew test aggregate
3. After test execution, open:
   ```bash
   build/reports/serenity/index.html
## 🧠 Notes

- Make sure your IDE is configured to use Java 20 as the project SDK.
- Gradle wrapper version is configured in gradle/wrapper/gradle-wrapper.properties.

3. Project Structure (POM - Page Object Model):
   ```bash 
   📁 src/test/java
   └── 📦 demoblaze.ui.serenity.automation
   ├── 📁 definitions
   │   ├── 🧾 HomeDefinition.java
   ├── 📁 pageobjects
   │   ├── 🧾 HomePage.java
   ├── 📁 runners
   │   └── 🧾 AutomationRunner.java
   ├── 📁 steps
   │   ├── 🧾 HomeStep.java
   └── 📁 utils
   
   📁 src/test/resources
   ├── 📁 driver
   │   └── 🧩 chromedriver.exe
   └── 📁 features
       └── 🟩 home.feature
   📁 target
   ├── 📁 cucumber-reports
   ├── 📁 site
   └── 🧾 products.txt
   
