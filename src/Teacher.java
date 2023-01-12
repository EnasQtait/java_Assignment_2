//Enas mohammd taha qutit ,id: 1210236 , lab section number :3

public class Teacher {

    private String name;
    private int id;
    private double basicSalary;
    private double extraPaymentRate;
    private Course[] coursesTaught;


    public Teacher() {

    }

    public Teacher(String name, int id, double basicSalary, double extraPaymentRate, Course[] coursesTaught) {
        this.name = name;
        this.id = id;
        this.basicSalary = basicSalary;
        this.extraPaymentRate = extraPaymentRate;
        this.coursesTaught = coursesTaught;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getExtraPaymentRate() {
        return extraPaymentRate;
    }

    public void setExtraPaymentRate(double extraPaymentRate) {
        this.extraPaymentRate = extraPaymentRate;
    }

    public Course[] getCoursesTaught() {
        return coursesTaught;
    }

    public void setCoursesTaught(Course[] coursesTaught) {
        this.coursesTaught = coursesTaught;

    }

    /*
     * this method print the information for (class Teacher) and print the information for the array of (class Course)
     */
    public void printInfo() {
        System.out.println("name : " + name + ", id : " + id + ", Basic salary : " + basicSalary + ", Extra payment rate : " + extraPaymentRate);
        for (Course course : coursesTaught) {
            course.printInfo();
        }
    }

    /*
     * in this method takes an int level and start comparing the level with the (first number from the left )from courses id number if they are similar counter = counter + 1
     */
    public int countCourseLevel(int level) {
        int numOfDigit = 0, courseLevel, count = 0;
        for (Course course : coursesTaught) {
            int id = course.getId();
            while (id > 0) {
                numOfDigit++;
                id = id / 10;

            }
            courseLevel = course.getId() / (int) Math.pow(10, numOfDigit - 1);
            if (courseLevel == level)
                count++;

        }
        return count;

    }


    /*
     * this method calculate the rate by finding the countCourseLevel for each course from the method above and
     * do the calculation on it
     */
    public double calculateExtraPayment() {
        double ExtraPayment = 0;
        for (int i = 1; i <= 4; i++) //  because the level of the id courses just from int ( 1 to 4 )
        {
            ExtraPayment += (i * countCourseLevel(i) * extraPaymentRate);
        }
        return ExtraPayment;
    }

}
