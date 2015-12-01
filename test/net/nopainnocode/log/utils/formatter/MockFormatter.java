package net.nopainnocode.log.utils.formatter;

import net.nopainnocode.log.domain.Log;
import net.nopainnocode.log.domain.type.Status;

import java.util.List;
import java.util.Map;

/**
 * Created by no_pain_no_code on 2015. 11. 30..
 */
public class MockFormatter implements Formatter {
    @Override
    public String doFormat(Map<Status, List<Log>> logMap) {
        return null;
    }
}
