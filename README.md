# QA Automation Framework – Dockerized (TestNG + Selenium)

## 📌 Overview
This project is a containerized UI Automation Framework built using:

- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Docker**
- **Allure Reporting**

The framework is designed to run reliably in both local and CI environments using headless Chrome inside a Docker container.

---

## 🚀 Key Features

✔ Page Object Model (POM) Design Pattern  
✔ TestNG Suite Execution  
✔ Parallel Execution Support  
✔ Dockerized Test Execution  
✔ Headless Chrome Configuration  
✔ Maven Surefire Integration  
✔ Allure Reporting Support  
✔ CI-Ready Setup  

---

## 🏗 Project Structure
QA-Automation-Portfolio/
│
├── src/
│ ├── main/java
│ └── test/java
│
├── testng.xml
├── pom.xml
├── Dockerfile
├── logs/
├── allure-results/
└── README.md

-----------------------------------------------------
Code
---
## Running Tests in Docker(Recommended)
🔹 Step 1: Build Docker Image
docker build -t automation-tests .
🔹 Step 2: Run Tests Inside Container
docker run --rm automation-tests
Running Tests Locally
🔹 Run via Maven
mvn clean test
🔹 Run specific TestNG suite
mvn test -DsuiteXmFile=testng.xml
------------------------------------------------------
⚙️ Chrome Configuration (CI Safe)

The framework runs Chrome in headless mode using:

--headless=new

--no-sandbox

--disable-dev-shm-usage

--window-size=1920,1080

This ensures compatibility with Linux containers and CI environments.
-------------------------------------------------------
📊 Reporting

Test reports are generated using:

Maven Surefire Reports (target/surefire-reports)

Allure Reports (allure-results)

To generate Allure report locally:
allure serve allure-results


------------------------------------------------------
🔄 CI/CD Integration

This project is designed to integrate easily with:

Jenkins

GitHub Actions

GitLab CI

Azure DevOps

Typical CI flow:
Code Push → Build Docker Image → Run Container → Execute Tests → Publish Reports
-----------------------------------------------------
Design Principles

Separation of concerns using Page Object Model

Centralized DriverFactory for browser management

Environment-agnostic configuration

Container-first testing strategy

CI-ready architecture
----------------------------------------------------
🎯 Why Docker?

Running tests inside Docker:

Eliminates "Works on My Machine" issues

Provides environment consistency

Simplifies CI setup

Enables scalable parallel execution
----------------------------------------------------

📌 Future Enhancements

GitHub Actions CI workflow

Parallel TestNG execution tuning

API automation integration

Docker Compose setup (UI + API + DB)

Test data management improvements
---------------------------------------------------
👤 Author

Shahryar Saleem
QA Automation Engineer
Focused on building scalable, CI-ready automation frameworks.
