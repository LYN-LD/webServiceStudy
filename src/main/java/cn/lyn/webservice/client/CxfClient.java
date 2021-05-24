package cn.lyn.webservice.client;

import cn.lyn.webservice.serviceone.WebServiceInterface;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * @author LengYouNuan
 * @create 2021-05-24 下午2:13
 */

public class CxfClient {

    public static void main(String[] args) {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean=new JaxWsProxyFactoryBean();

        jaxWsProxyFactoryBean.setAddress("http://127.0.0.1:8080/soap/sayHello");

        jaxWsProxyFactoryBean.setServiceClass(WebServiceInterface.class);
        WebServiceInterface webServiceInterface = (WebServiceInterface) jaxWsProxyFactoryBean.create();
        String aha = webServiceInterface.sayHello("aha");
        System.out.println(aha);
    }
}
