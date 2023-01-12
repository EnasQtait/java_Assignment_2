//Enas mohammd taha qutit ,id: 1210236 , lab section number :3

public class Course {
    private String name;
    private int Id;


    public Course(String name, int id, double basicSalary, double extraPaymentRate, Course[] arrayCourse) {
    }

    public Course(String name, int Id) {
        this.name = name;
        this.Id = Id;
    }


    public String getName() {
        return name;
    }

    /*
    this method check if the name of a course is from 4 characters
    * */
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }

    /*
    this method print course information
    * */
    public void printInfo() {
        System.out.println("Course Name : " + name + ", Id : " + Id);
    }


}
