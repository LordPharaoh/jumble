import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

public class JumbleFrame extends JFrame {
	String lang = null;// start off without a language

	// all the languages that have been loaded up. Maybe only need
	// one LanguageMap at a time, but can change that later
	Set<LanguageMap> languageMaps = new HashSet<LanguageMap>();

	public JumbleFrame() {
		super("Jumble Solver");// title the bar
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ALWAYS DO THIS
		addMenuBar();// just wanted to show you how to make a menu bar
		loadJumblePanel();
		pack();// make sure the frame is just big enough to show all components
	}

	private void addSplashPanel() {
		// Things are typically added to the content pane
		// Opening Screen could include animations, etc.
		// it is a type of JPanel
		this.getContentPane().add(new OpeningScreen());
	}

	private void addMenuBar() {
		JMenuBar jmb = new JMenuBar();
		this.setJMenuBar(jmb);
		JMenu fileMenu = new JMenu("File");
		jmb.add(fileMenu);
		JMenuItem newPuzzle = new JMenuItem("New Jumble");
		newPuzzle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// when someone clicks on the newPuzzle MenuItem this method is
				// called
				if (lang == null) {// check to see if they have already loaded
									// up a language
					JOptionPane.showMessageDialog(null,
							"Select a language first!");
					return;
				}
				// here might be a good time to change the device
				// keyboard to match the language :)
				loadJumblePanel();

			}

		});

		fileMenu.add(newPuzzle);// adds to the File Menu

		JMenu languageMenu = new JMenu("Language");

		jmb.add(languageMenu);

		JMenuItem russian = new JRadioButtonMenuItem("Russian");
		russian.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				lang = "ru";

			}
		});

		languageMenu.add(russian);

		JMenuItem english = new JRadioButtonMenuItem("English");
		english.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lang = "en";

			}
		});
		languageMenu.add(english);

		ButtonGroup group = new ButtonGroup();
		group.add(russian);
		group.add(english);
	}

	protected void loadJumblePanel() {
		this.getContentPane().removeAll();

		LanguageMap map = getCurrentLanguage();
		JumblePanel jp = new JumblePanel(map);
		jp.setPreferredSize(jp.getPreferredSize());
		this.getContentPane().add(jp);
		validate();
		repaint();
	}

	private LanguageMap getCurrentLanguage() {
		// TODO Auto-generated method stub
		return null;
	}

	protected void languageSelected(String string) {
		this.lang = string;
		// check to see if any LanguageMaps have this language
		for (LanguageMap lm : this.languageMaps) {
			if (lm.getLanguage().equals(string))
				return;// this language has already been loaded
		}
		// new language, so construct a new LanguageMap and add it
		// to the languageMaps ... This involves reading from a file,
		// so you don't want to repeat this and you don't want to load
		// up languages that may not be needed

	}
}
