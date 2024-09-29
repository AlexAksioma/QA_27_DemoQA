package dto;

import enums.Gender;

public class StudentDto {
    private String name;
    private String lastName;
    private String email;
    private Gender gender;
    private String mobile;
    private String dateOfBirth;
    private String subjects;


    public StudentDto(String name, String lastName, String email, Gender gender,
                      String mobile, String dateOfBirth, String subjects) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.mobile = mobile;
        this.dateOfBirth = dateOfBirth;
        this.subjects = subjects;
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
