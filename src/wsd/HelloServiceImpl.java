package wsd;

import javax.jws.WebService;

@WebService(endpointInterface = "src.wsd.HelloService")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name + "!!!";
    }
}
