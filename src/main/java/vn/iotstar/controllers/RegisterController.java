package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserServiceImpl;
import vn.iotstar.utils.Constant;


@WebServlet(urlPatterns = "/register")

public class RegisterController extends HttpServlet 
{

	
	private static final long serialVersionUID = 1L;
	IUserService service = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("username") != null) 
		{
		resp.sendRedirect(req.getContextPath() + "/admin");
		return;

		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String username = req.getParameter("uname");
		String password = req.getParameter("psw");
		String email = req.getParameter("email");
		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");
		
		String alertMsg ="";
		
		if (service.checkExistEmail(email)) 
		{
			alertMsg = "Email đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
			return;
		}
		if (service.checkExistUsername(username)) 
		{
			alertMsg =
			"Tài khoản đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
			return;
		}
		boolean isSuccess = service.register(username, password, email, fullname,
				phone);
				if (isSuccess) 
				{
				//SendMail sm = new SendMail();
				//sm.sendMail(email, "Shopping.iotstar.vn", "Welcome to Shopping. Please Login to use service. Thanks !");
				req.setAttribute("alert", alertMsg);
				resp.sendRedirect(req.getContextPath() + "/login");
				} else 
				{
				alertMsg = "System error!";
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
				}
			}
				
	

}
