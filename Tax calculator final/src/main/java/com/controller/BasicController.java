package com.controller;

import com.domain.Admin;
import com.domain.User;
import com.service.AccountService;
import com.service.AdminService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/home")
public class BasicController {

    private final AccountService accountService;

    private final AdminService adminService;

    public BasicController(AccountService accountService, AdminService adminService) {
        this.accountService = accountService;
        this.adminService = adminService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/signup")
    public String signup() {

        return "registration";
    }
    @RequestMapping("/adminR")
    public String signupA() {

        return "adminReg";
    }
    @RequestMapping("/login")
    public String login() {

        return "login";
    }

    @RequestMapping("/createuser")
    public String create(@ModelAttribute("user") User user,@ModelAttribute("username") String username,Model model) {
        model.addAttribute("username",username);

        accountService.insert(user);
        return "redirect:/tax/homepage";
    }
    @RequestMapping("/createadmin")
    public String createA(@ModelAttribute("admin") Admin admin) {

        adminService.insert(admin);
        return "redirect:/home/adminR";
    }



    @RequestMapping("/userlogin")

    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpServletRequest request){

        try {
            String uname = username.toString();
            //User user = accountService.get(uname);
            //String checkuser = user.getUsername();
            String check = "asd";
            if (check.equals(uname)) {
                return "redirect:/tax/homepage";
            } else {
                return "redirect:/tax/registration";
            }
        }

        catch(Exception a){
            return "redirect:/tax/login";
        }


    }


}
