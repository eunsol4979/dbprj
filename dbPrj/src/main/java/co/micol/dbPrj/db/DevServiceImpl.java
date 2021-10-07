package co.micol.dbPrj.db;

import co.micol.dbPrj.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DevServiceImpl extends DataSource {
	private PreparedStatement psmt;
	private ResultSet rs;

//public List<DevVO> selectList() {
//	DevVO vo;
//	List<DevVO> list = new ArrayList<DevVO>();
//	
//	return list;
//}

	public void selectList() {
		String sql = "select * from dev";
		try {
			psmt = conn.preparStatment(sql);
					rs = psmt.executeQuery();
					while(rs.next()) {
						System.out.println(rs.getInt("id"));
						System.out.println(rs.getString("name"));
						System.out.println(rs.getString("address"));
						System.out.println(rs.getInt("age"));
					}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) rs.close();
			if(psmt != null) psmt.clos
		}
	}

}
