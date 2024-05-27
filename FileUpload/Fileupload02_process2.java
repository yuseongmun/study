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

/**
 * Servlet implementation class Fileupload02_process2
 */
@WebServlet("/fileupload02_process2.do")
public class Fileupload02_process2 extends HttpServlet {
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println("!DOCTYPE html");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>���� �ð� ������</title>");
		pw.println("</head>");
		pw.println("<body>");
		MultipartRequest multi = new NultipartRequest(request,"C:\\file_repo",5*1024*1024,"utf-8",new DefaultFileRenamePolicy());
		
		Enumeration params = multi.getParameterNames();
		while(params.hasMoreElements()) {
			String name = (String)params.nextElement();
			String value = multi.getParameter(name);
			pw.println(name+"="+value+"<br>");			
		}
		pw.println("---------------------------------<br>");
		
		String name = multi.getParameter("name");
		String subject = multi.getParameter("subject");
		
		String name2 = multi.getParameter("name2");
		String subject2 = multi.getParameter("subject2");
		
		String name3 = multi.getParameter("name3");
		String subject3 = multi.getParameter("subject3");
		
		Enumeration files = multi.getFileNames();
		
		String file = (String)files.nextElement();
		String filename = multi.getFilesystemName(file);		
		pw.println("�ۼ���1 : "+name+", ");
		pw.println("����1 : "+subject+", ");
		pw.println("���ε� �� ���ϸ�1 : "+filename+"<br>");
		
		
		String file2 = (String)files.nextElement();
		String filename2 = multi.getFilesystemName(file2);
		pw.println("�ۼ���2 : "+name2+", ");
		pw.println("����2 : "+subject2+", ");
		pw.println("���ε� �� ���ϸ�2 : "+filename2+"<br>");
		
		String file3 = (String)files.nextElement();
		String filename3 = multi.getFilesystemName(file3);
		pw.println("�ۼ���3 : "+name+", ");
		pw.println("����3 : "+subject+", ");
		pw.println("���ε� �� ���ϸ�3 : "+filename3+"<br>");
		
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
		
	}

}
