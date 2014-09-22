package de.appdynamics.ace.metric.query.rest;


import de.appdynamics.ace.metric.query.MetricQueryParser;
import org.apache.http.HttpEntity;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by stefan.marx on 27.08.14.
 */
public class ControllerRestAccess {
    public String getPassword() {
        return _password;
    }

    public String getHost() {
        return _host;
    }

    public String getPort() {
        return _port;
    }

    public boolean isSsl() {
        return _ssl;
    }

    public String getUser() {
        return _user;
    }

    public String getAccount() {
        return _account;
    }

    private final String _password;
    private final String _host;
    private final String _port;
    private final boolean _ssl;
    private final String _user;
    private final String _account;

    public ControllerRestAccess(String host, String port, boolean ssl, String username, String password, String account) {
        _host = host;
        _port = port;
        _ssl = ssl;
        _user = username;
        _password = password;
        _account = account;


    }

    public MetricResults queryMetrics(String application, String path, long startMilis, long stopMillis, boolean aggregated) throws RestException {

        MetricResults result = new MetricResults();

        URI uri = null;
        try {

            uri = new URIBuilder()
                    .setScheme(isSsl() ? "https" : "http")
                    .setHost(getHost())
                    .setPort(Integer.parseInt(getPort()))
                    .setPath("/controller/rest/applications/" + application + "/metric-data")
                    .setParameter("time-range-type", "BETWEEN_TIMES")
                    .setParameter("start-time",""+startMilis)
                    .setParameter("end-time",""+stopMillis)
                    .setParameter("rollup", aggregated ? "true" : "false")
                    .setParameter("output","JSON")
                    .setParameter("metric-path",path)
                    .build();

            InputStream is = executeHttpCall(uri);



            ObjectMapper mapper = new ObjectMapper();

            MetricData[] data = mapper.readValue(is, MetricData[].class);

            result.addMetricData(data);




        } catch (URISyntaxException e) {
           throw new RestException("Problem while creating access URL",e);
        } catch (IOException e) {
            throw new RestException("Problem while accessing URL "+uri,e);
        }


        return result;
    }

    private java.io.InputStream executeHttpCall(URI uri) throws IOException {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();


        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                AuthScope.ANY,
                new UsernamePasswordCredentials(getUser()+"@"+getAccount(),getPassword()));

// Add AuthCache to the execution context
        HttpClientContext context = HttpClientContext.create();
        context.setCredentialsProvider(credsProvider);
        HttpGet httpget = new HttpGet(uri);
        CloseableHttpResponse result = httpclient.execute(httpget, context);
        return result.getEntity().getContent();
    }
}
