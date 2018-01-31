package Internet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressDemo {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
      // 获取InetAddress 实例
		//InetAddress address=InetAddress.getLocalHost();
		//System.out.println("获取主机名："+address.getHostName());
		//System.out.println("获取主机IP地址"+address.getHostAddress());
		// 获取字节数组形式的IP地址
		//System.out.println(Arrays.toString(address.getAddress()));
		//输出InetAddress对象
		//System.out.println(address);
		//DESKTOP-1MQMM0D/192.168.56.1
		// 用主机名字或者Ip地址获取InetAddress实例
		InetAddress address2 = InetAddress.getByName("DESKTOP-1MQMM0D");
		System.out.println(address2);
		InetAddress address3 = InetAddress.getByName("192.168.56.1");
		System.out.println(address3);
		
	}

}
