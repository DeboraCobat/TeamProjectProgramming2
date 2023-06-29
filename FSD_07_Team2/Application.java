package FSD_07_Team2;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Application {   
    static LocalDate appointmentDate=LocalDate.now().plusDays(0);
    static LocalDate today=LocalDate.now();
    private static final String password = "123";
    public static void main(String[] args) throws IOException {
        Application app = new Application();
    //------------------------------------------------------------------------------------------------------------------








































    //------------------------------------------------------------------------------------------------------------------
        Character user;
        char action;
        boolean escapeLoop;
        Scanner console = new Scanner(System.in);
        do{
            System.out.println("\nMAIN MENU");
            System.out.println("If you're a patient hit ---------------------- P");
            System.out.println("If you're a doctor hit ----------------------- D");
            System.out.println("If you're  management hit -------------------- M");
            System.out.println("To exit -------------------------------------- X");
            System.out.print("User: ");
            user=Character.toUpperCase(console.next().charAt(0));
            if (user.equals('P')) {
                escapeLoop = false;
                while (!escapeLoop) {
                    System.out.println("\nPATIENT MENU");
                    System.out.println("To book appointment hit   -------------------- A");
                    System.out.println("To cancel appointment hit -------------------- C");
                    System.out.println("To verify your appointment hit --------------- V");
                    System.out.println("To get your treatment history ---------------- R");
                    System.out.println("To view the list of doctors hit -------------- L");
                    System.out.println("To go back to previous window hit ------------ B");
                    System.out.print("Command: ");
                    action = Character.toUpperCase(console.next().charAt(0));
                    switch (action) {
                        case 'A' -> app.bookAppointment();
                        case 'C' -> app.cancelAppointment();
                        case 'V' -> app.checkAppointment();
                        case 'R' -> app.getPatientTreatmentHistory();
                        case 'L' -> app.getDoctorList();
                        case 'B' -> escapeLoop = true;
                    }
                }//end of escape while loop
            }
            else if (user.equals('D')) {
                escapeLoop = false;
                while (!escapeLoop) {
                    System.out.println("\nDOCTOR MENU");
                    System.out.println("To add new patient hit ----------------------- P");
                    System.out.println("To see list of today's appointments ---------- A");
                    System.out.println("To lookup patient treatment history hit ------ R");
                    System.out.println("To add new treatment hit --------------------- T");
                    System.out.println("To get list of treatment by any doctor hit --- E");
                    System.out.println("To go back to previous window hit ------------ B");
                    System.out.print("Command: ");
                    action = Character.toUpperCase(console.next().charAt(0));
                    switch (action) {
                        case 'P' -> app.addNewPatient();
                        case 'A' -> app.checkBookedAppointment();
                        case 'R' -> app.getPatientTreatmentHistory();
                        case 'T' -> app.addNewTreatment();
                        case 'E' -> app.getDoctorPerformRecord();
                        case 'B' -> escapeLoop = true;
                    }
                }//end of escape while loop
            }else if(user.equals('M')) {
                System.out.println("Please enter the password: ");
                if (console.next().equals( Application.password)) {
                    System.out.println("Successfully signed in as management.");
                    escapeLoop = false;
                    while (!escapeLoop) {
                        System.out.println("\nMANAGEMENT MENU");
                        System.out.println("To add create new appointment hit ------------ C");
                        System.out.println("To add new patient hit ----------------------- P");
                        System.out.println("To add new doctor hit ------------------------ D");
                        System.out.println("To see list of existing patient -------------- L");
                        System.out.println("To see list of doctors ----------------------- M");
                        System.out.println("To lookup patient treatment history hit ------ R");
                        System.out.println("To lookup doctor performance hit ------------- E");
                        System.out.println("To go back to previous window hit ------------ B");
                        System.out.print("Command: ");
                        action = Character.toUpperCase(console.next().charAt(0));
                        switch (action) {
                            case 'C' -> app.createAppointment();
                            case 'P' -> app.addNewPatient();
                            case 'D' -> app.addNewDoctor();
                            case 'L' -> app.getPatientList();
                            case 'M' -> app.getDoctorList();
                            case 'R' -> app.getPatientTreatmentHistory();
                            case 'E' -> app.getDoctorPerformRecord();
                            case 'B' -> escapeLoop = true;
                        }
                    }//end of escapeLoop
                } 
                else {
                    System.out.println("Wrong Password !\n");
                }
            }//end of if statement
        }while(user!='X');//end of while loop
        console.close();
    }//end of main method
    //------------------------------------------------------------------------------------------------------------------
    //Method create/add new patient
    public void addNewPatient() throws IOException{
        Scanner console = new Scanner(System.in);
        System.out.print("Enter patient first name: ");
        String aFirstName = console.nextLine().toUpperCase();
        System.out.print("Enter patient last name: ");
        String aLastName = console.nextLine().toUpperCase();
        System.out.print("Enter patient date of birth (YYYY-MM-DD): ");
        LocalDate aDOB = LocalDate.parse(console.nextLine());
        System.out.print("Enter patient insurance company: ");
        String aInsuranceCo = console.nextLine().toUpperCase(); //may have space in between
        System.out.print("Enter patient employer name: ");
        String aEmployer = console.nextLine().toUpperCase(); //may have space in between
        Patient newPatient = new Patient(aFirstName, aLastName, aDOB,aInsuranceCo,aEmployer);        
        try {
            Files.write(Paths.get("Lists/PatientList.txt"), ("\n"+ newPatient.toPrint()).getBytes(), StandardOpenOption.APPEND);
            System.out.println("New patient successfully add to patient list\n");
        }
        catch (IOException i) {
            i.printStackTrace();
        }
        //console.close(); -- let garbage collector take care of it, actually we need it be open for menu.
    }//end of add new patient method
    //------------------------------------------------------------------------------------------------------------------
    public void addNewDoctor() throws IOException{
        Scanner console = new Scanner(System.in);
        System.out.print("Enter doctor's first name: ");
        String aFirstName = console.nextLine().toUpperCase();
        System.out.print("Enter doctor's last name: ");
        String aLastName = console.nextLine().toUpperCase();
        System.out.print("Enter doctor's date of birth (YYYY-MM-DD): ");
        LocalDate aDOB = LocalDate.parse(console.nextLine());
        System.out.print("Enter doctor's speciality: ");
        String aSpeciality = console.nextLine();
        Doctor newDoctor = new Doctor(aFirstName, aLastName, aDOB, aSpeciality);
        
        try {
            Files.write(Paths.get("Lists/DoctorList.txt"), ("\n"+ newDoctor.toPrint()).getBytes(), StandardOpenOption.APPEND);
            System.out.println("New doctor successfully add to doctor list");
        }
        catch (IOException i) {
            i.printStackTrace();
        }
        //console.close(); -- let garbage collector take care of it, actually we need it be open for menu.     
    }//end of new doctor method
    //------------------------------------------------------------------------------------------------------------------
    public void addNewTreatment() throws IOException{
        Scanner console = new Scanner(System.in);
        //System.out.print("Enter patient date of birth: ");
        LocalDate aDate = LocalDate.now();
        System.out.print("Enter patient first name: ");
        String pFirstName = console.nextLine().toUpperCase();
        System.out.print("Enter patient last name: ");
        String pLastName = console.nextLine().toUpperCase();
        while(validateNameInFile("Lists/PatientList.txt",pFirstName+";"+pLastName) == false) {
            System.out.println(pFirstName+";"+pLastName + " is not in patient list, check spelling and try again!!.");            
            System.out.print("Enter patient first name: ");
            pFirstName = console.nextLine().toUpperCase();
            System.out.print("Enter patient last name: ");
            pLastName = console.nextLine().toUpperCase();
        }
        System.out.print("Enter doctor's first name: ");
        String dFirstName = console.nextLine().toUpperCase();
        System.out.print("Enter doctor's last name: ");
        String dLastName = console.nextLine().toUpperCase();
        while(validateNameInFile("Lists/DoctorList.txt",dFirstName+";"+dLastName) == false) {
            System.out.println(dFirstName+";"+dLastName + " is not registered as doctor, check spelling and try again!!.");
            System.out.print("Enter doctor's first name: ");
            dFirstName = console.nextLine().toUpperCase();
            System.out.print("Enter doctor's last name: ");
            dLastName = console.nextLine().toUpperCase();
        }
        System.out.print("Enter patient's health problem: ");
        String aProblem = console.nextLine();
        System.out.print("Enter test type and result (if any), else hit 'N' for none: ");
        String aTest = console.nextLine();
        if (aTest.toUpperCase().trim().equals("N")){aTest ="none";}
        System.out.print("Enter required test prescription (if any), else hit 'N' for none: ");
        String aTestPres = console.nextLine();
        if (aTestPres.toUpperCase().trim().equals("N")){aTestPres ="none";}
        System.out.print("Enter required drug prescription (if any), else hit 'N' for none: ");
        String aDrugPres = console.nextLine();
        if (aDrugPres.toUpperCase().trim().equals("N")){aDrugPres ="none";}
        System.out.print("Enter recommendation to patient (if any), else hit 'N' for none: ");
        String aRecommendation = console.nextLine();
        if (aRecommendation.toUpperCase().trim().equals("N")){aRecommendation ="none";}
        System.out.print("Enter required referral to patient (if any), else hit 'N' for none: ");
        String aReferral = console.nextLine();
        if (aReferral.toUpperCase().trim().equals("N")){aReferral ="none";}
        System.out.print("Enter remarks (if any), else hit 'N' for none: ");
        String aRemark = console.nextLine();
        if (aRemark.toUpperCase().trim().equals("N")){aRemark ="none";}

        Treatment newTreatment = new Treatment(aDate,pFirstName +" "+pLastName,dFirstName+" "+dLastName,aProblem,aTest,aTestPres,aDrugPres,aRecommendation,aReferral,aRemark);

        try {
            Files.write(Paths.get("Lists/Treatment.txt"), ("\n"+ newTreatment.toPrint()).getBytes(), StandardOpenOption.APPEND);
            System.out.println("New treatment successfully add to treatment list\n");
        }
        catch (IOException i) {
            i.printStackTrace();
        }
        //console.close(); -- let garbage collector take care of it, actually we need it be open for menu.
    }//end of new doctor method
    //------------------------------------------------------------------------------------------------------------------
    //method to create appointment list
    public void createAppointment() throws IOException {
        //LocalDate eventDate = LocalDate.of(2022,12,9);
        //LocalDate appointmentDate=LocalDate.now().plusDays(0);
        //System.out.println(appointmentDate);
        LocalTime appointStart = LocalTime.of(9,30);
        int eachAppointperiodInMinutes = 30;
        //double appointStart= 9.00;
        int noOfAppointment= 20;

        StringBuilder allAppointments= new StringBuilder();

        for (int i=0; i<noOfAppointment; i++){
            LocalTime nextAppointment = appointStart.plusMinutes(i*eachAppointperiodInMinutes);
            allAppointments.append(nextAppointment).append(" ");

        }//end of for loop

        try {
            PrintWriter outFile = new PrintWriter("Appointments/appointmentList_"+appointmentDate+".txt");
            outFile.print(allAppointments);
            outFile.close();
            System.out.println("Successfully created all appointments.\n");
        } //end of try
        catch (IOException e) {
            System.out.println("Oh no some error occurred, try again !!\n");
            e.printStackTrace();
        }//end of catch
    }//end of createAppointment method
    //------------------------------------------------------------------------------------------------------------------
    //Method to bookAppointment
    public void bookAppointment() throws FileNotFoundException {
        try {
            //LocalDate appointmentDate=LocalDate.now().plusDays(0);
            Scanner console = new Scanner(System.in);
            Scanner inFile = new Scanner(new FileReader("Appointments/appointmentList_"+appointmentDate+".txt"));
            String allAvailableAppointments = inFile.nextLine();
            ArrayList<String> appointments = new ArrayList<>(Arrays.asList(allAvailableAppointments.split(" ")));

            int j=1;
            for (String items:appointments){
                if (items.length()<=5) {
                    System.out.print(items + "  ");
                    if (j%5==0){System.out.println();}
                    j++;
                }
            }//end of for loop
            //return Integer.parseInt(result);
            if (j>1){
                System.out.print("\nType a time slot you selected: ");
                String selectSlot = console.next();
                //System.out.println(selectSlot);
                System.out.print("Type your first name: ");
                String yourFirstName = console.next().toUpperCase();
                System.out.print("Type your last name: ");
                String yourLastName = console.next().toUpperCase();

                appointments.set(appointments.indexOf(selectSlot),selectSlot + "_"+yourFirstName+"_"+yourLastName);

                StringBuilder updatedAppointmentList = new StringBuilder();
                for (String items:appointments){
                    updatedAppointmentList.append(items).append(" ");
                }
                PrintWriter outFile = new PrintWriter("Appointments/appointmentList_"+appointmentDate+".txt");
                outFile.print(updatedAppointmentList);
                outFile.close();
                inFile.close();

                System.out.println("\nYou successfully booked your appointment");
                System.out.println("------------------------------------------");
                System.out.printf("Appointment Detail %nName: %s %s %nDate: %s%nTime: %s%n",yourFirstName,yourLastName,appointmentDate,selectSlot);
                System.out.println("------------------------------------------\n");
            }
            else {System.out.println("Sorry no appointment available for "+ appointmentDate +" !!");}
            //console.close(); -- let garbage collector take care of it, actually we need it be open for menu.
        }
        catch (FileNotFoundException | NoSuchElementException e){
            System.out.println("Oh no some error occurred, try again !!");
            e.printStackTrace();
        }        
    } //end of bookAppointment method
    //------------------------------------------------------------------------------------------------------------------
    //check appointment
    public void checkAppointment() throws FileNotFoundException {
        try {
            Scanner console = new Scanner(System.in);
            //LocalDate appointmentDate=LocalDate.now().plusDays(0);
            System.out.print("Type your first name: ");
            String yourFirstName = console.next().toUpperCase();
            System.out.print("Type your last name: ");
            String yourLastName = console.next().toUpperCase();

            //read appointment text file and convert it into array list
            Scanner inFile = new Scanner(new FileReader("Appointments/appointmentList_"+appointmentDate+".txt"));
            String allAvailableAppointments = inFile.nextLine();
            ArrayList<String> appointments = new ArrayList<>(Arrays.asList(allAvailableAppointments.split(" ")));

            String matchStr="";
            for (String items:appointments){
                if (items.contains(yourFirstName + "_" + yourLastName)) {
                    matchStr = items;
                    String selectedSlot = items.substring(0,5);
                    System.out.println("Your appointment detail is :");
                    System.out.println("------------------------------------------");
                    System.out.printf("Appointment Detail %nName: %s %s %nDate: %s%nTime: %s%n",yourFirstName,yourLastName,appointmentDate,selectedSlot);
                    System.out.println("------------------------------------------\n");
                }

//                matchIndex++;
            }//end of for loop
            if (matchStr.equals("")){
                System.out.println("Sorry!, appointment not found!");
            }
            //console.close(); -- let garbage collector take care of it, actually we need it be open for menu.
        }
        catch (FileNotFoundException | NoSuchElementException e){
            System.out.println("Oh no some error occurred, try again !!");
            e.printStackTrace();
        }
    } //end of check appointment
    //------------------------------------------------------------------------------------------------------------------
    //Cancel appointment
    public void cancelAppointment() throws FileNotFoundException {
        try {
            Scanner console = new Scanner(System.in);
            //LocalDate appointmentDate=LocalDate.now().plusDays(0);
            System.out.print("Type your first name: ");
            String yourFirstName = console.next().toUpperCase();
            System.out.print("Type your last name: ");
            String yourLastName = console.next().toUpperCase();

            //read appointment text file and convert it into array list
            Scanner inFile = new Scanner(new FileReader("Appointments/appointmentList_"+appointmentDate+".txt"));
            String allAvailableAppointments = inFile.nextLine();
            ArrayList<String> appointments = new ArrayList<>(Arrays.asList(allAvailableAppointments.split(" ")));

            int matchIndex=0;
            for (String items:appointments){
                if (items.contains(yourFirstName + "_" + yourLastName)) {
                    String selectedSlot = items.substring(0,5);
                    System.out.println("Your appointment detail is :");
                    System.out.println("------------------------------------------");
                    System.out.printf("Appointment Detail %nName: %s %s %nDate: %s%nTime: %s%n",yourFirstName,yourLastName,appointmentDate,selectedSlot);
                    System.out.println("------------------------------------------\n");
                    System.out.print("Type 'Y' to confirm or 'N' to cancel: ");
                    String cancelConfirmation = console.next().toUpperCase().trim();
                    if (cancelConfirmation.equals("Y")) {
                        //proceed cancellation
                        appointments.set(matchIndex,selectedSlot);
                        StringBuilder updatedAppointmentList = new StringBuilder();
                        for (String str:appointments){
                            updatedAppointmentList.append(str).append(" ");
                        }
                        PrintWriter outFile = new PrintWriter("Appointments/appointmentList_"+appointmentDate+".txt");
                        outFile.print(updatedAppointmentList);
                        outFile.close();
                        System.out.println("Your appointment successfully cancelled, thank you !\n");
                    }
                    else if (cancelConfirmation.equals("N")){
                        //abort cancellation
                        System.out.println("Cancel appointment command aborted !!\n");
                    }
                }
                matchIndex++;
            }//end of for loop
           //console.close(); -- let garbage collector take care of it, actually we need it be open for menu.
        }
        catch (FileNotFoundException | NoSuchElementException e){
            System.out.println("Oh no some error occurred, try again !!\n");
            e.printStackTrace();
        }
    } //end of cancel appointment
    //------------------------------------------------------------------------------------------------------------------
    //Method to check booked appointments
    public void checkBookedAppointment() throws FileNotFoundException {
        try {
            //LocalDate appointmentDate=LocalDate.now().plusDays(0);
            Scanner inFile = new Scanner(new FileReader("Appointments/appointmentList_"+appointmentDate+".txt"));
            String allAvailableAppointments = inFile.nextLine();
            ArrayList<String> appointments = new ArrayList<>(Arrays.asList(allAvailableAppointments.split(" ")));

            
            for (String items:appointments){
                System.out.print(items + "\n");
            }//end of for loop
        }
        catch (FileNotFoundException | NoSuchElementException e){
            System.out.println("Oh no some error occurred, try again !!");
            e.printStackTrace();
        }
        System.out.println();
       
    } //end of checkBookedAppointment method
    //------------------------------------------------------------------------------------------------------------------
    //Method to getTreatmentRecord
    public void getPatientTreatmentHistory() throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter patient first name: ");
        String pFirstName = console.nextLine().toUpperCase();
        System.out.print("Enter patient last name: ");
        String pLastName = console.nextLine().toUpperCase();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("Lists/PatientList.txt"));
            for (String line = br.readLine(); line != null; line = br.readLine()){
                if(line.contains(pFirstName+";"+pLastName)){
                    //System.out.println(line);
                    ArrayList<String> pInfo = new ArrayList<>(Arrays.asList(line.split(";")));
                    System.out.print("\nName: "+pInfo.get(0)+" "+pInfo.get(1)+", Date of Birth: "+pInfo.get(2)+", Insurance Company: "+pInfo.get(3)+", Employer: "+pInfo.get(4)+"\n");
                }
            }
            BufferedReader brT = new BufferedReader(new FileReader("Lists/Treatment.txt"));
            for (String lineT = brT.readLine(); lineT != null; lineT = brT.readLine()){
                if(lineT.contains(pFirstName+" "+pLastName)){
                    //System.out.println(line);
                    System.out.println("--------------------------------------------------------------------------------------------");
                    ArrayList<String> tInfo = new ArrayList<>(Arrays.asList(lineT.split(";")));
                    System.out.print("Date: "+tInfo.get(0)+"\nDoctor: "+tInfo.get(2)+"\nProblem: "+ tInfo.get(3)+"\nTests: "+ tInfo.get(4)+"\nTest prescription: "+ tInfo.get(5)
                            +"\nDrug prescription: "+ tInfo.get(6)+"\nRecommendation: "+tInfo.get(7)+"\nReferral: "+tInfo.get(8)+"\nRemark: "+tInfo.get(9)+"\n");                    }
            }
            System.out.println("--------------------------------------------------------------------------------------------\n");
            br.close();
            brT.close();            
        }        
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        //console.close(); -- let garbage collector take care of it, actually we need it be open for menu.
    } //end of getTreatmentRecord method
    //------------------------------------------------------------------------------------------------------------------
    //Method to getPatient List
    public void getPatientList() throws FileNotFoundException {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Lists/PatientList.txt"));
            System.out.printf("|  %-20s  | %-15s | %-20s  |  %-20s  |%n","Patient Name","DOB","Insurance Company", "Employer");
            System.out.println("---------------------------------------------------------------------------------------------");
            for (String line = br.readLine(); line != null; line = br.readLine()){
                //System.out.println(line);
                ArrayList<String> pInfo = new ArrayList<>(Arrays.asList(line.split(";")));
                System.out.printf("|  %-20s  | %-15s | %-20s  |  %-20s  |%n",pInfo.get(0)+" "+pInfo.get(1),pInfo.get(2),pInfo.get(3),pInfo.get(4));
            }
            br.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("---------------------------------------------------------------------------------------------\n");
        
    } //end of getPatientList method
    //------------------------------------------------------------------------------------------------------------------
    //Method to getDoctor List
    public void getDoctorList() throws FileNotFoundException {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Lists/DoctorList.txt"));
            System.out.printf("|  %-20s  | %-15s | %-20s  |%n","Doctor Name","DOB"," Speciality");
            System.out.println("--------------------------------------------------------------------");
            for (String line = br.readLine(); line != null; line = br.readLine()){
                //System.out.println(line);
                ArrayList<String> dInfo = new ArrayList<>(Arrays.asList(line.split(";")));
                System.out.printf("|  %-20s  | %-15s | %-20s  |%n",dInfo.get(0)+" "+dInfo.get(1),dInfo.get(2),dInfo.get(3));
            }
            br.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("--------------------------------------------------------------------\n");
        
    } //end of getDoctorList method
    //------------------------------------------------------------------------------------------------------------------
    //Method to getDoctorPerformRecordRecord
    public void getDoctorPerformRecord() throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter doctor first name: ");
        String dFirstName = console.nextLine().toUpperCase();
        System.out.print("Enter doctor last name: ");
        String dLastName = console.nextLine().toUpperCase();        
        try {
            BufferedReader br = new BufferedReader(new FileReader("Lists/DoctorList.txt"));
            for (String line = br.readLine(); line != null; line = br.readLine()){
                if(line.contains(dFirstName+";"+dLastName)){
                    //System.out.println(line);
                    ArrayList<String> pInfo = new ArrayList<>(Arrays.asList(line.split(";")));
                    System.out.print("\nName: "+pInfo.get(0)+" "+pInfo.get(1)+", Date of Birth: "+pInfo.get(2)+", Speciality: "+pInfo.get(3)+"\n");
                }
            }
            BufferedReader brT = new BufferedReader(new FileReader("Lists/Treatment.txt"));
            System.out.println("-----------------------------------------------------------------------------");
            System.out.printf("|  %-12s  | %-20s | %s  %n","Date","Patient Name"," Health Problem");
            System.out.println("-----------------------------------------------------------------------------");
            for (String lineT = brT.readLine(); lineT != null; lineT = brT.readLine()){
                if(lineT.contains(dFirstName+" "+dLastName)){
                    ArrayList<String> tInfo = new ArrayList<>(Arrays.asList(lineT.split(";")));
                    System.out.printf("|  %-12s  | %-20s | %s  %n",tInfo.get(0),tInfo.get(1),tInfo.get(3));
                    //System.out.print("Date: "+tInfo.get(0)+",   Patient Name: "+tInfo.get(1)+",     Problem: "+ tInfo.get(3)+"\n");
                }
            }
            br.close();
            brT.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-----------------------------------------------------------------------------\n");
        //console.close(); -- let garbage collector take care of it, actually we need it be open for menu.
    } //end of getDoctorPerformRecord method
    //------------------------------------------------------------------------------------------------------------------
    // validate patients and doctor records
    public static boolean validateNameInFile(String listFileName, String searchTerm){
        try {
            BufferedReader br = new BufferedReader(new FileReader(listFileName));
            for (String line = br.readLine(); line != null; line = br.readLine()){
                if(line.contains(searchTerm)){
                    return true;
                }
            }
            return false;
            //br.close();            
            
        } catch (Exception e) {
            System.out.println("Sorry, file not found.");
            System.out.println(e.getMessage());
            return false;
        }
    }
    //-----------------------------------------------------------------------------------------------------------------
}// end of Application class