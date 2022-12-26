package com.service;

import com.domain.LeaveApplication;
import com.repository.LeaveApplicationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LeaveApplicationService {

    private LeaveApplicationRepository leaveApplicationRepository;

    public LeaveApplicationService(LeaveApplicationRepository leaveApplicationRepository) {
        this.leaveApplicationRepository = leaveApplicationRepository;
    }

    @Transactional
    public boolean insert(LeaveApplication leaveApplication) {

        if (leaveApplication.getTotalDays() <= leaveApplication.getLeaveType().getTotalDays()) {
            return leaveApplicationRepository.create(leaveApplication);
        }
        return false;
    }

    @Transactional(readOnly = true)
    public LeaveApplication get(Long id) {
        return leaveApplicationRepository.get(id);
    }

    public List<LeaveApplication> list()
    {
        return leaveApplicationRepository.list();
    }
    @Transactional
    public boolean update(LeaveApplication leaveApplication) {

        if (leaveApplication.getTotalDays() <= leaveApplication.getLeaveType().getTotalDays()) {
            return leaveApplicationRepository.update(leaveApplication);
        }
        return false;
    }
    public void delete(LeaveApplication leaveApplication) {

         leaveApplicationRepository.delete(leaveApplication);
    }
}
