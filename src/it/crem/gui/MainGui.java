package it.crem.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Spinner;

public class MainGui {

	protected Shell shlRoncoVillage;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainGui window = new MainGui();
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
		shlRoncoVillage.open();
		while (!shlRoncoVillage.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		
		display.dispose();
		
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlRoncoVillage = new Shell();
		shlRoncoVillage.setText("Ronco Village");
		
		text = new Text(shlRoncoVillage, SWT.BORDER);
		text.setBounds(94, 59, 75, 33);
		
		Label lblNewLabel = new Label(shlRoncoVillage, SWT.NONE);
		lblNewLabel.setBounds(4, 12, 69, 21);
		lblNewLabel.setText("Nome");
		
		Label lblNewLabel_1 = new Label(shlRoncoVillage, SWT.NONE);
		lblNewLabel_1.setBounds(-13, 23, 69, 21);
		lblNewLabel_1.setText("Cognome");
		
		text_1 = new Text(shlRoncoVillage, SWT.BORDER);
		text_1.setBounds(83, -21, 75, 33);

	}
}
