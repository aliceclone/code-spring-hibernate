
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestConnection")
public class TestConnection extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public static final String URL_DB = "jdbc:mysql://localhost:3306/customer_management?useSSL=false&serverTimezone=UTC";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	PrintWriter writer = response.getWriter();
	// load driver
	// Class.forName("com.mysql.jdbc.Driver");
	Connection connection = null;
	try {
	    connection = DriverManager.getConnection(URL_DB, "hbstudent", "hbstudent");
	    writer.println("Connecting ...");
	    writer.append("Served at: ").append(request.getContextPath());

	} catch (SQLException e) {
	    e.printStackTrace();

	} finally {

	    if (connection != null) {
		try {
		    connection.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	    }
	}

    }

}
