package com.controller;

import com.domain.LeaveApplication;
import com.domain.LeaveType;
import com.domain.Security;
import com.domain.Student;
import com.repository.LeaveApplicationRepository;
import com.repository.SecurityRepository;
import com.service.LeaveTypeService;
import com.service.SecurityService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
@Controller
@RequestMapping("/reg")
public class SecurityController {

    private SecurityService securityService;

    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping ("/user")
    public String create() throws Exception {

        Security security = new Security();


        securityService.insert(security);

        return "USER created";
    }
}
