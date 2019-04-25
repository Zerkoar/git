package test;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Admin_Control {

	protected Shell shlAdmin;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Admin_Control window = new Admin_Control();
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
		shlAdmin.open();
		shlAdmin.layout();
		while (!shlAdmin.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlAdmin = new Shell();
		shlAdmin.setSize(414, 291);
		shlAdmin.setText("\u7BA1\u7406\u5458\u9875\u9762");
		
		Button btnNewButton = new Button(shlAdmin, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Admin_Modify modify=new Admin_Modify();
				try {
					modify.open();
				} catch (ClassNotFoundException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(44, 73, 95, 80);
		btnNewButton.setText("\u7BA1\u7406\u5B66\u7C4D");
		
		Button btnNewButton_1 = new Button(shlAdmin, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Admin admin=new Admin();
				try {
					admin.open();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(145, 73, 95, 80);
		btnNewButton_1.setText("\u67E5\u770B\u5B66\u751F");
		
		Button btnNewButton_2 = new Button(shlAdmin, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Classes classes=new Classes();
				try {
					classes.open();
				} catch (ClassNotFoundException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(246, 73, 95, 80);
		btnNewButton_2.setText("\u67E5\u770B\u73ED\u7EA7");

	}
}
