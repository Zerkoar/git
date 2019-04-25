package test;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Login {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Login window = new Login();
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
		shell.setSize(388, 259);
		shell.setText("\u5B66\u7C4D\u7BA1\u7406\u7CFB\u7EDF\u767B\u5F55\u754C\u9762");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(124, 45, 158, 23);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(74, 48, 40, 17);
		lblNewLabel.setText("\u5B66\u53F7:");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(74, 95, 40, 17);
		lblNewLabel_1.setText("\u5BC6\u7801:");
		
		text_1 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(124, 92, 158, 23);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageBox mb1=new MessageBox(shell);
				Login_Check check=new Login_Check();
				String sid1=text.getText();
				String password1=text_1.getText();
				try {
                     check.Check(sid1, password1, mb1,shell);
				} catch (ClassNotFoundException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(160, 142, 62, 27);
		btnNewButton.setText("\u767B\u5F55");
		
	/*	Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Enroll enroll=new Enroll();
				enroll.open();
			}
		});
		btnNewButton_1.setBounds(220, 141, 62, 27);
		btnNewButton_1.setText("\u6CE8\u518C");*/

	}
}
