package BackingBeans;

import Controllers.ValidationControl;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author phuongtm
 */
@Named(value = "indexManagedBean")
@ViewScoped
public class indexManagedBean {

    private String firstName;

    private String lastName;

    private String region;

    private String age;

    private String sex;
    
    private boolean firstView = true;
    
    private boolean firstView2 = true;
    
    private String email;
    
    private String emailSurvey;

    public String getEmailSurvey() {
        return emailSurvey;
    }

    public void setEmailSurvey(String emailSurvey) {
        this.emailSurvey = emailSurvey;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Creates a new instance of indexManagedBean
     */
    public indexManagedBean() {
    }
    
    public String getAccess() {
        if (firstView) {
            firstView = false;
            return "";
        }
        if (email != null && !email.equals("")) {
            if (ValidationControl.isValidEmailAddress(email)) {
                return "<form name=\"login\" method=\"post\" action=\"http://192.168.11.1:5280/\">\n"
                        + "\n"
                        + "<div align=\"center\">\n"
                        + "\n"
                        + "  <input type=\"hidden\" name=\"accept_terms\" value=\"yes\" />   <input type=\"hidden\" name=\"redirect\" value=\"https://facebook.com\">\n"
                        + "\n"
                        + "  <input type=\"hidden\" name=\"mode_login\">\n"
                        + "\n"
                        + "  <input type=\"submit\" value=\"Truy cập\" class=\"text\">\n"
                        + "\n"
                        + "</div>";
            } else {
                return "<h3><center>Địa chỉ email không hợp lệ</center></h3>";
            }
        }
        return "<h3><center>Xin vui lòng nhập địa chỉ email</center></h3>";
    }
    
    public String getAccessByCompleteSurvey() {
        if (firstView2) {
            firstView2 = false;
            return "";
        }
        if ((firstName != null  && emailSurvey != null && age != null) && (!firstName.equals("") && !emailSurvey.equals("") && !region.equals("Question") && !age.equals(""))) {
            if (ValidationControl.isValidEmailAddress(emailSurvey)) {
                return "<form name=\"login\" method=\"post\" action=\"http://192.168.11.1:5280/\">\n"
                        + "\n"
                        + "<div align=\"center\">\n"
                        + "\n"
                        + "  <input type=\"hidden\" name=\"accept_terms\" value=\"yes\" />   <input type=\"hidden\" name=\"redirect\" value=\"https://facebook.com\">\n"
                        + "\n"
                        + "  <input type=\"hidden\" name=\"mode_login\">\n"
                        + "\n"
                        + "  <input type=\"submit\" value=\"Truy cập\" class=\"text\">\n"
                        + "\n"
                        + "</div>";
            } else {
                return "<h3>Địa chỉ email không hợp lệ</h3>";
            }

        }
        return "<h3><center>Xin vui lòng điền đầy đủ thông tin</center></h3>";
    }
    
}
