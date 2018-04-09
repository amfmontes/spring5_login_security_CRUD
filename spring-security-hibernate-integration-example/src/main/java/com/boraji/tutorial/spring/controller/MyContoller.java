package com.boraji.tutorial.spring.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boraji.tutorial.spring.dao.NoticiasDao;
import com.boraji.tutorial.spring.model.Noticias;

@Controller
public class MyContoller {

	
	 @Autowired
	    private NoticiasDao noticiasDao;
  
	 @GetMapping("/")
	  public String index(Model model, Principal principal) {
//	    model.addAttribute("message", "You are logged in as " + principal.getName());
	    return "index";
	  }
	@GetMapping("/privado")
  public String privado(Model model, Principal principal) {
    model.addAttribute("message", "You are logged in as " + principal.getName());
    return "privado";
  }
  @GetMapping("/noticias")
  public String noticias(Model model, Principal principal) {
//    model.addAttribute("message", "You are logged in as " + principal.getName());
    return "noticias";
  }
  @GetMapping("/contacto")
  public String contacto(Model model, Principal principal) {
//    model.addAttribute("message", "You are logged in as " + principal.getName());
    return "contacto";
  }

  // POST: Save product
  @RequestMapping(value = { "/insertar" }, method = RequestMethod.POST)
  // Avoid UnexpectedRollbackException (See more explanations)
  @Transactional(propagation = Propagation.NEVER)
  public String productSave(Model model, //
          @ModelAttribute("productForm") @Validated Noticias noticiaInfo, //
          BindingResult result, //
          final RedirectAttributes redirectAttributes) {

      if (result.hasErrors()) {
          return "noticia";
      }
      try {
          noticiasDao.save(noticiaInfo);
      } catch (Exception e) {
          // Need: Propagation.NEVER?
          String message = e.getMessage();
          model.addAttribute("message", message);
          // Show product form.
          return "noticia";

      }
      return "redirect:/noticiasList";
  }
}
