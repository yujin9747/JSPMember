package com.crud.dao;
import java.sql.* ;
import java.util.ArrayList;
import com.crud.bean.MemberVO;
import com.crud.common.JDBCUtil;
public class MemberDAO {
	private Connection conn = null ;
	private PreparedStatement stmt = null ;
	private ResultSet rs = null ;
	private final String M_INSERT = "insert into member(userid, password, username, email, photo, detail)" + 
									" values(?, sha1(?), ?, ?, ?, ?)" ;
	private final String M_UPDATE = "update member set username = ?, email = ?, photo = ?, detail = ? " +
									"where sid = ?" ;
	private final String M_DELETE = "delete from member where sid = ?" ;
	private final String M_SELECT = "select * from member where sid = ?" ;
	private final String M_LIST = "select * from member order by regdate desc" ;
	
	public int insertMember(MemberVO vo) {
		int result = 0 ;
		conn = JDBCUtil.getConnection() ;
		try {
			stmt = conn.prepareStatement(M_INSERT);
			stmt.setString(1, vo.getUserid());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getUsername());
			stmt.setString(4, vo.getEmail());
			stmt.setString(5, vo.getPhoto());
			stmt.setString(6, vo.getDetail());
			result = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void deleteMember(int sid) {
		conn = JDBCUtil.getConnection() ;
		try {
			stmt = conn.prepareStatement(M_DELETE);
			stmt.setInt(1, sid) ;
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int updateMember(MemberVO vo) {
		conn = JDBCUtil.getConnection() ;
		try {
			stmt = conn.prepareStatement(M_UPDATE);
			stmt.setString(1, vo.getUsername());
			stmt.setString(2, vo.getEmail());
			stmt.setString(3, vo.getPhoto());
			stmt.setString(4, vo.getDetail());
			stmt.setInt(5, vo.getSid());

			System.out.println(vo.getUsername() + "-" + vo.getEmail() + "-" 
			+ vo.getPhoto() + "-" + vo.getDetail() + "-" + vo.getSid());
			stmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public MemberVO getOne(int sid) {
		MemberVO one = null ;
		conn = JDBCUtil.getConnection() ;
		try {
			stmt = conn.prepareStatement(M_SELECT) ;
			stmt.setInt(1, sid);
			rs = stmt.executeQuery() ;
			if(rs.next()) {
				one = new MemberVO() ;
				one.setSid(rs.getInt("sid"));
				one.setUserid(rs.getString("userid"));
				one.setUsername(rs.getString("username"));
				one.setEmail(rs.getString("email"));
				one.setPhoto(rs.getString("photo"));
				one.setDetail(rs.getString("detail"));
				one.setRegdate(rs.getDate("regdate"));
			}
			rs.close() ;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return one ;
	}
	
	public ArrayList<MemberVO> getList() {
		ArrayList<MemberVO> list = null ;
		conn = JDBCUtil.getConnection() ;
		try {
			stmt = conn.prepareStatement(M_LIST) ;
			rs = stmt.executeQuery() ;
			list = new ArrayList<MemberVO>() ;
			while(rs.next()) {
				MemberVO one = new MemberVO() ;
				one.setSid(rs.getInt("sid"));
				one.setUserid(rs.getString("userid"));
				one.setUsername(rs.getString("username"));
				one.setEmail(rs.getString("email"));
				one.setRegdate(rs.getDate("regdate"));
				list.add(one) ;
			}
			rs.close() ;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list ;
	}

	public String getPhotoFilename(int sid) {
		String filename = null ;
		try {
			conn = JDBCUtil.getConnection() ;
			stmt = conn.prepareStatement(M_SELECT) ;
			stmt.setInt(1, sid) ;
			rs = stmt.executeQuery() ;
			if(rs.next()) {
				filename = rs.getString("photo") ;
			}
			rs.close() ;
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("===> JDBC�� getPhotoFilename() ��� ó��") ;
		return filename ;
	}

}
