package com.runrong.managecenter.business.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  
public class MainsiteErrorController implements ErrorController {  
  
 private static final String ERROR_PATH = "/error";  
   
 	@RequestMapping(value=ERROR_PATH)  
    public String handleError(){  
        return "/managecenter/404.html";  
    }  
   
	 @Override  
	 public String getErrorPath() {  
	  // TODO Auto-generated method stub  
		 return ERROR_PATH;  
	 }  
	  
}  
