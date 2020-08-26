package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlogDao;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet(urlPatterns= {"/delete"})
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("delete blog");
		try {
		deleteBlog(request,response);
		}catch(SQLException|IOException e) {
			e.printStackTrace();
		}
		
	}

	private void deleteBlog(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		BlogDao blogdao = new BlogDao();
		
		blogdao.deleteBlog(id);
		response.sendRedirect("allblogs");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
