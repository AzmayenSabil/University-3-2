package ContentCoupling;

public class Student {
    public int student_id;
    public String name;
    public int semester;
    public int cgpa;

    public Student(int student_id, String name, int semester, int cgpa){
        this.student_id = student_id;
        this.name = name;
        this.semester = semester;
        this.cgpa = cgpa;
    }

    public void showInfo(){
        System.out.println("Info : name> "+ name +" id> "+ student_id +" sem> "+ semester +" cgpa> "+ cgpa);
    }

}
