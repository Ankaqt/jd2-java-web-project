package by.htp.dao.impl;

public class SQLQueryConstant {
	
	public static final String SQL_QUERY_SELECT_USER = "SELECT * from userinfo where userinfo_name=? and userinfo_password=?";
	public static final String SQL_QUERY_CREATE_USER = "INSERT INTO userinfo(userinfo_name,userinfo_email,userinfo_phone,userinfo_password) VALUES(?,?,?,?)";
	
	public static final String SQL_QUERY_SELECT_ALL_NEWS = "SELECT * FROM news WHERE news_status ='active'";
	public static final String SQL_QUERY_SELECT_NEWS_BY_ID = "SELECT * FROM news WHERE news_id = ?";
	public static final String SQL_QUERY_UPDATE_NEWS = "UPDATE news SET news_title = ?, news_brief = ?, news_content = ? WHERE news_id = ?";
	public static final String SQL_QUERY_DELETE_NEWS = "UPDATE news SET news_status ='inactive' WHERE news_id = ?";
	public static final String SQL_QUERY_ADD_NEWS = "INSERT INTO news (news_title, news_brief, news_content, news_date) VALUES (?, ?, ?, ?)";

}
