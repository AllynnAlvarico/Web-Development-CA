package alvarico.allynn;

import javax.servlet.ServletException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ServletException, SQLException {
        RegisterServlet rs = new RegisterServlet();
        LoginServlet ls = new LoginServlet();

//        testInput(rs);
//        retrieveData(ls);
//        displayAllData(rs);

    }
    public static void testInput(RegisterServlet rs) throws SQLException {
        rs.databaseConnection("gamura", "daughter", "GOTG", "peterquill");
    }
    public static void retrieveData(LoginServlet ls) throws SQLException {
        System.out.println(ls.retrieveUser("husky", "food").getFullName());
    }
    public static void displayAllData(RegisterServlet rs) throws SQLException {
        rs.displayTableData();
    }
}