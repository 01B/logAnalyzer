package net.nopainnocode.log.io;

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

    public boolean writeLog(String path, String formmattedStr) {

        boolean result = false;

        // File outputStream
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path + OUTPUT_LOG)))) {
            writer.write(formmattedStr);
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
