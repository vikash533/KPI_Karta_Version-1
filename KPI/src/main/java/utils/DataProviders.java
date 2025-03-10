package utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "registrationTestData")
    public Object[][] getRegistrationTestData() {
        return new Object[][]{
            // Scenario: Blank Data
            {"blankData", "", "", "", "", "", "", "", ""},

            // Scenario: Blank Full Name
            {"blankFullName", "  ", "amit.sharma@yopmail.com", "Test@1234", "Test@1234", "9988776655", "TechCorp", "Automation_Testing", "USA"},

            // Scenario: Invalid Email
            {"invalidEmail", "Amit Sharma", "amit.sharma", "Test@1234", "Test@1234", "9988776655", "TechCorp", "Automation_Testing", "USA"},

            // Scenario: Blank Email
            {"blankEmail", "Amit Sharma", "    ", "Test@1234", "Test@1234", "9988776655", "TechCorp", "Automation_Testing", "USA"},

            // Scenario: Blank Password
            {"blankPassword", "Amit Sharma", "amit.sharma@yopmail.com", "   ", "Test@1234", "9988776655", "TechCorp", "Automation_Testing", "USA"},

            // Scenario: Blank Confirm Password
            {"blankConfirmPassword", "Amit Sharma", "amit.sharma@yopmail.com", "Test@1234", "   ", "9988776655", "TechCorp", "Automation_Testing", "USA"},

            // Scenario: Blank Mobile Number
            {"blankMobileNumber", "Amit Sharma", "amit.sharma@yopmail.com", "Test@1234", "Test@1234", "   ", "TechCorp", "Automation_Testing", "USA"},

            // Scenario: Blank Organization Name
            {"blankOrgName", "Amit Sharma", "amit.sharma@yopmail.com", "Test@1234", "Test@1234", "9988776655", "   ", "Automation_Testing", "USA"},

            // Scenario: Blank Job Title
            {"blankJobTitle", "Amit Sharma", "amit.sharma@yopmail.com", "Test@1234", "Test@1234", "9988776655", "TechCorp", "   ", "USA"},

            // Scenario: Blank Country
            {"blankCountry", "Amit Sharma", "amit.sharma@yopmail.com", "Test@1234", "Test@1234", "9988776655", "TechCorp", "Automation_Testing", "   "},

            // Scenario: Mismatch Password and Confirm Password
            {"mismatchPassword", "Amit Sharma", "amit.sharma@yopmail.com", "Test@1234", "Test@12347", "9988776655", "TechCorp", "Automation_Testing", "USA"},

            // Scenario: Valid Data
            {"validData", "Amit Sharma", "amit.sharma@yopmail.com", "Test@1234", "Test@1234", "9988776655", "TechCorp", "Automation_Testing", "USA"}
        };
    }
}