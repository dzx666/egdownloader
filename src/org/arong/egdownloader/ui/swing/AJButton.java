package org.arong.egdownloader.ui.swing;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.arong.egdownloader.ui.CursorManager;

/**
 * 封装JButton,使构造函数可以设置text值,name值,注册监听器,坐标,大小<br>
 * 默认使用手型光标,白色字体
 * 
 * @author 阿荣
 * @since 2013-8-25
 * 
 */
public class AJButton extends JButton {

	private static final long serialVersionUID = 1876134017404282134L;

	/**
	 * 装JButton,使构造函数可以设置text值,name值,注册监听器,坐标,大小<br>
	 * 默认使用手型光标
	 * 
	 * @param text
	 * @param name
	 * @param actionListener
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public AJButton(String text, String name, ActionListener actionListener,
			int x, int y, int width, int height) {
		super(text);
		this.setName(name);
		this.setToolTipText(text);
		this.setBounds(x, y, width, height);
		this.setForeground(Color.GRAY);
		this.setMargin(new Insets(5, 5, 5, 5));
		// 设置为手型光标
		this.setCursor(CursorManager.getPointerCursor());
		this.addActionListener(actionListener);
	}
}