package net.nopainnocode.log;

import net.nopainnocode.log.io.LogReader;
import net.nopainnocode.log.io.LogWriter;

/**
 * Created by no_pain_no_code on 2015. 11. 29..
 * Reader 를 통해 input 로그를 읽어 Writer 를 통해 output 로그를 입력합니다
 */
public class LogAnalyzer {

    private String path;

    private LogReader logReader;
    private LogWriter logWriter;

    public LogAnalyzer(String path) {
        this.path = path;
        this.logReader = new LogReader(path);
        this.logWriter = new LogWriter(path);
    }

    /**
     * 로그의 정보를 읽어 분석결과를 출력합니다.
     * @return
     */
    public boolean analyze() {
        return logWriter.writeLog(logReader.readLog());
    }
}
