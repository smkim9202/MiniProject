package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class ServerEx {

	public static void main(String[] args) {
		ServerSocket server = null;
		Socket socket = null;
		BufferedReader in = null;
		BufferedWriter out = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			server = new ServerSocket(9999);
			System.out.println("�������� : ���� �����....");
			
			socket = server.accept();
			System.out.println("Ŭ���̾�Ʈ�� ���� ��");
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				String inMsg = in.readLine();
				if(inMsg.equalsIgnoreCase("bye")) {
					System.out.println("Ŭ���̾�Ʈ�� ����");
					break;
				}
				//���� �޽����� ���
				System.out.println("Ŭ���̾�Ʈ : "+ inMsg);
				
				System.out.println("������ >>");
				String outMsg = sc.nextLine();
				out.write(outMsg + "\n");
				out.flush();				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				sc.close();
				out.close();
				in.close();
				socket.close();
				server.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		

	}

}
