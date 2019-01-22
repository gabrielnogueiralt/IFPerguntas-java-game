package model;

import java.awt.EventQueue;

import controler.Controladora;

public class Main {
	
	private static Controladora controladora;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					controladora = Controladora.getInstance();
					controladora.switchPrimeiraJanela();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	

}
