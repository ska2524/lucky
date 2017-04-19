package org.zerock.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
import org.zerock.domain.PageVO;

@Repository
public class BoardDAO extends GenericDAO<BoardVO,Integer>{
	
	public List<BoardVO> list(PageVO param){
		
		return sess.selectList(mapper+".read", param);

	}
	
	
}

