package net.nopainnocode.log.utils.formatter;

import net.nopainnocode.log.domain.Log;
import net.nopainnocode.log.domain.type.Status;

import java.util.List;
import java.util.Map;

/**
 * Created by no_pain_no_code on 2015. 11. 29..
 * 로그 분석 결과의 자료구조와 서식을 만듦니다.
 */
public interface Formatter {
    String doFormat(Map<Status, List<Log>> logMap);
}
