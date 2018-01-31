package SocketDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
  public static void main(String[] args) {
	  try {
			Socket s = new Socket("localhost", 8888);
			BufferedWriter request = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			BufferedReader respond = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String back = null;
			Scanner sc = new Scanner(System.in);
			String info=null;
			while((info=sc.nextLine())!=null) {
				request.write(info);
				request.newLine();
				request.flush();
				if(info.equals("exit")) {
					break;
				}
				while((back=respond.readLine())!=null) {
					System.out.println("Œ“ «client£¨serverÀµ"+back);
					//if(back.equals("3*5=15")||back.equals("515OK")||back.equals(String.valueOf(Server.i))){
						break;
					}
				}
				
			
			
				

			

			request.close();
			respond.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
