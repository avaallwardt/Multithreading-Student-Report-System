public class Student extends Person{
    private double gpa;
    private int absenceCount;

    public Student() {
        //GPA should generate a random number from 0 to 4, including decimals. For example, 3.4 should be a possible GPA value.
        //Absence count should be randomized from a range of 0-10, inclusive.
        gpa = (Math.random() * 5); // range = max - min + 1
        absenceCount = (int) (Math.random() * 11);
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getAbsenceCount() {
        return absenceCount;
    }

    public void setAbsenceCount(int absenceCount) {
        this.absenceCount = absenceCount;
    }
}
