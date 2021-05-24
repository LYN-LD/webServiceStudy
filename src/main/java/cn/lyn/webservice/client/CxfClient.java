package cn.lyn.webservice.client;

import cn.lyn.webservice.interceptor.CxfInterceptor;
import cn.lyn.webservice.serviceone.WebServiceInterface;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.message.Message;

import java.util.List;

/**
 * @author LengYouNuan
 * @create 2021-05-24 下午2:13
 */

public class CxfClient {

    public static void main(String[] args) {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean=new JaxWsProxyFactoryBean();

        jaxWsProxyFactoryBean.setAddress("http://127.0.0.1:8080/soap/sayHello");

        jaxWsProxyFactoryBean.setServiceClass(WebServiceInterface.class);


        //客户端日志出拦截器
        List<Interceptor<? extends Message>> outFaultInterceptors = jaxWsProxyFactoryBean.getOutFaultInterceptors();
        outFaultInterceptors.add(new CxfInterceptor());

        //客户端日志入拦截器
        List<Interceptor<? extends Message>> inFaultInterceptors = jaxWsProxyFactoryBean.getInFaultInterceptors();
        inFaultInterceptors.add(new CxfInterceptor());


        WebServiceInterface webServiceInterface = (WebServiceInterface) jaxWsProxyFactoryBean.create();
        String aha = webServiceInterface.sayHello("aha");
        System.out.println(aha);
    }
}
