package com.controller;

import com.domain.Tax;
import com.domain.User;
import com.service.AccountService;
import com.service.TaxService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import javax.validation.Valid;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
@RequestMapping("/tax")
public class HomeController {


    private final AccountService accountService;
    private final TaxService taxService;
    private DataSource dataSource;

    public HomeController(AccountService accountService, TaxService taxService, DataSource dataSource) {
        this.accountService = accountService;
        this.taxService = taxService;
        this.dataSource = dataSource;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }



    @RequestMapping("/deleteuserByUser")
    public String del(@ModelAttribute("email") String email,/*@ModelAttribute("Festival_bonus") int Festival_bonus,*/ Model model) throws SQLException {

        model.addAttribute("email", email);


        //delete sql
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("delete from taxreg where email =? ");

        statement.setString(1, email);

        statement.execute();

        return "redirect:/home/signup";
    }

    @RequestMapping("/userlogout")
    public String logout(){
        return "redirect:/home/login";
    }




    @RequestMapping("/homepage")
    public String homepage(@ModelAttribute("email") String email,Model model){
        model.addAttribute("email",email);
        return "homepage";
    }

    @RequestMapping("/calculatetax")
    public String taxcalculate(@ModelAttribute("tax") Tax tax){

        taxService.insert(tax);
        return "redirect:/tax/showtax";
    }

    @RequestMapping("/userU")
    public String UserUpdateButton(@ModelAttribute("email") String email,Model model) {
        model.addAttribute("email",email);

        return "updateByUser";
    }

    @RequestMapping("/updateuserByUser")
    public String reg(@ModelAttribute("email") String email,@ModelAttribute("New-name") String NewName, @ModelAttribute("New-email") String NewEmail,/*@ModelAttribute("Festival_bonus") int Festival_bonus,*/ Model model) throws SQLException {

        model.addAttribute("email", email);
        model.addAttribute("New-name", NewName);
        model.addAttribute("New-email", NewEmail);

        //update sql
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("update taxreg set name =?,email=? where email=?");
        statement.setString(1, NewName);
        statement.setString(2, NewEmail);
        statement.setString(3, email);


        statement.executeUpdate();

        return "redirect:/tax/homepage";
    }


