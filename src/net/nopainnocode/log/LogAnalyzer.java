package net.nopainnocode.log;

import net.nopainnocode.log.domain.Log;
import net.nopainnocode.log.domain.type.Status;
import net.nopainnocode.log.io.LogReader;
import net.nopainnocode.log.io.LogWriter;
import net.nopainnocode.log.utils.formatter.Formatter;
import net.nopainnocode.log.utils.formatter.LogFormatter;
import net.nopainnocode.log.utils.parser.LogParser;
import net.nopainnocode.log.utils.parser.Parser;

import java.util.List;
import java.util.Map;

/**
 * Created by no_pain_no_code on 2015. 11. 29..
 * Reader 를 통해 input 로그를 읽어 Writer 를 통해 output 로그를 입력합니다
 */
public class LogAnalyzer {

    private Parser parser;
    private Formatter formatter;

    public LogAnalyzer(Parser parser, Formatter formatter){
        this.parser = parser;
        this.formatter = formatter;
    }
    /**
     * 로그의 정보를 읽어 분석결과를 출력합니다.
     * @return
     */
    public boolean analyze(String path) {

        String inputLogStr = new LogReader().readLog(path);
        Map<Status, List<Log>> logMaps = parser.parse(inputLogStr.toString());
        String formattedStr = formatter.doFormat(logMaps);

        return new LogWriter().writeLog(path, formattedStr);
    }
}
