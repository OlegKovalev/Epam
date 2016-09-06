package wsd;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
// Remote procedure call
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloService {
    @WebMethod
    public String sayHello(String name);
}