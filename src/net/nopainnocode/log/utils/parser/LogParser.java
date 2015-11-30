package net.nopainnocode.log.utils.parser;

import net.nopainnocode.log.domain.Log;
import net.nopainnocode.log.domain.UrlInfo;
import net.nopainnocode.log.domain.type.Status;
import net.nopainnocode.log.domain.type.WebBrower;
import net.nopainnocode.log.utils.formatter.Formatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by no_pain_no_code on 2015. 11. 29..
 * 불러온 input 로그 정보를 분석하기 쉽게 데이터를 파싱한다.
 */
public class LogParser implements Parser {

    /**
     * 로그 정보를 쪼개어 저장한다.
     * @param str
     * @param formatter
     */
    @Override
    public void parse(String str, Formatter formatter) {

        String[] line = str.replaceAll("\\[", "").split("\n");
        int len = line.length;

        for (int i = 0; i < len; i++)
            formatter.addLog(generateLog(line[i].split("\\]")));
    }

    /**
     * 로그 정보를 만듧니다.
     * @param logSplit
     * @return
     */
    private Log generateLog(String[] logSplit) {

        Status status = Status.valueOf(Integer.valueOf(logSplit[0]));
        UrlInfo urlInfo = UrlInfo.build(logSplit[1]);
        WebBrower browser = WebBrower.valueOf(logSplit[2]);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = dateFormat.parse(logSplit[3]);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new Log(status, urlInfo, browser, date);
    }
}
