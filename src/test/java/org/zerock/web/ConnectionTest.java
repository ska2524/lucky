package org.zerock.web;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.PageVO;
import org.zerock.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ConnectionTest {
	
	Logger logger = Logger.getLogger(ConnectionTest.class);
	

	@Inject
	private DataSource ds;
	
	@Inject
	SqlSessionFactory sqlFactory;
	
	@Inject
	ApplicationContext ctx;
	
	@Inject
	BoardDAO dao;
	
	
	@Test
	public void create(){
		
		BoardVO vo = new BoardVO();
		vo.setTitle("안녕");
		vo.setContent("살려줘요");
		vo.setWriter("이정훈");
		vo.setBno(8);
		
		dao.create(vo);
		
	}
	
	@Test
	public void read(){
		
		List<BoardVO> list = dao.list(new PageVO());		
		
//		for (BoardVO boardVO : list) {
//			System.out.println(boardVO.toString());
//		}
		
		list.forEach(board -> System.out.println(board));
		
		
	}
	
	
	
	
	@Test
	public void testSession(){
		
		SqlSession sess = sqlFactory.openSession();
		logger.info(sess);
		
		 String time = sess.selectOne("org.zerock.boardMapper.getTime");
		
		logger.info(time);
		sess.close();
	}
	
	
	
	@Test
	public void testCtx(){
		
	 Object obj = ctx.getBean("sqlSessionFactory");
		
	 logger.info(obj);
	}
	
	
	
	
	@Test
	public void testLoad(){
		try {
			Connection con = ds.getConnection();
			logger.info(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	

}
