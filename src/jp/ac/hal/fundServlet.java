package jp.ac.hal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fundServlet
 */
@WebServlet("/fundServlet")
public class fundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public fundServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		request.setCharacterEncoding("utf-8");

		String strproject_no = request.getParameter("project_no");
		String strsupport_amount = request.getParameter("support_amount");

		System.out.println(strproject_no);
		System.out.println(strsupport_amount);

		boolean isErr = false;

		// 数値変換処理
		int project_no = 0;
		try {
			project_no = Integer.parseInt(strproject_no);
		} catch (NumberFormatException e) {
			isErr = true;
		}

		int support_amount = 0;
		try {
			support_amount = Integer.parseInt(strsupport_amount);
		} catch (NumberFormatException e) {
			isErr = true;
		}

		System.out.println(project_no);
		System.out.println(support_amount);

		if(!isErr){
			ProjectDAO dao = new ProjectDAO();

			int count = dao.updateSupportAmount(support_amount, project_no);
			int count2 = dao.updateSupportNumbers(project_no);

			if(count <= 0 || count2 <= 0 ){
				request.setAttribute("mes","データが更新されませんでした");
			}else{
				request.setAttribute("mes", "データを更新しました");
			}
		}
		request.getRequestDispatcher("fund_comp.jsp").forward(request, response);
	}

}
