package spring011;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"spring011"}) //@component 라고 선언된 클래스를 찾아서 
public class MemberContext {

}
