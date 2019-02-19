package exercice1a;

import java.io.File;
import java.io.FilenameFilter;

public class ListeFiltre4 {

	private File f;
	private File[] liste;

	public ListeFiltre4(String chemin) {
		super();
		f = new File(chemin);
		lister(f);
	}
	
	public void lister(File pa) {
		
		FilenameFilter filter = new FilenameFilter () {
			@Override
			public boolean accept(File dir, String name) {
				if(new File(dir, name).isDirectory()) {
					
					return true;
				}
				if (name.endsWith(".java")) {
					System.out.println(dir+name);
					return true;
				}
				
				return false;
			}
		};
		
		liste = pa.listFiles(filter);
		for(File path:liste) {
			if(path.isDirectory()) {
				System.out.println(path);
				lister(path);
			}
		}
	}

	public static void main(String[] args) {
		ListeFiltre4 l = new ListeFiltre4(".");
	}

}
