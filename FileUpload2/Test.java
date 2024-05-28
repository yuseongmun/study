package test1;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class Test
 */
@WebServlet("/test.do")
public class Test extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fileUrl = "C:\\file_repo";
		String uploadFileName = "";
		int sizeLimit = 5 * 1024 * 1024; // 5메가까지 제한 넘어서면 예외발생

		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();

		MultipartRequest multi = new MultipartRequest(request, fileUrl, sizeLimit, "utf-8", policy);

		Enumeration params = multi.getParameterNames();

		while (params.hasMoreElements()) {
			String name = (String) params.nextElement();
			String value = multi.getParameter(name);
			System.out.println(name + " = " + value + "<br>");
		}
		System.out.println("-----------------------------------<br>");

		Enumeration files = multi.getFileNames();

		while (files.hasMoreElements()) {
			String name = (String) files.nextElement();
			String filename = multi.getFilesystemName(name);
			String original = multi.getOriginalFileName(name);
			String type = multi.getContentType(name);
			File file = multi.getFile(name);

			System.out.println("요청 파라미터 이름 : " + name + "<br>");
			System.out.println("실제 파일 이름 : " + original + "<br>");
			System.out.println("저장 파일 이름 : " + filename + "<br>");
			System.out.println("파일 콘텐츠 유형 : " + type + "<br>");

			if (file != null) {
				System.out.println(" 파일 크기 : " + file.length());
				System.out.println("<br>");
			}
		}
	}

}
