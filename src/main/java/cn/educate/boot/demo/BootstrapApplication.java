package cn.educate.boot.demo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 * 添加mybatis的扫描路径
 */
@SpringBootApplication
@Slf4j
@MapperScan(basePackages = "cn.educate.boot.demo.dao")
public class BootstrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapApplication.class, args);
        log.info(">>>>>>>>start success<<<<<<<");
    }

}
