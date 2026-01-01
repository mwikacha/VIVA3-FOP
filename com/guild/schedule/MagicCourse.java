package com.guild.schedule;

import java.util.List;

public class MagicCourse {

    //Instance Variables
    private String courseName;   //cannot be null or empty
    private String dayOfWeek;
    private Integer startTime;   //use int to allow null
    private Integer endTime;

    //Static Variables
    private static final int MAX_HOUR = 24;
    private static int totalCourses = 0;

    //Constructors

    //No-argument constructor
    public MagicCourse() {
        this.courseName = "Unnamed Magic Course";
        this.dayOfWeek = "Not Set";
        this.startTime = null;  //Integer can initialize with null(not set yet), if int, initialize with 0
        this.endTime = null;
        totalCourses++;
    }

    //Parameterized constrcutor, throw to ensures the initial value passed are legal
    public MagicCourse(String courseName, String dayOfWeek, int startTime, int endTime) {

        if (courseName == null || courseName.trim().isEmpty()) {    //.trim()=remove space
            throw new IllegalArgumentException("Course name cannot be empty");
        }

        if (startTime < 0 || startTime > MAX_HOUR || endTime < 0 || endTime > MAX_HOUR) {
            throw new IllegalArgumentException("Time out of valid range");  
        }

        if (startTime >= endTime) {
            throw new IllegalArgumentException("Course end time must be later than start time");
        }

        this.courseName = courseName;   //update new value
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;

        totalCourses++;
    }

    //getter & setter methods(setter must repeat validation even constructor alr checked the initial values since someone could change the project properties to illegal values)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be empty");
        }
        this.courseName = courseName;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        if (dayOfWeek == null || dayOfWeek.trim().isEmpty()) {
            throw new IllegalArgumentException("Day of Week cannot be empty");
        }
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        if (startTime < 0 || startTime > MAX_HOUR) {
            throw new IllegalArgumentException("Time out of valid range");
        }
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        if (endTime < 0 || endTime > MAX_HOUR) {
            throw new IllegalArgumentException("Time out of valid range");
        }
        if (startTime != null && endTime <= startTime) {
            throw new IllegalArgumentException("Course and time must be later than start time");
        }
        this.endTime = endTime;
    }

    //static method

    //return total number of course created
    public static int getTotalCourses() {
        return totalCourses;
    }

    //Check if two courses have time conflict
    public static boolean hasConflict(MagicCourse c1, MagicCourse c2) {

        if (c1.startTime == null || c1.endTime == null || 
            c2.startTime == null || c2.endTime == null) {   //one of them null then throw excp
                throw new IllegalArgumentException("Course time not set");
            }

            if (!c1.dayOfWeek.equals(c2.dayOfWeek)) {   //different week --> false(no conflict)
                return false;
            }

            //time overlap check
            return c1.startTime < c2.endTime &&
                   c2.startTime < c1.endTime;
    }

    //Count number ofconflicting course pairs
    public static Integer countConflicts(List<MagicCourse> courseList) {

        if (courseList == null || courseList.isEmpty()) {   //if null, means nothing to compare
            return null;
        }

        int count = 0;
        for (int i = 0; i < courseList.size(); i++) {
            for (int j = i + 1;j < courseList.size(); j++) {    //eg.i=[0],j=[1], c1 vs c2
                if (hasConflict(courseList.get(i), courseList.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }
}



