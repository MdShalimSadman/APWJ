package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.xml.transform.Result;
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




    @RequestMapping("/data")
    public void getData() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users");
        while(resultSet.next()) {
            System.out.println(resultSet.getLong(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
        }

    }

    @RequestMapping("/registration")
    public String calc(HttpServletRequest request, HttpServletResponse response){
        return "registration";
    }

    @RequestMapping("/registration/v2")
    public String cal (@ModelAttribute("input1") float input1, @ModelAttribute("input3") float input3, Model model)  {
        model.addAttribute("input1",input1);
        model.addAttribute("input3", input3);

        float sum = 0;
        sum = input1 + input3;

        model.addAttribute("sum", sum);




        return "welcome";
    }






}
