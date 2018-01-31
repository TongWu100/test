package Internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try {
			URL url = new URL("http://www.baidu.com");
			InputStream is=url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
			String line = null;
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
			br.close();
			is.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
