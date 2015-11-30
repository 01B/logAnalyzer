package net.nopainnocode.log.utils.formatter;

import net.nopainnocode.log.domain.Log;

/**
 * Created by no_pain_no_code on 2015. 11. 30..
 */
public class MockFormatter implements Formatter<Log> {
    @Override
    public String doFormat() {
        return "test";
    }

    @Override
    public void addLog(Log value) {

    }
}
