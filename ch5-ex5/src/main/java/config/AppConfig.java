package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import services.CommentService;

@Configuration
public class AppConfig {
    @Bean
    @Scope("prototype")
    public CommentService commentService() {
        return new CommentService();
    }
}
