package com.guild.schedule;

import com.guild.schedule.MagicCourse;
import java.util.ArrayList;
import java.util.List;

public class MagicCourseTest {

    public static void main(String[] args) {
        System.out.println("=== Object Creation Test ===");

        //create an object using the no-argument constructor
        MagicCourse c1 = new MagicCourse(); //tp test default value(noset, null)
        
        //create objects using parameterized constructor
        MagicCourse c2 = new MagicCourse("Fire Magic", "Monday", 9, 11);
        MagicCourse c3 = new MagicCourse("Frost Spell", "Monday", 10,12);

        //display total number of courses created
        System.out.println("Total courses after creation: " + MagicCourse.getTotalCourses()); 

        System.out.println("\n=== Invalid Input Test ===");

        //test setting courseName to empty string
        try {
            c1.setCourseName("");   //empty name
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception for empty courseName: " + e.getMessage());
        }

        //test setting startTime < 0
        try {
            c1.setStartTime(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception for startTime < 0: " + e.getMessage());
        }

        //test setting endTime > MAX_HOUR
        try {
            c1.setEndTime(25);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception for endTime > MAX_HOUR: " + e.getMessage());
        }

        //test setting endtime <= starttime
        try {
            c1.setStartTime(10);
            c1.setEndTime(9);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception for endTime <= startTime: " + e.getMessage());
        }

        System.out.println("\n=== Course Conflict Test ===");

        //cehck conflict between two courses on the same day wtih overlapping times
        boolean conflict1 = MagicCourse.hasConflict(c2, c3);
        System.out.println("c2 and c3 conflict? " + conflict1);

        //check conflict between courses on different days or non-overlaping times
        MagicCourse c4 = new MagicCourse("Summoning" , "Tuesday", 9, 11);   
        boolean conflict2 = MagicCourse.hasConflict(c2, c4);    //c2-Mon, c4-Tue --> non conflict
        System.out.println("c2 and c4 conflict? " + conflict2);

        System.out.println("\n === Conflict Count Test ===");
        List<MagicCourse> courseList = new ArrayList<>();
        courseList.add(c2);
        courseList.add(c3);
        courseList.add(c4);

        //count total conflicting course pairs in the list
        Integer totalConflicts = MagicCourse.countConflicts(courseList);
        System.out.println("Total conflicting pairs: " + totalConflicts);

        //test with an empty list
        List<MagicCourse> emptyList = new ArrayList<>();
        System.out.println("Conflicts in empty list: " + MagicCourse.countConflicts(emptyList));    //base on MagicCourse, should be return null
        
        System.out.println("\n=== Total Course Count Test ===");

        //display total number of courses created so far
        System.out.println("Total courses created: " + MagicCourse.getTotalCourses());
    }
}
