package myPackage;
import java.text.*;
import java.util.*;
import java.sql.*;
import myPackage.UserBean;
import myPackage.ConnectionManager;

public class UserDAO {
   static Connection currentCon = null;
   static ResultSet rs = null;  

   public static UserBean login(UserBean bean) {

      Statement stmt = null;    

      String username = bean.getUsername();    
      String password = bean.getPassword();   
   
      String searchQuery =
            "select *from users where username='"+ username
                     + "' and password='"
                     + password
                     + "'";
   
   System.out.println("Query: "+searchQuery);
   
   try {
      currentCon = ConnectionManager.getConnection();
      stmt=currentCon.createStatement();
      rs = stmt.executeQuery(searchQuery);         
      boolean more = rs.next();
      
      if (!more) {
         bean.setValid(false);
      } else if (more) {
         String firstName = rs.getString("FirstName");
         String lastName = rs.getString("LastName");
     
         bean.setFirstName(firstName);
         bean.setLastName(lastName);
         bean.setValid(true);
      }
   } catch (Exception ex) {
      System.out.println(ex);
   } finally {
      if (rs != null)  {
         try {
            rs.close();
         } catch (Exception e) {}
            rs = null;
         }
      if (stmt != null) {
         try {
            stmt.close();
         } catch (Exception e) {}
            stmt = null;
         }
      if (currentCon != null) {
         try {
            currentCon.close();
         } catch (Exception e) {
         }
         currentCon = null;
      }
   }
   return bean;
   } 
}
