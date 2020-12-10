package dao;

import java.util.List;

import entity.CommentInfo;
import entity.NewsInfo;
import entity.Page;
import entity.UserInfo;

public interface UserInfoDao {
	//增
		int addInfo(UserInfo qu);
		//删
		int deleteInfo(int id);
		//改
		int  updateInfo(UserInfo qu);
		//查
		List<UserInfo> getAllQuestion_info();
		//查询科目
		List<UserInfo> getAllQuestion_info2(int i);
		//按题干模糊查询
		  List<UserInfo> findStr(String str);
		  
		  
		   boolean validateUser(String uname,String upwd);
		   List<NewsInfo> getNewsInfo();
		   List<CommentInfo> getCommentInfo();
		  
		    //分页
			List<NewsInfo> getNewsByPage(Page page);
			//统计数量
			int getNewsCount();
			//修改
			int  updateNews(NewsInfo newsInfo);	
	      	//删除
			int delNewsInfoById(int id);
}
