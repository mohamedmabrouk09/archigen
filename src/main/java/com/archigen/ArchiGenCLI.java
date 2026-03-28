package com.archigen;

import com.archigen.command.NewCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "archigen", mixinStandardHelpOptions = true, version = "1.0.0",
         description = "Generates a Spring Boot project scaffold",
         subcommands = {NewCommand.class})
public class ArchiGenCLI implements Runnable {

    public static void main(String[] args) {
        int exitCode = new CommandLine(new ArchiGenCLI()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public void run() {
        new CommandLine(this).usage(System.out);
    }
}
