package pl.sda.livecodingspringcore;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sda.livecodingspringcore.model.BlogPost;
import pl.sda.livecodingspringcore.service.BlogPostService;
import pl.sda.livecodingspringcore.service.JsonSerializer;

@Component  //commandlinerrunner - zamiast kodu w klasie main
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) //tego nie trzeba pisać-domyślnie
@Slf4j
public class CommandLinePrinter implements CommandLineRunner {

    private BlogPostService blogPostService;
    private JsonSerializer jsonSerializer;
    private String greeting;

    public CommandLinePrinter(BlogPostService blogPostService,
                              JsonSerializer jsonSerializer,
                              @Value("${blog.post.greeting}") String greeting) {
        this.blogPostService = blogPostService;
        this.jsonSerializer = jsonSerializer;
        this.greeting = greeting;
    }

    @Override
    public void run(String... args) throws Exception {
        blogPostService.save(new BlogPost(1, "tytuł pierwszy", "zawartość pierwsza"));
        blogPostService.save(new BlogPost(2, "      tytuł         drugi          ", "bomba -zawartość druga"));
        blogPostService.save(new BlogPost(3, "   jakiś trzeci tytuł posta    ", "trzecia zawartość posta"));    //zad 7

        log.info(greeting);
        log.info("BlogPost o id 1: " + jsonSerializer.serializeBlogPost(blogPostService.findById(1)));
        log.info("BlogPost o id 2: " + jsonSerializer.serializeBlogPost(blogPostService.findById(2)));
        log.info("BlogPost o id 3: " + jsonSerializer.serializeBlogPost(blogPostService.findById(3)));  //zad 7

    }
}
