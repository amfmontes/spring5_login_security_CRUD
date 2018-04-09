package com.boraji.tutorial.spring.controller;

import java.io.PrintWriter;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boraji.tutorial.spring.dao.NoticiasDao;
import com.boraji.tutorial.spring.model.NoticiaInfo;
import com.boraji.tutorial.spring.model.PaginationResult;

@Controller
public class MyContoller {

	@Autowired
	private NoticiasDao noticiasDao;

	@GetMapping("/")
	public String index(Model model, Principal principal) {
		// model.addAttribute("message", "You are logged in as " + principal.getName());
		return "index";
	}

//	@GetMapping("/privado")
//	public String privado(Model model, Principal principal) {
//		model.addAttribute("message", "You are logged in as " + principal.getName());
//		return "privado";
//	}

//	@GetMapping("/admin")
//	public String admin(Model model, Principal principal) {
//		return "admin";
//	}

//	@GetMapping("/noticias")
//	public String noticias(Model model, Principal principal) {
//		// model.addAttribute("message", "You are logged in as " + principal.getName());
//		return "noticias";
//	}

	@GetMapping("/contacto")
	public String contacto(Model model, Principal principal) {
		// model.addAttribute("message", "You are logged in as " + principal.getName());
		return "contacto";
	}

	 // GET: Show product.
	 @RequestMapping({ "/noticias" })
	    public String listProductHandler(Model model, //
	            @RequestParam(value = "name", defaultValue = "") String likeName,
	            @RequestParam(value = "page", defaultValue = "1") int page) {
	        final int maxResult = 5;
	        final int maxNavigationPage = 10;
	 
	        PaginationResult<NoticiaInfo> result = noticiasDao.queryProducts(page, //
	                maxResult, maxNavigationPage, likeName);
	 
	        model.addAttribute("paginationNoticias", result);
	        return "noticias";
	    }
	
	
	 // GET: Show product.
    @RequestMapping(value = { "/admin" }, method = {RequestMethod.POST, RequestMethod.GET})
    public String noticia(Model model, @RequestParam(value = "titulo", defaultValue = "") String titulo) {
        NoticiaInfo noticiaInfo = null;
 
        if (titulo != null && titulo.length() > 0) {
            noticiaInfo = noticiasDao.findNoticiaInfo(titulo);
        }
        if (noticiaInfo == null) {
            noticiaInfo = new NoticiaInfo();
            noticiaInfo.setNewNoticia(true);
        }
        model.addAttribute("noticiaForm", noticiaInfo);
        return "admin";
    }
	
	
	// POST: Save product
	@RequestMapping(value = { "/privado" }, method = {RequestMethod.POST, RequestMethod.GET})
	// Avoid UnexpectedRollbackException (See more explanations)
	
	@Transactional(propagation = Propagation.NEVER)
	public String productSave(Model model, //
			@ModelAttribute("noticiaForm")
			@Validated NoticiaInfo noticiaInfo, //
			BindingResult result, //
			final RedirectAttributes redirectAttributes) {
		System.out.println("entra al request");
		if (result.hasErrors()) {
			return "noticia";
		}
		try {
			noticiasDao.save(noticiaInfo);
			System.out.println("entra al try-catch");
		} catch (Exception e) {
			// Need: Propagation.NEVER?
			String message = e.getMessage();
			model.addAttribute("message", message);
			System.out.println("no entra bien al try");
			// Show product form.
			return "noticia";

		}
		return "redirect:/privado";
	}
}
