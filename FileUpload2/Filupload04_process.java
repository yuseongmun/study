package test1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class Filupload04_process
 */
@WebServlet("/fileupload04_process.do")
public class Filupload04_process extends HttpServlet {
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.print("<head>");
		pw.print("<title>현재 시간 페이지</title>");
		pw.print("</head>");
		pw.print("<body>");
		String encoding = "utf-8";
		File fileUploadPath = new File("C:\\file_repo");
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(fileUploadPath);
		factory.setSizeThreshold(1024*1024);
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(request);
			Iterator params = items.iterator();
			
			while(params.hasNext()) {
				FileItem item = (FileItem)params.next();
				
				if(item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString("utf-8");
					pw.println(name+"="+value+"<br>");
				}else {
					String fileFieldName = item.getFieldName();
					String fileName = item.getName();
					String contentType = item.getContentType();
					
					fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
					long fileSize = item.getSize();
					
					File file = new File(fileUploadPath +"/"+fileName);
					item.write(file);
					
					pw.println("-----------------------------<br>");
					pw.println("요청 파라미터 이름 : "+fileFieldName+"<br>");
					pw.println("저장 파일 이름 : "+fileName+"<br>");
					pw.println("파일 콘텐츠 유형 : "+contentType+"<br>");
					pw.println("파일 크기 : "+fileSize	);
					pw.println("</body>");
					pw.println("</html>");
					pw.close();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
