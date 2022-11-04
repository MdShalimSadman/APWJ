package com;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

//import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
//import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@Controller
public class HomeController {

    private DataSource dataSource;

    public HomeController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @RequestMapping("/hello")
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.write("<h1>Hello Java Homepage<h1>");
    }

    @RequestMapping("/greet")
    public String greet() {
        return "home";
    }






    @RequestMapping("/registration")
    public String calc(HttpServletRequest request, HttpServletResponse response){
        return "registration";
    }

    @RequestMapping("/registration/v2")
    public String cal (@ModelAttribute("number1") int number1, @ModelAttribute("number2") int number2, Model model)  {
        model.addAttribute("number1",number1);
        model.addAttribute("number2", number2);

        int sum = 0;
        sum =  number1 + number2;

        model.addAttribute("sum", sum);




        return "welcome";
    }






}
