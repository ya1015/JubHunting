package jp.ac.hal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RaiseEditServlet
 */
@WebServlet("/RaiseEditTitleServlet")
public class RaiseEditTitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RaiseEditTitleServlet() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		// 文字コード設定
		request.setCharacterEncoding("utf-8");

		HttpSession sessionCount = request.getSession(true);

		// エラー用フラグ
		boolean isErr = false;

		// パラメータの受け取り
		String strproject_no = request.getParameter("project_no");
		String project_name = request.getParameter("project_name");
		String caption = request.getParameter("caption");
		String category_name = request.getParameter("category_name");
		String planning_area = request.getParameter("planning_area");
		String strgoal_support_amount = request.getParameter("goal_support_amount");
		String recruitment_end = request.getParameter("recruitment_end");
		// System.out.println(project_name);
		// System.out.println(strproject_no);
		// System.out.println(caption);
		// System.out.println(category_name);
		// System.out.println(planning_area);
		// System.out.println(strgoal_support_amount);
		// System.out.println(recruitment_end);

		String fcount = request.getParameter("fcount");

		System.out.println(fcount);

		// 数値変換処理
		int project_no = 0;
		try {
			project_no = Integer.parseInt(strproject_no);
		} catch (NumberFormatException e) {
			isErr = true;
		}

		int goal_support_amount = 0;
		try {
			goal_support_amount = Integer.parseInt(strgoal_support_amount);
		} catch (NumberFormatException e) {
			isErr = true;
		}

		// System.out.println(goal_support_amount);
		// System.out.println(project_no);

		// フォーマットチェック

		if (!isErr) {
			// エラーが無いときの処理
			ProjectDAO dao = new ProjectDAO();

			// カテゴリー番号をとってくる
			int category_no = dao.selectCategory(category_name);
			// System.out.println(category_no);

			// 企画テーブルのデータの更新(int型変数countは判定用)
			int count = dao.updateTitle(project_no, project_name, caption, category_no, planning_area,
					goal_support_amount, recruitment_end);
					// System.out.println("aa");

			// 戻り値の件数で判定
			if (count <= 0) {
				// データの追加が出来なかった
				// System.out.println("aaa");
				request.getRequestDispatcher("raise_form.jsp").forward(request, response);
			} else {
				// データの追加に成功
				String counter = (String) sessionCount.getAttribute("counter");

				//文字列結合
				counter = counter + fcount;//検索対象文字列counter
				System.out.println(counter);

				sessionCount.setAttribute("counter", counter);

				// request.setAttribute("fcount", fcount);
				String pattern1 = "a";
				String pattern2 = "b";
				String pattern3 = "c";

				if(counter.indexOf(pattern1) != -1 && counter.indexOf(pattern2) != -1 && counter.indexOf(pattern3) != -1){
					//"a","b","c"が含まれている
					request.getRequestDispatcher("RaiseConfirmationServlet").forward(request, response);
				}
				request.getRequestDispatcher("raise_edit_text.jsp").forward(request, response);

			}
		} else {
			// System.out.println("eee");
			request.getRequestDispatcher("raise_edit_title.jsp").forward(request, response);
		}
	}

}
