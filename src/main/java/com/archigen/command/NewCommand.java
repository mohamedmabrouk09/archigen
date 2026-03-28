package com.archigen.command;

import picocli.CommandLine.Command;

@Command(name = "new", description = "Generate a new Clean Architecture project")
public class NewCommand implements Runnable {

    @Override
    public void run() {
        System.out.println("NewCommand — not yet implemented");
    }
}
