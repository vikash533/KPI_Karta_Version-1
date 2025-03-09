package utils;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	 @DataProvider(name="registrationData")
    public Object[][] getBlankDataRegPage() {
        return new Object[][] {
            {"   ", "   ", "   ", "  ", "  ", "   ", "   ", "   "}
//            {"  ", "amit.sharma@yopmail.com", "Test@1234", "Test@1234", "9988776655", "TechCorp", "Automation_Testing", "USA"},
//            {"Amit Sharma", "amit.sharma", "Test@1234", "Test@1234", "9988776655", "TechCorp", "Automation_Testing", "USA"},
//            {"Amit Sharma", "    ", "Test@1234", "Test@1234", "9988776655", "TechCorp", "Automation_Testing", "USA"},
//            {"Amit Sharma", "amit.sharma@yopmail.com", "   ", "Test@1234", "9988776655", "TechCorp", "Automation_Testing", "USA"},
//            {"Amit Sharma", "amit.sharma@yopmail.com", "Test@1234", "   ", "9988776655", "TechCorp", "Automation_Testing", "USA"},
//            {"Amit Sharma", "amit.sharma@yopmail.com", "Test@1234", "Test@1234", "   ", "TechCorp", "Automation_Testing", "USA"},
//            {"Amit Sharma", "amit.sharma@yopmail.com", "Test@1234", "Test@1234", "9988776655", "   ", "Automation_Testing", "USA"},
//            {"Amit Sharma", "amit.sharma@yopmail.com", "Test@1234", "Test@1234", "9988776655", "TechCorp", "   ", "USA"},
//            {"Amit Sharma", "amit.sharma@yopmail.com", "Test@1234", "Test@1234", "9988776655", "TechCorp", "Automation_Testing", "   "}       
        };
    }
	 	
	 @DataProvider(name="blkFNameregistrationData")
    public Object[][] getDataRegistratrionPage1() {
        return new Object[][] {
            {"  ", "amit.sharma@yopmail.com", "Test@1234", "Test@1234", "4242432445", "TechCorp", "Automation_Testing", "USA"}
        };
    }
	 
	 @DataProvider(name="invEmailregistrationData")
	    public Object[][] getDataRegistratrionPage2() {
	        return new Object[][] {
	            {"Amit Sharma", "amit.sharma", "Test@1234", "Test@1234", "4242432445", "TechCorp", "Automation_Testing", "USA"}

	        };
	    }
	 
	 @DataProvider(name="blkEmailregistrationData")
	    public Object[][] getDataRegistratrionPage3() {
	        return new Object[][] {
	            {"Amit Sharma", "    ", "Test@1234", "Test@1234", "4242432445", "TechCorp", "Automation_Testing", "USA"}
	        };
	    }
	 
	 @DataProvider(name="blkPassregistrationData")
	    public Object[][] getDataRegistratrionPage4() {
	        return new Object[][] {
	            {"Amit Sharma", "amit.sharma@yopmail.com", "   ", "Test@1234", "4242432445", "TechCorp", "Automation_Testing", "USA"}
	        };
	  }
	 
	 @DataProvider(name="blkConfPassregistrationData")
	    public Object[][] getDataRegistratrionPage5() {
	        return new Object[][] {
	            {"Amit Sharma", "amit.sharma@yopmail.com", "Test@1234", "   ", "4242432445", "TechCorp", "Automation_Testing", "USA"}
	        };
	  }
	 
	 @DataProvider(name="blkMobNumregistrationData")
	    public Object[][] getDataRegistratrionPage6() {
	        return new Object[][] {
	            {"Amit Sharma", "amit.sharma@yopmail.com", "Test@1234", "Test@1234", "   ", "TechCorp", "Automation_Testing", "USA"}
	        };
	  }
	 
	 @DataProvider(name="blkOrgNameregistrationData")
	    public Object[][] getDataRegistratrionPage7() {
	        return new Object[][] {
	            {"Amit Sharma", "amit.sharma@yopmail.com", "Test@1234", "Test@1234", "4242432445", "   ", "Automation_Testing", "USA"}
	        };
	  } 
	 
	 @DataProvider(name="blkJobTitleregistrationData")
	    public Object[][] getDataRegistratrionPage8() {
	        return new Object[][] {
	            {"Amit Sharma", "amit.sharma@yopmail.com", "Test@1234", "Test@1234", "4242432445", "TechCorp", "   ", "USA"}
	        };
	  }
	 
	 @DataProvider(name="blkCountryregistrationData")
	    public Object[][] getDataRegistratrionPage9() {
	        return new Object[][] {
	            {"Amit Sharma", "amit.sharma@yopmail.com", "Test@1234", "Test@1234", "4242432445", "TechCorp", "Automation_Testing", "   "}
	        };
	  }
	 @DataProvider(name="mismatchPassConPass")
	    public Object[][] mismatchPassConPass() {
	        return new Object[][] {
	            {"Amit Sharma", "amit.sharma@yopmail.com", "Test@1234", "Test@12347", "4242432445", "TechCorp", "Automation_Testing", "India"}
	        };
	  }
	 
	 @DataProvider(name="validdata")
	    public Object[][] signupwithvaliddata() {
	        return new Object[][] {
	            {"Amit Sharma", "amit.sharma121@yopmail.com", "Test@1234", "Test@1234", "4242432445", "TechCorp", "Automation_Testing", "India"}
	        };
	  }
}
