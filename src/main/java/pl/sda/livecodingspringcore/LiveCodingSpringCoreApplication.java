package pl.sda.livecodingspringcore;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.sda.livecodingspringcore.service.BlogPostService;

@SpringBootApplication
@Slf4j  //private static final Logger log = org.slf4j.LoggerFactory.getLogger(LiveCodingSpringCoreApplication.class);
//zamiast 'sout' = log.info lub
public class LiveCodingSpringCoreApplication {

    public static void main(String[] args) {
        // SpringApplication.run(LiveCodingSpringCoreApplication.class, args);      //zad 2 - pierwszy sposób=cała metoda main


        ConfigurableApplicationContext applicationContext = SpringApplication.run(LiveCodingSpringCoreApplication.class, args); //zad 3
        BlogPostService blogPostService = applicationContext.getBean(BlogPostService.class);    //wyciągamy beana BlogPostService, zamiast new.....


//        BlogPostService blogPostService = new BlogPostService(new BlogPostRepository());

//        blogPostService.save(new BlogPost(1, "tytuł pierwszy", "content pierwszy"));
//        blogPostService.save(new BlogPost(2, "tytuł drugi", "content drugi"));
//
//        log.info("BlogPost o id 2: " + blogPostService.findById(2));
    }

}
