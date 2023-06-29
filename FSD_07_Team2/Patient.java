package FSD_07_Team2;

import java.time.LocalDate;

public class Patient extends Person {
    //field or data members
    private String insuranceCompany;
    private String Employer;

    //constructor

    public Patient(String firstName, String lastName, LocalDate dateOfBirth, String insuranceCompany, String employer) {
        super(firstName, lastName, dateOfBirth);
        this.insuranceCompany = insuranceCompany;
        Employer = employer;
    }

    //getter & setters

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public String getEmployer() {
        return Employer;
    }

    public void setEmployer(String employer) {
        Employer = employer;
    }

    //toString method

    @Override
    public String toString() {
        return super.toString() + "\n"+
                "Insurance Company: " + insuranceCompany + "\n" +
                "Employer: " + Employer;
    }
    @Override
    public String toPrint(){
        //return String.format("%s s% s%",super.toString(), getInsuranceCompany(), getEmployer());
        return super.toPrint() + ";" + getInsuranceCompany() + ";" + getEmployer();
    }

}//end of class Patient

