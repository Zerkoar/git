package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.swt.widgets.MessageBox;

public class add {
public void addData(String sid,String name,String sex,String classes,String college,MessageBox mb) {
	String password="123";
	PreparedStatement ps;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/s9", "root", "root");
		String sql="select * from tables1 where ѧ��=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, sid);
		ResultSet rs=ps.executeQuery();
		if(sid==""||name==""||sex==""||classes==""||college=="") {
	    	mb.setMessage("����дȫ����Ϣ!");
	    	mb.open();
			return;
		}
		if(rs.next()){
	    	mb.setMessage("���ʧ�ܣ�ѧ���Ѵ���,����������!");
	    	mb.open();
		}
		else{
		sql="insert into tables1 values(?,?,?,?,?,?)";
	    ps=conn.prepareStatement(sql);
		ps.setString(1, sid);
		ps.setString(2, name);
		ps.setString(3, sex);
		ps.setString(4, classes);
		ps.setString(5, college);
		ps.setString(6, password);
		int result=ps.executeUpdate();
		
	    if(result>0){
	    	mb.setMessage("��ӳɹ�!");
	    	mb.open();
		}
		else {
	    	mb.setMessage("���ʧ��!");
	    	mb.open();
		}
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}
}
}
