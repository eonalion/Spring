package com.epam.suboch.logger;

import com.epam.suboch.event.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 */
public class FileEventLogger implements IEventLogger {
    private String filename;

    FileEventLogger(String filename){
        this.filename = filename;
    }
    public void logEvent(Event event) {
        Path path = Paths.get("logs", filename);

        try {
            FileUtils.writeStringToFile(path.toFile(), event.toString(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void init() throws IOException{
        File file = new File(filename);
        file.canWrite();
    }
}
