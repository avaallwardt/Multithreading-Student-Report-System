import java.lang.reflect.Array;
import java.util.ArrayList;

public class StudentReportSystemImplement implements Runnable{
    /*
        Your goal is this:
            • You will use multithreading to complete the methods found below.
            • Each method will use two threads to scan the passed ArrayList
                • One thread will start at the front
                • A second thread will start at the end
                • Each thread, upon finding a valid Student object, will add the found entry into a new ArrayList
                    •That new ArrayList is what will be returned
                • Must implement the Runnable interface.
                • You may make modifications to this class as needed to complete the below methods.
     */
    boolean isGPA; // GPA = true, Absence = false
    boolean isFront; // front = true, absence = false
    ArrayList<Student> studentList = new ArrayList<>();

    static ArrayList<Student> resultList = new ArrayList<>(); // by making resultList static, the two threads can add found students into the same list

    double minGPA;
    double maxGPA;
    int numAbsences;

    // we know if it wants by gpa or absences based on which one to use
    public StudentReportSystemImplement(double minGPA, double maxGPA, boolean isFront, ArrayList<Student> theStudentList){
        isGPA = true;
        this.minGPA = minGPA;
        this.maxGPA = maxGPA;
        this.isFront = isFront;
        studentList = theStudentList;
    }

    public StudentReportSystemImplement(int numAbsences, boolean isFront, ArrayList<Student> theStudentList){
        isGPA = false;
        this.numAbsences = numAbsences;
        this.isFront = isFront;
        studentList = theStudentList;
    }

    /** PRECONDITIONS:
     * classList not null
     * min >= 0.0
     * max <= 4.0
     */
    public void findStudentsWithinGPARange() {
        if (isFront) {
            for (int i = 0; i < studentList.size() / 2; i++) {
                System.out.println("Checking front: " + isFront);
                if ((studentList.get(i).getGpa() >= minGPA) && (studentList.get(i).getGpa() <= maxGPA)) {
                    resultList.add(studentList.get(i));
                }
            }
        } else {
            for (int i = studentList.size() - 1; i >= studentList.size() / 2; i--) {
                System.out.println("Checking front: " + isFront);
                if ((studentList.get(i).getGpa() >= minGPA) && (studentList.get(i).getGpa() <= maxGPA)) {
                    resultList.add(studentList.get(i));
                }
            }
        }
    }

    /** PRECONDITIONS:
     * classList not null
     * numOfAbsences >= 0 && <= 10
     */
    public void findStudentsWithinAbsenceRange() {
        if (isFront) {
            for (int i = 0; i < studentList.size() / 2; i++) {
                System.out.println("Checking front: " + isFront);
                if (studentList.get(i).getAbsenceCount() == numAbsences) {
                    resultList.add(studentList.get(i));
                }
            }
        } else {
            for (int i = studentList.size() - 1; i >= studentList.size() / 2; i--) {
                System.out.println("Checking front: " + isFront);
                if (studentList.get(i).getAbsenceCount() == numAbsences) {
                    resultList.add(studentList.get(i));
                }
            }
        }
    }

    @Override
    public void run(){
        if(isGPA){
            findStudentsWithinGPARange();
        }
        else{
            findStudentsWithinAbsenceRange();
        }
    }


}