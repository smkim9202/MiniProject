package natwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionReader {

	public static void main(String[] args) {
		try {
			//URL ��ü ����
			URL aURL = new URL("https://www.naver.com/");
			
			//URL ��ü���� URLConnection ��ü ����
			URLConnection uc = aURL.openConnection();
	
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream())); //�Է� ��Ʈ�� ����
			
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
