package com.nbclass;

import com.nbclass.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;
/**
 * @version V1.0
 * @date 2020年8月11日
 * @author hkx
 */
@SpringBootApplication
@MapperScan(basePackages = "com.nbclass.mapper")
public class SpringbootApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
