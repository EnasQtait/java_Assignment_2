//Enas mohammd taha qutit ,id: 1210236 , lab section number :3

import java.util.Scanner;

public class driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of teachers : ");
        Teacher[] arrayOfTeachers = new Teacher[input.nextInt()];
        // filling arrayOfTeachers
        for (int i = 0; i < arrayOfTeachers.length; i++) {
            System.out.println("Enter teacher’s name, id, basic salary, and extra payment rate :-");
            String name = input.next();
            int id = input.nextInt();
            double basicSalary = input.nextDouble();
            double extraPaymentRate = input.nextDouble();
            System.out.println("Enter number of courses the teacher taught :-");
            Course[] arrayCourse = new Course[input.nextInt()];
            // filling arrayCourse
            System.out.println("Enter Course names (only from  4 chars ) and ids :-");
            for (int j = 0; j < arrayCourse.length; j++) {
                String courseNames = input.next();
                int courseId = input.nextInt();
                arrayCourse[j] = new Course(courseNames, courseId);
            }
            // check the course name
            /*
             * the name of courses be just from 4 characters if not the program will ask the user to enter valid name until become valid (name from 4 characters)
             */
            for (Course course : arrayCourse) {

                while ((course.getName().length() != 4)) {
                    System.out.println("lest of course name and  id");
                    for (Course course1 : arrayCourse) {
                        System.out.println(course1.getName() + " " + course1.getId());
                    }
                    System.out.println("invalid course name whose id is " + course.getId() + ", plz enter valid name :-");
                    course.setName(input.next());
                }

            }
            // check the course id
            for (Course course : arrayCourse) {
                int x = Integer.parseInt(Integer.toString(course.getId()).substring(0, 1));// int x get the first int from the left for the id course

                /* the first int from the left for the id course must be from int ( 1 to 4 ) if not the program will print a list f courses name and  ides
                 *the program will ask user to enter  valid id until the id become accepted
                 */
                while (!(x < 5 && x > 0)) {
                    System.out.println("lest of course name and  id");

                    for (Course course1 : arrayCourse)
                        System.out.println(course1.getName() + " " + course1.getId());
                    System.out.println("invalid course id number whose name is " + course.getName() + ", pleas enter valid id :-");
                    int id1 = input.nextInt();
                    course.setId(id1);
                    x = Integer.parseInt(Integer.toString(course.getId()).substring(0, 1));
                }
            }
            // filling arrayOfTeachers
            arrayOfTeachers[i] = new Teacher(name, id, basicSalary, extraPaymentRate, arrayCourse);
        }
        /*
         * the program will ask user to enter number from { 1 to 4 } to do different operations until the user enter number 5 the program will end
         */
        int choice = 0;
        while (choice != 5) {
            System.out.println("\nEnter your choice of tasks ( 1-5 ):" +
                    "\nEnter 1 to Print teachers Info . \n" +
                    "Enter 2 to Display all teachers names and total Salaries . \n" +
                    "Enter 3 to Change basic salary for a teacher . \n" +
                    "Enter 4 to Display sum of total salaries for all teachers . \n" +
                    "Enter 5 to Exit . ");
            choice = input.nextInt();
            switch (choice) {
                /*
                 * when user enter 1 the system will print lest of teacher names and ides and ask user to enter the id number for the teacher that user want to see his / her information
                 * the program will Compare between the id and teachers id if they are similar program print teacher information .if they are not similar
                 * program will ask user to enter valid id course until user enter valid id
                 */
                case 1:
                    int id;
                    boolean found1 = false;
                    System.out.println("lest of teacher name and hes/her id");
                    for (Teacher teacher : arrayOfTeachers) {
                        System.out.println(teacher.getName() + " " + teacher.getId());
                    }
                    System.out.println("Enter id number for the teacher you want to see his / her information");
                    id = input.nextInt();
                    while (!found1) {
                        for (int f = 0; f < arrayOfTeachers.length; f++) {
                            if (id == arrayOfTeachers[f].getId()) {
                                found1 = true;
                                arrayOfTeachers[f].printInfo();
                            }
                        }


                        if (!found1) {
                            System.out.println("the id was not found , enter valid id from this list ");
                            for (Teacher teacher : arrayOfTeachers)
                                System.out.println(teacher.getName() + " " + teacher.getId());
                            System.out.println("Enter id number for the teacher you want to see his / her information");
                            id = input.nextInt();
                        }
                    }

                    break;
                /*
                 * when user enter 4 the system will print teachers name and teachers total salary=(basic salary + extra payment)
                 */

                case 2:

                    for (int t = 0; t < arrayOfTeachers.length; t++) {
                        System.out.println("teacher  name : " + arrayOfTeachers[t].getName() + "\ntotal salary : "
                                + (arrayOfTeachers[t].getBasicSalary() + arrayOfTeachers[t].calculateExtraPayment()));
                    }
                    break;
                /*
                 * when user enter 3 the system will print lest of teacher names and ides and ask user to enter the id number for the teacher that user want to Change his / her basic salary
                 * the program will Compare between the id and teachers id if they are similar program ask user to enter new basic salary.  if they are not similar
                 * program will ask user to enter valid id course until user enter valid id
                 */
                case 3:
                    boolean found = false;
                    System.out.println("lest of teacher name and hes/her id");
                    for (Teacher teacher : arrayOfTeachers) {
                        System.out.println(teacher.getName() + " " + teacher.getId());
                    }
                    System.out.println("Enter id number for the teacher you want to Change his / her basic salary");
                    int id1 = input.nextInt();
                    while (!found) {
                        for (int f = 0; f < arrayOfTeachers.length; f++) {
                            if (id1 == arrayOfTeachers[f].getId()) {
                                found = true;
                                System.out.println("Enter new basic salary ");
                                double BasicSalary = input.nextDouble();
                                arrayOfTeachers[f].setBasicSalary(BasicSalary);
                            }
                        }

                        if (!found) {
                            System.out.println("the id was not found , enter valid id from this list ");
                            for (Teacher teacher : arrayOfTeachers)
                                System.out.println(teacher.getName() + " " + teacher.getId());
                            System.out.println("Enter id number for the teacher you want to Change his / her basic salary");
                            id1 = input.nextInt();

                        }

                    }

                    break;
                /*
                 * when user enter 4 the system will count the sum of all teachers salaries and the
                 * salary for each teacher  is a sum of (basic salary for this teacher and  the extra payment for the teacher)
                 */
                case 4:
                    double sumOfSalary = 0;
                    for (int c = 0; c < arrayOfTeachers.length; c++) {
                        sumOfSalary += (arrayOfTeachers[c].getBasicSalary() + arrayOfTeachers[c].calculateExtraPayment());
                    }
                    System.out.println("sum of total Salaries " + sumOfSalary);

                    break;
                default:
                    break;
            }
        }
    }

}

