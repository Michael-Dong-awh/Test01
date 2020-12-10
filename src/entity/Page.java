package entity;

public class Page {
	private int currentpage;//当前页
	private int pagesize=2;//每页显示条数
	private int sumsize;//总条数
	private int lastpage;//最后一页
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
	//点击上一页 已经是首页
		if(currentpage <= 0){
			this.currentpage = 1;
			//点击下一页 已经是尾页
		}else if(currentpage > this.lastpage){
		this.currentpage =this.lastpage ;
	}else{
		this.currentpage =currentpage;

	}
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getSumsize() {
		return sumsize;
	}
	public void setSumsize(int sumsize) {
		this.sumsize = sumsize;
	}
	public int getLastpage() {
		return lastpage;
	}
	public void setLastpage(int lastpage) {
		this.lastpage = lastpage;
	}
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Page(int currentpage, int pagesize, int sumsize, int lastpage) {
		super();
		this.currentpage = currentpage;
		this.pagesize = pagesize;
		this.sumsize = sumsize;
		this.lastpage = lastpage;
	}
	@Override
	public String toString() {
		return "Page [currentpage=" + currentpage + ", pagesize=" + pagesize + ", sumsize=" + sumsize + ", lastpage="
				+ lastpage + "]";
	}
	
	
}
