package comm;

import java.io.*;
import java.net.*;

public class Client {
	Socket soc;
	DataInputStream dis;
	BufferedReader br;
	DataOutputStream dos;;

	public Client() throws Exception {
		soc = new Socket("localhost", 5000);
		dis = new DataInputStream(soc.getInputStream());
		br = new BufferedReader(new InputStreamReader(System.in));
		dos = new DataOutputStream(soc.getOutputStream());
		start();
	}

	public void start() {
		try {
			System.out.print("이름을 입력하세요 : ");
			String name = br.readLine();
			dos.writeUTF(name);

			Thread t = new SendThread();
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			while(true) {
				String received_msg = dis.readUTF();
				System.out.println(received_msg);
			}
		} catch (IOException e) {
			
		}
	}
	
	class SendThread extends Thread {
		public void run() {
			while (true) {
				try {
					String msg = br.readLine();
					dos.writeUTF(msg);
				} catch (Exception e) {

				}
			}
		}
	}
}
