package dto;

import enums.Gender;
import enums.Hobbies;

import java.util.List;
import java.util.Objects;

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
    private String state;
    private String city;

    public StudentDto(String name, String lastName, String email, Gender gender,
                      String mobile, String dateOfBirth, String subjects, List<Hobbies> hobbies,
                      String picture, String currentAddress, String state, String city) {
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
        this.state = state;
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
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

    @Override
    public String toString() {
        return "StudentDto{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", mobile='" + mobile + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", subjects='" + subjects + '\'' +
                ", hobbies=" + hobbies +
                ", picture='" + picture + '\'' +
                ", currentAddress='" + currentAddress + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDto that = (StudentDto) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(email, that.email) &&
                Objects.equals(mobile, that.mobile) &&
                Objects.equals(currentAddress, that.currentAddress) &&
                Objects.equals(state, that.state) &&
                Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, email, mobile, currentAddress, state, city);
    }
}
