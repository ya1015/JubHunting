package jp.ac.hal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class shinki_tourokuServlet
 */
@WebServlet("/shinki_tourokuServlet")
public class Shinki_tourokuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Shinki_tourokuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字コード設定
		request.setCharacterEncoding("utf-8");

		//パラメータの取り出し
		String name = request.getParameter("member_name");
		String id = request.getParameter("user_id");
		String pass = request.getParameter("pass");
		String pass2 = request.getParameter("pass2");
		String mail_address = request.getParameter("mail_address");
		String tel_no = request.getParameter("tel_no");
		String birthplace = request.getParameter("birthplace");

		//System.out.println(name);
		//System.out.println(id);
		//System.out.println(pass);
		//System.out.println(pass2);
		//System.out.println(mail_address);
		//System.out.println(tel_no);
		//System.out.println(location_id);

		//エラー用フラグ
		boolean isErr = false;

		//セッション定義
		HttpSession session = request.getSession(true);

		//エラーチェック(入力値なし)
		if(name == null || name.isEmpty()){
			isErr = true;
			request.setAttribute("nullErr", "未入力項目があります");
		}
		if(id == null || id.isEmpty()){
			isErr = true;
			request.setAttribute("nullErr", "未入力項目があります");
		}
		if(pass == null || pass.isEmpty()){
			isErr = true;
			request.setAttribute("nullErr", "未入力項目があります");
		}
		if(pass2 == null || pass2.isEmpty()){
			isErr = true;
			request.setAttribute("nullErr", "未入力項目があります");
		}
		if(mail_address == null || mail_address.isEmpty()){
			isErr = true;
			request.setAttribute("nullErr", "未入力項目があります");
		}
		if(tel_no == null || tel_no.isEmpty()){
			isErr = true;
			request.setAttribute("nullErr", "未入力項目があります");
		}
		//System.out.println(isErr);

		//パスワードと確認用パスワード照合
		if(!pass.equals(pass2)){
			isErr = true;
			request.setAttribute("passErr","確認用パスワードが違います");
		}
		//System.out.println(isErr);

		//全角文字防止
		if(id != null && !id.isEmpty()){
			if(!id.matches("[0-9a-zA-Z]+") ||!id.matches("[0-9a-zA-Z]+")){
				isErr = true;
				request.setAttribute("zenErr","会員名以外は半角で入力してください");
			}
		}
		if(pass != null && !pass.isEmpty()){
			if(!pass.matches("[0-9a-zA-Z]+") ||!pass.matches("[0-9a-zA-Z]+")){
				isErr = true;
				request.setAttribute("zenErr","会員名以外は半角で入力してください");
			}
		}
		if(pass2 != null && !pass2.isEmpty()){
			if(!pass2.matches("[0-9a-zA-Z]+") ||!pass2.matches("[0-9a-zA-Z]+")){
				isErr = true;
				request.setAttribute("zenErr","会員名以外は半角で入力してください");
			}
		}
		if(mail_address != null && !mail_address.isEmpty()){
			if(!mail_address.matches("[0-9a-zA-Z]+") ||!mail_address.matches("[0-9a-zA-Z]+")){
				isErr = true;
				request.setAttribute("zenErr","会員名以外は半角で入力してください");
			}
		}
		if(tel_no != null && !tel_no.isEmpty()){
			if(!tel_no.matches("[0-9a-zA-Z]+") ||!tel_no.matches("[0-9a-zA-Z]+")){
				isErr = true;
				request.setAttribute("zenErr","会員名以外は半角で入力してください");
			}
		}

		//System.out.println("a");
		//System.out.println(isErr);
		//エラーが出ていなければ
		if(!isErr){
			//System.out.println("b");
			MemberDAO dao = new MemberDAO();

			int count = dao.insert(name, id, pass, mail_address, tel_no, birthplace);

			String member = dao.select(id, pass);

			session.setAttribute("logUrl", "logoutServlet");
			session.setAttribute("logName", "ログアウト");
			session.setAttribute("member", member);

			//RaiseServletでに使用
			session.setAttribute("id", id);

			System.out.println("sss");
			request.getRequestDispatcher("regist_comp.jsp").forward(request, response);
			if(count <= 0){
				//System.out.println("c");
				request.setAttribute("mes","データが更新されませんでした");
				request.getRequestDispatcher("shinki_touroku.jsp").forward(request, response);
			}
		}else{
			//エラーがあれば
			request.getRequestDispatcher("shinki_touroku.jsp").forward(request, response);
		}
	}
}
