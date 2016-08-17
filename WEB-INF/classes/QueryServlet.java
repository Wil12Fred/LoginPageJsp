package myPackage;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import myPackage.UserBean;
 
public class QueryServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
    Connection conn = null;
    Statement stmt = null;
    try {     
      UserBean user = new UserBean();
      user.setUserName(request.getParameter("un"));
      user.setPassword(request.getParameter("pw"));

      user = UserDAO.login(user);
           
      if (user.isValid()) {
           HttpSession session = request.getSession(true);     
           session.setAttribute("currentSessionUser",user); 
           response.sendRedirect("userLogged.jsp");
      } else 
           response.sendRedirect("invalidLogin.jsp")
    } catch (Throwable theException) {
     System.out.println(theException); 
    }
  }
}
