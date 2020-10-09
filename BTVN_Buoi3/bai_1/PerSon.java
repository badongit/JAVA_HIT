package bai_1;

public class PerSon {
    private String name;
    private String dateOfBirth;
    private String gender;
    private String hobby;

    public PerSon() {
    }

    public PerSon(String name, String dateOfBirth, String gender, String hobby) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getHobby() {
        return hobby;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