    @RequestMapping("/taxcalculate")
    public String calculate(@Valid @ModelAttribute("Basic_salary") int Basic_salary,@ModelAttribute("email") String email, @ModelAttribute("House_rent") int House_rent, @ModelAttribute("Medical_allowance") int Medical_allowance,@ModelAttribute("Conveyance") int Conveyance,@ModelAttribute("Incentive") int Incentive,@ModelAttribute("Festival_Bonus") int Festival_Bonus,@ModelAttribute("Investment_amount") int Investment_amount, @ModelAttribute("Category") String Category, Model model) throws SQLException {

        model.addAttribute("email",email);
             //model.addAttribute("NID",NID);
        model.addAttribute("Basic_salary",Basic_salary);
        model.addAttribute("House_rent", House_rent);

        model.addAttribute("Medical_allowance", Medical_allowance);
        model.addAttribute("Conveyance", Conveyance);
        model.addAttribute("Incentive", Incentive);
        model.addAttribute("Festival_Bonus", Festival_Bonus);
        model.addAttribute("Investment_amount", Investment_amount);
        model.addAttribute("Category", Category);
        int sum = 0;
        int HouseRentExemption= Basic_salary*50/100;
        int taxableHouseRent = House_rent - HouseRentExemption;
        if(HouseRentExemption>House_rent) {

            taxableHouseRent=0;
        }

        int MedicalAllowanceExemption= Basic_salary*10/100;
        int taxableMedicalAllowance =Medical_allowance-MedicalAllowanceExemption;
        if(MedicalAllowanceExemption>Medical_allowance){

            taxableMedicalAllowance=0;
        }

        int ConveyanceExemption = 30000;
        int taxableConveyance=Conveyance-ConveyanceExemption;

        if(Conveyance<30000){

            taxableConveyance=0;
        }
        sum =  Basic_salary +taxableHouseRent+taxableMedicalAllowance+taxableConveyance+ Incentive+Festival_Bonus;

        model.addAttribute("sum", sum);
        model.addAttribute("HouseRentExemption", HouseRentExemption);
        model.addAttribute("taxableHouseRent", taxableHouseRent);
        model.addAttribute("MedicalAllowanceExemption", MedicalAllowanceExemption);
        model.addAttribute("taxableMedicalAllowance", taxableMedicalAllowance);
        model.addAttribute(" ConveyanceExemption", ConveyanceExemption);
        model.addAttribute("taxableConveyance", taxableConveyance);


        //slab
        int minBalance=0;
        if(Category.equals("General")){
            minBalance=300000;
        }
        else if(Category.equals("Female/ Senior citizen (65 years or above) ")){
            minBalance=350000;
        }
        else if(Category.equals("Disabled")){
            minBalance=450000;
        }
        else if(Category.equals("Freedom Fighter")){
            minBalance=475000;
        }

        int checkpoint1=0;
        int checkpoint2=0;
        int checkpoint3=0;
        int checkpoint4=0;
        int checkpoint5=0;
        int remaining=sum;
        int newTotal=0;
        int payableTax=0;
        int eligibleAmount=0;
        int rebate=0;
        int maximumTax=0;
        if(remaining>minBalance){
            remaining =remaining-minBalance;
            payableTax=payableTax+0;
            newTotal=newTotal+300000;
            if(remaining>=100000){
                remaining =remaining-100000;
                payableTax=payableTax+5000;
                checkpoint1=payableTax;
                newTotal=newTotal+100000;
                if(remaining>=300000){
                    remaining=remaining-300000;
                    payableTax=payableTax+30000;
                    checkpoint2=payableTax;
                    newTotal= newTotal+300000;
                    if(remaining>=400000){
                        remaining=remaining-400000;
                        payableTax=payableTax+60000;
                        checkpoint3=payableTax;
                        newTotal=newTotal+400000;
                        if(remaining>=500000){
                            remaining=remaining-500000;
                            payableTax=payableTax+100000;
                            checkpoint4=payableTax;
                            newTotal=newTotal+500000;
                            if(remaining>0 && checkpoint4!=0){
                                remaining=sum-newTotal;
                                payableTax=payableTax+(remaining*25/100);
                                checkpoint5=payableTax;
                            }
                        }
                        else{
                            payableTax=payableTax+remaining*20/100;
                            checkpoint1=payableTax;
                            remaining=0;

                        }
                    }
                    else{
                        payableTax=payableTax+remaining*15/100;
                        checkpoint3=payableTax;
                        remaining=0;

                    }
                }
                else{
                    payableTax=payableTax+remaining*10/100;
                    checkpoint2=payableTax;
                    remaining=0;

                }

            }
            else{
                payableTax=payableTax+remaining*5/100;
                checkpoint1=payableTax;
                remaining=0;

            }
        }









        model.addAttribute("payableTax", payableTax);
        model.addAttribute("checkpoint1", checkpoint1);
        model.addAttribute("checkpoint2", checkpoint2);
        model.addAttribute("checkpoint3", checkpoint3);
        model.addAttribute("checkpoint4", checkpoint4);
        model.addAttribute("checkpoint5", checkpoint5);
        model.addAttribute("minBalance", minBalance);

        //investment
        eligibleAmount=payableTax*20/100;
        int investment=Investment_amount;
        rebate=investment*15/100;
        maximumTax= payableTax-rebate;

        model.addAttribute("eligibleAmount", eligibleAmount);
        model.addAttribute("investment", investment);
        model.addAttribute("rebate", rebate);
        model.addAttribute("maximumTax", maximumTax);



        String username = "asd";
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into taxcalculator(total,email) values (?,?)");
        statement.setLong(1, maximumTax);
        statement.setString(2, email);
        //statement.setLong(2, taxpayable);

        statement.execute();


        return "showcalculate";
    }
    @RequestMapping("/taxhistory")
    public String showtax(@ModelAttribute("email") String email,Model model){
        model.addAttribute("email", email);
        Tax h = taxService.get(email);
        model.addAttribute("total", h.getTotal());
        model.addAttribute("email", h.geteMail());
        return "history";
    }





}
