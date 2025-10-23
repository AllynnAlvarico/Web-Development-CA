package alvarico.allynn;

import javax.servlet.ServletException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ServletException, SQLException {
        RegisterServlet rs = new RegisterServlet();
        try {
//            rs.databaseConnection("Tony3", "Stark3", "Ironman3", "ArcReactor3");
            rs.displayTableData();
        } catch (SQLException e) {
            rs.displayError(e);
            throw new RuntimeException(e);
        }
    }
}