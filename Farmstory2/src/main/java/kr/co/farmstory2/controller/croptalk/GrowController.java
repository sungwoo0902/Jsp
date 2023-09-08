package kr.co.farmstory2.controller.croptalk;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;

import kr.co.farmstory2.dto.ArticleDTO;
import kr.co.farmstory2.dto.FileDTO;
import kr.co.farmstory2.service.ArticleService;
import kr.co.farmstory2.service.FileService;

@WebServlet("/croptalk/grow.do")
public class GrowController extends HttpServlet{

	private static final long serialVersionUID = -2523302757768800809L;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ArticleService aService = ArticleService.INSTANCE;
	private FileService fService = FileService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		
		req.setAttribute("group", group);
		req.setAttribute("cate", cate);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/write.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파일 업로드
				String path = aService.getPath(req, "/upload");
				MultipartRequest mr = aService.uploadFile(req, path);
				
				// 폼 데이터 수신
				String group = mr.getParameter("group");
				String cate = mr.getParameter("cate");
				String title = mr.getParameter("title");
				String content = mr.getParameter("content");
				String writer = mr.getParameter("writer");
				String oName = mr.getOriginalFileName("file");
				String regip = req.getRemoteAddr();
				
				logger.debug("title : " + title);
				logger.debug("content : " + content);
				logger.debug("writer : " + writer);
				logger.debug("oName : " + oName);
				logger.debug("regip : " + regip);
				
				// DTO 생성
				ArticleDTO dto = new ArticleDTO();
				dto.setCate(cate);
				dto.setTitle(title);
				dto.setContent(content);
				dto.setFile(oName);
				dto.setWriter(writer);
				dto.setRegip(regip);

				// 글 Insert
				int no = aService.insertArticle(dto);
				
				// 파일명 수정 및 파일 Insert
				if(oName != null) {
					String sName = aService.renameToFile(req, path, oName);
					
					// 파일 Insert
					FileDTO fileDto = new FileDTO();
					fileDto.setAno(no);
					fileDto.setOfile(oName);
					fileDto.setSfile(sName);
					
					fService.insertFile(fileDto);
				}
				
				// 리다이렉트
				resp.sendRedirect("/Farmstory2/croptalk/grow.do?group="+group+"&cate="+cate);
			}
}
