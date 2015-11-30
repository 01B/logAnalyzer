package net.nopainnocode.log.io;

import net.nopainnocode.log.utils.formatter.Formatter;
import net.nopainnocode.log.utils.formatter.LogFormatter;
import net.nopainnocode.log.utils.parser.LogParser;
import net.nopainnocode.log.utils.parser.Parser;

import java.io.*;

/**
 * Created by no_pain_no_code on 2015. 11. 29..
 * input.log 파일을 읽습니다.
 */
public class LogReader {

    private final static String INPUT_LOG = "input.log";

    private String path;
    private Parser logParser;

    public LogReader(String path) {
        this.path = path;
        this.logParser = new LogParser();
    }

    public Formatter readLog() {

        Formatter formatter = new LogFormatter();
        StringBuilder inputLogStr = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path + INPUT_LOG)))) {
            String str;
            while ((str = reader.readLine()) != null)
                inputLogStr.append(str + "\n");

            logParser.parse(inputLogStr.toString(), formatter);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return formatter;
    }
}
