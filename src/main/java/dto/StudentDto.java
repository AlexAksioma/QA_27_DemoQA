package dto;

import enums.Gender;
import enums.Hobbies;

import java.util.List;

public class StudentDto {
    private String name;
    private String lastName;
    private String email;
    private Gender gender;
    private String mobile;
    private String dateOfBirth;
    private String subjects;
    private List<Hobbies> hobbies;
    private String picture;
    private String currentAddress;


    public StudentDto(String name, String lastName, String email,
                      Gender gender, String mobile, String dateOfBirth,
                      String subjects, List<Hobbies> hobbies, String picture,
                      String currentAddress) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.mobile = mobile;
        this.dateOfBirth = dateOfBirth;
        this.subjects = subjects;
        this.hobbies = hobbies;
        this.picture = picture;
        this.currentAddress = currentAddress;
    }

    public List<Hobbies> getHobbies() {
        return hobbies;
    }

    public String getPicture() {
        return picture;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
    public Gender getGender(){
        return gender;
    }

    public String getMobile() {
        return mobile;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSubjects() {
        return subjects;
    }
}
