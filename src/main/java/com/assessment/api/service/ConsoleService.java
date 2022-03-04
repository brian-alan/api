package com.assessment.api.service;

import com.assessment.api.entity.Console;
import com.assessment.api.repository.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsoleService {
    @Autowired
    private ConsoleRepository repository;

    public List<Console> seeAllConsole(){ return repository.findAll(); }

    public Console saveConsole (Console console){ return repository.save(console); }
}
