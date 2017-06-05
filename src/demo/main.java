package demo;

import java.awt.EventQueue;

import GUI.aplicacionTaxi;

public class main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aplicacionTaxi window = new aplicacionTaxi();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
