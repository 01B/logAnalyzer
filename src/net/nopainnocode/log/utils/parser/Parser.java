package net.nopainnocode.log.utils.parser;

import java.util.List;
import java.util.Map;

/**
 * Created by no_pain_no_code on 2015. 11. 29..
 * 로그 정보를 파싱한다.
 */
public interface Parser<K, V> {
    Map<K, List<V>> parse(String str);
}
