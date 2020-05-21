package lg.cn;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableDubbo
@MapperScan(basePackages = {"lg.cn.whmwms.mapper"})
@SpringBootApplication
public class WhmWmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhmWmsApplication.class, args);
    }

}
