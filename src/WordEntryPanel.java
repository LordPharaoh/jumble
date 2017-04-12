import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;


public class WordEntryPanel extends JPanel {
	public WordEntryPanel() {
		JTextField wordEntry = new JTextField(15);
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String wordScrambled = wordEntry.getText();
				
			}
		});
		
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		this.setBorder(new CompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED),BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		this.add(Box.createHorizontalGlue());
		this.add(wordEntry);
		this.add(Box.createRigidArea(new Dimension(10, 0)));
		this.add(submitButton);
	}
}
