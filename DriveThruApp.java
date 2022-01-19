/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivethru;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Arief Fahmi
 */
public class DriveThruApp {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     * 
     * keep arraylist data/
     * less depend on file/
     * 
     * total = rent * hours/
     * update
     * search
     * sorting
     */
    
    
    
    public static void main(String[] args) throws Exception{
        
        cls();
        
        //variable declaration
        
        Scanner sc = new Scanner(System.in);
        
        Student s = new Student();
        ArrayList stuList = new ArrayList();
        
        Car c = new Car();
        LinkedList carList = new LinkedList();
        
        Queue q = new Queue();
        
        File fStudent = new File("student.txt");
        File fCar = new File("new car.txt");
        File fQueue = new File("queue.txt");
        
        if(fStudent.exists()){
            System.out.println("Student file already exists.");
            System.out.print("Load existing file? (y/n): ");
            String load = sc.nextLine();
            if(load.equalsIgnoreCase("y")){
                stuList = loadStudentFile();
                System.out.println("Student file load successful.");
            }
            else{System.out.println("Student file load cancelled.");}
        }else{fStudent.createNewFile();}
        
        System.out.println();
        
        if(fCar.exists()){
            System.out.println("Car file already exists.");
            System.out.print("Load existing file? (y/n): ");
            String load = sc.nextLine();
            if(load.equalsIgnoreCase("y")){
                carList = loadCarFile();
                System.out.println("Car file load successful.");
            }
            else{System.out.println("Car file load cancelled.");}
        }else{fCar.createNewFile();}
        
        System.out.println();
        
        if(fQueue.exists()){
            System.out.println("Queue file already exists.");
            System.out.print("Load existing file? (y/n): ");
            String load = sc.nextLine();
            if(load.equalsIgnoreCase("y")){
                q = loadQueueFile();
                System.out.println("Queue file load successful.");
            }
            else{System.out.println("Queue file load cancelled.");}
        }else{fQueue.createNewFile();}
        
        System.out.println();
        
        pause();
        
        int option = 99;
        
        for(;;){
            
            option = menu();
            
            switch (option) {
                case 11:
                    stuList = inputStudentData(stuList);
                    pause();
                    break;
                case 12:
                    carList = inputCarData(carList);
                    pause();
                    break;
                case 21:
                    stuList = updateStudentData(stuList);
                    pause();
                    break;
                case 22:
                    carList = updateCarData(carList);
                    pause();
                    break;
                case 31:
                    deleteStudentData(stuList);
                    pause();
                    break;
                case 32:
                    carList = deleteCarData(carList);
                    pause();
                    break;
                case 41:
                    if(!stuList.isEmpty()){
                        stuList = sortStudentList(stuList);
                        
                        cls();
                        displayStudentList(stuList);
                    }else{System.err.print("Student list is empty. ");}
                    pause();
                    break;
                case 42:
                    if(!carList.isEmpty()){
                        carList = sortCarList(carList);
                        
                        cls();
                        displayCarList(carList);
                    }else{System.err.print("Car list is empty. ");}
                    pause();
                    break;
                case 43:
                    if(!q.isEmpty()){
                        
                        cls();
                        displayQueueList(q);
                    }else{System.err.print("Queue is empty. ");}
                    pause();
                    break;
                case 51:
                    {
                        Object[] obj = addToQueue(stuList, carList, q);
                        stuList = (ArrayList) obj[0];
                        carList = (LinkedList) obj[1];
                        q = (Queue) obj[2];
                        pause();
                        break;
                    }
                case 52:
                    {
                        Object[] obj = removeFromQueue(stuList, carList, q);
                        stuList = (ArrayList) obj[0];
                        carList = (LinkedList) obj[1];
                        q = (Queue) obj[2];
                        pause();
                        break;
                    }
                case 61:
                    stuList.clear();
                    stuList = loadStudentFile();
                    carList.clear();
                    carList = loadCarFile();
                    q.clear();
                    q = loadQueueFile();
                    System.out.println("Load successful.");
                    pause();
                    break;
                case 62:
                    if(fStudent.exists()){
                        System.out.println("Student file already exists.");
                        System.out.print("Overwrite? (y/n): ");
                        String overwrite = sc.nextLine();
                        
                        if(overwrite.equalsIgnoreCase("y")){
                            saveStudentFile(stuList);
                            System.out.println("Student list saved.");
                        }
                        else{System.out.println("Save cancelled.");}
                    }   if(fCar.exists()){
                        System.out.println("Car file already exists.");
                        System.out.print("Overwrite? (y/n): ");
                        String overwrite = sc.nextLine();
                        
                        if(overwrite.equalsIgnoreCase("y")){
                            saveCarFile(carList);
                            System.out.println("Car list saved.");
                        }
                        else{System.out.println("Save cancelled.");}
                    }   if(fQueue.exists()){
                        System.out.println("Queue file already exists.");
                        System.out.print("Overwrite? (y/n): ");
                        String overwrite = sc.nextLine();
                        
                        if(overwrite.equalsIgnoreCase("y")){
                            saveQueueFile(q);
                            System.out.println("Queue list saved.");
                        }
                        else{System.out.println("Save cancelled.");}
                    }   pause();
                    break;
                case 0:
                    System.out.println("Any unsaved changes will be lost. ");
                    System.out.print("Continue? (y/n): ");
                    String exitFlag = sc.nextLine();
                    if(exitFlag.equalsIgnoreCase("y")){System.exit(0);}
                    pause();
                    break;
                default:
                    break;
            }
        }
    }
    
