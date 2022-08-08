package br.com.farmaciasoft.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Fundo extends JPanel {

	private static final long serialVersionUID = 1L;
	BufferedImage imagemFundo;
	
	/**
	 * Create the panel.
	 */
	public Fundo() {
		try {
			this.imagemFundo = ImageIO.read(new File("/br/com/farmaciasoft/view/assets/fundo.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.drawImage(imagemFundo, 0, 0, null);
	}

}
