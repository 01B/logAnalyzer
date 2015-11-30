package net.nopainnocode.log.utils.formatter;

import net.nopainnocode.log.utils.parser.LogParser;
import net.nopainnocode.log.utils.parser.Parser;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by no_pain_no_code on 2015. 11. 30..
 */
public class LogFormatterTest {

    private Parser logParser;
    private Formatter formatter;
    @Before
    public void setUp() throws Exception {
        logParser = new LogParser();
        formatter = new LogFormatter();
    }

    @Test
    public void test_1() throws Exception {

        // given
        String testStr =
        "[200][http://apis.daum.net/search/image?apikey=e3ea&q=daum][IE][2012-06-10 08:08:46]"
        + "[200][http://apis.daum.net/search/knowledge?apikey=fqwk&q=daum][IE][2012-06-10 08:08:47]"
        + "[200][http://apis.daum.net/search/image?apikey=tr8j&q=daum][IE][2012-06-10 08:08:48]"
        + "[200][http://apis.daum.net/search/vclip?apikey=fqwk&q=daum][IE][2012-06-10 08:08:49]"
        + "[200][http://apis.daum.net/search/news?apikey=jg9k&q=daum][IE][2012-06-10 08:08:50]"
        + "[200][http://apis.daum.net/search/vclip?apikey=tr8j&q=daum][IE][2012-06-10 08:08:51]"
        + "[200][http://apis.daum.net/search/news?apikey=dcj8&q=daum][IE][2012-06-10 08:08:52]"
        + "[200][http://apis.daum.net/search/image?apikey=23jf&q=daum][IE][2012-06-10 08:08:53]"
        + "[200][http://apis.daum.net/search/book?apikey=dcj8&q=daum][IE][2012-06-10 08:08:54]"
        + "[200][http://apis.daum.net/search/book?apikey=dcj8&q=daum][IE][2012-06-10 08:08:55]"
        + "[200][http://apis.daum.net/search/book?apikey=e3ea&q=daum][IE][2012-06-10 08:08:56]"
        + "[200][http://apis.daum.net/search/news?apikey=2jdc&q=daum][IE][2012-06-10 08:08:57]"
        + "[10][http://apis.daum.net/search/knowledge?q=daum][IE][2012-06-10 08:08:58]"
        + "[200][http://apis.daum.net/search/news?apikey=dcj8&q=daum][IE][2012-06-10 08:08:59]"
        + "[200][http://apis.daum.net/search/knowledge?apikey=jg9k&q=daum][IE][2012-06-10 08:09:00]"
        + "[200][http://apis.daum.net/search/book?apikey=2jdc&q=daum][IE][2012-06-10 08:09:01]"
        + "[200][http://apis.daum.net/search/blog?apikey=wejf&q=daum][IE][2012-06-10 08:09:02]"
        + "[200][http://apis.daum.net/search/blog?apikey=wejf&q=daum][IE][2012-06-10 08:09:03]"
        + "[200][http://apis.daum.net/search/blog?apikey=jg9k&q=daum][IE][2012-06-10 08:09:04]"
        + "[200][http://apis.daum.net/search/knowledge?apikey=e3ea&q=daum][IE][2012-06-10 08:09:05]"
        + "[200][http://apis.daum.net/search/image?apikey=fwji&q=daum][IE][2012-06-10 08:09:06]"
        + "[200][http://apis.daum.net/search/knowledge?apikey=jg9k&q=daum][IE][2012-06-10 08:09:07]"
        + "[200][http://apis.daum.net/search/image?apikey=anw1&q=daum][IE][2012-06-10 08:09:08]"
        + "[200][http://apis.daum.net/search/vclip?apikey=jg9k&q=daum][IE][2012-06-10 08:09:09]"
        + "[200][http://apis.daum.net/search/news?apikey=fqwk&q=daum][IE][2012-06-10 08:09:10]";

        //when
        logParser.parse(testStr, formatter);
        String formattingStr = formatter.doFormat();

        //then


    }
}
