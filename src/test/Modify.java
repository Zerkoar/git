package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.swt.widgets.MessageBox;

public class Modify {
public void modifyData(String sid1,String name1,String sex1,String classes1,String college,MessageBox mb){
	String sid=sid1;
	String name=name1;
	String sex=sex1;	
	String classes=classes1;
	if(name.equals("")||sex.equals("")||classes.equals("")||college.equals(""))
	{
		mb.setMessage("��Ϣ�����п�!");
		mb.open();
	}
	else{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/s9", "root", "root");
		String sql = "update tables1 set  ����=? , �Ա�=? , �༶=? , ѧԺ =? where ѧ��=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, sex);
		ps.setString(3, classes);
		ps.setString(4, college);
		ps.setString(5, sid);
		int result=ps.executeUpdate();
	    if(result>0){
			mb.setMessage("�޸ĳɹ�!");
			mb.open();
		}
		else {
			mb.setMessage("�޸�ʧ��!");
			mb.open();
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}
	}
}
}
