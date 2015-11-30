package net.nopainnocode.log.utils.parser;

import net.nopainnocode.log.utils.formatter.Formatter;
import net.nopainnocode.log.utils.formatter.MockFormatter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by no_pain_no_code on 2015. 11. 30..
 */
public class LogParserTest {

    private Parser logParser;

    @Before
    public void setUp() throws Exception {
        logParser = new LogParser();
    }

    @Test
    public void test_parser() throws Exception {

        //given
        String logStr =
        "[200][http://apis.daum.net/search/knowledge?apikey=23jf&q=daum][IE][2012-06-10 08:02:28]"
        + "[10][http://apis.daum.net/search/blog?q=daum][IE][2012-06-10 08:02:29]"
        + "[200][http://apis.daum.net/search/vclip?apikey=e3ea&q=daum][Firefox][2012-06-10 08:02:30]"
        + "[200][http://apis.daum.net/search/knowledge?apikey=fwji&q=daum][IE][2012-06-10 08:02:31]"
        + "[200][http://apis.daum.net/search/blog?apikey=23jf&q=daum][IE][2012-06-10 08:02:32]"
        + "[200][http://apis.daum.net/search/image?apikey=e3ea&q=daum][IE][2012-06-10 08:02:33]"
        + "[200][http://apis.daum.net/search/image?apikey=tr8j&q=daum][Firefox][2012-06-10 08:02:34]"
        + "[200][http://apis.daum.net/search/knowledge?apikey=wejf&q=daum][IE][2012-06-10 08:02:35]"
        + "[200][http://apis.daum.net/search/vclip?apikey=tr8j&q=daum][IE][2012-06-10 08:03:47]"
        + "[200][http://apis.daum.net/search/vclip?apikey=anw1&q=daum][IE][2012-06-10 08:03:48]"
        + "[404][http://apis.daum.net/search/aaaaapikey=jg9k&q=daum][IE][2012-06-10 08:03:49]"
        + "[200][http://apis.daum.net/search/vclip?apikey=wejf&q=daum][IE][2012-06-10 08:03:50]"
        + "[200][http://apis.daum.net/search/book?apikey=dcj8&q=daum][IE][2012-06-10 08:03:51]"
        + "[200][http://apis.daum.net/search/book?apikey=23jf&q=daum][IE][2012-06-10 08:03:52]"
        + "[200][http://apis.daum.net/search/image?apikey=anw1&q=daum][IE][2012-06-10 08:03:53]"
        + "[200][http://apis.daum.net/search/image?apikey=jg9k&q=daum][IE][2012-06-10 08:03:54]"
        + "[404][http://apis.daum.net/search/aaaaapikey=dcj8&q=daum][IE][2012-06-10 08:03:55]"
        + "[200][http://apis.daum.net/search/news?apikey=23jf&q=daum][IE][2012-06-10 08:03:56]";

        //when
        Formatter mockFormatter = new MockFormatter();
        logParser.parse(logStr, mockFormatter);

        //then
        Assert.assertEquals(mockFormatter.doFormat(), "test");
    }
}
