package comm;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
	ArrayList<Thread> threads;
	HashMap<String, DataOutputStream> clients;
	ServerSocket ss;

	public Server() {
		threads = new ArrayList<Thread>();
		clients = new HashMap<String, DataOutputStream>();
		Collections.synchronizedMap(clients);
		start();
	}

	public void start() {
		try {
			ss = new ServerSocket (5000);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("server is ready");

		while (true) {
			try {
				Socket soc = ss.accept();
				System.out.println("new connection arrived");
				Thread t = new ReceiveThread(soc);
				t.start();
				threads.add(t);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void addClient(String name, Socket soc) throws IOException {
		clients.put(name, new DataOutputStream(soc.getOutputStream()));
	}

	public synchronized void removeClient(String name) {
		clients.remove(name);
	}

	public synchronized void sendMsg(String msg, String name) throws Exception {
		Iterator<String> it = clients.keySet().iterator();
		while(it.hasNext()) {
			String client_name = it.next();
			clients.get(client_name).writeUTF(name + ":" + msg);
		}
	}

	class ReceiveThread extends Thread {
		Socket soc;
		DataInputStream dis;
		String name;

		public ReceiveThread(Socket soc) throws Exception {
			this.soc = soc;
			dis = new DataInputStream(soc.getInputStream());
			this.name = dis.readUTF();
			addClient(name, soc);
		}

		public void run() {
			try {
				while (true) {
					String msg = dis.readUTF();
					sendMsg(msg, name);
				}
			} catch (Exception e) {
				removeClient(this.name);
			}
		}
	}
}