package jp.ac.hal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RaiseEditTextServlet
 */
@WebServlet("/RaiseEditTextServlet")
public class RaiseEditTextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RaiseEditTextServlet() {
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
		String text = request.getParameter("text");
		String strproject_no = request.getParameter("project_no");

		String fcount = request.getParameter("fcount");
		System.out.println(fcount);

		// 数値変換処理
		int project_no = 0;
		try {
			project_no = Integer.parseInt(strproject_no);
		} catch (NumberFormatException e) {
			isErr = true;
		}

		// System.out.println(strproject_no);

		// エラーチェック
		if (text == null || text.isEmpty()) {
			isErr = true;
			request.setAttribute("isNull", "本文を入力してください");
		}

		if (!isErr) {
			// エラーが無いときの処理
			ProjectDAO dao = new ProjectDAO();

			// 企画テーブルのデータを更新
			int count = dao.updateText(text, project_no);

			// 戻り値の件数で判定
			if (count <= 0) {
				// データの追加が出来なかった
				// System.out.println("kkk");
				request.getRequestDispatcher("raise_edit_text.jsp").forward(request, response);
			} else {
				// データの追加に成功
				String counter = (String) sessionCount.getAttribute("counter");

				//文字列結合
				counter = counter + fcount;
				System.out.println(counter);

				sessionCount.setAttribute("counter", counter);

				String pattern1 = "a";
				String pattern2 = "b";
				String pattern3 = "c";

				if (counter.indexOf(pattern1) != -1 && counter.indexOf(pattern2) != -1
						&& counter.indexOf(pattern3) != -1) {
					// "a","b","c"が含まれている
					request.getRequestDispatcher("RaiseConfirmationServlet").forward(request, response);
				}
				request.getRequestDispatcher("raise_edit_image.jsp").forward(request, response);

			}
		} else {
			// System.out.println("eee");
			request.getRequestDispatcher("raise_edit_text.jsp").forward(request, response);
		}
	}
}
