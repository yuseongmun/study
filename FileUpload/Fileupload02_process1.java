package test1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class Fileupload02_process1
 */
@WebServlet("/fileupload02_process1.do")
public class Fileupload02_process1 extends HttpServlet {
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		MultipartRequest multi = new MultipartRequest(request, "C:\\file_repo", 5 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		
		String name1 = multi.getParameter("name1");
		String subject1 = multi.getParameter("subject1");
		
		String name2 = multi.getParameter("name2");
		String subject2 = multi.getParameter("subject2");
		
		String name3 = multi.getParameter("name3");
		String subject3 = multi.getParameter("subject3");
		
		Enumeration files=multi.getFileNames();
		
		String file3 = (String)files.nextElement();
		String filename3 = multi.getFilesystemName(file3);
		
		String file2 = (String)files.nextElement();
		String filename2 = multi.getFilesystemName(file2);
		
		String file1 = (String)files.nextElement();
		String filename1 = multi.getFilesystemName(file1);
		
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>현재 시간 페이지</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<table border = \"1\">");
		pw.println("<tr>");
		pw.println("<th width=\"100\">이름</th>");
		pw.println("<th width=\"100\">제목</th>");
		pw.println("<th width=\"100\">파일</th>");
		pw.println("</tr>");
		
		pw.println("<tr><td>"+name1+"</td>");
		pw.println("<td>"+subject1+"</td>");
		pw.println("<td>"+filename1+"</td></tr>\n");
		
		pw.println("<tr><td>"+name2+"</td>");
		pw.println("<td>"+subject2+"</td>");
		pw.println("<td>"+filename2+"</td></tr>\n");
		
		pw.println("<tr><td>"+name3+"</td>");
		pw.println("<td>"+subject3+"</td>");
		pw.println("<td>"+filename3+"</td></tr>\n");
		pw.println("</body>");
		pw.println("</html>");
		
		pw.close();
	}
	
	

}
