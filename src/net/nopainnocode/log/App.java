package net.nopainnocode.log;

import net.nopainnocode.log.domain.Log;
import net.nopainnocode.log.domain.type.Status;
import net.nopainnocode.log.utils.formatter.Formatter;
import net.nopainnocode.log.utils.formatter.LogFormatter;
import net.nopainnocode.log.utils.parser.LogParser;
import net.nopainnocode.log.utils.parser.Parser;

import java.util.List;

/**
 * Created by no_pain_no_code on 2015. 11. 29..
 */
public class App {
    public static void main(String[] args) {
        //String path = "/Users/no_pain_no_code/Documents/dkTechinLog/";
        String path = "";
        Parser parser = new LogParser<Status, List<Log>>();
        Formatter formatter = new LogFormatter();
        new LogAnalyzer(parser, formatter).analyze(path);
    }
}
