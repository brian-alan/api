package com.assessment.api.abstractfactory;

public class Microsoft implements Company{
    @Override
    public String name() {
        return "Microsoft";
    }

    @Override
    public CompanyConsole console(String gen) {
        CompanyConsole console = null;
        if(gen.equals("Last")){
            console = new XboxLastGen();
        }else if(gen.equals("New")){
            console = new XboxNewGen();
        }
        return console;
    }
}
