package cn.lg;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo(scanBasePackages = {"cn.lg.whmoms.servicImpl"})
@MapperScan(basePackages = {"cn.lg.whmoms.mapper"})
@SpringBootApplication
public class WhmOmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhmOmsApplication.class, args);
    }

}
