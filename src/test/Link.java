package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.swt.widgets.MessageBox;

public class Link {
public void Linkmysql(String sid1 ,String name1,MessageBox mb1){
	try {
		String	 sid=sid1;
	    String	 name=name1;
	    String   sql=null;
	    MessageBox mb=mb1;
	    int p=0;
	    if(sid==""&&name=="") {
	    	mb.setMessage("ѧ�ţ��������ܶ�Ϊ��!");
	    	mb.open();
	    	p=1;
	    	name=null;
	    	sid=null;
	    }
	    else if(sid=="") sid=null;
	    else if(name=="") name=null;
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/s9", "root", "root");
		sql="select * from tables1 where ѧ��=? or ����=?";
		if(sid!=null&&name!=null) sql="select * from tables1 where ѧ��=? and ����=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, sid);
		ps.setString(2, name);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			  p=1;
		}
		 if(p!=1){
		    	mb.setMessage("��ѯ�޼�¼,����������!");
		    	mb.open();
		}

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}
}
}

