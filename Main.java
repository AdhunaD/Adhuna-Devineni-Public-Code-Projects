// Adhuna Devineni AP CSA Period 3

public class Main {
    public static void main(String[] args) {
        School msj = new School(50); // number of classrooms

        Student a = new Student("Natasha", 17); // name, age
        Student b = new Student("Nessa", 16);
        Student c = new Student("Phoenix", 15);

        Classroom c1 = new Classroom();
        Classroom c2 = new Classroom();

        c1.addStudent(a);
        c1.addStudent(b);
        c2.addStudent(c);

        msj.setIndividualClassroom(c1, 0);
        msj.setIndividualClassroom(c2, 1);

        System.out.println(msj.getIndividualClassroom(0).getStudent(0).getName());
        System.out.println(msj.getIndividualClassroom(0).getStudent(1).getName());
        System.out.println(msj.getIndividualClassroom(1).getStudent(0).getAge());
    }
}
