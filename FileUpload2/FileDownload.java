package test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownload
 */
@WebServlet("/download.do")
public class FileDownload extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // request에 담긴 내용이 한글 > utf-8
		response.setContentType("text/html; charset=utf-8"); // response할 파일 html, 한글 > utf-8
		String file_repo="C:\\file_repo"; // 사진 저장된 경로(서버) file_repo로 명명
		String fileName = (String)request.getParameter("fileName"); // 가져온 filename (request형)>(String형) 변환, fileName으로 명명
		System.out.println("fileName="+fileName); // 출력
		OutputStream out = response.getOutputStream(); // OutputStream 객체 생성, out으로 명명
		String downFile = file_repo+"\\"+fileName; // 위에서 명명한 내용들 downFile로 명명
		File f = new File(downFile); //downFile 객체 새로 생성
		
		response.setHeader("Cache=control", "no-cache"); // 스트레스 받지 마세요
		response.addHeader("Content-disposition", "attachment; fileName="+fileName); // 스트레스 받지 마세요
		
		FileInputStream in = new FileInputStream(f); // 매개변수를 f로 하는 FileInputStream 객체 생성, in으로 명명
		byte[]buffer=new byte[1024*8]; // 1024*8 바이트씩 읽기
		while(true) {
			int count = in.read(buffer); // 1024*8씩 읽고 횟수 저장
			if(count == -1) // count는 더 이상 읽을 내용 없으면 -1
				break; // -1이면 while문 탈출
			out.write(buffer,0,count); // (?) 
		}
		in.close(); // 나중에 생성한 in 먼저 닫기 
		out.close(); // 먼저 생성한 out 나중에 닫기
	}
}
