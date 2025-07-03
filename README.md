# 🔧 Automation Testing Project - Selenium | TestNG | Maven

This project demonstrates end-to-end automation of the [Demo Guru99 Telecom Website](http://demo.guru99.com/telecom/) using:

- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Eclipse IDE**
## 📁 Project Structure



```
AutomationTestingProject/
├── pom.xml
├── testng.xml
├── src/
│   └── main/java/
│       └── MavenTestNg/
│           ├── DemoGuru.java       ← Main automation test script
│           ├── AddTariffPlan.java  ← Page/test component for adding tariff plans
│           ├── WebOpen.java        ← Browser setup & initialization
│           ├── SkipTest.java       ← TestNG skip test example
│           ├── Dependency.java     ← TestNG dependent test example
│           └── TestCase.java       ← Sample test class
├── CustomerData.xlsx              ← Excel data for test cases
└── test-output/                   ← TestNG-generated reports
```


## ✅ This project covers:

- Launching the application
- Adding a new customer
- Adding a tariff plan
- Linking customer and tariff
- Paying the bill
- Using `@BeforeMethod`, `@Test`, and `@AfterMethod` from TestNG

---

## ✅ Features Automated

- Open Guru99 Telecom website → [https://demo.guru99.com/telecom](https://demo.guru99.com/telecom)


🛠 Tools & Technologies Used
Tool/Tech	Description
Java	Scripting language
Selenium	Web automation framework
TestNG	Test management framework
Apache POI	Excel file handling
Maven	Build and dependency management
Eclipse IDE	Development environment

▶️ How to Run
🔹 Prerequisites
Java JDK 8 or higher

Maven installed

Eclipse IDE with TestNG plugin

🔹 Run Steps
Clone this repository or import the project into Eclipse

Right-click on testng.xml → Run As → TestNG Suite

View reports under the test-output/ folder

✍️ Author
Kailasnath K S
Automation Enthusiast | Quality Focused | Always Learning
