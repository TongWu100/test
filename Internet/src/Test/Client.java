package Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {
		 //Ϊ�˼���������е��쳣��ֱ��������  
	     
	     int port = 8800;   //Ҫ���ӵķ���˶�Ӧ�ļ����˿�  
	     //�����˽�������  
	     Socket client = new Socket("localhost", port);  
	      //�������Ӻ�Ϳ����������д������  
	    Writer writer = new OutputStreamWriter(client.getOutputStream());  
	      writer.write("Hello Server.");  
	      writer.flush();  
	      //д���Ժ���ж�����  
	    Reader reader =new InputStreamReader(client.getInputStream());  
	      char chars[] = new char[64];  
	      int len;  
	      StringBuffer sb = new StringBuffer();  
	      while ((len=reader.read(chars)) != -1) {  
	         sb.append(new String(chars, 0, len));  
	      }  
	      System.out.println("from server: " + sb);  
	      writer.close();  
	      reader.close();  
	      client.close();  
	   }  
	}


