public class UserInfo {
    private final String fullName;
    private final String phoneNumber;
    private final String emailAddress;
    private final String country;

    public UserInfo(String fullName, String phoneNumber, String emailAddress, String country) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.country = country;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getCountry() {
        return country;
    }
}
