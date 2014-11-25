package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
//xml없이 빈을 설정할 때 사용하는 어노테이션
@Configuration
@ComponentScan
public class Application {
	//빈으로 등록되는 메서드
    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
              return "Hello World!";
            }
        };
    }

  public static void main(String[] args) {
      ApplicationContext context = 
          new AnnotationConfigApplicationContext(Application.class);
      MessagePrinter printer = context.getBean(MessagePrinter.class);
      printer.printMessage();
  }
}
