package test;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Admin {

	protected Shell shlAdminWindow;
	private Table table;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Admin window = new Admin();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void open() throws ClassNotFoundException, SQLException {
		Display display = Display.getDefault();
		createContents();
		shlAdminWindow.open();
		shlAdminWindow.layout();
		while (!shlAdminWindow.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void show() throws ClassNotFoundException, SQLException{
		String name="管理员";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/s9", "root", "root");
		String sql="select * from tables1 where 姓名<>? ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(new String[] { rs.getString("学号"),
					rs.getString("姓名"), rs.getString("性别"),
					rs.getString("班级"),rs.getString("学院"),rs.getString("密码")});
		}
	}
	protected void createContents() throws ClassNotFoundException, SQLException {
		shlAdminWindow = new Shell();
		shlAdminWindow.setSize(501, 374);
		shlAdminWindow.setText("\u5B66\u751F\u540D\u5355");
		
		table = new Table(shlAdminWindow, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(0, 24, 485, 311);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(69);
		tableColumn.setText("\u5B66\u53F7");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(71);
		tableColumn_1.setText("\u59D3\u540D");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(44);
		tableColumn_2.setText("\u6027\u522B");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(100);
		tableColumn_3.setText("\u73ED\u7EA7");
		
		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setText("\u5B66\u9662");
		tableColumn_4.setWidth(87);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(110);
		tblclmnNewColumn.setText("\u5BC6\u7801");
		
		text = new Text(shlAdminWindow, SWT.BORDER);
		text.setBounds(0, 0, 187, 23);
		
		Button btnNewButton = new Button(shlAdminWindow, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					table.removeAll();
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/s9", "root", "root");
					String sql="select * from tables1 where 学号 like ? or 姓名 like ? or 性别 like ? or 班级 like ? or 学院  like ? ";
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setString(1, "%"+text.getText()+"%");
					ps.setString(2, "%"+text.getText()+"%");
					ps.setString(3, "%"+text.getText()+"%");
					ps.setString(4, "%"+text.getText()+"%");
					ps.setString(5, "%"+text.getText()+"%");
					ResultSet rs = ps.executeQuery();
					while(rs.next())
					{
						TableItem tableItem = new TableItem(table, SWT.NONE);
						tableItem.setText(new String[] { rs.getString("学号"),
								rs.getString("姓名"), rs.getString("性别"),
								rs.getString("班级"),rs.getString("学院"),rs.getString("密码")});
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(193, 0, 64, 23);
		btnNewButton.setText("\u67E5\u8BE2");
		show();

	}
}
