package jp.ac.hal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 文字化け対策
		request.setCharacterEncoding("utf-8");

		// パラメータ取得
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		// セッション定義
		HttpSession session = request.getSession(true);

		// エラー判定用フラグ
		boolean isErr = false;

		// エラーチェック(入力値なし)
		if (id == null || id.equals("")) {
			isErr = true;
			request.setAttribute("nullErr", "ユーザーIDを入力してください");
		}
		if (pass == null || pass.equals("")) {
			isErr = true;
			request.setAttribute("nullErr", "ユーザーIDを入力してください");
		}

		// 全角防止
		if (id != null && !id.equals("")) {
			if (!id.matches("[0-9a-zA-Z]+") || !id.matches("[0-9a-zA-Z]+")) {
				isErr = true;
				request.setAttribute("zenErr", "半角で入力してください");
			}
		}
		if (pass != null && !pass.equals("")) {
			if (!pass.matches("[0-9a-zA-Z]+") || !pass.matches("[0-9a-zA-Z]+")) {
				isErr = true;
				request.setAttribute("zenErr", "半角で入力してください");
			}
		}

		// エラーがないときの処理
		if (!isErr) {
			// DAOを使ってデータを読み込む
			MemberDAO dao = new MemberDAO();

			//idとpassを元にDAOを使ってDBにmemberをとりだす
			String member = dao.select(id, pass);

			//memberが取り出せたとき
			if (member != null || !member.equals("")) {

				//ログインが出来たとき
				session.setAttribute("member", member);

				//ログイン成功で.jspページでリンクを変える
				session.setAttribute("logUrl", "logoutServlet");
				session.setAttribute("logName", "ログアウト");

				//RaiseServletでに使用
				session.setAttribute("id", id);

				request.getRequestDispatcher("index.jsp").forward(request,response);
			} else {
				//ログインが出来なかったとき
				request.getRequestDispatcher("login.jsp").forward(request,response);

				session.setAttribute("logUrl", "loginServlet");
				session.setAttribute("logName", "ログイン");
			}
		} else {
			//エラーがあるときの処理
			request.getRequestDispatcher("login.jsp").forward(request, response);
			session.setAttribute("logUrl", "logoutServlet");
			session.setAttribute("logname", "ログアウト");
		}
	}
}
