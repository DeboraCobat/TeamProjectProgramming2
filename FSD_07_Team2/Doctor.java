package FSD_07_Team2;

import java.time.LocalDate;

public class Doctor extends Person {
    //field or data member
    private String speciality;

    //constructor
    public Doctor(String firstName,String lastName, LocalDate dateOfBirth, String speciality) {
        super(firstName, lastName, dateOfBirth);
        this.speciality = speciality;
    }

    //getters and setters

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    //toString Method
    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Speciality: " + speciality;
    }

    @Override
    public String toPrint(){
        return super.toPrint() +";"+ getSpeciality();
    }
}//end class Doctor
