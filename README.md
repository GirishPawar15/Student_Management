Group Members:   1.Girish Nagesh Pawar (Group Leader)
                 2.Ziyan Jakirali Kazi


## 🎓 Student Management System in Java (Console + PostgreSQL)

This project is a simple **console-based Java application** to manage student data using PostgreSQL and JDBC. 

It supports the following operations:
    - ✅ Add Student
    - 🔁 Update Student
    - ❌ Delete Student
    - 📋 View All Students



## 📌 Features

- Create table if not exists (`applicants`)
- Add new student data with roll number and details
- Update an existing student's information
- Delete student data by roll number
- Display all student records in tabular form



## 📂 Project Structure

Your project uses a clean MVC-like structure:

      src/main/java
      ├── dao
      │ └── StudentDAO.java
      ├── model
      │ └── Student.java
      ├── utils
      │ ├── Jdbcconn.java
      │ └── Main.java



## 🧱 Table Schema (PostgreSQL)

```sql
CREATE TABLE IF NOT EXISTS applicants (
    Ro_No INT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Add VARCHAR(100) NOT NULL,
    Mo_No VARCHAR(11) NOT NULL,
    E_Mail VARCHAR(100) NOT NULL,
    std VARCHAR(100) NOT NULL,
    Preveous_Year_marks DECIMAL(5,2) NOT NULL
);



🛠 Technologies Used

    -✅Java SE 8
    -✅JDBC (Java Database Connectivity)
    -✅PostgreSQL Database
    -✅Maven (Optional)



💡 Future Enhancements

    -✅Use PreparedStatements for security
    -✅Add GUI using JavaFX or Swing
    -✅Add user authentication
    -✅Export records to Excel or PDF



PostgreSQL JDBC with basic DAO pattern
    📦 Dependencies (in pom.xml)
    org.postgresql postgresql 42.7.1






![Screenshot 2025-07-10 183526](Screenshot%202025-07-10%20183526.png)

