package jp.ac.hal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProjectDAO {
	/*
	 * 接続オブジェクトを生成して返す
	 *
	 * @return 接続オブジェクト
	 *
	 * @throws ClaccNotFoundException
	 *
	 * @throws SQLException
	 */
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost/jh", "root", "");
	}

	/*
	 * 会員テーブルからuser_idを元にmember_noをとってくる
	 */
	public int selectMember_no(String user_id) {
		int member_no = 0;
		// DB接続
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement("SELECT member_no FROM member WHERE user_id = ?");) {

			// ?を置き換え
			ps.setString(1, user_id);

			// SQL実行と結果セットの受け取り
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// 会員番号が見つかった
				member_no = rs.getInt("member_no");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return member_no;
	}

	/*
	 * カテゴリーテーブルからcategory_noをとってくる
	 */
	public int selectCategory(String category_name) {
		int category_no = 0;

		// DB接続
		try (Connection con = getConnection();

				PreparedStatement ps = con
						.prepareStatement("SELECT category_no FROM category WHERE category_name = ?");) {

			// ?を置き換え
			ps.setString(1, category_name);

			// SQL実行と結果セットの受け取り
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// カテゴリー番号が見つかった
				category_no = rs.getInt("category_no");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return category_no;
	}

	/*
	 * プロジェクトテーブルにデータを追加する
	 */
	public int insert(String project_name, int category_no, int member_no) {
		int count = 0;// 更新件数
		// DB接続
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("INSERT INTO project(project_name, member_no, category_no) VALUES(?,?,?)");) {

			// ?を置き換え
			ps.setString(1, project_name);
			ps.setInt(2, member_no);
			ps.setInt(3, category_no);

			// SQL実行と結果セットの受け取り
			count = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return count;
	}

	/*
	 * 追加されたデータの中の最新の企画番号をとってくる
	 */
	public int selectNewProjectNo() {
		int project_no = 0;

		// DB接続
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("SELECT project_no FROM project ORDER BY project_no DESC LIMIT 1");) {

			// SQL実行
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// カテゴリー番号が見つかった
				project_no = rs.getInt("project_no");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return project_no;
	}

	/*
	 * データ更新(raise_edit_title.jsp)
	 */
	public int updateTitle(int project_no, String project_name, String caption, int category_no, String planning_area,
			int goal_support_amount, String recruitment_end) {
		int count = 0;// 更新件数

		// System.out.println("mm");

		// DB接続
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(
						"UPDATE project SET project_name=?, caption=?, category_no=?, planning_area=?,goal_support_amount=?, recruitment_end=? WHERE project_no=?");) {

			// ?を置き換え
			ps.setString(1, project_name);
			ps.setString(2, caption);
			ps.setInt(3, category_no);
			ps.setString(4, planning_area);
			ps.setInt(5, goal_support_amount);
			ps.setString(6, recruitment_end);
			ps.setInt(7, project_no);

			// SQL実行と結果セットの受け取り
			count = ps.executeUpdate();
			System.out.println("bb");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return count;
	}

	/*
	 * データ更新(raise_edit_text.jsp)
	 */
	public int updateText(String text, int project_no) {
		int count = 0; // 更新件数

		// DB接続
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement("UPDATE project SET text=? WHERE project_no=?");) {

			// ?を置き換え
			ps.setString(1, text);
			ps.setInt(2, project_no);

			// SQL実行と結果セットの受け取り
			count = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return count;
	}

	/*
	 * 紹介用画像データ追加(raise_edit_image.jsp)
	 */
	public int insertImage(String introduction_visual_path, int project_no, int type) {
		int count = 0; // 更新件数

		// DB接続
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(
						"INSERT INTO introduction_visual(introduction_visual_path, project_no, type) VALUES(?, ?, ?)");) {

			// ?を置き換え
			ps.setString(1, introduction_visual_path);
			ps.setInt(2, project_no);
			ps.setInt(3, type);

			// SQL実行と結果セットの受け取り
			count = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return count;
	}

	/*
	 * データ更新
	 */
	public int updateMovie(String movie_path, int project_no) {
		int count = 0; // 更新件数

		// DB接続
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement("UPDATE project SET movie_path=? WHERE project_no=?");) {

			ps.setString(1, movie_path);
			ps.setInt(2, project_no);

			count = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return count;
	}

	/*
	 * 企画テーブルから値をとってくる(raise_confirmation.jsp)
	 */
	public ArrayList<Project> select1(int project_no) {
		ArrayList<Project> list = new ArrayList<Project>();

		// System.out.println("aa");

		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(
						"SELECT project_name, recruitment_end, goal_support_amount, caption, movie_path, text, introduction_visual_path, planning_area FROM project"
								+ " JOIN introduction_visual ON project.project_no = introduction_visual.project_no WHERE project.project_no = ?");

		) {
			// ?置き換え
			ps.setInt(1, project_no);

			// SQL実行と結果セットの受け取り
			ResultSet rs = ps.executeQuery();

			// 結果セットからオブジェクトにデータを入れる
			if (rs.next()) {
				// 次のデータが存在したらオブジェクトを生成する
				Project p = new Project();

				// 生成したオブジェクトにデータをセットする
				p.setProject_name(rs.getString("project_name"));
				p.setRecruitment_end(rs.getInt("recruitment_end"));
				p.setGoal_support_amount(rs.getInt("goal_support_amount"));
				p.setCaption(rs.getString("caption"));
				p.setMovie_path(rs.getString("movie_path"));
				p.setText(rs.getString("text"));
				p.setIntroduction_visual_path(rs.getString("introduction_visual_path"));
				p.setPlanning_area(rs.getString("planning_area"));

				// System.out.println(rs.getString("project_name"));
				// System.out.println(rs.getInt("recruitment_end"));
				// System.out.println(rs.getInt("goal_support_amount"));
				// System.out.println(rs.getString("caption"));
				// System.out.println(rs.getString("movie_path"));
				// System.out.println(rs.getString("text"));
				// System.out.println(rs.getString("introduction_visual_path"));
				// System.out.println(rs.getString("planning_area"));

				// 生成したオブジェクトをリストに追加する
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * 企画テーブルから値をとってくる(raise_confirmation.jsp)
	 */
	public String select2(int project_no) {
		String category_name = "";

		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(
						"SELECT category_name FROM category JOIN project ON  category.category_no = project.category_no WHERE project.project_no = ?");

		) {
			ps.setInt(1, project_no);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				category_name = rs.getString("category_name");
				System.out.println(category_name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return category_name;
	}

	/*
	 * 企画テーブルの公開フラグを立てる処理
	 */
	public void updateFlag(int project_no) {

		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("UPDATE project SET publication_flag = true WHERE project_no = ? ");

		) {
			ps.setInt(1, project_no);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return;
	}

	/*
	 * detail.jsp用
	 */
	public ArrayList<Project> selectDetail(int project_no) {

		ArrayList<Project> list = new ArrayList<Project>();

		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(
						"SELECT project.project_no, project_name, category_name, introduction_visual_path,"
						+ " caption, support_amount, goal_support_amount, support_numbers, recruitment_end, text"
						+ " FROM project INNER JOIN introduction_visual ON project.project_no = introduction_visual.project_no"
						+ " INNER JOIN category ON project.category_no = category.category_no WHERE project.project_no = ?");
				) {
			ps.setInt(1, project_no);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Project p = new Project();

				p.setProject_no(rs.getInt("project_no"));
				p.setProject_name(rs.getString("project_name"));
				p.setIntroduction_visual_path(rs.getString("introduction_visual_path"));
				p.setCaption(rs.getString("caption"));
				p.setSupport_amount(rs.getInt("support_amount"));
				p.setGoal_support_amount(rs.getInt("goal_support_amount"));
				p.setSupport_numbers(rs.getInt("support_numbers"));
				p.setRecruitment_end(rs.getInt("recruitment_end"));
				p.setText(rs.getString("text"));

				// System.out.println(rs.getInt("support_amount"));
				// System.out.println(rs.getInt("support_numbers"));

				list.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * List.jsp用
	 */
	public ArrayList<Project> selectList() {

		System.out.println("ListDAO");
		ArrayList<Project> list = new ArrayList<Project>();

		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(
						"SELECT project.project_no, project_name, introduction_visual_path, category_name, caption, support_amount, support_numbers, recruitment_end FROM project "
						+ "INNER JOIN introduction_visual ON project.project_no = introduction_visual.project_no INNER JOIN category ON project.category_no = category.category_no WHERE project.publication_flag = true");) {

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Project p = new Project();

				p.setProject_no(rs.getInt("project_no"));
				p.setProject_name(rs.getString("project_name"));
				p.setIntroduction_visual_path(rs.getString("introduction_visual_path"));
				p.setCategory_name(rs.getString("category_name"));
				p.setCaption(rs.getString("caption"));
				p.setSupport_amount(rs.getInt("support_amount"));
				p.setSupport_numbers(rs.getInt("support_numbers"));
				p.setRecruitment_end(rs.getInt("recruitment_end"));

				//System.out.println(rs.getInt("project_no"));
				//System.out.println(rs.getString("project_name"));
				//System.out.println(rs.getString("introduction_visual_path"));
				//System.out.println(rs.getString("category_name"));
				//System.out.println(rs.getString("caption"));
				//System.out.println(rs.getInt("support_amount"));
				//System.out.println(rs.getInt("support_numbers"));
				//System.out.println(rs.getInt("recruitment_end"));

				list.add(p);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * fund.jsp用
	 */
	public int updateSupportAmount(int support_amount, int project_no){
		int count = 0; //更新件数

		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(
						"UPDATE project SET support_amount = support_amount + ? WHERE project_no = ? ");
				){
			ps.setInt(1, support_amount);
			ps.setInt(2, project_no);

			count = ps.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return count;
	}

	public int updateSupportNumbers(int project_no){
		int count = 0;//更新件数

		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(
						"UPDATE project SET support_numbers = support_numbers + 1 WHERE project_no = ? ");
				){

			ps.setInt(1, project_no);

			count = ps.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return count;
	}

}
