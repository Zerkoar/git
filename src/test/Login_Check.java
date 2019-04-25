package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class Login_Check {

	public void Check(String sid1,String password1,MessageBox mb1,Shell shell) throws SQLException, ClassNotFoundException{
		String sid=sid1;
		String password=password1;
		MessageBox mb=mb1;
		if(sid==""||password==""){
			mb.setMessage("学号或密码不能为空!");
			mb.open();
		}
		else{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/s9", "root", "root");
		String sql="select * from tables1 where 学号=? and 密码=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, sid);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			mb.setMessage("登录成功!");
			mb.open();
			shell.dispose();
			//显示个人信息窗口
			if(rs.getString("姓名").equals("管理员")){
				Admin_Control control=new Admin_Control();
				control.open();
			}
			else{
			Information_Check information=new Information_Check();
			information.show(rs);
			information.open();
			}
		}
		else{
			mb.setMessage("学籍或密码错误!");
			mb.open();
		}
		}
	}
}
