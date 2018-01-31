package SocketDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {
	static int i=0;
    public static void main(String[] args) throws IOException {
    	 
    		//1 �����������˶���
			ServerSocket ss = new ServerSocket(8888);
			//2����accept������ʼ�������ȴ��ͻ�������
			System.out.println("*****���������������ȴ��ͻ�������*******");
			while(true) {
		   
			Socket s=ss.accept();
			i++;
			new Thread(new Task(s)).start();
			}
    }
    	static class Task implements Runnable {  
    		   
    	      private Socket s;
    	      Pattern p = Pattern.compile("\\d\\*\\d");
    	      public Task(Socket socket) {  
    	         this.s = socket;  
    	      }  
    	        
    	      public void run() {  
    	         try {  
    	            handleSocket();  
    	         } catch (Exception e) {  
    	            e.printStackTrace();  
    	         }  
    	      }  
    	
          public void handleSocket() throws Exception {
			//3��ȡ������������ȡ�ͻ�����Ϣ
			//InputStream request = s.getInputStream();
			BufferedReader request = new BufferedReader(new InputStreamReader(s.getInputStream()));
			BufferedWriter respond = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			//Scanner sc = new Scanner(br);
			String info = null;
			StringBuilder sb = new StringBuilder();
			int index;
			while((info=request.readLine())!=null) {
				if((index=info.indexOf("end"))!=-1) {
					sb.append(info.substring(0, index));
					info = sb.toString();
					sb.delete(0, index);
					System.out.println("���Ƿ��������ͻ���˵"+info);
					
				}
				
				if(info.equals("HelloServer")) {
					respond.write("515OK");
					respond.write("end");
					respond.newLine();
					respond.flush();
				}else if(p.matcher(info).matches()){
					String [] s1 = info.split("\\*");
					int result = 0;
					result= (Integer.parseInt(s1[0]))*(Integer.parseInt(s1[1]));
					respond.write(info+"="+String.valueOf(result));
					respond.write("end");
					respond.newLine();
					respond.flush();
				}else if(info.equals("count")) {
					respond.write(String.valueOf(i));
					respond.write("end");
					respond.newLine();
					respond.flush();
				}
				else if(info.equals("exit")){
					respond.write("exit");
					respond.write("end");
					respond.newLine();
					respond.flush();
				}

			}
//			OutputStream os = s.getOutputStream();
//			PrintWriter pw = new PrintWriter(os);
//			pw.write("3*5=15\r\n");
//			pw.flush();
			s.shutdownInput();
			s.shutdownOutput();
			respond.close();
			request.close();
			s.close();
			
		} 
		}

    }    	
   

