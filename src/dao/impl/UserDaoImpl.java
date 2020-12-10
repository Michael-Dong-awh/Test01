package dao.impl;

import java.util.ArrayList;
import java.util.List;
import dao.BaseDao;
import dao.UserInfoDao;
import entity.CommentInfo;
import entity.NewsInfo;
import entity.Page;
import entity.UserInfo;

public class UserDaoImpl  extends BaseDao implements UserInfoDao{

	@Override
	public int addInfo(UserInfo qu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteInfo(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateInfo(UserInfo qu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserInfo> getAllQuestion_info() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> getAllQuestion_info2(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> findStr(String str) {
		// TODO Auto-generated method stub
		return null;
	}
//账户密码
	@Override
	public boolean validateUser(String uname, String upwd) {
	boolean flag = false;
		try {
			String sql = "SELECT * FROM user_info o WHERE o.`username` =? AND o.`password` = ?";
			pst = getConnection().prepareStatement(sql);
			pst.setString(1,uname);
			pst.setString(2,upwd);
			rs = pst.executeQuery();
			while(rs.next()){
				flag =true;
			}
		} catch (Exception e) {
		e.printStackTrace();
		}finally {
			closeAll(conn, pst, rs);
		}
		return flag;
	}
//信息表
	@Override
	public List<NewsInfo> getNewsInfo() {
		List<NewsInfo> list = new ArrayList<NewsInfo>();
		try {
			String sql = "SELECT * FROM `news_info`";
			pst = getConnection().prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				NewsInfo nInfo =	new NewsInfo();
				nInfo.setNewsid(rs.getInt(1));
				nInfo.setTypeid(rs.getInt(2));
				nInfo.setNewstitle(rs.getString(3));
				nInfo.setNewsauthor(rs.getString(4));
				nInfo.setNewssummary(rs.getString(5));
				nInfo.setNewscontent(rs.getString(6));
				nInfo.setNewspic(rs.getString(7));
				list.add(nInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pst, rs);
		}
		return list;
	}
//comment_info表
	@Override
	public List<CommentInfo> getCommentInfo() {
		List<CommentInfo> list = new ArrayList<>();
		try {
			String sql = "SELECT * FROM `comment_info`";
			pst = getConnection().prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				CommentInfo co = new CommentInfo();
				co.setCommentId(rs.getInt(1));
				co.setUsername(rs.getString(2));
				co.setIp(rs.getString(3));
				co.setContent(rs.getString(4));
				co.setNewsId(rs.getInt(5));
				/*co.setFbtime(rs.getString(6));*/
				co.setFbtime(rs.getDate(6));
				list.add(co);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pst, rs);
		}
		return list;
	}

	@Override
	public int getNewsCount() {
		int count = 0;
		try {
			String sql = "SELECT COUNT(*) FROM news_info";
			pst = getConnection().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);//查询结果为第一行
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public List<NewsInfo> getNewsByPage(Page page) {
		 List<NewsInfo> list = new ArrayList<>();
		try {
			String sql = "SELECT * FROM`news_info` LIMIT ?,?";
			pst = getConnection().prepareStatement(sql);
			//赋值
/*//			private int currentpage;//当前页
			private int pagesize=2;//每页显示条数
			private int sumsize;//总条数
			private int lastpage;//最后一页
*/			pst.setInt(1,(page.getCurrentpage()-1)*page.getPagesize());
			pst.setInt(2,page.getPagesize());
			rs = pst.executeQuery();
			while(rs.next()){
				NewsInfo nInfo =	new NewsInfo();
				nInfo.setNewsid(rs.getInt(1));
				nInfo.setTypeid(rs.getInt(2));
				nInfo.setNewstitle(rs.getString(3));
				nInfo.setNewsauthor(rs.getString(4));
				nInfo.setNewssummary(rs.getString(5));
				nInfo.setNewscontent(rs.getString(6));
				nInfo.setNewspic(rs.getString(7));
				list.add(nInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pst, rs);
		}
		return list;
	}

	@Override
	public int updateNews(NewsInfo newsInfo) {
		int flag = 0;
		try {
			String sql ="UPDATE `news_info` SET type_id =?,news_title = ?,news_author = ?,news_summary = ?,news_content = ?,news_pic='aaa.jpg' WHERE news_id = ?";
			pst = getConnection().prepareStatement(sql);
			pst.setInt(1, newsInfo.getTypeid());
			pst.setString(2, newsInfo.getNewstitle());
			pst.setString(3, newsInfo.getNewsauthor());
			pst.setString(4, newsInfo.getNewssummary());
			pst.setString(5, newsInfo.getNewscontent());
			pst.setInt(6, newsInfo.getNewsid());
			flag = pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			closeAll(conn, pst, rs);
		}
		return flag;
	}

	@Override
	public int delNewsInfoById(int id) {
		int flag=0;
		try {
			String sql="DELETE FROM news_info WHERE news_id=?";
			pst= getConnection().prepareStatement(sql);
			pst.setInt(1, id);
			flag = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeAll(conn, pst, rs);
		}
		return flag;
	}

	

}
