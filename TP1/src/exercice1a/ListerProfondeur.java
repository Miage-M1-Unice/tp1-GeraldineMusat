package exercice1a;

import java.io.File;

public class ListerProfondeur {

	private File f;
	private File[] liste;
	
	public ListerProfondeur(String chemin) {
		super();
		f = new File(chemin);
		lister(f);
	}
	
	public void lister(File pa) {
		liste = pa.listFiles();
		for(File path:liste) {
			System.out.println(path);
			if(path.isDirectory()) {
				lister(path);
			}
		}
	}
	
	public static void main(String[] args) {
		ListerProfondeur pro = new ListerProfondeur(".");

		
	}

}
