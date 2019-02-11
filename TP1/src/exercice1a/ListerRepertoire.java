package exercice1a;

import java.io.File;

public class ListerRepertoire {
	
	private File f;
	
	public ListerRepertoire(String chemin) {
		super();
		f = new File(chemin);
	}

	public void lister() {
		String[] liste = f.list();
		for (String path:liste) {
			System.out.println(path);
		}
	}

	public static void main(String[] args) {
		ListerRepertoire rep = new ListerRepertoire(".");
		rep.lister();
	}
}
