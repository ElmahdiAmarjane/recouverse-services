package com.recouvrex.process.service.impl;

import com.recouvrex.process.model.Case;
import com.recouvrex.process.model.Task;
import com.recouvrex.process.model.User;
import com.recouvrex.process.repository.CaseRepository;
import com.recouvrex.process.repository.TaskRepository;
import com.recouvrex.process.service.TaskService;
import com.recouvrex.process.utils.IdentificationTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CaseRepository caseRepository;

    @Override
    public List<Task> findByCaseId(Long caseId) {
            return taskRepository.findByCaseId(caseId);
    }

    public List<Task> findByCaseIdAndUserId(Long caseId, Long userId) {
        return taskRepository.findByCaseIdAndUserId(caseId, userId);
    }
    @Override
    public Task save(Task task,Long caseId) {
        Case cas = caseRepository.findById(caseId).orElse(null);
        task.setCas(cas);
        return taskRepository.save(task);
    }

}
