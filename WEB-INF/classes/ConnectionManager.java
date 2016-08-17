package myPackage;
import java.sql.*;
import java.util.*;
import myPackage.*;

public class ConnectionManager {

  static Connection con;
  static String url;
        
  public static Connection getConnection() {
    
    String url = "jdbc:mysql://localhost/jsplogin?useSSL=false";
    try {             
      con = DriverManager.getConnection(url,"root","4puridiompe"); 
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return con;
  }
}
