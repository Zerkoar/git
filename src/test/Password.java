package test;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Password {

	protected Shell shell;
	private Text text;
	private Text text_1;
	ResultSet rs;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Password window = new Password();
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

	public void modify_password(ResultSet rs1){
		rs=rs1;
	}
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(257, 225);
		shell.setText("\u4FEE\u6539\u5BC6\u7801");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(23, 38, 48, 17);
		lblNewLabel.setText("\u65E7\u5BC6\u7801\uFF1A");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageBox mb=new MessageBox(shell);
				try {
					if(!text.getText().equals(rs.getString("密码"))) {
						mb.setMessage("旧密码错误!");
						mb.open();
					}
					else{
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/s9", "root", "root");
						String sql = "update tables1 set  密码 =? where 学号=?";
						PreparedStatement ps=conn.prepareStatement(sql);
						ps.setString(1, text_1.getText());
						ps.setString(2, rs.getString("学号"));
						int result=ps.executeUpdate();
					    if(result>0){
							mb.setMessage("修改成功!");
							mb.open();
							shell.dispose();
						}
						else {
							mb.setMessage("修改失败!");
							mb.open();
						}
					}
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(77, 125, 80, 27);
		btnNewButton.setText("\u786E\u8BA4\u4FEE\u6539");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(77, 35, 131, 23);
		
		text_1 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(77, 80, 131, 23);
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("\u65B0\u5BC6\u7801\uFF1A");
		label.setBounds(23, 83, 48, 17);

	}
}
