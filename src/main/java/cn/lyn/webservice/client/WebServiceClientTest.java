package cn.lyn.webservice.client;

import cn.lyn.webservice.wsdl.WebServiceImpl;
import cn.lyn.webservice.wsdl.WebServiceImplService;

/**
 * @author LengYouNuan
 * @create 2021-05-23 下午7:52
 */
public class WebServiceClientTest {

    public static void main(String[] args) {
        WebServiceImplService factory=new WebServiceImplService();
        WebServiceImpl client = factory.getWebServiceImplPort();
        String dev = client.sayHello("dev");
        System.out.println(dev);
    }
}
