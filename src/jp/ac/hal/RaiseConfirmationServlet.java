package jp.ac.hal;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RaiseConfirmationServlet
 */
@WebServlet("/RaiseConfirmationServlet")
public class RaiseConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RaiseConfirmationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		// 文字コード設定
		request.setCharacterEncoding("utf-8");

		// エラー用フラグ
		boolean isErr = false;

		//パラメータの受け取り
		String strproject_no = request.getParameter("project_no");

		//数値変換処理
		int project_no = 0;
		try {
			project_no = Integer.parseInt(strproject_no);
		} catch (NumberFormatException e) {
			isErr = true;
		}

		//System.out.println(project_no);

		if(!isErr){
			// エラーが無いときの処理
			ProjectDAO dao = new ProjectDAO();
			ArrayList<Project> list = dao.select1(project_no);
			String category_name = dao.select2(project_no);

			//データをセットする
			request.setAttribute("list",list);
			request.setAttribute("category_name",category_name);

			//System.out.println(category_name);

			// 最後に画面遷移
			request.getRequestDispatcher("raise_confirmation.jsp").forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
