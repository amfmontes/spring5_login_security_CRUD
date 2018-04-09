package com.boraji.tutorial.spring.dao;

import com.boraji.tutorial.spring.entity.Noticia;
import com.boraji.tutorial.spring.model.NoticiaInfo;
import com.boraji.tutorial.spring.model.PaginationResult;

public interface NoticiasDao {

	public Noticia findNoticia(String titulo);

	public NoticiaInfo findNoticiaInfo(String titulo);

	public void save(NoticiaInfo noticiaInfo);
	
	 public PaginationResult<NoticiaInfo> queryProducts(int page,
             int maxResult, int maxNavigationPage  );

public PaginationResult<NoticiaInfo> queryProducts(int page, int maxResult,
             int maxNavigationPage, String likeName);

	

}
