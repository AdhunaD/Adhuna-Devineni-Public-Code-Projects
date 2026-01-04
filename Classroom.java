import java.util.ArrayList;

public class Classroom {
    private ArrayList<Student> students;

    public Classroom() {
        students = new ArrayList<Student>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public Student getStudent(int index) {
        if (index >= 0 && index < students.size()) {
            return students.get(index);
        }
        return null;
    }
}
