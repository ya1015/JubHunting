package jp.ac.hal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RaiseEditImageServlet
 */
@WebServlet("/RaiseEditImageServlet")
public class RaiseEditImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RaiseEditImageServlet() {
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
		String movie_path = request.getParameter("movie_path");
		String introduction_visual_path = request.getParameter("introduction_visual_path");
		String strtype = request.getParameter("type");
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

		//System.out.println(project_no);


		int type = 0;
		try {
			type = Integer.parseInt(strtype);
		} catch (NumberFormatException e) {
			isErr = true;
		}

		//System.out.println(type);

		// System.out.println(fcount);

		// System.out.println(movie_path);
		// System.out.println(introduction_visual_path);
		// System.out.println(type);
		// System.out.println(project_no);

		// System.out.println(strproject_no);

		// フォーマットチェック

		if (!isErr) {
			// エラーが無いときの処理
			ProjectDAO dao = new ProjectDAO();

			// 紹介用ビジュアルテーブルにデータ(メインビジュアル)を追加
			int count = dao.insertImage(introduction_visual_path, project_no, type);

			// 企画テーブルにデータ(動画)を更新
			int count2 = dao.updateMovie(movie_path, project_no);

			// 戻り値の件数で判定
			if (count <= 0 || count2 <= 0) {
				// データの追加が出来なかった
				 //System.out.println("kkk");
				request.getRequestDispatcher("raise_edit_text.jsp").forward(request, response);
			} else {
				// データの追加に成功
				String counter = (String) sessionCount.getAttribute("counter");

				//文字列結合
				counter = counter + fcount;
				System.out.println(counter);

				sessionCount.setAttribute("counter", counter);

				request.setAttribute("project_no", project_no);

				String pattern1 = "a";
				String pattern2 = "b";
				String pattern3 = "c";

				if (counter.indexOf(pattern1) != -1 && counter.indexOf(pattern2) != -1
						&& counter.indexOf(pattern3) != -1) {
					// "a","b","c"が含まれている
					request.getRequestDispatcher("RaiseConfirmationServlet").forward(request, response);
				}

				request.getRequestDispatcher("raise_edit_title.jsp").forward(request, response);
			}
		} else {
			System.out.println("eee");
			request.getRequestDispatcher("raise_edit_text.jsp").forward(request, response);
		}
	}

}
