package com.recouvrex.process.service.impl;

import com.recouvrex.process.model.Status;
import com.recouvrex.process.repository.StatusRepository;
import com.recouvrex.process.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusRepository statusRepository;
    @Override
    public Status save(Status status) {
        return statusRepository.save(status);
    }

    @Override
    public List<Status> listStatus() {
        return statusRepository.findAll();
    }
}
