package utils;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	 @DataProvider(name="registrationData")
    public Object[][] getDataRegistratrionPage() {
        return new Object[][] {
            {"   ", "   ", "    ", "    ", "   ", "   ", "     ", "   "},
            {"Amit Sharma", "amit.sharma@yopmail.com", "Test@1234", "Test@1234", "9988776655", "TechCorp", "Automation_Testing", "USA"},
//            {"Priya Verma", "priya.v@yopmail.com", "Pass@9876", "Pass@9876", "9123456789", "SoftEdge", "Manual_Testing", "Canada"},
//            {"Rahul Singh", "rahulsingh@yopmail.com", "Secure#456", "Secure#456", "8765432109", "InfyTech", "DevOps_Engineer", "UK"},
//            {"Sneha Mehta", "sneha.m@yopmail.com", "QATest@567", "QATest@567", "9654321987", "CodeSolutions", "Performance_Testing", "Australia"}
        };
    }

}
