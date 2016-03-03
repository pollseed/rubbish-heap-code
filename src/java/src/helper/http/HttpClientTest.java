package validate_code.validate_code;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.httpclient.HttpException;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import wrapper.http.HttpClientHelper;
import wrapper.http.HttpClientHelper.Parameter;
import wrapper.http.HttpClientHelper.Response;

public class HttpClientTest extends TestCase {
    private static final String URI = "https://www.google.co.jp/?";
    private static final String QUERY = "q=アサガオ";

    @Test
    public void test_api_level_3() throws HttpException, IOException {
        final Response res = HttpClientHelper.get3Level(new Parameter(URI, QUERY));
        assertThat(res.code, is(200));
        assertThat(res.body, notNullValue());
    }

    @Test
    public void test_api_level_4() throws ClientProtocolException, IOException {
        assertThat(EntityUtils.toString(HttpClientHelper.get4Level(
                new Parameter(
                        URI,
                        QUERY,
                        new ArrayList<Header>() {
                            {
                                new BasicHeader("Accept-Charset", "utf-8");
                            }
                        }))),
                notNullValue());
    }
}
