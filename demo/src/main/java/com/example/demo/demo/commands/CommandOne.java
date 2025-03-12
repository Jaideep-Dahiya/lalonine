package com.example.demo.demo.commands;

import org.springframework.stereotype.Component;

@Component
public class CommandOne implements Command{
    @Override
    public boolean canExecute(String input) {
        return false;
    }

    @Override
    public void execute(String input) {
        System.out.println("1 --> "+input);
    }
}
