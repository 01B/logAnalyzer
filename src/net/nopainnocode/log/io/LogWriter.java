package net.nopainnocode.log.io;

import net.nopainnocode.log.utils.formatter.Formatter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by no_pain_no_code on 2015. 11. 29..
 * output.log 파일에 결과를 입력합니다.
 */
public class LogWriter {

    private final static String OUTPUT_LOG = "output.log";
    private String path;

    public LogWriter(String path) {
        this.path = path;
    }

    public boolean writeLog(Formatter formatter) {

        boolean result = false;
        String formmattingStr = formatter.doFormat();

        // File outputStream
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path + OUTPUT_LOG)))) {
            writer.write(formmattingStr);
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
