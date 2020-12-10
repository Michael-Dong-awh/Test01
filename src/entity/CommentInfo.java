package entity;

import java.util.Date;

public class CommentInfo {
	private int commentId;
	private String username;
	private String ip;
	private String content;
	private int newsId;
	private Date  fbtime;
	public CommentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public Date getFbtime() {
		return fbtime;
	}

	public void setFbtime(Date fbtime) {
		this.fbtime = fbtime;
	}

	public CommentInfo(int commentId, String username, String ip, String content, int newsId, Date fbtime) {
		super();
		this.commentId = commentId;
		this.username = username;
		this.ip = ip;
		this.content = content;
		this.newsId = newsId;
		this.fbtime = fbtime;
	}
	
	
}
