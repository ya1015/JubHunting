package jp.ac.hal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	/*
	 * 接続オブジェクトを生成して返す
	 *
	 * @return 接続オブジェクト
	 *
	 * @throws ClaccNotFoundException
	 *
	 * @throws SQLException
	 */
	private Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost/jh",
				"root", "");
	}

	/*
	 * 会員テーブルからデータを取得する
	 */

	public String select(String id, String pass) {
		String member = "";

		// DB接続
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("SELECT member_name FROM member WHERE user_id=? AND password=?");) {

			// 1個目の？を入力されたＩＤに置き換え
			ps.setString(1, id);
			// ２個目の？を入力されたパスワードに置き換え
			ps.setString(2, pass);

			// SQL実行と結果セットの受け取り
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// ユーザ情報が見つかった
				member = rs.getString("member_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		;
		return member;
	}

	/*
	 * 会員テーブルにデータを追加する
	 *
	 * @param name ユーザ名
	 *
	 * @param id ユーザID
	 *
	 * @param password パスワード
	 *
	 * @param mail_address メールアドレス
	 *
	 * @param tel_no 電話番号
	 *
	 * @return 更新件数
	 */
	public int insert(String name, String id, String pass, String mail_address,
			String tel_no, String birthplace) {
		int count = 0;// 更新件数

		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("INSERT INTO member(member_name, user_id, password, mail_address, tel_no, birthplace) VALUES(?, ?, ?, ?, ?, ?)");) {
			System.out.println(ps);
			// ?を置き換え
			ps.setString(1, name);
			ps.setString(2, id);
			ps.setString(3, pass);
			ps.setString(4, mail_address);
			ps.setString(5, tel_no);
			ps.setString(6, birthplace);

			// SQL実行
			count = ps.executeUpdate();
			//System.out.println(count);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return count;
	}
}


