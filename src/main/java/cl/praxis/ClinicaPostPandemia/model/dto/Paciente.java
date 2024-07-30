package cl.praxis.ClinicaPostPandemia.model.dto;

public class Paciente {

    private int id;
    private String name;
    private String lastName;
    private char gender;
    private int age;
    private String phone;
    private String email;
    private String url;

    public Paciente() {
    }

    public Paciente(int id, String name, String lastName, char gender, int age, String phone, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public Paciente(int id, String name, String lastName, char gender, int age, String phone, String email, String url) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.url = url;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public char getGender() {

        return gender;
    }

    public void setGender(char gender) {

        this.gender = gender;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getUrl() {
        return url; }

    public void setUrl(String url) {
        this.url = url; }
}