package net.nopainnocode.log.utils.parser;

import net.nopainnocode.log.utils.formatter.Formatter;

/**
 * Created by no_pain_no_code on 2015. 11. 29..
 * 로그 정보를 파싱한다.
 */
public interface Parser {
    void parse(String str, Formatter formatter);
}
