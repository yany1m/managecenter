package com.runrong.managecenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.runrong.managecenter.config.DbConfig;
import com.runrong.managecenter.config.QyCreditConfig;
import com.runrong.managecenter.config.RSAConfig;
import com.runrong.managecenter.config.SecurityConfig;
import com.runrong.managecenter.config.ServerPortConfig;
import com.runrong.managecenter.config.StatementConfig;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableScheduling
public class ManageCenterApp extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {
	private static Logger logger = LoggerFactory.getLogger(ManageCenterApp.class);

    public static void main(String[] args) throws Throwable {
    	
    	ServerPortConfig.init();
        DbConfig.init();
        SecurityConfig.init();
        RSAConfig.init();
        StatementConfig.init();
        QyCreditConfig.init();
        logger.info("Config加载完毕~");
        SpringApplication.run(ManageCenterApp.class, args);
    }
    
    @Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {  
        return builder.sources(ManageCenterApp.class);  
    }  
  
    @Override  
    public void customize(ConfigurableEmbeddedServletContainer container) {  
        container.setPort(ServerPortConfig.serverPort);  
    }  
}
