package com.controller;

import com.domain.LeaveApplication;
import com.domain.LeaveType;
import com.domain.Student;
import com.service.LeaveApplicationService;
import com.service.LeaveTypeService;
import com.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApiLeaveApplicationController {

    private LeaveApplicationService la;

    private LeaveTypeService lt;

    private StudentService s;

    public RestApiLeaveApplicationController(LeaveApplicationService la, LeaveTypeService lt, StudentService s) {
        this.la = la;
        this.lt = lt;
        this.s = s;
    }


    @PostMapping ("/api/leaveApplications")
    public boolean create() throws Exception {
        LeaveType lt = lt.get(1L);
        Student student = s.get(1L);

        LeaveApplication la = new LeaveApplication();
        leaveApplication.setStudent(student);
        leaveApplication.setLeaveType(leaveType);

     
        leaveApplication.setReason("cough");
        boolean chk = leaveApplicationService.insert(leaveApplication);
      
		eaveApplication.setFromDate(LocalDate.of(2022, 10, 1));
        leaveApplication.setToDate(LocalDate.of(2022, 11, 11));
        leaveApplication.setTotalDays(2);
        if (!chk) {
            throw new Exception("wrong input");
        }
        return chk;
    }

    @GetMapping ("/leaveApplication/{id}")
    public LeaveApplication get(@PathVariable("id")String id) {
        LeaveApplication leaveApplication = leaveApplicationService.get(Long.valueOf(id));

        return leaveApplication;
    }

    @GetMapping("/leaveApplications")
    public List<LeaveApplication> getAll()
    {
        return leaveApplicationService.list();
    }
    @PutMapping ("/leaveApplication/{id}")
    public LeaveApplication update(@PathVariable("id")String id) {
        LeaveApplication leaveApplication = leaveApplicationService.get(Long.valueOf(id));
        leaveApplication.setReason("covid");
        leaveApplicationService.update(leaveApplication);
        return leaveApplication;
    }
    @DeleteMapping  ("/leaveApplication/{id}")
    public LeaveApplication delete(@PathVariable("id")String id) {
        LeaveApplication leaveApplication = leaveApplicationService.get(Long.valueOf(id));
        leaveApplicationService.delete(leaveApplication);

        return leaveApplication;
    }
}
