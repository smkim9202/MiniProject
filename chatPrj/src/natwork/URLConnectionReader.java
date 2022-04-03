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
			//URL 객체 생성
			URL aURL = new URL("https://www.naver.com/");
			
			//URL 객체에서 URLConnection 객체 생성
			URLConnection uc = aURL.openConnection();
	
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream())); //입력 스트림 생성
			
			String inputLine;
			
			while((inputLine = in.readLine()) != null) //한행 씩 읽음
				System.out.println(inputLine);
				in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
