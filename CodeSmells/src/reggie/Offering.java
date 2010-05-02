package reggie;

import java.sql.*;

public class Offering {
    private int id;
    private Course course;
    private String daysTimes;

    static String url = "jdbc:odbc:Reggie";

    static { try { Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); } 
             catch (Exception ignored) {} }

    public static Offering create(Course course, String daysTimesCsv) 
        throws Exception 
    {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, "", "");
            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(
		"SELECT MAX(ID) FROM offering;");
            result.next();
            int newId = 1 + result.getInt(1);

            statement.executeUpdate("INSERT INTO offering VALUES ('"
                    + newId + "','" + course.getName() 
		    + "','" + daysTimesCsv + "');");
            return new Offering(newId, course, daysTimesCsv);
        } finally {
            try { conn.close(); } catch (Exception ignored) {}
        }
    }

    public static Offering find(int id) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, "", "");
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(
		"SELECT * FROM offering WHERE ID =" + id + ";");
            if (result.next() == false)
                return null;

            String courseName = result.getString("Course");
            Course course = Course.find(courseName);
            String dateTime = result.getString("DateTime");
            conn.close();

            return new Offering(id, course, dateTime);
        } catch (Exception ex) {
            try { conn.close(); } catch (Exception ignored) {}
            return null;
        }
    }

    public void update() throws Exception {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, "", "");
            Statement statement = conn.createStatement();

            statement.executeUpdate(
		"DELETE FROM Offering WHERE ID=" + id + ";");
            statement.executeUpdate(
                    "INSERT INTO Offering VALUES('" + id + "','" +
                      course.getName() + "','" + daysTimes + "');");
        } finally {
            try { conn.close(); } catch (Exception ignored) {}
        }
    }

    public Offering(int id, Course course, String daysTimesCsv) {
        this.id = id;
        this.course = course;
        this.daysTimes = daysTimesCsv;
    }

    public int getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public String getDaysTimes() {
        return daysTimes;
    }

    public String toString() {
        return "Offering " + getId() + ": " 
		+ getCourse() + " meeting " + getDaysTimes();
    }
}
