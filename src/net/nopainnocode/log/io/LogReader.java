package net.nopainnocode.log.io;

import java.io.*;

/**
 * Created by no_pain_no_code on 2015. 11. 29..
 * input.log 파일을 읽습니다.
 */
public class LogReader {

    private final static String INPUT_LOG = "input.log";

    public String readLog(String path) {

        StringBuilder inputLogStr = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path + INPUT_LOG)))) {

            String str;
            while ((str = reader.readLine()) != null)
                inputLogStr.append(str + "\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputLogStr.toString();
    }
}
