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
import javax.sql.DataSource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
@RequestMapping("/home")
public class InfoController {

    private final AccountService accountService;
    private DataSource dataSource;
    private final AdminService adminService;

    public InfoController(AccountService accountService, AdminService adminService, DataSource dataSource) {
        this.accountService = accountService;
        this.adminService = adminService;
        this.dataSource = dataSource;
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
    @RequestMapping("/adminH")
    public String adminHomePage() {

        return "adminHome";
    }

    @RequestMapping("/adminU")
    public String AdminUserCreationButton() {

        return "userByAdmin";
    }
    @RequestMapping("/adminUu")
    public String AdminUserUpdateButton() {

        return "updateByAdmin";
    }
    @RequestMapping("/adminUd")
    public String AdminUserDeleteButton() {

        return "deleteByAdmin";
    }

    @RequestMapping("/login")
    public String login() {

        return "login";
    }

    @RequestMapping("/createuser")
    public String create(@ModelAttribute("user") User user,@ModelAttribute("email") String email,Model model) {
        model.addAttribute("email",email);

        accountService.insert(user);
        return "redirect:/tax/homepage";
    }

    @RequestMapping("/createuserByAdmin")
    public String createByAdmin(@ModelAttribute("user") User user,@ModelAttribute("email") String email,Model model) {
        model.addAttribute("email",email);

        accountService.insert(user);
        return "redirect:/home/adminH";
    }
    @RequestMapping("/updateuserByAdmin")
    public String reg(@ModelAttribute("Prev-name") String PrevName, @ModelAttribute("Prev-email") String PrevEmail,@ModelAttribute("New-name") String NewName, @ModelAttribute("New-email") String NewEmail,/*@ModelAttribute("Festival_bonus") int Festival_bonus,*/ Model model) throws SQLException {
        model.addAttribute("Prev-name", PrevName);
        model.addAttribute("Prev-email", PrevEmail);
        model.addAttribute("New-name", NewName);
        model.addAttribute("New-email", NewEmail);

       //update sql
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("update taxreg set name =?,email=? where name =? and email=?");
        statement.setString(1, NewName);
        statement.setString(2, NewEmail);
        statement.setString(3, PrevName);
        statement.setString(4, PrevEmail);

        statement.executeUpdate();

        return "redirect:/home/adminH";
    }
    @RequestMapping("/deleteuserByAdmin")
    public String del(@ModelAttribute("Prev-name") String PrevName, @ModelAttribute("Prev-email") String PrevEmail,/*@ModelAttribute("Festival_bonus") int Festival_bonus,*/ Model model) throws SQLException {
        model.addAttribute("Prev-name", PrevName);
        model.addAttribute("Prev-email", PrevEmail);


        //delete sql
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("delete from taxreg where name =? and email=?");
        statement.setString(1, PrevName);
        statement.setString(2, PrevEmail);

        statement.execute();

        return "redirect:/home/adminH";
    }





    @RequestMapping("/createadmin")
    public String createA(@ModelAttribute("admin") Admin admin) {

        adminService.insert(admin);
        return "redirect:/home/adminH";
    }



    @RequestMapping("/userlogin")

    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpServletRequest request){

        try {
            String e = email.toString();
            //User user = accountService.get(uname);
            //String checkuser = user.getUsername();
            String check = "asd";
            if (check.equals(email)) {
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
