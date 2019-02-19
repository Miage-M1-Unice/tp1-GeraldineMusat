package exercice1a;

import java.io.File;
import java.io.FilenameFilter;

public class MyFilter1 implements FilenameFilter{

	private String filtre;
	
	public MyFilter1(String filter) {
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
