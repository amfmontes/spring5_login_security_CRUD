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

import com.boraji.tutorial.spring.model.Noticias;

@Transactional
public class NoticiasDaoImp implements NoticiasDao {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void save(Noticias noticiasInfo) {
		// TODO Auto-generated method stub
	
		
	        int code = noticiasInfo.getId();
	 
	        Noticias noticia = null;
	 
	        boolean isNew = false;
	       
			if (id != null) {
	            noticia = this.findNoticias(id);
	        }
	        if (noticia == null) {
	            isNew = true;
	            noticia = new Noticia();
	            noticia.setCreateDate(new Date());
	        }
	        noticia.setCode(code);
	        noticia.setTitulo(noticiasInfo.getTitulo());
	        noticia.setFecha(noticiasInfo.getFecha());
	        noticia.setContenido(noticiasInfo.getContenido());
	      
	 	       
	        if (isNew) {
	            this.sessionFactory.getCurrentSession().persist(product);
	        }
	        // If error in DB, Exceptions will be thrown out immediately
	        this.sessionFactory.getCurrentSession().flush();
	    }

	}

}
