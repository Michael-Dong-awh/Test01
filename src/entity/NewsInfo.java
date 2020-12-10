package entity;

public class NewsInfo {
	 private int newsid ;
	 private int typeid;
     private String  newstitle;
     private String  newsauthor;
     private String  newssummary;
     private String  newscontent;
     private String  newspic;
	public NewsInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewsInfo(int newsid, int typeid, String newstitle, String newsauthor, String newssummary, String newscontent,
			String newspic) {
		super();
		this.newsid = newsid;
		this.typeid = typeid;
		this.newstitle = newstitle;
		this.newsauthor = newsauthor;
		this.newssummary = newssummary;
		this.newscontent = newscontent;
		this.newspic = newspic;
	}

	public int getNewsid() {
		return newsid;
	}
	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getNewstitle() {
		return newstitle;
	}
	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}
	public String getNewsauthor() {
		return newsauthor;
	}
	public void setNewsauthor(String newsauthor) {
		this.newsauthor = newsauthor;
	}
	public String getNewssummary() {
		return newssummary;
	}
	public void setNewssummary(String newssummary) {
		this.newssummary = newssummary;
	}
	public String getNewscontent() {
		return newscontent;
	}
	public void setNewscontent(String newscontent) {
		this.newscontent = newscontent;
	}
	public String getNewspic() {
		return newspic;
	}
	public void setNewspic(String newspic) {
		this.newspic = newspic;
	}
	@Override
	public String toString() {
		return "NewsInfo [newsid=" + newsid + ", typeid=" + typeid + ", newstitle=" + newstitle + ", newsauthor="
				+ newsauthor + ", newssummary=" + newssummary + ", newscontent=" + newscontent + ", newspic=" + newspic
				+ "]";
	}
     
}
