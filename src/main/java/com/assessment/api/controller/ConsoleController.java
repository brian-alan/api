package com.assessment.api.controller;

import com.assessment.api.abstractfactory.Company;
import com.assessment.api.abstractfactory.CompanyConsole;
import com.assessment.api.abstractfactory.FactoryCreator;
import com.assessment.api.entity.Console;
import com.assessment.api.service.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/console")
public class ConsoleController {

    @Autowired
    private ConsoleService service;

    @GetMapping
    public List<Console> getAllConsoles(){
        return service.seeAllConsole();
    }

    @PostMapping("/{company}/{gen}")
    public Console addConsole(@PathVariable(value = "company") String companyName,
                              @PathVariable(value = "gen") String gen){
        //Singleton
        FactoryCreator factoryCreator = FactoryCreator.getFactoryCreator();
        Company company = factoryCreator.getCompany(companyName);
        CompanyConsole cConsole = factoryCreator.getConsole(company, gen);
        Console console = new Console();
        console.setCompany(company.name());
        console.setName(cConsole.model());
        return service.saveConsole(console);
    }
}
