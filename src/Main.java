import java.util.ArrayList;

public class Main {
    static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {

        for(int i = 0; i < 1000; i++){
            Student student = new Student();
            studentList.add(student);
        }

    }


    public static void studentReportExtend() {
        // passing in GPA --> using the GPA constructor --> sets the instance variables accordingly
        StudentReportSystemExtend front = new StudentReportSystemExtend(3.75, 4, true, studentList);
        StudentReportSystemExtend back = new StudentReportSystemExtend(3.75, 4, false, studentList);

        front.start();
        back.start();
        // call start --> which calls run in the child class that we defined
        // it's just subclassing --> it extends thread then when hit start it will call the
    }

    public static void studentReportImplement() {
        StudentReportSystemImplement front = new StudentReportSystemImplement(3.75, 4, true, studentList);
        StudentReportSystemImplement back = new StudentReportSystemImplement(3.75, 4, false, studentList);

        Thread frontThread = new Thread(front); // implement if wrapping the thread object (can only wrap the thread object if implement implements Runnable)
        // implement runnable interface --> implement run --> can go inside constructor parameter of a thread object
        Thread backThread = new Thread(back);
        frontThread.start();
        backThread.start();
        // thread calls start which calls run and in the run is a call to the method that does the stuff

    }

    public static void studentReportExtendLambda() {
        StudentReportSystemLambda lambda = new StudentReportSystemLambda();
        lambda.findStudentsWithinGPARange(studentList, 3.75, 4.0);
        lambda.findStudentsWithNumAbsences(studentList, 5);
    }
}