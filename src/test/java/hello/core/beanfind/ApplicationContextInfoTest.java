package hello.core.beanfind;

import hello.core.Order.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDeifinitionNames = ac.getBeanDefinitionNames();
        for (String beanDeifinitionName : beanDeifinitionNames) {
            Object bean = ac.getBean(beanDeifinitionName);
            System.out.println("name = " + beanDeifinitionName + "object = "+ bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDeifinitionNames = ac.getBeanDefinitionNames();
        for (String beanDeifinitionName : beanDeifinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDeifinitionName);

            //ROLE_APPLICATION 직접 등록한 애플리케이션 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDeifinitionName);
                System.out.println("name = " + beanDeifinitionName + " object = " + bean);
            }
        }//for
    }

}
