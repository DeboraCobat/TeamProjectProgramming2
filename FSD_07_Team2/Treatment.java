package FSD_07_Team2;

import java.time.LocalDate;

public class Treatment {
    //field or data member
    private LocalDate date;
    private String patientName;
    private String doctorName;
    private String healthProblem;
    private String tests;
    private String testPrescription;
    private String drugPrescription;
    private String recommendation;
    private String referral;
    private String remark;

    //constructor
    public Treatment(LocalDate date, String patientName, String doctorName, String healthProblem, String tests,
                     String testPrescription, String drugPrescription, String recommendation, String referral, String remark) {
        this.date = date;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.healthProblem = healthProblem;
        this.tests = tests;
        this.testPrescription = testPrescription;
        this.drugPrescription = drugPrescription;
        this.recommendation = recommendation;
        this.referral = referral;
        this.remark = remark;
    }

    public Treatment(LocalDate date, String patientName, String doctorName) {
        this.date = date;
        this.patientName = patientName;
        this.doctorName = doctorName;
    }

    //getter and setter
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getHealthProblem() {
        return healthProblem;
    }

    public void setHealthProblem(String healthProblem) {
        this.healthProblem = healthProblem;
    }

    public String getTests() {
        return tests;
    }

    public void setTests(String tests) {
        this.tests = tests;
    }

    public String getTestPrescription() {
        return testPrescription;
    }

    public void setTestPrescription(String testPrescription) {
        this.testPrescription = testPrescription;
    }

    public String getDrugPrescription() {
        return drugPrescription;
    }

    public void setDrugPrescription(String drugPrescription) {
        this.drugPrescription = drugPrescription;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getReferral() {
        return referral;
    }

    public void setReferral(String referral) {
        this.referral = referral;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    //toString method
    @Override
    public String toString() {
        return "Date: " + date + "\n" +
                "Patient name: " + patientName + "\n" +
                "Doctor name: " + doctorName + "\n" +
                "Health problem: " + healthProblem + '\'' +
                "Tests: " + tests + "\n" +
                "Test Prescription: " + testPrescription + "\n" +
                "Drug Prescription: " + drugPrescription + "\n" +
                "Recommendation: " + recommendation + "\n" +
                "Referral: " + referral + "\n" +
                "Remark :" + remark;
    }

    public String toPrint(){
        return date + ";" + patientName + ";" + doctorName + ";" + healthProblem + ";" + tests + ";" +
                testPrescription + ";" + drugPrescription + ";" + recommendation + ";" + referral + ";" + remark;
    }

    public String toPrint2(){
        return "Date: "+date + ";    Patient: " + patientName + ";    Doctor: " + doctorName + ";   Problem: " + healthProblem + ";  Diagnostic test:" + tests +
                ";  Test prescription: " + testPrescription + ";   Drug prescription: " + drugPrescription + ";   Recommendation: " + recommendation +
                "; Referral: " + referral + ";   Remark: " + remark;
    }

    //--------------------------------------


}
