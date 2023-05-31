# Automation Testing Project Readme

This repository contains an automation testing project built in Java using Selenium for frontend testing and RestAssured for backend testing. TestNG is used for assertions and test execution.

## Features

- Frontend testing with Selenium: The project includes test cases and utility classes to perform automated testing of web applications using Selenium WebDriver. This allows you to simulate user interactions and validate the behavior of your frontend.

- Backend testing with RestAssured: The project also includes test cases and utility classes to perform automated testing of RESTful APIs using RestAssured. This enables you to validate the functionality and response of your backend services.

- TestNG for assertions and test execution: TestNG is utilized as the testing framework for creating and executing test cases. It provides powerful assertion capabilities, test configuration, parallel execution, data provider and reporting.

## Prerequisites

Before you can run the automation tests in this project, you need to ensure the following prerequisites are met:

- Java Development Kit (JDK) 8 or above is installed on your machine.
- Maven is installed on your machine.
- Chrome or Firefox web browser is installed.
- An IDE (Integrated Development Environment) such as Eclipse or IntelliJ is recommended for code editing and execution.

## Clone Repository

To clone this repository to your local machine, follow these steps:

1. Open a terminal or command prompt.

2. Change the current working directory to the location where you want the cloned directory to be created.

3. Run the following command to clone the repository:

   ```
   git clone git@github.com:markitj42/Java-be-fe-technical-setup.git
   ```

4. After executing the command, the repository will be cloned to your local machine.

## Build and Test Execution

To execute the automation tests, follow these steps:

1. Open the cloned project in your preferred IDE.

2. Ensure that the required dependencies are resolved by Maven. If using IntelliJ, you can click on the "Reimport All Maven Projects" button in the Maven Projects tab.

3. Locate the `testng.xml` file in the project structure.

4. Right-click on the `testng.xml` file and select "Run" or "Run As" -> "TestNG Suite" to execute the test cases.

5. The test execution will start, and you can monitor the progress and results in the IDE's console or TestNG's HTML reports.

## Additional Configuration

- WebDriver Configuration: By default, the project is set to use the Chrome WebDriver for frontend testing. If you prefer to use Firefox, modify the WebDriver setup in the `BaseTest` class.

- TestNG Configuration: TestNG configuration settings such as parallel execution, thread count, and report generation can be modified in the `testng.xml` file.

## Contributions

Contributions to this project are welcome. If you find any issues or have suggestions for improvements, please feel free to open an issue or submit a pull request.