    //user interface methods
    
    public static void cls(){System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");}

    public static void pause(){
        Scanner pause = new Scanner(System.in);
        
        System.out.print("Press Enter to continue...");
        pause.nextLine();
    }

    public static int menu(){
        
        int option = 99;
        
        cls();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("DriveThru");
        System.out.println("");
        System.out.println("11. Register new student");
        System.out.println("12. Register new car");
        System.out.println("");
        System.out.println("21. Update student data");
        System.out.println("22. Update car data");
        System.out.println("");
        System.out.println("31. Delete student data");
        System.out.println("32. Delete car data");
        System.out.println("");
        System.out.println("41. Display student list");
        System.out.println("42. Display car list");
        System.out.println("43. Display queue list");
        System.out.println("");
        System.out.println("51. Assign car to student");
        System.out.println("52. Return car from student");
        System.out.println("");
        System.out.println("61. Load data from file");
        System.out.println("62. Save data to file");
        System.out.println("");
        System.out.println("0. Exit");
        System.out.println("");
        System.out.print("Enter option: ");
        
        try{
            option = parseInt(sc.nextLine());
        }
        catch (NumberFormatException nfe) {
            System.err.println("Invalid input");
            pause();
        }
        
        
        cls();
        
        return option;
    }
    
    //sorting methods
    
    public static ArrayList sortStudentList(ArrayList stuList){
        
        Scanner sc = new Scanner(System.in);
        
        int choice = 99;
        
        System.out.println("Sort by: ");
        System.out.println("11. Student ID (ascending)");
        System.out.println("12. Student ID (descending)");
        System.out.println("21. Name (ascending)");
        System.out.println("22. Name (descending)");
        System.out.println("31. Phone (ascending)");
        System.out.println("32. Phone (descending)");
        
        System.out.print("Enter choice: ");
        
        try{
            choice = Integer.parseInt(sc.nextLine());
        }
        catch (NumberFormatException nfe) {
            System.err.println("Invalid input");
            pause();
        }
        
        switch (choice) {
            case 11:
                Collections.sort(stuList, new StudentSortById());
                break;
            case 12:
                Collections.sort(stuList, new StudentSortById().reversed());
                break;
            case 21:
                Collections.sort(stuList, new StudentSortByName());
                break;
            case 22:
                Collections.sort(stuList, new StudentSortByName().reversed());
                break;
            case 31:
                Collections.sort(stuList, new StudentSortByPhone());
                break;
            case 32:
                Collections.sort(stuList, new StudentSortByPhone().reversed());
                break;
        }  
        
        return stuList;
    }
    
    public static LinkedList sortCarList(LinkedList carList){
        
        ArrayList tempList = new ArrayList();
        
        Object o = (Car) carList.getFirst();
        
        while(o != null){
        
            tempList.add(o);
            o = (Car) carList.getNext();
        }
        
        Scanner sc = new Scanner(System.in);
        
        int choice = 99;
        
        System.out.println("Sort by: ");
        System.out.println("11. Car Registration (ascending)");
        System.out.println("12. Car Registration (descending)");
        System.out.println("21. Make & Model (ascending)");
        System.out.println("22. Make & Model (descending)");
        System.out.println("31. Transmission (ascending)");
        System.out.println("32. Transmission (descending)");
        System.out.println("41. Rate (ascending)");
        System.out.println("42. Rate (descending)");
        
        System.out.print("Enter choice: ");
        
        try{
            choice = Integer.parseInt(sc.nextLine());
        }
        catch (NumberFormatException nfe) {
            System.err.println("Invalid input");
            pause();
        }
        
        switch (choice) {
            case 11:
                Collections.sort(tempList, new CarSortByRegistration());
                break;
            case 12:
                Collections.sort(tempList, new CarSortByRegistration().reversed());
                break;
            case 21:
                Collections.sort(tempList, new CarSortByMakeModel());
                break;
            case 22:
                Collections.sort(tempList, new CarSortByMakeModel().reversed());
                break;
            case 31:
                Collections.sort(tempList, new CarSortByTransmission());
                break;
            case 32:
                Collections.sort(tempList, new CarSortByTransmission().reversed());
                break;
            case 41:
                Collections.sort(tempList, new CarSortByRate());
                break;
            case 42:
                Collections.sort(tempList, new CarSortByRate().reversed());
                break;
        }
        
        carList.clear();
        
        for(int i=0; i<tempList.size(); i++){
            o = (Car) tempList.get(i);
            
            carList.insertAtBack(o);
        }
        
        return carList;
    }
    
    //methods to load file
    
    public static ArrayList loadStudentFile() throws FileNotFoundException, IOException{
        
        Student s;
        ArrayList stuList = new ArrayList();
        File fStudent = new File("student.txt");
        
        if (!fStudent.exists()) {
            fStudent.createNewFile();
        }

        FileReader frStudent = new FileReader(fStudent);
        BufferedReader brStudent = new BufferedReader(frStudent);

        String sLine = brStudent.readLine();

        while(sLine != null){
            String splitStudent[] = sLine.split(", ");
            s = new Student(splitStudent[0], splitStudent[1], splitStudent[2], splitStudent[3], Boolean.parseBoolean(splitStudent[4]));
            stuList.add(s);

            sLine = brStudent.readLine();
        }
        
        return stuList;
    }
    
    public static LinkedList loadCarFile() throws FileNotFoundException, IOException{
        
        Car c;
        LinkedList carList = new LinkedList();
        
        File fCar = new File("car.txt");
        if (!fCar.exists()) {fCar.createNewFile();}
        
        FileReader frCar = new FileReader(fCar);
        BufferedReader brCar = new BufferedReader(frCar);

        String cLine = brCar.readLine();

        while(cLine != null){
            String splitCar[] = cLine.split(", ");
            c = new Car(splitCar[0], splitCar[1], splitCar[2], splitCar[3], Double.parseDouble(splitCar[4]), splitCar[5], Boolean.parseBoolean(splitCar[6]));
            carList.insertAtBack(c);

            cLine = brCar.readLine();
        }
        
        return carList;
    }
    
    public static Queue loadQueueFile() throws FileNotFoundException, IOException{
        
        Queue q = new Queue();
        
        File fQueue = new File("queue.txt");
        if (!fQueue.exists()) {fQueue.createNewFile();}    
            
        FileReader frQueue = new FileReader(fQueue);
        BufferedReader brQueue = new BufferedReader(frQueue);
        
        String qLine = brQueue.readLine();
        
        while(qLine != null){
            q.enqueue(qLine);
            
            qLine = brQueue.readLine();
        }
        
        return q;
    }
    
    //methods to update file
    
    public static void saveStudentFile(ArrayList stuList) throws FileNotFoundException, IOException{
        
        Student s;
        
        File fStudent = new File("student.txt");
        if (!fStudent.exists()) {fStudent.createNewFile();}
        
        try (FileWriter fwStudent = new FileWriter(fStudent); BufferedWriter bwStudent = new BufferedWriter(fwStudent); PrintWriter pwStudent = new PrintWriter(bwStudent)) {
            
            for (int i=0; i < stuList.size(); i++){
                s = (Student) stuList.get(i);
                pwStudent.print(s.getID() + ", " + s.getName() + ", " + s.getPhone() + ", " + s.getCurCarReg() + ", " + s.getBookStatus() + "\n");
            }
            
        }
    }
    
    public static void saveCarFile(LinkedList carList) throws FileNotFoundException, IOException{
        Car c;
        
        File fCar = new File("car.txt");
        
        if (!fCar.exists()){fCar.createNewFile();}
        
        try (FileWriter fwCar = new FileWriter(fCar); BufferedWriter bwCar = new BufferedWriter(fwCar); PrintWriter pwCar = new PrintWriter(bwCar)) {
            
            c = (Car) carList.getFirst();
            
            while(c != null){
                
                pwCar.print(c.getRegistration() + ", " + c.getMake() + ", " + c.getModel() + ", " + c.getTransmission() + ", " + c.getRate() + ", " + c.getCurStuID() + ", " + c.getBookStatus() + "\n");
                
                c = (Car) carList.getNext();
            }
            
        }
        
    }
    
    public static void saveQueueFile(Queue q) throws FileNotFoundException, IOException{
        
        File fQueue = new File("queue.txt");
        
        if (!fQueue.exists()) {fQueue.createNewFile();}
        
        try (FileWriter fwQueue = new FileWriter(fQueue); BufferedWriter bwQueue = new BufferedWriter(fwQueue); PrintWriter pwQueue = new PrintWriter(bwQueue)) {
            
            Object obj = q.getFirst();
            String qLine = String.valueOf(obj);
            
            while(obj != null){
                
                pwQueue.println(qLine);
                
                obj = q.getNext();
                qLine = String.valueOf(obj);
            }
            
        }
    }
    
    //methods for user input
    
    public static ArrayList inputStudentData(ArrayList stuList) throws IOException{
        
        //variable declaration
        
        Scanner sc = new Scanner(System.in);
        
        Student s = new Student();
        
        File fStudent = new File("student.txt");
        
        if (!fStudent.exists()) {
            fStudent.createNewFile();
        }
        
        for (;;){

            
            //input student details

            System.out.println("\n\n\n");

            System.out.println("Enter Student ID 0 to stop");

            System.out.println("\n");

            System.out.print("Student ID (e.g 20161234567): ");
            String id = sc.nextLine();

            if(id.equalsIgnoreCase("0")){break;}
            
            for(int i=0; i<stuList.size(); i++){
                
                s = (Student) stuList.get(i);
                
                if(id.equalsIgnoreCase(s.getID()))
                {
                    System.err.println("Student already exists.");
                    return stuList;
                }
            }

            System.out.print("Student name (e.g Ahmad bin Abu): ");
            String name = sc.nextLine();

            System.out.print("Student phone (e.g 0123456789): ");
            String phone = sc.nextLine();

            s = new Student(id, name, phone, "", false);
            stuList.add(s);            
        }
        
        return stuList;
    }
    
    public static LinkedList inputCarData(LinkedList carList) throws IOException{
        
        //variable declaration
        Scanner sc = new Scanner(System.in);
        
        Car c = new Car();
        
        File fCar = new File("car.txt");
        if (!fCar.exists()) {fCar.createNewFile();}
        
        for (;;){
            System.out.println("\n\n\n");

            System.out.println("Enter Car Registration 0 to stop");

            System.out.println("\n");

            System.out.print("Car registration (e.g WXX1234): ");
            String carRegistration = sc.nextLine();

            if(carRegistration.equalsIgnoreCase("0")){break;}
            
            c = (Car) carList.getFirst();
            
            while(c != null){
                if(carRegistration.equalsIgnoreCase(c.getRegistration()))
                {
                    System.err.println("Car already exists.");
                    return carList;
                }
                else{c = (Car) carList.getNext();}
            }

            System.out.print("Car make (e.g Proton): ");
            String carMake = sc.nextLine();

            System.out.print("Car model (e.g Saga): ");
            String carModel = sc.nextLine();

            System.out.print("Car transmission (a/m): ");
            String carTransmission = sc.nextLine();
            
            System.out.print("Car rate (e.g RM7.00): RM");
            double carRate = Double.parseDouble(sc.nextLine());

            c = new Car(carRegistration, carMake, carModel, carTransmission, carRate, "", false);
            carList.insertAtBack(c);
        }
        
        return carList;
    }
    
    //methods to update data
    
    public static ArrayList updateStudentData(ArrayList stuList){
        
        int i = 0;
        boolean stuFound = false;
        
        Scanner sc = new Scanner(System.in);
        
        Student s = new Student();
        
        for(;;){
        
            System.out.println("\n\n\n");

            System.out.println("Enter 0 to cancel");

            System.out.print("Student ID: ");
            String input = sc.nextLine();

            if(input.equalsIgnoreCase("0")){break;}

            for (i=0; i<stuList.size(); i++){
                s = (Student) stuList.get(i);

                if(s.getID().equalsIgnoreCase(input) && !s.getBookStatus()){
                    System.out.println("Student found");
                    stuFound = true;
                    
                    System.out.print("Student name (e.g Ahmad bin Abu): ");
                    String name = sc.nextLine();

                    System.out.print("Student phone (e.g 0123456789): ");
                    String phone = sc.nextLine();

                    Student s2 = new Student(s.getID(), name, phone, "", false);
                    stuList.set(i, s2);
                    
                    System.out.println("Student data update successful.");
                    
                    break;
                }
                else if(!s.getID().equalsIgnoreCase(input)){stuFound = false;}
                else if(s.getBookStatus()){
                    stuFound = true;
                    System.err.println("Student " + s.getID() + " must return car " + s.getCurCarReg() + " before data update can be done");
                    break;
                }
                
            }
            
            if(!stuFound){System.err.println("Student not found");}
            
            
        }
        
        return stuList;
    }
    
    public static LinkedList updateCarData(LinkedList carList){
        Scanner sc = new Scanner(System.in);
        
        Car c = new Car();
        
        boolean carFound = false;
        
            System.out.println("\n\n\n");

            System.out.println("Enter 0 to cancel");
            
            

            System.out.print("Car Registration: ");
            String input = sc.nextLine();
            
            if(input.equalsIgnoreCase("0")){return carList;}
            
            c = (Car) carList.getFirst();
            
            while(c != null){
                if(input.equalsIgnoreCase(c.getRegistration())){
                    carFound = true;
                    carList.getNext();
                    break;
                }
                else{
                    c = (Car) carList.getNext();
                }
            }
            
            if(carFound){
                System.out.println("Car found");
                
                if(!c.getBookStatus()){

                    System.out.print("Car make (e.g Proton): ");
                    c.setMake(sc.nextLine());

                    System.out.print("Car model (e.g Saga): ");
                    c.setModel(sc.nextLine());

                    System.out.print("Car transmission (a/m): ");
                    c.setTransmission(sc.nextLine());

                    System.out.print("Car rate (e.g RM7.00): RM");
                    c.setRate(Double.parseDouble(sc.nextLine()));
                    
                    System.out.println("Car data update successful.");
                }else{
                    System.err.println("Student " + c.getCurStuID() + " must return car " + c.getRegistration() + " before data update can be done");
                }
                
            }else{System.err.println("Car not found");}
            
        return carList;
    }
    
    //methods to delete data
    
    public static ArrayList deleteStudentData(ArrayList stuList){
        
        int i=0;
        boolean stuFound = false;
        
        Scanner sc = new Scanner(System.in);
        
        Student s = new Student();
        
        for(;;){
        
            System.out.println("\n\n\n");

            System.out.println("Enter 0 to cancel");

            System.out.print("Student ID: ");
            String input = sc.nextLine();

            if(input.equalsIgnoreCase("0")){break;}

            for (i=0; i<stuList.size(); i++){
                s = (Student) stuList.get(i);

                if(s.getID().equalsIgnoreCase(input) && !s.getBookStatus()){
                    System.out.println("Student found");
                    stuFound = true;
                    stuList.remove(i);
                    
                    System.out.println("Student data delete successful.");
                    break;
                }
                else if(!s.getID().equalsIgnoreCase(input)){stuFound = false;}
                else if(s.getBookStatus()){
                    stuFound = true;
                    System.err.println("Student " + s.getID() + " must return car " + s.getCurCarReg() + " before data deletion can be done");
                    break;
                }
                
            }
            
            if(!stuFound){System.err.println("Student not found");}
            
            
        }
        
        return stuList;
    }
    
    public static LinkedList deleteCarData(LinkedList carList){
        Scanner sc = new Scanner(System.in);
        
        Car c = new Car();
        Car c2 = new Car();
        LinkedList temp = new LinkedList();
        
        boolean carFound = false;
        
            System.out.println("\n\n\n");

            System.out.println("Enter 0 to cancel");

            System.out.print("Car Registration: ");
            String input = sc.nextLine();
            
            c = (Car) carList.getFirst();
            
            while(c != null){
                if(input.equalsIgnoreCase(c.getRegistration())){
                    carFound = true;
                    c2 = c;
                    c = (Car) carList.getNext();
                }
                temp.insertAtBack(c);
                c = (Car) carList.getNext();
            }
            
            if(carFound){
                System.out.println("Car found");
                
                System.out.println("Car make & model: " + c2.getMake() + " " + c2.getModel());
                
                if(!c2.getBookStatus()){
                    System.out.println("Car data delete successful.");
                    
                    carList = temp;
                }else{
                    System.err.println("Student " + c2.getCurStuID() + " must return car " + c2.getRegistration() + " before data update can be done");
                }
                
            }else{System.err.println("Car not found");}
            
        return carList;
    }
    
    //methods to display data
    
    public static void displayStudentList(ArrayList stuList){
        
        Student s;
        
        System.out.println("Student List");
                
        System.out.println("\n");

        System.out.printf("%3s %12s %30s %15s", "No.", "Student ID", "Name", "Phone");
        System.out.println();

            for (int i=0; i<stuList.size(); i++){
                s = (Student) stuList.get(i);
                System.out.format("%3s %12s %30s %15s", (i+1), s.getID(), s.getName(), s.getPhone());
                System.out.println();
            }

        System.out.println("");
    }
    
    public static void displayCarList(LinkedList carList){
        Car c;
    
        System.out.println("Car List");
                
        System.out.println("\n");

        System.out.printf("%3s %2s %9s %10s %15s %10s", "No. ", "Car Registration", "Make", "Model", "Transmission", "Rate (RM)");
        System.out.println();

        c = (Car) carList.getFirst();
        int i=0;

        while(c != null){
            System.out.format("%3s %8s %18s %10s %15s %10s", (i+1), c.getRegistration(), c.getMake(), c.getModel(), c.displayTransmission(), String.format("%,.2f", c.getRate()));
            System.out.println();
            c = (Car) carList.getNext();
            i++;
        }

        System.out.println("");
    }
    
    public static void displayQueueList(Queue q){
        
        System.out.println("Queue List");
                
        System.out.println("\n");

        System.out.printf("%3s %12s %20s %18s", "No.", "Student ID", "Car Registration", "Total due (RM)");
        System.out.println();

        int i=0;
        
        
        String qLine = String.valueOf(q.getFirst());
        String[] splitQueue = qLine.split(", ");
        
        while(splitQueue.length > 1){
            
            System.out.printf("%3s %12s %11s %18s", (i+1), splitQueue[0], splitQueue[1], String.format("%.2f", Double.parseDouble(splitQueue[2])));
            System.out.println();
                        
            qLine = String.valueOf(q.getNext());
            
            splitQueue = qLine.split(", ");

            i++;
        }

        System.out.println();
}
    
    //methods to manage queue
    
    public static Object[] addToQueue(ArrayList stuList, LinkedList carList, Queue q) throws FileNotFoundException, IOException{
        
        if(!stuList.isEmpty()){
            if(!carList.isEmpty()){
                
                String qFlag = "y";

                while(qFlag.equalsIgnoreCase("y")){
                    
                    cls();
                    
                    Scanner sc = new Scanner(System.in);

                    Student s = new Student();
                    Car c = new Car();

                    String qStuID = "";
                    String qCarReg = "";

                    boolean stuFound = false;
                    boolean carFound = false;

                    System.out.println("Assign car to student");
                    System.out.println("\n\n\n");
                    System.out.print("Student ID: ");

                    qStuID = sc.nextLine();

                    for (int i=0; i<stuList.size(); i++){
                        s = (Student) stuList.get(i);

                        if(qStuID.equalsIgnoreCase(s.getID())){
                            stuFound=true;
                            break;
                        }
                        else {stuFound=false;}
                    }   

                    if(stuFound){
                        System.out.println("Student found");
                        System.out.println("Student name: " + s.getName());

                        if(!s.getBookStatus()){

                            System.out.print("Car registration: ");
                            qCarReg = sc.nextLine();

                            System.out.println();

                            c = (Car) carList.getFirst();

                            while (c != null){
                                if(qCarReg.equalsIgnoreCase(c.getRegistration())){
                                    carFound=true;
                                    break;
                                }
                                else {carFound=false;}

                                c = (Car) carList.getNext();
                            }

                            if(carFound){
                                
                                System.out.println("Car found");
                                System.out.println("Car make & model: " + c.getMake() + " " + c.getModel());

                                if(!c.getBookStatus()){

                                    System.out.print("Rental hours: ");
                                    double hours = Integer.parseInt(sc.nextLine());

                                    double total = c.getRate() * hours;

                                    String carStuQ = (s.getID() + ", " + c.getRegistration() + ", " + String.format("%.2f", total));

                                    s.setBookStatus(true);
                                    s.setCurCarReg(c.getRegistration());

                                    c.setBookStatus(true);
                                    c.setCurStuID(s.getID());

                                    q.enqueue(carStuQ);

                                    System.out.println();
                                    System.out.println("Student " + s.getID() + " successfully assigned to car " + c.getRegistration());
                                }
                                else {System.err.println("Car " + c.getRegistration() + " has already been assigned to student " + c.getCurStuID());}
                            }
                            else {System.err.println("Car not found");}

                        }else {System.err.println("Student " + s.getID() + " has already been assigned to car " + s.getCurCarReg());}

                    }    
                    else {System.err.println("Student not found");}

                    System.out.print("Continue? (y/n): ");
                    qFlag = sc.nextLine();
                }
            }else{System.err.print("Car list is empty. ");}
        }else{System.err.print("Student list is empty. ");}
        
        Object[] obj = new Object[3];
        obj[0] = stuList;
        obj[1] = carList;
        obj[2] = q;
        
        return obj;
    }
    
    public static Object[] removeFromQueue(ArrayList stuList, LinkedList carList, Queue q) throws FileNotFoundException, IOException{
        
        Scanner sc = new Scanner(System.in);
        
        Student s = new Student();
        Car c = new Car();
        
        Object o = null;
        
        //System.out.println("Return car");
                
        String dqFlag = "y";
        
        cls();

        while (dqFlag.equalsIgnoreCase("y")) {
            
            o = q.dequeue();
            
            if(o != null){
                
                String dq[] = o.toString().split(", ");
                
                for (int i=0; i<stuList.size(); i++){
                    s = (Student) stuList.get(i);

                    if(dq[0].equalsIgnoreCase(s.getID())){
                        s.setBookStatus(false);
                        s.setCurCarReg("");
                    }
                }

                c = (Car) carList.getFirst();

                while(c != null){
                    if(dq[1].equalsIgnoreCase(c.getRegistration()))
                        c.setBookStatus(false);
                        c.setCurStuID("");

                    c = (Car) carList.getNext();
                }

                System.out.println("\n\n\n");

                System.out.println("Student ID: " + dq[0]);
                System.out.println("Car Registration: " + dq[1]);
                System.out.println("Total Amount Due (RM): " + dq[2]);
            
            }
            else{System.err.print("Queue is empty. ");}

            System.out.print("Continue? (y/n): ");
            dqFlag = sc.nextLine();
        }
        
        Object[] obj = new Object[3];
        obj[0] = stuList;
        obj[1] = carList;
        obj[2] = q;
        
        return obj;
    }
}