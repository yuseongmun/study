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
		request.setCharacterEncoding("utf-8"); // request�� ��� ������ �ѱ� > utf-8
		response.setContentType("text/html; charset=utf-8"); // response�� ���� html, �ѱ� > utf-8
		String file_repo="C:\\file_repo"; // ���� ����� ���(����) file_repo�� ���
		String fileName = (String)request.getParameter("fileName"); // ������ filename (request��)>(String��) ��ȯ, fileName���� ���
		System.out.println("fileName="+fileName); // ���
		OutputStream out = response.getOutputStream(); // OutputStream ��ü ����, out���� ���
		String downFile = file_repo+"\\"+fileName; // ������ ����� ����� downFile�� ���
		File f = new File(downFile); //downFile ��ü ���� ����
		
		response.setHeader("Cache=control", "no-cache"); // ��Ʈ���� ���� ������
		response.addHeader("Content-disposition", "attachment; fileName="+fileName); // ��Ʈ���� ���� ������
		
		FileInputStream in = new FileInputStream(f); // �Ű������� f�� �ϴ� FileInputStream ��ü ����, in���� ���
		byte[]buffer=new byte[1024*8]; // 1024*8 ����Ʈ�� �б�
		while(true) {
			int count = in.read(buffer); // 1024*8�� �а� Ƚ�� ����
			if(count == -1) // count�� �� �̻� ���� ���� ������ -1
				break; // -1�̸� while�� Ż��
			out.write(buffer,0,count); // (?) 
		}
		in.close(); // ���߿� ������ in ���� �ݱ� 
		out.close(); // ���� ������ out ���߿� �ݱ�
	}
}
