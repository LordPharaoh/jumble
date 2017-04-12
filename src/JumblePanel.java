import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;


public class JumblePanel extends JPanel {

	LanguageMap map;
	public JumblePanel(LanguageMap map) {
		
		this.setLayout(new BorderLayout());
		this.add(new WordEntryPanel(), BorderLayout.WEST);
	}
	
	
	
}
