package ContentCoupling;

public class Teacher {
    public int teacher_id;
    public String name;

    Student student1 = new Student(123, "Sabil", 3, 3);

    public void changeInfo(int cgpa){
        student1.cgpa = cgpa;
    }

    public void seeStudent(){
        student1.showInfo();
    }

}
