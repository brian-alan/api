package com.assessment.api.abstractfactory;

public interface Company {
    String name();
    CompanyConsole console(String gen);
}
