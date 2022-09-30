/**
 * TODO: Add your file header
 * Name: Matthew Mizumoto
 * ID: A16907397
 * Email: mmizumoto@ucsd.edu
 * Sources used: java.oracle to find the java documentation for using a
 * hashset and hashmap
 * 
 * This file contains the custom tests that test for edge cases for
 * course.java, sanctuary.java, and student.java. These tests also
 * contains some speciic cases that were not tested in public tester.
 */

import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * TODO: Add your class header
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 *
 * This class contains various test cases for some of the more complex
 * methods in the 3 java files that were created.
 */
public class CustomTester {

    // ----------------Student class----------------
    /**
     * Test the equals method when not equal and a non Student object is passed
     */
    @Test
    public void testEquals() {
        Student student1 = new Student(new String("Test"), 
            new String("Student"), new String("A12345678"));
        Student student2 = new Student(new String("Test"), 
            new String("Student"), new String("A87654321"));
        assertFalse(student1.equals(student2));
        assertFalse(student1.equals("Not Student Object"));
    }

    /**
     * Test the compareTo method when CompareTo returns non zero
     */
    @Test
    public void testCompareTo() {
        Student student1 = new Student(new String("Test"), 
            new String("Student"), new String("A12345678"));
        Student student2 = new Student(new String("Test"), 
            new String("Student"), new String("A87654321"));
        assertTrue(student1.compareTo(student2) > 0);
        assertTrue(student2.compareTo(student1) < 0);
    }

    // ----------------Course class----------------
    /**
     * Test the enroll method when student is null
     */
    @Test
    public void testEnroll() {
        Course course = new Course("CSE", "00", "Something", 2);
        try {
            course.enroll(null);
            // Should throw IllegalArgumentException
            fail();
        } catch (IllegalArgumentException e) {
            // do nothing
        }
    }

    /**
     * Test the unenroll method when student is null
     */
    @Test
    public void testUnenroll() {
        Course course = new Course("CSE", "00", "Something", 2);
        try {
            course.enroll(null);
            // Should throw IllegalArgumentException
            fail();
        } catch (IllegalArgumentException e) {
            // do nothing
        }
    }

    /**
     * Test the getRoster method when we have 3 enrolled students and when
     * we have 1 enrolled student
     */
    @Test
    public void testGetRoster() {
        // setting up test for course with 3 students
        Course course = new Course("CSE", "00", "Something", 5);
        Student student1 = new Student(new String("Test"), 
            new String("Student"), new String("A12345678"));
        Student student2 = new Student(new String("Test"), 
            new String("Student"), new String("A87654321"));
        Student student3 = new Student(new String("Test"), 
            new String("Student"), new String("A12348765"));
        course.enroll(student1);
        course.enroll(student2);
        course.enroll(student3);
        ArrayList<Student> roster = new ArrayList<Student>();
        roster.add(student2);
        roster.add(student3);
        roster.add(student1);
        assertEquals(roster, course.getRoster());
        // setting up test for course with 1 student
        Course course2 = new Course("CSE", "01", "Something", 5);
        course2.enroll(student1);
        ArrayList<Student> roster2 = new ArrayList<Student>();
        roster2.add(student1);
        assertEquals(roster2, course2.getRoster());
    }

    // ----------------Sanctuary class----------------
    /**
     * Test the constructor when maxAnimals < 0 and when maxSpecies < 0
     */
    @Test
    public void testSanctuaryConstructor() {
        // Testing when maxAnimals < 0
        try {
            Sanctuary sanct = new Sanctuary(-1, 5);
            // Should throw IllegalArgumentException
            fail();
        } catch (IllegalArgumentException e) {
            // do nothing
        }

        // Testing when maxSpecies < 0
        try {
            Sanctuary sanct = new Sanctuary(50, -1);
            // Should throw IllegalArgumentException
            fail();
        } catch (IllegalArgumentException e) {
            // do nothing
        }
    }

    /**
     * Test the rescue method when there are already some animals of that
     * species in the hashmap
     */
    @Test
    public void testRescueTestOne(){
        Sanctuary sanct = new Sanctuary(50, 5);
        sanct.sanctuary.put("Lion", 20);
        sanct.rescue("Lion", 5);
        assertEquals(25, (int)sanct.sanctuary.get("Lion"));
    }

    /**
     * Test the rescue method when species == null or when num <= 0
     */
    @Test
    public void testRescueTestTwo(){
        Sanctuary sanct = new Sanctuary(50, 5);
        // Testing when num <= 0
        try {
            sanct.rescue("Lion", 0);
            // Should throw IllegalArgumentException
            fail();
        } catch (IllegalArgumentException e) {
            // do nothing
        }

        // Testing when species == null
        try {
            sanct.rescue(null, 10);
            // Should throw IllegalArgumentException
            fail();
        } catch (IllegalArgumentException e) {
            // do nothing
        }
    }

    /**
     * Test the release method when all the animals of a species are released
     */
    @Test
    public void testReleaseTestOne(){
        Sanctuary sanct = new Sanctuary(50, 5);
        sanct.sanctuary.put("Lion", 20);
        assertEquals(1, sanct.sanctuary.size());
        sanct.release("Lion", 20);
        // All Lions are released so the key Lion should be removed.
        assertEquals(0, sanct.sanctuary.size());
    }

    /**
     * Test the release method when num is <= 0, when num is > the number of
     * animals in the species, spcies == null, and when species does not exist
     * in the sanctuary.
     */
    @Test
    public void testReleaseTestTwo(){
        Sanctuary sanct = new Sanctuary(50, 5);
        sanct.sanctuary.put("Lion", 20);
        // Testing when num > the number of animals in the species
        try {
            sanct.release("Lion", 25);
            // Should throw IllegalArgumentException
            fail();
        } catch (IllegalArgumentException e) {
            // do nothing
        }

        // Testing when num is <= 0
        try {
            sanct.release("Lion", 0);
            // Should throw IllegalArgumentException
            fail();
        } catch (IllegalArgumentException e) {
            // do nothing
        }

        // Testing when species is null
        try {
            sanct.release(null, 2);
            // Should throw IllegalArgumentException
            fail();
        } catch (IllegalArgumentException e) {
            // do nothing
        }

        // Testing when species does not exist in the sanctuary
        try {
            sanct.release("Goat", 10);
            // Should throw IllegalArgumentException
            fail();
        } catch (IllegalArgumentException e) {
            // do nothing
        }
    }
}
