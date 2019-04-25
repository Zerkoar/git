package test;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Admin_Modify {

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
			Admin_Modify window = new Admin_Modify();
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

	/**
	 * Create contents of the window.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	protected void createContents() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/s9", "root", "root");
		shell = new Shell();
		shell.setSize(310, 331);
		shell.setText("\u7BA1\u7406\u5B66\u751F");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(95, 22, 133, 23);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(51, 71, 38, 17);
		lblNewLabel.setText("\u59D3\u540D\uFF1A");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(95, 68, 133, 23);
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("\u5B66\u53F7\uFF1A");
		label.setBounds(51, 25, 38, 17);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(95, 114, 133, 23);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("\u6027\u522B\uFF1A");
		label_1.setBounds(51, 117, 38, 17);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(95, 162, 133, 23);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("\u73ED\u7EA7\uFF1A");
		label_2.setBounds(51, 165, 38, 17);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageBox mb=new MessageBox(shell);
				Modify modify=new Modify();
				String sid=text.getText();
				String name=text_1.getText();
				String sex=text_2.getText();	
				String classes=text_3.getText();
				String college=text_4.getText();
				modify.modifyData(sid,name,sex,classes,college,mb);
			}
		});
		btnNewButton.setBounds(131, 244, 45, 27);
		btnNewButton.setText("\u4FEE\u6539");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageBox mb=new MessageBox(shell);
				add a=new add();
				String sid=text.getText();
				String name=text_1.getText();
				String sex=text_2.getText();	
				String classes=text_3.getText();
				String college=text_4.getText();
				a.addData(sid,name,sex,classes,college,mb);
			}
		});
		btnNewButton_1.setBounds(80, 244, 45, 27);
		btnNewButton_1.setText("\u6DFB\u52A0");
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageBox mb=new MessageBox(shell);
				Delet delet=new Delet();
				String sid=text.getText();
				delet.deletData(sid,mb);
			}
		});
		btnNewButton_2.setBounds(182, 244, 45, 27);
		btnNewButton_2.setText("\u5220\u9664");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setText("\u5B66\u9662\uFF1A");
		label_3.setBounds(51, 206, 38, 17);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(95, 203, 133, 23);

	}
}
