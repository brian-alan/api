package com.assessment.api.abstractfactory;

import java.util.Objects;

public class FactoryCreator {

    private static FactoryCreator factoryCreator;

    private FactoryCreator(){

    }

    public static FactoryCreator getFactoryCreator(){
        if (factoryCreator == null){
            factoryCreator = new FactoryCreator();
        }
        return factoryCreator;
    }

    public Company getCompany(String companyName){
        Company company = null;
        if (companyName.equals("Sony")){
            company = new Sony();
        }else if(companyName.equals("Microsoft")){
            company = new Microsoft();
        }
        return company;
    }
    public CompanyConsole getConsole(Company company, String gen){
        Objects.requireNonNull(company);
        CompanyConsole console = company.console(gen);
        return console;
    }
}
