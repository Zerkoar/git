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
		String sql="delete from tables1 where ѧ��=? ";
		ps=conn.prepareStatement(sql);
		ps.setString(1, sid);
	    ps=conn.prepareStatement(sql);
		ps.setString(1, sid);
		int result=ps.executeUpdate();
	    if(result>0){
	    	mb.setMessage("ɾ���ɹ�");
	    	mb.open();
		}
		else {
	    	mb.setMessage("ɾ��ʧ�ܣ�ѧ�Ų�����,����������!");
	    	mb.open();
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}
	}
}
