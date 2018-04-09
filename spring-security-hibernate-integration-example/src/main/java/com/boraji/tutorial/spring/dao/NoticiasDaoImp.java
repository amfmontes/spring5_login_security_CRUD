package com.boraji.tutorial.spring.dao;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.SessionFactory;

import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.spring.entity.Noticia;
import com.boraji.tutorial.spring.model.NoticiaInfo;
import com.boraji.tutorial.spring.model.PaginationResult;

@Transactional
public class NoticiasDaoImp implements NoticiasDao {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public Noticia findNoticia(String titulo) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Noticia.class);
        crit.add(Restrictions.eq("titulo", titulo));
        return (Noticia) crit.uniqueResult();
    }
 
    public NoticiaInfo findNoticiaInfo(String titulo) {
        Noticia noticia = this.findNoticia(titulo);
        if (noticia == null) {
            return null;
        }
        return new NoticiaInfo(noticia.getId(), noticia.getTitulo(), noticia.getFecha(), 
        		noticia.getContenido());
    }
	
	
	public void save(NoticiaInfo noticiaInfo) {
		// TODO Auto-generated method stub
	
		
	        String titulo = noticiaInfo.getTitulo();
	 
	        Noticia noticia = null;
	 
	        boolean isNew = false;
	       
			if (titulo != null) {
	            noticia = this.findNoticia(titulo);
	        }
	        if (noticia == null) {
	            isNew = true;
	            noticia = new Noticia();
	            noticia.setCreateDate(new Date());
	        }
//	        noticia.setId();
	        noticia.setTitulo(titulo);
	        noticia.setFecha(noticiaInfo.getFecha());
	        noticia.setContenido(noticiaInfo.getContenido());
	      
	 	       
	        if (isNew) {
	            this.sessionFactory.getCurrentSession().persist(noticia);
	        }
	        // If error in DB, Exceptions will be thrown out immediately
	        this.sessionFactory.getCurrentSession().flush();
	    }


	   public PaginationResult<NoticiaInfo> queryProducts(int page, int maxResult, int maxNavigationPage,
	            String likeName) {
	        String sql = "Select new " + NoticiaInfo.class.getName() //
	                + "(p.id, p.titulo, p.fecha, p.contenido) " + " from "//
	                + Noticia.class.getName() + " p ";
	        if (likeName != null && likeName.length() > 0) {
	            sql += " Where lower(p.titulo) like :likeName ";
	        }
	        sql += " order by p.createDate desc ";
	        //
	        Session session = sessionFactory.getCurrentSession();
	 
	        Query query = session.createQuery(sql);
	        if (likeName != null && likeName.length() > 0) {
	            query.setParameter("likeName", "%" + likeName.toLowerCase() + "%");
	        }
	        return new PaginationResult<NoticiaInfo>(query, page, maxResult, maxNavigationPage);
	    }
	 
	    public PaginationResult<NoticiaInfo> queryProducts(int page, int maxResult, int maxNavigationPage) {
	        return queryProducts(page, maxResult, maxNavigationPage, null);
	    }
	

}
