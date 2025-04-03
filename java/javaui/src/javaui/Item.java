package javaui;

import java.awt.Color;

import javax.swing.JButton;

public class Item extends JButton{
	private final Color mainColor = SystemColor.MAIN_COLOR_2;
	private final int index;
	private Animator animator;
	private GoogleMaterialDesignIcon icon;
	private final boolean mainMenu;
	private boolean mouseEnter;
	private float alpha;

	public Item(boolean mainMenu, int index) {
	    this.mainMenu = mainMenu;
	    this.index = index;
	    init();
	}

	private void init() {
	    setContentAreaFilled(false);
	    setHorizontalAlignment(JButton.LEFT);
	    setForeground(new Color(50, 50, 50));
	    if (mainMenu) {
	        setBorder(new EmptyBorder(0, 20, 0, 0));
	    } else {
	        setBorder(new EmptyBorder(0, 51, 0, 0));
	    }
	}

}
