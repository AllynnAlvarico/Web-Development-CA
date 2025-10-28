package alvarico.allynn;

import javax.servlet.ServletException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ServletException, SQLException {
        RegisterServlet rs = new RegisterServlet();
        LoginServlet ls = new LoginServlet();
        try {
//            rs.databaseConnection("Tony4", "Stark4", "Ironman4", "ArcReactor4");
//            rs.displayTableData();
            System.out.println(ls.retrieveUser("husky", "food"));
        } catch (SQLException e) {
            rs.displayError(e);
            throw new RuntimeException(e);
        }
    }
}