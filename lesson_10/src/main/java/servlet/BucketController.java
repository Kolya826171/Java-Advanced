package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Bucket;
import service.BucketService;
import service.impl.BucketServiceImpl;

public class BucketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BucketService bucketService = BucketServiceImpl.getBucketrService();   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookId = request.getParameter("bookId");
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		Bucket bucket = new Bucket(userId, Integer.parseInt(bookId), LocalDate.of(2015, 11, 15));
		bucketService.insert(bucket);
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bucketId = req.getParameter("bucketId");
		bucketService.delete(Integer.parseInt(bucketId));
		
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write("Success");
	}
}
