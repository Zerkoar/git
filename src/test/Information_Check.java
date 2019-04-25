package test;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.custom.TableCursor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Information_Check {

	protected Shell shlInformation;
	public Text text;
	public Text text_1;
	public Text text_2;
	private Text text_3;
	private Button button;
	ResultSet rs;
	private Label label_2;
	private Text text_4;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Information_Check window = new Information_Check();
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
		shlInformation.open();
		shlInformation.layout();
		while (!shlInformation.isDisposed()) {
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
	protected void createContents() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/s9", "root", "root");
		shlInformation = new Shell();
		shlInformation.setSize(272, 310);
		shlInformation.setText("\u4E2A\u4EBA\u4FE1\u606F");
		
		Label lblNewLabel = new Label(shlInformation, SWT.NONE);
		lblNewLabel.setBounds(33, 28, 37, 17);
		lblNewLabel.setText("\u5B66\u53F7:");
		
		text = new Text(shlInformation, SWT.BORDER);
		text.setText(rs.getString("学号"));
		text.setBounds(76, 25, 119, 23);
		
		Label lblNewLabel_1 = new Label(shlInformation, SWT.NONE);
		lblNewLabel_1.setBounds(33, 70, 37, 17);
		lblNewLabel_1.setText("\u59D3\u540D:");
		
		text_1 = new Text(shlInformation, SWT.BORDER);
		text_1.setBounds(76, 64, 119, 23);
		text_1.setText(rs.getString("姓名"));
		
		Label label = new Label(shlInformation, SWT.NONE);
		label.setBounds(33, 113, 37, 17);
		label.setText("\u6027\u522B:");
		
		text_2 = new Text(shlInformation, SWT.BORDER);
		text_2.setBounds(76, 107, 119, 23);
		text_2.setText(rs.getString("性别"));
		
		Label label_1 = new Label(shlInformation, SWT.NONE);
		label_1.setBounds(33, 157, 37, 17);
		label_1.setText("\u73ED\u7EA7:");
		
		text_3 = new Text(shlInformation, SWT.BORDER);
		text_3.setBounds(76, 151, 119, 23);
		text_3.setText(rs.getString("班级"));
		label_2 = new Label(shlInformation, SWT.NONE);
		label_2.setText("\u5B66\u9662:");
		label_2.setBounds(33, 196, 37, 17);
		
		text_4 = new Text(shlInformation, SWT.BORDER);
		text_4.setText(rs.getString("学院"));
		text_4.setBounds(76, 190, 119, 23);
		
		button = new Button(shlInformation, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageBox mb=new MessageBox(shlInformation);
				Modify modify=new Modify();
				String sid=text.getText();
				String name=text_1.getText();
				String sex=text_2.getText();	
				String classes=text_3.getText();
				String college=text_4.getText();
				modify.modifyData(sid,name,sex,classes,college,mb);
			}
		});
		button.setBounds(76, 219, 60, 27);
		button.setText("\u4FEE\u6539\u4FE1\u606F");
		
		Button btnNewButton = new Button(shlInformation, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Password pas=new Password();
				pas.modify_password(rs);
				pas.open();
			}
		});
		btnNewButton.setBounds(142, 219, 60, 27);
		btnNewButton.setText("\u4FEE\u6539\u5BC6\u7801");
		


	}
	public void show(ResultSet rs1) throws SQLException{
		rs=rs1;
	}
}
