package wrapper.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public final class HttpClientHelper {
    public static final class Parameter {
        public String uri = "";
        public String query = "";
        public String charset = "UTF-8";
        public int connectTimeout = 300;
        public int socketTimeout = 300;
        public List<Header> headers = new ArrayList<Header>();

        public Parameter(
                final String uri,
                final String query,
                final String charset,
                final int connectTimeout,
                final int socketTimeout,
                final List<Header> headers) {
            this.uri = uri;
            this.query = query;
            this.charset = charset;
            this.connectTimeout = connectTimeout;
            this.socketTimeout = socketTimeout;
            this.headers = headers;
        }

        public Parameter(
                final String uri,
                final String query,
                final List<Header> headers) {
            this.uri = uri;
            this.query = query;
            this.headers = headers;
        }

        public Parameter(
                final String uri,
                final String query) {
            this.uri = uri;
            this.query = query;
        }
    }

    public static class Response {
        public int code;
        public String body;

        public Response(final int code, final String body) {
            this.code = code;
            this.body = body;
        }
    }

    public static final Response get3Level(final Parameter parameter) {
        try {
            final HttpMethod method = new GetMethod(getURI(parameter));
            new HttpClient().executeMethod(method);
            try (final BufferedReader br =
                    new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()))) {
                final StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                return new Response(method.getStatusCode(), sb.toString());
            }
        } catch (final IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static final String getURI(final Parameter p) throws UnsupportedEncodingException {
        return p.uri + URLEncoder.encode(p.query, p.charset);
    }

    public static final HttpEntity get4Level(final Parameter parameter) {
        try {
            return HttpClientBuilder
                    .create()
                    .setDefaultRequestConfig(RequestConfig
                            .custom()
                            .setConnectTimeout(parameter.connectTimeout)
                            .setSocketTimeout(parameter.socketTimeout)
                            .build())
                    .setDefaultHeaders(parameter.headers)
                    .build()
                    .execute(new HttpGet(getURI(parameter)))
                    .getEntity();
        } catch (final IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
