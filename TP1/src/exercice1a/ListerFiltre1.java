package exercice1a;

import java.io.File;
import java.io.FilenameFilter;

public class ListerFiltre1{
	
	private File f;
	private File[] liste;
	private MyFilter1 filter;

	public ListerFiltre1(String chemin) {
		super();
		f = new File(chemin);
		filter = new MyFilter1(".java");
		lister(f);
	}
	
	public void lister(File pa) {
		liste = pa.listFiles(filter);
		for(File path:liste) {
			if(path.isDirectory()) {
				System.out.println(path);
				lister(path);
			}
		}
	}

	public static void main(String[] args) {
		ListerFiltre1 l = new ListerFiltre1(".");
	}

}
