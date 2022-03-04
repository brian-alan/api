package com.assessment.api.abstractfactory;

public class Sony implements Company{
    @Override
    public String name() {
        return "Sony";
    }

    @Override
    public CompanyConsole console(String gen) {
        CompanyConsole console = null;
        if(gen.equals("Last")){
            console = new PlayLastGen();
        }else if(gen.equals("New")){
            console = new PlayNewGen();
        }
        return console;
    }
}
