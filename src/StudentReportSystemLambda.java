import java.util.ArrayList;

public class StudentReportSystemLambda {
    /*
        Your goal is this:
            • You will use multithreading to complete the methods found below.
            • Each method will use two threads to scan the passed ArrayList
                • One thread will start at the front
                • A second thread will start at the end
                • Each thread, upon finding a valid Student object, will add the found entry into a new ArrayList
                    •That new ArrayList is what will be returned
                • Must use a Lambda expression to create a Runnable object to relay within the methods
     */

    /** PRECONDITIONS:
     * classList not null
     * min >= 0.0
     * max <= 4.0
     */
    public ArrayList<Student> findStudentsWithinGPARange(ArrayList<Student> classList,double min, double max) {
        // with this, we can use parameters
        Thread t1, t3; // declare but dont initialize thread
        ArrayList<Student> gpaHits = new ArrayList<>();
        Runnable gpaFront = () -> {
                for(int i = 0; i < classList.size()/2; i++) {
                    if (classList.get(i).getGpa() >= min && classList.get(i).getGpa() <= max) {
                        gpaHits.add(classList.get(i));
                    }
                }
        }; // instance of a method
        // Lambda -- single defined method in the interface
            // only works with functional interfaces (when it only has one method in it)


        t1 = new Thread(gpaFront);
        // for passing in something through the parameter of thread, can either do class that implements Runnable or a Runnable method object
        t1.start(); // still call start on t1


        // Thread t3 = new Thread(class that implements runnable);

        // back
        Runnable gpaBack = () -> {
                for(int i = classList.size(); i >= classList.size()/2; i--){
                    if(classList.get(i).getGpa() >= min && classList.get(i).getGpa() <= max){
                        gpaHits.add(classList.get(i));
                    }
                }
        }; // instance of a method
        // Lambda is shorthand code for defining interface


        t3 = new Thread(gpaBack);
        // for passing in something through the parameter of thread, can either do class that implements Runnable or a Runnable method object
        t3.start(); // still call start on t1
        // don't want return statement to happen before the threads are done
        try {
            t1.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return gpaHits;
    }

    /** PRECONDITIONS:
     * classList not null
     * numOfAbsences >= 0 && <= 10
     */
    public ArrayList<Student> findStudentsWithNumAbsences(ArrayList<Student> classList,int numOfAbsences) {
        Thread t1, t3; // declare but dont initialize thread
        ArrayList<Student> gpaHits = new ArrayList<>();
        Runnable gpaFront = () -> {
            for(int i = 0; i < classList.size()/2; i++) {
                if (classList.get(i).getAbsenceCount() == numOfAbsences) {
                    gpaHits.add(classList.get(i));
                }
            }
        }; // instance of a method
        // Lambda -- single defined method in the interface
        // only works with functional interfaces (when it only has one method in it)


        t1 = new Thread(gpaFront);
        // for passing in something through the parameter of thread, can either do class that implements Runnable or a Runnable method object
        t1.start(); // still call start on t1


        // Thread t3 = new Thread(class that implements runnable);

        // back
        Runnable gpaBack = () -> {
            for(int i = classList.size(); i >= classList.size()/2; i--){
                if(classList.get(i).getAbsenceCount() == numOfAbsences){
                    gpaHits.add(classList.get(i));
                }
            }
        }; // instance of a method


        t3 = new Thread(gpaBack);
        // for passing in something through the parameter of thread, can either do class that implements Runnable or a Runnable method object
        t3.start(); // still call start on t1
        // don't want return statement to happen before the threads are done
        try {
            t1.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return gpaHits;
    }
}
