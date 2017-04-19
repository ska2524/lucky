package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.zerock.domain.BoardVO;

public abstract class GenericDAO<E,K> {

	@Inject
	protected SqlSessionTemplate sess;
	
	protected String mapper;
	
	public GenericDAO() {
		mapper=this.getClass().getName();
		
	}
	
	
	
	public void create(E vo){
		
		sess.insert(mapper+".insert",vo);		
		
	}
	
	public E read(K key){
		
		return sess.selectOne(mapper+".read",key);  
	}
	
	public void update(E vo){
		sess.update(mapper+".update", vo);
	}
	
}
