package org.osdsc.prototype.simpleblog.controller;

import java.util.ArrayList;
import java.util.List;

import org.osdsc.prototype.simpleblog.model.SignupForm;
import org.osdsc.prototype.simpleblog.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
 
@Controller
public class BaseController {
 
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
		
		List<User> userList = new ArrayList<User>();
		
		User user = new User();		
		user.setAccountName("honeymonkey");
		user.setFullName("Bank Thaweepol");
		user.setEmail("twp_nn@osdsc.com");		
			
		userList.add(user);
		
		user = new User();
		user.setAccountName("monkeyhoney");
		user.setFullName("Thaweepol Bank");
		user.setEmail("lolwut@osdsc.com");	
		
		userList.add(user);
		
		return new ModelAndView("index", "userList", userList);
    }
	
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup() {
    	    	
    	return new ModelAndView("signup", "signupForm", new SignupForm());
    }
 
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model, SignupForm signupForm, 
    		BindingResult result, RedirectAttributes redirectAttributes) {
    	    	
        if (result.hasErrors()) {
            return "index";
        }
 
        return "show";
     
    }
 
    @RequestMapping(value = "/security-error", method = RequestMethod.GET)
    public String securityError(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("page_error", "You do have have permission to do that!");
        return "redirect:/";
    }
 
}
