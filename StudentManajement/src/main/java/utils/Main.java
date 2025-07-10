package utils;

import dao.StudentDAO;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        String tableName = "Stud";
        int choice;

        while (true) {
            System.out.println("\n--- Student Management System Menu ---");
            System.out.println("1. Add Student ");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Show All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
                            + "Ro_No INT PRIMARY KEY, "
                            + "Name VARCHAR(100) NOT NULL, "
                            + "Add VARCHAR(100) NOT NULL, "
                            + "Mo_No VARCHAR(11) NOT NULL, "
                            + "E_Mail VARCHAR(100) NOT NULL, "
                            + "std VARCHAR(100) NOT NULL, "
                            + "Preveous_Year_marks DECIMAL(5,2) NOT NULL)";
                    StudentDAO.createTable(tableName, sql);
                    //break;

                //case 2:
                    System.out.print("Enter Roll Number: ");
                    int roNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    System.out.print("Enter Mobile Number: ");
                    String mobile = sc.nextLine();

                    System.out.print("Enter E-Mail Address: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Standard: ");
                    String std = sc.nextLine();

                    System.out.print("Enter Previous Year Marks: ");
                    double marks = sc.nextDouble();

                    StudentDAO.addStudent(tableName, roNo, name, address, mobile, email, std, marks);
                    break;

                case 2:
                    System.out.print("Enter Roll Number to update: ");
                    int updateRoNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    name = sc.nextLine();

                    System.out.print("Enter New Address: ");
                    address = sc.nextLine();

                    System.out.print("Enter New Mobile Number: ");
                    mobile = sc.nextLine();

                    System.out.print("Enter New E-Mail Address: ");
                    email = sc.nextLine();

                    System.out.print("Enter New Standard: ");
                    std = sc.nextLine();

                    System.out.print("Enter New Previous Year Marks: ");
                    marks = sc.nextDouble();

                    StudentDAO.updateStudent(tableName, updateRoNo, name, address, mobile, email, std, marks);
                    break;

                case 3:
                    System.out.print("Enter Roll Number to delete: ");
                    int delRoNo = sc.nextInt();
                    sc.nextLine();
                    StudentDAO.deleteStudent(tableName, delRoNo);
                    break;

                case 4:
                    StudentDAO.showTable(tableName);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
