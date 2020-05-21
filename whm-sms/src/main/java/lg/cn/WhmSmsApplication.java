package lg.cn;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@MapperScan(basePackages = {"lg.cn.whmsms.mapper"})
@SpringBootApplication
public class WhmSmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhmSmsApplication.class, args);
    }

}
