package alvarico.allynn.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    //    private String jdbcConnection = "jdbc:mysql://192.168.178.145:3306/"; local network connection to my database server
//    private String jdbcConnection = "jdbc:mysql://194.125.24.208:3306/"; //outside connection to my database server
    private String jdbcConnection = "jdbc:mysql://localhost:3306/"; //outside connection to my database server
    private String schema = "webdev";
//    private String db_userTable = "user";
    private String db_productTable = "product";

    public Connection getLaptopConnection() throws SQLException {
        return DriverManager.getConnection(
                getConnectionUrl(),
                getLaptopUser(),
                getLaptopPassword()
        );
    }

    public Connection getDesktopConnection() throws SQLException {
        return DriverManager.getConnection(
                getPcConnectionUrl(),
                getPCUser(),
                getPCPassword()
        );
    }

    public String getConnectionUrl() {
        return jdbcConnection + schema;
    }

    public String getPcConnectionUrl() {
        return jdbcConnection + getPcSchema();
    }

    public void setSchema(String schemaName) {
        this.schema = schemaName;
    }

    public String getPcSchema() {
        return "webdev";
    }

    public String getLaptopSchema() {
        return "tu914";
    }

    public String getLaptopUser(){
        return "root";
    }

    public String getLaptopPassword(){
        return "9542MEnw#";
    }

    public String getPCUser(){
        return "root";
    }

    public String getPCPassword(){
        return "@admin2110";
    }

    public String getPCUser2(){
        return "webdevass1";
    }

    public String getPCPassword2(){
        return "webdevelopmentassignment";
    }

    public String getLocalJdbcConnection(){
        return "jdbc:mysql://localhost:3306/";
    }

    public String getJdbc() {
        return jdbcConnection;
    }

//    public String getTable() {
//        return db_userTable;
//    }
}
