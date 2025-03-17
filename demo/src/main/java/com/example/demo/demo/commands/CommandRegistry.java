package com.example.demo.demo.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandRegistry {

    List<Command> commands = new ArrayList<>();

    private Command commandOne;
    private Command commandTwo;

    //add as many commands as you want
    @Autowired
    CommandRegistry(Command commandOne,Command commandTwo) {
        this.commandOne = commandOne;
        this.commandTwo = commandTwo;
        commands.add(commandOne);
        commands.add(commandTwo);
        // just add them here as well
    }

    public void run(){
        commandOne.execute("hey");
        commandTwo.execute("hey ");
        //get input
        String input = "";
        for(Command c : commands){
           if(c.canExecute(input)){
               c.execute(input);
           }
        }
    }
}
