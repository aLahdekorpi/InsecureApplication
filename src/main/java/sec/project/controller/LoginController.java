/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author alex
 */
@Controller
public class LoginController {
        
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loadForm() {
        return "loginform";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submitForm(@RequestParam String name, @RequestParam String password) {
        if(name.equals("admin") && password.equals("admin")){
            return "form";
        } else {
            return "loginform";
        }
        
    }
}
