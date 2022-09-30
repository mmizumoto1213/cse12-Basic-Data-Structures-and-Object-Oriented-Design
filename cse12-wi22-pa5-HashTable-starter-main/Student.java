/**
 * TODO: Complete the solution for Student
 */
import java.util.Objects;

/**
 * This class creates a student which contains information about the a
 * student
 */
public class Student implements Comparable<Student> {
    private final String firstName;
    private final String lastName;
    private final String PID;

    /**
     * A constructor that creates a student given some information
     * @param firstname - the students firstname
     * @param lastname - the students lastname
     * @param PID - the students PID
     */
    public Student(String firstName, String lastName, String PID) {
        if (firstName == null || lastName == null || PID == null) {
            throw new IllegalArgumentException();
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.PID = PID;
    }

    /**
     * A method that gets the students lastname
     * @return - the students lastname
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * A method that gets the students firstname
     * @return - the students firstname
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * A method that gets the students PID
     * @return - the students PID
     */
    public String getPID() {
        return PID;
    }

    /**
     * A method that checks if two students are equal
     * @param o - The student being compared to
     * @return - a boolean to check if the students are the same
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Student && compareTo((Student)o) == 0) {
            return true;
        }
        return false;
    }

    /**
     * A method that returns a hashcode for a student
     * @param firstname - the students firtname
     * @param lastname - the students lastname
     * @param PID - the students PID
     * @return - a hashcode for this student
     */
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, PID);
    }

    /**
     * A method that compares two students lexicographically
     * @param o - the student being compared to
     * @return - an integer that represents a comparison value
     */
    @Override
    public int compareTo(Student o) {
        // three if statements checking if the lastname, firstname, and
        // PID are not equal
        if (!o.getLastName().equals(lastName)) {
            return o.getLastName().compareTo(lastName);
        }
        if (!o.getFirstName().equals(firstName)) {
            return o.getFirstName().compareTo(firstName);
        }
        if (!o.getPID().equals(PID)) {
            return o.getPID().compareTo(PID);
        }
        // returns 0 if the students are equal
        return 0;
    }
}
