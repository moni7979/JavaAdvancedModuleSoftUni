package softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {

    private List<Student> studentList;

    private int capacity;

    public SoftUni (int capacity) {
        this.capacity = capacity;
        this.studentList = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return this.studentList.size();
    }

    public String insert(Student student) {
        if (getCount() + 1 <= capacity) {
            if (!studentList.contains(student)) {
                studentList.add(student);
                return String.format("Added student %s %s.%n", student.getFirstName(), student.getLastName());
            } else {
                return "Student is already in the hall.";
            }
        } else {
            return "The hall is full.";
        }
    }

    public String remove(Student student) {
        if (studentList.contains(student)) {
            studentList.remove(student);
            return String.format("Removed student %s %s.%n", student.getFirstName(), student.getLastName());
        } else {
            return "Student not found.";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : studentList) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hall size: ").append(getCount()).append(System.lineSeparator());
        this.studentList.forEach(student -> sb.append(student.toString()).append(System.lineSeparator()));
        return sb.toString();
    }

}
