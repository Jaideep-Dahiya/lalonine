package com.example.demo.demo.commands;

public interface Command {
    boolean canExecute(String input);
    void execute(String input);
}
