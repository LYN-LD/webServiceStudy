package cn.lyn.webservice.client;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.Charset;

/**
 * http方式调用webservice接口
 * @author LengYouNuan
 * @create 2021-05-24 下午4:30
 */
public class HttpClientMethod {

    private static final Logger logger = LogManager.getLogger(HttpClientMethod.class);

    public static void main(String[] args) {

        String  name="aaa";

        //soap 参数
        String s = "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:ws='http://serviceone.webservice.lyn.cn/'>\n" +
                "    <soapenv:Header/>\n" +
                "    <soapenv:Body>\n" +
                "        <ws:sayHello>\n" +
                "            <arg0>" + name + "</arg0>\n" +
                "        </ws:sayHello>\n" +
                "    </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        String soapXml= s;


        //获取http构建器对象
        HttpClientBuilder builder = HttpClientBuilder.create();
        CloseableHttpClient httpClient = builder.build();

        //封装httppost请求对象
        HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/soap/sayHello");
        httpPost.setConfig(RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(30000).build());
        try {
            httpPost.setHeader("Content-Type", "text/xml;charset=UTF-8");
            httpPost.setHeader("SOAPAction", "");
            StringEntity data = new StringEntity(soapXml,
                    Charset.forName("UTF-8"));
            httpPost.setEntity(data);  //设置post请求参数实体

            //执行http请求
            CloseableHttpResponse response = httpClient
                    .execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                // 打印响应内容
                String retStr = EntityUtils.toString(httpEntity, "UTF-8");
                logger.info("==================================================================================");
                logger.info("==================================================================================");
                logger.info("response:=========》" + retStr);
            }
            // 释放资源
            httpClient.close();
        } catch (Exception e) {
            logger.error("exception in doPostSoap1_1", e);
        }
    }
}
