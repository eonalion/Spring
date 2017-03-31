package com.epam.suboch.command;

import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class TestCommand implements CommandMarker {
    @CliCommand(value = "test", help = "Print test message")
    public String test(
            @CliOption(key = {"", "msg" }, mandatory = true, help= "The message to test command") String msg) {
        return msg;
    }
}
