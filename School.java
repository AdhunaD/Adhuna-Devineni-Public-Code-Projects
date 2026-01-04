import java.util.ArrayList;

public class School {
    private ArrayList<Classroom> classrooms;

    public School(int numClassrooms) {
        classrooms = new ArrayList<Classroom>();
        for (int i = 0; i < numClassrooms; i++) {
            classrooms.add(null);
        }
    }

    public void setIndividualClassroom(Classroom c, int index) {
        if (index >= 0 && index < classrooms.size()) {
            classrooms.set(index, c);
        }
    }

    public Classroom getIndividualClassroom(int index) {
        if (index >= 0 && index < classrooms.size()) {
            return classrooms.get(index);
        }
        return null;
    }
}
