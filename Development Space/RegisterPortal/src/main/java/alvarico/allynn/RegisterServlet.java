package alvarico.allynn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
    private String db_schema = "webdev";

    private String jdbcConnection = "jdbc:mysql://localhost:3306/";
    private String db_userTable = "user";

//    private String jdbcConnection = "jdbc:mysql://192.168.178.145:3306/";
//    private String db_user = "webdevass1";
//    private String db_password = "webdevelopmentassignment";
    private String db_user = "root";
    String db_password = "@admin2110";
    private final Connection connect;

    public RegisterServlet() throws SQLException {
        System.out.println("Connecting");
        connect = DriverManager.getConnection(jdbcConnection + db_schema, db_user, db_password);
        System.out.println("Connection Established");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost Method");
        response.setContentType("text/html");
        System.out.println("created text/html");
        String firstname = request.getParameter("fname");
        System.out.println("created name");
        String lastname = request.getParameter("lname");
        System.out.println("created last name");
        String username = request.getParameter("username");
        System.out.println("created username");
        String password = request.getParameter("password");
        System.out.println("created password");
        String confirmPassword = request.getParameter("cpassword");
        System.out.println("created cpassword");


        System.out.println("Entering PrintWriter");
        PrintWriter out = response.getWriter();
        System.out.println("create html content");
        out.println("<html>");
        out.println("<body>");

        if (password.equals(confirmPassword)){
            out.println("<h1>"+ firstname +" susccessfully registered</h1");
            out.println("</body>");

            try {
                databaseConnection(firstname, lastname, username, password);
            } catch (SQLException e) {
                out.println(e);
                displayError(e);
                throw new RuntimeException(e);
            }
        } else {

            out.println("Error! </body>");
        }

    }

    public void databaseConnection(String firstname, String lastname, String username,String password) throws SQLException {
        System.out.println("Creating User Object");
        User newUser = new User(firstname, lastname, username, password);
        System.out.println("Entering Data to Table");
        createUser(preparedStatement(this.connect), newUser);
        System.out.println("Data successfully stored");
    }

    public PreparedStatement preparedStatement(Connection connect) throws SQLException {
        System.out.println("Creating User");
        return connect.prepareStatement("INSERT INTO " + db_userTable + " (fname, lname, username, password, balance)" + " VALUES(?, ?, ?, ?, ?)");
    }
    public void createUser(PreparedStatement prep, User user) throws SQLException {
        prep.setString(1, user.getFirst_name());
        prep.setString(2, user.getLast_name());
        prep.setString(3, user.getUsername());
        prep.setString(4, user.getPassword());
        prep.setString(5, String.valueOf(user.getBalance()));
        prep.executeUpdate();
        prep.close();
        System.out.println("Closing Connection");
    }

    public void displayError(Exception e){
        System.out.printf("Line 33 error in class:%s", RegisterServlet.class.getName());
        System.out.printf("\nException Trace:%s", e);
    }
    public void displayTableData() throws SQLException {
        ResultSet rs = connect.createStatement().executeQuery("SELECT * FROM " + db_userTable);
        String fname;
        String lname;
        String username;
        String password;
        String balance;
        System.out.println("Retrieving Records");
        while (rs.next()) {
            fname = rs.getString(1);
            lname = rs.getString(2);
            username = rs.getString(3);
            password = rs.getString(4);
            if (rs.getString(5) != null) {
                balance = String.valueOf(0);
            } else {
                balance = rs.getString(5);
            }

            String formatted = String.format("Full Name: %s %s | Username: %s | Password: %s | balance: %s", fname, lname, username, password, balance);
            System.out.println(formatted);
        }
    }
}
