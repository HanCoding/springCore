package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolisy;
import hello.core.member.Grade;
import hello.core.member.Member;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.cassandra.DataCassandraTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;


public class AllBeanTest {

    @Test
    public void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member memberA = new Member(1L, "memberA", Grade.VIP);
    }

    @RequiredArgsConstructor
    static class DiscountService {
        private final Map<String, DiscountPolisy> polisyMap;
        private final List<DiscountPolisy> polisies;
    }
}
