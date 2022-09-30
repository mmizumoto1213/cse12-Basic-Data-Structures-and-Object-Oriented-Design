/**
 * TODO: Complete the solution for Course
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * This class creates a corse which contains information about the corse
 * and the students enrolled in the course.
 */
public class Course {
    HashSet<Student> enrolled;
    private final int capacity;
    private final String department;
    private final String number;
    private final String description;

    /**
     * Constructor to create the course given the course information
     * @param department - the initials for the course department
     * @param number - the number for the course
     * @param description - slight information about the course topic
     * @param capacity - the course capacity for students
     */
    public Course(String department, String number, String description, 
        int capacity){
            if (department == null || number == null || 
            description == null || capacity < 0) {
                throw new IllegalArgumentException();
            }
            this.capacity = capacity;
            this.department = department;
            this.number = number;
            this.description = description;
            enrolled = new HashSet<>();
        }

    /** 
     * A method to get the department
     * @return - department of course
     */
    public String getDepartment(){
        return department;
    }

    /** 
     * A method to get the number
     * @return - number of course
     */
    public String getNumber(){
        return number;
    }

    /** 
     * A method to get the description
     * @return - description of course
     */
    public String getDescription(){
        return description;
    }

    /** 
     * A method to get the capacity
     * @return - capacity of course
     */
    public int getCapacity(){
        return capacity;
    }

    /**
     * A method to enroll a student into a course
     * @param student - the student being enrolled into the course
     * @return - a boolean to show is the enrollment was successful
     */
    public boolean enroll(Student student) {
        if (student == null) {
            throw new IllegalArgumentException();
        }
        if (!enrolled.contains(student) && enrolled.size() < capacity) {
            enrolled.add(student);
            return true;
        }
        return false;
    }

    /**
     * A method to unenroll a student from a course
     * @param student - the student being unenrolled from the course
     * @return - a boolean to show is the unenrollment was successful
     */
    public boolean unenroll(Student student) {
        if (student == null) {
            throw new IllegalArgumentException();
        }
        if (enrolled.contains(student)) {
            enrolled.remove(student);
            return true;
        }
        return false;
    }

    /**
     * A method to cancel a course by unenrolling a students
     */
    public void cancel() {
        enrolled.clear();
    }

    /**
     * A method to check if a course has reached maximum capacity
     * @return - a boolean to check if it is at max capcity
     */
    public boolean isFull() {
        if (enrolled.size() == capacity) {
            return true;
        }
        return false;
    }

    /**
     * A method to get the amount of students enrolled in a course
     * @return - the number of students enrolled in the course
     */
    public int getEnrolledCount() {
        return enrolled.size();
    }

    /**
     * A method to get the number of available seats in a course
     * @return - the number of available seats
     */
    public int getAvailableSeats() {
        return capacity - enrolled.size();
    }

    /**
     * A method to get a shallow copy of the hashset of enrolled students
     * @return - a shadow copy of a hashset of the enrolled students
     */
    public HashSet<Student> getStudents() {
        return (HashSet<Student>)enrolled.clone();
    }

    /**
     * A method to get the roster of the enrolled students in an arraylist
     * @return - an arraylist of the enrolled students in the course
     */
    public ArrayList<Student> getRoster() {
        ArrayList<Student> toReturn = new ArrayList<Student>();
        // converts enrolled to an array and adds each index to the arraylist
        for (int i = 0; i < enrolled.size(); i++) {
            toReturn.add((Student)enrolled.toArray()[i]);
        }
        Collections.sort(toReturn);
        return toReturn;
    }

    /**
     * A method to print the course information
     * @return - A string of the course information
     */
    public String toString() {
        return department + " " + number + " " + "[" + capacity + "]" +
            "\n" + description;
    }
}
