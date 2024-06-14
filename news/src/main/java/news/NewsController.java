package news;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

@WebServlet("/news.nhn")
@MultipartConfig(maxFileSize = 1024 * 1024 * 2, location = "c:/Temp/img")

public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NewsDAO dao;
	private ServletContext ctx;

	// �� ���ҽ� �⺻ ��� ����
	private final String START_PAGE = "newsList.jsp";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new NewsDAO(); // 0x10
		ctx = getServletContext(); // 0x1000
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action"); // addNews

		dao = new NewsDAO(); // 0x1500

		// �ڹ� ���÷����� ����� if, switch ���� ��û�� ���� ���� �޼��尡 ����ǵ��� ��.

		Method m;
		String view = null;

		// action �Ķ���� ���� ������ ���
		if (action == null) {
			action = "listNews";
		}
		try {
			// ���� Ŭ�������� action �̸��� HttpServletRequest�� �Ķ���ͷ� �ϴ� �޼��� ã��
			m = this.getClass().getMethod(action, HttpServletRequest.class);

			// �޼��� ���� �� ���� �� �޾ƿ�
			view = (String) m.invoke(this, request);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			// ���� �α׸� ����� view�� �α��� ȭ������ ����, �տ����� ���� redirection ��뵵 ����
			ctx.log("��û action ����!!");
			request.setAttribute("error", "action �Ķ���Ͱ� �߸��Ǿ����ϴ�!!");
			view = START_PAGE;
		} catch (Exception e) {
			e.printStackTrace();
		}

		// POST ��û ó���Ŀ��� ���𷺼� ������� �̵��� �� �־�� ��.
		if (view.startsWith("redirect:/")) {
			// redirect/ ���ڿ� ���� ��θ� ������ ��
			String rview = view.substring("redirect:/".length());
			response.sendRedirect(rview);
		} else {
			// ������ ��� ������, �������� ���ؽ�Ʈ ��δ� �ʿ����.
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}

	public String addNews(HttpServletRequest request) {
		News n = new News();
		try {
			// �̹��� ���� ����
			Part part = request.getPart("file");
			String fileName = getFilename(part);
			if(fileName != null && !fileName.isEmpty()) {
				part.write(fileName);
			}
			// �Է°��� News ��ü�� ����
			BeanUtils.populate(n,request.getParameterMap());
			
			// �̹��� ���� �̸��� News ��ü���� ����
			n.setImg("/img/"+fileName);				
				dao.addNews(n);				
			}catch(Exception e) {
				e.printStackTrace();
				ctx.log("���� �߰� �������� ���� �߻�!!");
				request.setAttribute("error", "������ ���������� ��ϵ��� �ʾҽ��ϴ�!!");
				return listNews(request);
			}
			return "redirect:/news.nhn?action=listNews";				
	}
	

	public String deleteNews(HttpServletRequest request) {
		int aid = Integer.parseInt(request.getParameter("aid"));
		try {
			dao.delNews(aid);
		} catch (SQLException e) {
			e.printStackTrace();
			ctx.log("���� ���� �������� ���� �߻�!!");
			request.setAttribute("error", "������ ���������� �������� �ʾҽ��ϴ�!!");
			return listNews(request);
		}
		return "redirect:/news.nhn?action=listNews";
	}

	public String listNews(HttpServletRequest request) {
		List<News> list;
		try {
			list = dao.getAll();
			request.setAttribute("newslist", list);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("���� ��� ���� �������� ���� �߻�!!");
			request.setAttribute("error", "���� ����� ���������� ó������ �ʾҽ��ϴ�!!");
		}
		return "newsList.jsp";
	}

	public String getNews(HttpServletRequest request) {
		int aid = Integer.parseInt(request.getParameter("aid"));
		try {
			News n = dao.getNews(aid);
			request.setAttribute("news", n);
		} catch (SQLException e) {
			e.printStackTrace();
			ctx.log("������ �������� �������� ���� �߻�!!");
			request.setAttribute("error", "������ ���������� �������� ���߽��ϴ�!!");
		}
		return "newsView.jsp";
	}

	// multipart ������� �����̸� ����
	private String getFilename(Part part) {
		String fileName = null;
		// ���� �̸��� ����ִ� ��� ������ ������ ��
		String header = part.getHeader("content-disposition");
		// part.getHeader -> form-data; name="img"; filename="����5.jpg"
		System.out.println("Header => " + header);

		// ���� �̸��� ����ִ� �Ӽ� �κ��� ���� ��ġ�� ������ �ֵ���ǥ ������ �� �κи� ������ ��
		int start = header.indexOf("filename=");
		fileName = header.substring(start + 10, header.length() - 1);
		ctx.log("���ϸ�:" + fileName);
		return fileName;
	}
}
