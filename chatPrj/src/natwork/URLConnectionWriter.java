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
			//POST가 가능한 사이트 URL 객체 생성
			URL aURL = new URL("");
			
			//URL 객체에서 URLConnection 객체 생성
			URLConnection uc = aURL.openConnection();
	
			//출력 모드 설정
			uc.setDoOutput(true);
			
			//출력 스트림 설정
			OutputStreamWriter out = new OutputStreamWriter(uc.getOutputStream());
			
			//서버에 데이터 보내기
			out.write("fname=Kitea&lname=Hwang");
			out.close();
			//입력 스트림 생성
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream())); 
			
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
