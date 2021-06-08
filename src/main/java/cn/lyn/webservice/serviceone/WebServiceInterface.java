package cn.lyn.webservice.serviceone;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * webService服务端接口
 * @author LengYouNuan
 * @create 2021-05-23 下午5:47
 */
@WebService
//@XmlType(name = "TypeName")
//@BindingType(value = SOAPBinding.SOAP12HTTP_MTOM_BINDING)
public interface WebServiceInterface {

    @WebMethod
    //WebResult注解指定返回值 不使用该注解可能导致获取不到返回值
    @WebResult(name="sayHelloResponse",targetNamespace = "http://serviceone.webservice.lyn.cn/")
    public String sayHello(@WebParam(name="name",targetNamespace = "http://serviceone.webservice.lyn.cn/")String name);
}
