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
			mb.setMessage("ѧ�Ż����벻��Ϊ��!");
			mb.open();
		}
		else{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/s9", "root", "root");
		String sql="select * from tables1 where ѧ��=? and ����=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, sid);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			mb.setMessage("��¼�ɹ�!");
			mb.open();
			shell.dispose();
			//��ʾ������Ϣ����
			if(rs.getString("����").equals("����Ա")){
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
			mb.setMessage("ѧ�����������!");
			mb.open();
		}
		}
	}
}
