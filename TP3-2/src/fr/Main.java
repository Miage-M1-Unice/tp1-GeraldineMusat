package fr;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, MalformedURLException {
		// TODO Auto-generated method stub
		URL[] url = new URL[] {new URL("file://C:/Users/Geraldine/Desktop/TP Huet/tp1-GeraldineMusat/TP3-1/bin/")};
		URLClassLoader urlclass = new URLClassLoader(url);
		Class<?> Test = urlclass.loadClass("fr.Test");
		Constructor<?> constructor = Test.getConstructor();
        Object t = constructor.newInstance();
	}

}
