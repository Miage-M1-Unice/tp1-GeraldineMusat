package exercice1a;

import java.io.File;
import java.io.FilenameFilter;

public class ListeFiltre2 {
	
	private File f;
	private File[] liste;
	private MyFilter2 filter;

	public ListeFiltre2(String chemin) {
		super();
		f = new File(chemin);
		filter = new MyFilter2(".java");
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
	
	public class MyFilter2 implements FilenameFilter {

		private String filtre;
		
		public MyFilter2(String filter) {
			this.filtre = filter;
		}
		
		@Override
		public boolean accept(File dir, String name) {
			if(new File(dir, name).isDirectory()) {
				
				return true;
			}
			if (name.endsWith(filtre)) {
				System.out.println(dir+name);
				return true;
			}
			
			return false;
		}
	}

	public static void main(String[] args) {
		ListeFiltre2 l = new ListeFiltre2(".");
	}

}
