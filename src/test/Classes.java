package test;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Classes {

	protected Shell shell;
	private Table table;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Classes window = new Classes();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	public void show() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/s9", "root", "root");
		String sql="select 学院,班级,count(学号)人数  from tables1 where 学院 is not NULL group by 班级,学院";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(new String[] { rs.getString("学院"),rs.getString("班级"),rs.getString("人数")});
		}
	}
	/**
	 * Create contents of the window.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	protected void createContents() throws ClassNotFoundException, SQLException {
		shell = new Shell();
		shell.setSize(342, 300);
		shell.setText("\u73ED\u7EA7\u540D\u5355");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(0, 24, 326, 237);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(121);
		tableColumn.setText("\u5B66\u9662");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(130);
		tableColumn_1.setText("\u73ED\u7EA7");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(71);
		tableColumn_2.setText("\u4EBA\u6570");

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					table.removeAll();
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/s9", "root", "root");
					String sql="select 学院,班级,count(学号)人数  from tables1 where 学院 like ? or 班级 like ? group by 班级,学院";
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setString(1, "%"+text.getText()+"%");
					ps.setString(2, "%"+text.getText()+"%");
					ResultSet rs = ps.executeQuery();
					while(rs.next())
					{
						TableItem tableItem = new TableItem(table, SWT.NONE);
						tableItem.setText(new String[] { rs.getString("学院"),rs.getString("班级"),rs.getString("人数")});
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		text = new Text(shell, SWT.BORDER);
		text.setBounds(0, 0, 132, 23);
		btnNewButton.setBounds(138, 0, 54, 23);
		btnNewButton.setText("\u67E5\u8BE2");	
		show();
	}
}
