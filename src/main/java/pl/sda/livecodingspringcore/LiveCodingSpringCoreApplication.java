package pl.sda.livecodingspringcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@Slf4j  //private static final Logger log = org.slf4j.LoggerFactory.getLogger(LiveCodingSpringCoreApplication.class);
//zamiast 'sout' = log.info lub
public class LiveCodingSpringCoreApplication {

    public static void main(String[] args) {
        // SpringApplication.run(LiveCodingSpringCoreApplication.class, args);      //zad 2 - pierwszy sposób=cała metoda main

//spr
        ConfigurableApplicationContext applicationContext = SpringApplication.run(LiveCodingSpringCoreApplication.class, args); //zad 3 - drugi sposób
//        BlogPostService blogPostService = applicationContext.getBean(BlogPostService.class);    //wyciągamy beana BlogPostService, zamiast new.....


//        BlogPostService blogPostService = new BlogPostService(new BlogPostRepository());

//        blogPostService.save(new BlogPost(1, "tytuł pierwszy", "content pierwszy"));  //trzeci sposób - patrz klasa Command.... przeniesiono kod
//        blogPostService.save(new BlogPost(2, "tytuł drugi", "content drugi"));
//
//        log.info("BlogPost o id 2: " + blogPostService.findById(2));
    }

}
