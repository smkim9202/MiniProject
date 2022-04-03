package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;


public class ClientEx {

	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader in = null;
		BufferedWriter out = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			socket = new Socket("localhost", 9999);
			System.out.println("������ ���� ��");
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				System.out.println("������>>");
				String outMsg = sc.nextLine();
				
				if(outMsg.equalsIgnoreCase("bye")) {
					out.write(outMsg + "\n");
					out.flush();
					System.out.println("���� ����!!!");
					break;
				}
				//���� �޽����� ���
				out.write(outMsg + "\n");
				out.flush();		
				
				String inMsg = in.readLine();
				System.out.println("����>>" + inMsg);
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

			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		

	}

}