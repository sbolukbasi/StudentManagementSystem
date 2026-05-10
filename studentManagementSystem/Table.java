package studentManagementSystem;

import java.sql.*;
public class Table {
    
    Connection conn = null;
    Statement  st = null;

    public Table() {
        conn = OnlineDB.connectOnlineDB();
    }

    public void CreateTables() {

        // ── 1. Group2_Students ───────────────────────────────────────────────
        String sqlStudents =
            "CREATE TABLE IF NOT EXISTS Group2_Students (" +
            "    StudentID   VARCHAR(4)    PRIMARY KEY, " +
            "    Name        VARCHAR(100)  NOT NULL, " +
            "    Surname     VARCHAR(100)  NOT NULL, " +
            "    Gender      VARCHAR(10), " +
            "    Email       VARCHAR(100)  NOT NULL, " +
            "    Department  VARCHAR(100)  NOT NULL, " +
            "    Year        INT, " +
            "    GPA         DECIMAL(3,2)  NOT NULL " +
            ")";

        // ── 2. Group2_Enrollments ────────────────────────────────────────────
        String sqlEnrollments =
            "CREATE TABLE IF NOT EXISTS Group2_Enrollments (" +
            "    EnrollmentID INT(10)       AUTO_INCREMENT PRIMARY KEY, " +
            "    StudentID    VARCHAR(4)    NOT NULL, " +
            "    CourseCode   VARCHAR(20)   NOT NULL, " +
            "    CourseName   VARCHAR(150)  NOT NULL, " +
            "    Credits      INT(1)        NOT NULL, " +
            "    FOREIGN KEY (StudentID) " +
            "        REFERENCES Group2_Students(StudentID) ON DELETE CASCADE" +
            ")";

        // ── 3. Group2_Login ──────────────────────────────────────────────────
        String sqlLogin =
            "CREATE TABLE IF NOT EXISTS Group2_Login (" +
            "    Username   VARCHAR(80)   NOT NULL, " +
            "    Password   VARCHAR(100)  NOT NULL, " +
            "    PRIMARY KEY (Username) " +
            ")";

        try {
            st = conn.createStatement();

            st.executeUpdate(sqlStudents);
            System.out.println("Group2_Students table created.");

            st.executeUpdate(sqlEnrollments);
            System.out.println("Group2_Enrollments table created.");

            st.executeUpdate(sqlLogin);
            System.out.println("Group2_Login table created.");

            System.out.println("All tables ready.");

        } catch (Exception e) {
            System.out.println("Error creating tables: " + e.getMessage());
        }
    }

    public void InsertSampleData() {

        // ── Login sample data ────────────────────────────────────────────────
        String[] sqlLogin = {
            "INSERT INTO Group2_Login VALUES ('admin123', '123456')"
        };

        // ── Students sample data ─────────────────────────────────────────────
        String[] sqlStudents = {
            "INSERT INTO Group2_Students VALUES ('S001', 'Ada',   'Lovelace', 'Female', 'adalovelace@st.uskudar.edu.tr',  'Software Engineering', 2, 3.66)",
            "INSERT INTO Group2_Students VALUES ('S002', 'Alan',  'Turing',   'Male',   'alanturing@st.uskudar.edu.tr',   'Computer Science',     3, 3.85)"
        };

        // ── Enrollments sample data ──────────────────────────────────────────
        String[] sqlEnrollments = {
            "INSERT INTO Group2_Enrollments (StudentID, CourseCode, CourseName, Credits) VALUES ('S001', 'SE204', 'Software Construction', 3)",
            "INSERT INTO Group2_Enrollments (StudentID, CourseCode, CourseName, Credits) VALUES ('S001', 'CS101', 'Intro to Programming',  3)",
            "INSERT INTO Group2_Enrollments (StudentID, CourseCode, CourseName, Credits) VALUES ('S002', 'CS201', 'Data Structures',       3)"
        };

        try {
            st = conn.createStatement();

            for (String sql : sqlLogin) {
                st.executeUpdate(sql);
            }
            System.out.println("Login sample data inserted.");

            for (String sql : sqlStudents) {
                st.executeUpdate(sql);
            }
            System.out.println("Students sample data inserted.");

            for (String sql : sqlEnrollments) {
                st.executeUpdate(sql);
            }
            System.out.println("Enrollments sample data inserted.");

            System.out.println("All sample data inserted.");

        } catch (Exception e) {
            System.out.println("Error inserting sample data: " + e.getMessage());
        }
    }
}
