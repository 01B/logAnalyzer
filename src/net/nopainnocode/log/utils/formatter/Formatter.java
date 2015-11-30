package net.nopainnocode.log.utils.formatter;

/**
 * Created by no_pain_no_code on 2015. 11. 29..
 * 로그 분석 결과의 자료구조와 서식을 만듦니다.
 */
public interface Formatter<V> {
    String doFormat();
    void addLog(V value);
}
