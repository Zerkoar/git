package test;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Enroll {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Enroll window = new Enroll();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(302, 300);
		shell.setText("SWT Application");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(47, 23, 38, 17);
		lblNewLabel.setText("\u5B66\u53F7\uFF1A");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(91, 20, 134, 23);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(91, 58, 134, 23);
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("\u59D3\u540D\uFF1A");
		label.setBounds(47, 61, 38, 17);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(91, 96, 134, 23);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("\u6027\u522B\uFF1A");
		label_1.setBounds(47, 99, 38, 17);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(91, 132, 134, 23);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("\u73ED\u7EA7\uFF1A");
		label_2.setBounds(47, 135, 38, 17);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(91, 172, 134, 23);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setText("\u5BC6\u7801 \uFF1A");
		label_3.setBounds(47, 175, 38, 17);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageBox mb=new MessageBox(shell);
				PreparedStatement ps;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/s9", "root", "root");
					String sql="select * from tables1 where sid=?";
					ps=conn.prepareStatement(sql);
					ps.setString(1,text.getText() );
					ResultSet rs=ps.executeQuery();
				    if(text.getText().equals("")||text_1.getText().equals("")
							||text_2.getText().equals("")||text_3.getText().equals("")
							||text_4.getText().equals("")) {
				    	mb.setMessage("请填写全部信息!");
				    	mb.open();
						return;
					}
					if(rs.next()){
				    	mb.setMessage("添加失败，学号已存在,请重新输入!");
				    	mb.open();
					}
					else{
					sql="insert into tables1 values(?,?,?,?,?)";
				    ps=conn.prepareStatement(sql);
					ps.setString(1, text.getText());
					ps.setString(2, text_1.getText());
					ps.setString(3, text_2.getText());
					ps.setString(4, text_3.getText());
					ps.setString(5, text_4.getText());
					int result=ps.executeUpdate();
					
				    if(result>0){
				    	mb.setMessage("注册成功!");
				    	mb.open();
					}
					else {
				    	mb.setMessage("注册失败!");
				    	mb.open();
					}
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(113, 212, 80, 27);
		btnNewButton.setText("\u6CE8\u518C");

	}
}
