package Internet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressDemo {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
      // ��ȡInetAddress ʵ��
		//InetAddress address=InetAddress.getLocalHost();
		//System.out.println("��ȡ��������"+address.getHostName());
		//System.out.println("��ȡ����IP��ַ"+address.getHostAddress());
		// ��ȡ�ֽ�������ʽ��IP��ַ
		//System.out.println(Arrays.toString(address.getAddress()));
		//���InetAddress����
		//System.out.println(address);
		//DESKTOP-1MQMM0D/192.168.56.1
		// ���������ֻ���Ip��ַ��ȡInetAddressʵ��
		InetAddress address2 = InetAddress.getByName("DESKTOP-1MQMM0D");
		System.out.println(address2);
		InetAddress address3 = InetAddress.getByName("192.168.56.1");
		System.out.println(address3);
		
	}

}
