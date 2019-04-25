package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.swt.widgets.MessageBox;

public class Delet {
	public void deletData(String sid1,MessageBox mb1){
		String sid=sid1;
		MessageBox mb=mb1;
		PreparedStatement ps;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/s9", "root", "root");
		String sql="delete from tables1 where 学号=? ";
		ps=conn.prepareStatement(sql);
		ps.setString(1, sid);
	    ps=conn.prepareStatement(sql);
		ps.setString(1, sid);
		int result=ps.executeUpdate();
	    if(result>0){
	    	mb.setMessage("删除成功");
	    	mb.open();
		}
		else {
	    	mb.setMessage("删除失败，学号不存在,请重新输入!");
	    	mb.open();
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	}
}
