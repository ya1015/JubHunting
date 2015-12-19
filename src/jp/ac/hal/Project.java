package jp.ac.hal;

public class Project {
	//企画番号
	private int project_no;
	//企画名
	private String project_name;
	//募集終了日
	private int recruitment_end;
	//目標支援額
	private int goal_support_amount;
	//キャプション
	private String caption;
	//動画パス
	private String movie_path;
	//本文
	private String text;
	//最終支援人数
	private int support_numbers;
	//紹介用画像パス
	private String introduction_visual_path;
	//公開フラグ
	private int publication_flag;
	//最終支援額
	private int support_amount;
	//企画地
	private String planning_area;
	//カテゴリー名
	private String category_name;




	public int getProject_no() {
		return project_no;
	}
	public void setProject_no(int project_no) {
		this.project_no = project_no;
	}

	public String getIntroduction_visual_path() {
		return introduction_visual_path;
	}
	public void setIntroduction_visual_path(String introduction_visual_path) {
		this.introduction_visual_path = introduction_visual_path;
	}

	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public int getRecruitment_end() {
		return recruitment_end;
	}
	public void setRecruitment_end(int recruitment_end) {
		this.recruitment_end = recruitment_end;
	}

	public int getGoal_support_amount() {
		return goal_support_amount;
	}
	public void setGoal_support_amount(int goal_support_amount) {
		this.goal_support_amount = goal_support_amount;
	}

	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getMovie_path() {
		return movie_path;
	}
	public void setMovie_path(String movie_path) {
		this.movie_path = movie_path;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public int getSupport_numbers() {
		return support_numbers;
	}
	public void setSupport_numbers(int support_numbers) {
		this.support_numbers = support_numbers;
	}

	public int getSupport_amount() {
		return support_amount;
	}
	public void setSupport_amount(int support_amount) {
		this.support_amount = support_amount;
	}

	public String getPlanning_area() {
		return planning_area;
	}
	public void setPlanning_area(String planning_area) {
		this.planning_area = planning_area;
	}

	public int getPublication_flag() {
		return publication_flag;
	}
	public void setPublication_flag(int publication_flag) {
		this.publication_flag = publication_flag;
	}

	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}



}
