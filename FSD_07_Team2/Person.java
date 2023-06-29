package FSD_07_Team2;

import java.time.LocalDate;

public abstract class Person{
    //field or data member
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    //constructor

    public Person(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }


    //getter & setters

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    //toString method


    public String toString() {
        return "Name: " + firstName + " " + lastName + "\n" +
                "Date of birth: " + dateOfBirth;
    }

    public String toPrint(){
        return firstName +";"+ lastName + ";" + dateOfBirth;
    }

}//end of abstract class person
