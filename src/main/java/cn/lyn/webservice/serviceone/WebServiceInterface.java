package cn.lyn.webservice.serviceone;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * webService服务端接口
 * @author LengYouNuan
 * @create 2021-05-23 下午5:47
 */
@WebService
public interface WebServiceInterface {

    @WebMethod
    public String sayHello(String name);
}
