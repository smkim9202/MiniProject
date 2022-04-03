package natwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionWriter {

	public static void main(String[] args) {
		try {
			//POST�� ������ ����Ʈ URL ��ü ����
			URL aURL = new URL("");
			
			//URL ��ü���� URLConnection ��ü ����
			URLConnection uc = aURL.openConnection();
	
			//��� ��� ����
			uc.setDoOutput(true);
			
			//��� ��Ʈ�� ����
			OutputStreamWriter out = new OutputStreamWriter(uc.getOutputStream());
			
			//������ ������ ������
			out.write("fname=Kitea&lname=Hwang");
			out.close();
			//�Է� ��Ʈ�� ����
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream())); 
			
			String inputLine;
			
			while((inputLine = in.readLine()) != null) //���� �� ����
				System.out.println(inputLine);
				in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
