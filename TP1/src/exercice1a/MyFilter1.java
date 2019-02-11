package exercice1a;

import java.io.File;
import java.io.FilenameFilter;

public class MyFilter1 implements FilenameFilter{

	@Override
	public boolean accept(File dir, String name) {
		if(dir.toString().contains(name)) { 
			dir.co
			return true;
		}else{
			return false;
		}
	}

}
