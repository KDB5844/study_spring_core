package hello.core.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class BeanScopeTest {


    @Scope("prototype")
    @Component
    static class HelloBean{}

}
