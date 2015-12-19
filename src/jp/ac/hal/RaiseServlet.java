package jp.ac.hal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RaiseServlet
 */
@WebServlet("/RaiseServlet")
public class RaiseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RaiseServlet() {
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
		// 文字コード設定
		request.setCharacterEncoding("utf-8");

		// パラメータ取得
		String project_name = request.getParameter("project_name");
		String category_name = request.getParameter("category_name");

		// System.out.println(project_name);
		// System.out.println(category_name);

		// セッション定義
		HttpSession session = request.getSession(true);
		HttpSession sessionCount = request.getSession(true);

		// LoginServletまたはShinki_tourokuServletからセッションを受け取る
		String user_id = (String) session.getAttribute("id");

		// エラー検知用フラグ
		boolean isErr = false;

		// エラーチェック(入力値なし)
		if (project_name == null || project_name.equals("")) {
			isErr = true;
			request.setAttribute("nullErr", "タイトルが未入力です");
		}

		// エラーがないときの処理
		if (!isErr) {
			ProjectDAO dao = new ProjectDAO();

			// DAOを使って会員テーブルからmember_noをとってきて変数に代入
			int member_no = dao.selectMember_no(user_id);

			// DAOを使ってカテゴリーテーブルからcategory_noをとってきて変数に代入
			int category_no = dao.selectCategory(category_name);

			// 企画テーブルにデータの追加(int型変数countは判定用)
			int count = dao.insert(project_name, category_no, member_no);

			// 追加されたデータの中の企画番号を取ってくる
			int project_no = dao.selectNewProjectNo();
			//System.out.println(project_no);

			// 戻り値の件数で判定
			if (count <= 0) {
				// データの追加が出来なかった
				//System.out.println("aaa");
				request.getRequestDispatcher("raise_form.jsp").forward(request, response);
			} else {
				// データの追加が出来た
				// セッションを使って次ページにデータを送る
				session.setAttribute("category_name", category_name);
				session.setAttribute("project_name", project_name);

				//count用
				String counter = "";
				sessionCount.setAttribute("counter", counter);

				// raise_edit_title.jspに値を送る
				session.setAttribute("project_no", project_no);
				//System.out.println(project_no);

				request.getRequestDispatcher("raise_edit_title.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("raise_form.jsp").forward(request, response);
		}
	}
}
