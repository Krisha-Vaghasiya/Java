package com.student;
import java.sql.*;

public class stdCrud {

	public static void main(String[] args) throws Exception {
		
		// TODO Auto-generated method stub
		String username = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/ass"; // change DB if needed

        // 1. Load Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. Establish connection
        Connection con = DriverManager.getConnection(url, username, password);

        // 3. Create statement
        Statement st = con.createStatement();

        // a. Create Student table
        String createTable = "CREATE TABLE IF NOT EXISTS Student (" +
                             "RollNo INT PRIMARY KEY, " +
                             "Name VARCHAR(50), " +
                             "Address VARCHAR(100))";
        st.executeUpdate(createTable);
        System.out.println("Student Table Created.");

        // b. Insert two records
        st.executeUpdate("INSERT INTO Student VALUES (18, 'Adi', 'Delhi')");
        st.executeUpdate("INSERT INTO Student VALUES (19, 'jiya', 'Mumbai')");
        System.out.println("Two Records Inserted.");

        // c. Display all records
        System.out.println("\n--- Student Records ---");
        ResultSet rs = st.executeQuery("SELECT * FROM Student");
        while (rs.next()) {
            System.out.println(rs.getInt("RollNo") + " | " +
                               rs.getString("Name") + " | " +
                               rs.getString("Address"));
        }

        // d. Update one record
        st.executeUpdate("UPDATE Student SET Address='Pune' WHERE RollNo=2");
        System.out.println("\nRecord Updated.");

        // Display after update
        rs = st.executeQuery("SELECT * FROM Student");
        System.out.println("\n--- After Update ---");
        while (rs.next()) {
            System.out.println(rs.getInt("RollNo") + " | " +
                               rs.getString("Name") + " | " +
                               rs.getString("Address"));
        }

        // e. Delete one record
        st.executeUpdate("DELETE FROM Student WHERE RollNo=1");
        System.out.println("\nRecord Deleted.");

        // Display after delete
        rs = st.executeQuery("SELECT * FROM Student");
        System.out.println("\n--- After Delete ---");
        while (rs.next()) {
            System.out.println(rs.getInt("RollNo") + " | " +
                               rs.getString("Name") + " | " +
                               rs.getString("Address"));
        }

        // 4. Close resources
        rs.close();
        st.close();
        con.close();
        

	}

}
