package Internet;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       try {
		URL immoc = new URL("http://www.immoc.com");
		URL url = new URL(immoc,"/index.html?username=tom#test");
		System.out.println("Э��"+url.getProtocol());
		System.out.println("����"+url.getHost());
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
