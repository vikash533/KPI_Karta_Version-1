package cssSelectors;

public class RegistrationPageSelectors {

    // Blank Data Scenario
    public String BLANK_FULLNAME_ERROR = "document.querySelector(\"#fullName ~ div\").innerText";
    public String BLANK_EMAIL_ERROR = "document.querySelector('#email~div').innerText";
    public String BLANK_PASSWORD_ERROR = "document.querySelector('#password~div').innerText";
    public String BLANK_CONFIRM_PASSWORD_ERROR = "document.querySelector('#confirmPassword~div').innerText";
    public String BLANK_MOBILE_ERROR = "document.querySelector(\"ngx-intl-tel-input[name='phone'] ~ div\")?.innerText";
    public String BLANK_ORG_NAME_ERROR = "document.querySelector('#companyName~div').innerText";
    public String BLANK_JOB_TITLE_ERROR = "document.querySelector('#job_title~div').innerText";
    public String BLANK_COUNTRY_ERROR = "document.querySelector('#country~div').innerText";

    // Blank Full Name Scenario
    public String BLANK_FULL_NAME_SINGLE_ERROR = "document.querySelector(\"#fullName ~ div\").innerText";

    // Invalid Email Scenario
    public String INVALID_EMAIL_ERROR = "document.querySelector('#email~div').innerText";

    // Blank Email Scenario
    public String BLANK_EMAIL_SINGLE_ERROR = "document.querySelector('#email~div').innerText";

    // Blank Password Scenario
    public String BLANK_PASSWORD_SINGLE_ERROR = "document.querySelector('#password~div').innerText";

    // Blank Confirm Password Scenario
    public String BLANK_CONFIRM_PASSWORD_SINGLE_ERROR = "document.querySelector('#confirmPassword~div').innerText";

    // Blank Mobile Number Scenario
    public String BLANK_MOBILE_NUMBER_SINGLE_ERROR = "document.querySelector(\"ngx-intl-tel-input[name='phone'] ~ div\")?.innerText";

    // Blank Organization Name Scenario
    public String BLANK_ORG_NAME_SINGLE_ERROR = "document.querySelector('#companyName~div').innerText";

    // Blank Job Title Scenario
    public String BLANK_JOB_TITLE_SINGLE_ERROR = "document.querySelector('#job_title~div').innerText";

    // Blank Country Scenario
    public String BLANK_COUNTRY_SINGLE_ERROR = "document.querySelector('#country~div').innerText";

    // Mismatch Password Scenario
    public String MISMATCH_PASSWORD_ALERT = "document.querySelector(\"div[role='alert']\").innerText";
    
}
