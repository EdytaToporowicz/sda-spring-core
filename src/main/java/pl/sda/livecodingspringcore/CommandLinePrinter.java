package pl.sda.livecodingspringcore;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.sda.livecodingspringcore.model.BlogPost;
import pl.sda.livecodingspringcore.service.BlogPostService;
import pl.sda.livecodingspringcore.service.JsonSerializer;

@Component  //commandlinerrunner - zamiast kodu w klasie main
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) //tego nie trzeba pisać-domyślnie
@Slf4j
public class CommandLinePrinter implements CommandLineRunner {

    private BlogPostService blogPostService;
    private JsonSerializer jsonSerializer;

    public CommandLinePrinter(BlogPostService blogPostService, JsonSerializer jsonSerializer) {
        this.blogPostService = blogPostService;
        this.jsonSerializer = jsonSerializer;
    }

    @Override
    public void run(String... args) throws Exception {
        blogPostService.save(new BlogPost(1, "tytuł pierwszy", "zawartość pierwsza"));
        blogPostService.save(new BlogPost(2, "      tytuł         drugi          ", "zawartość druga"));
        blogPostService.save(new BlogPost(3, "   jakiś trzeci tytuł posta    ", "trzecia zawartość posta"));    //zad 7


        log.info("BlogPost o id 1: " + jsonSerializer.serializeBlogPost(blogPostService.findById(1)));
        log.info("BlogPost o id 3: " + jsonSerializer.serializeBlogPost(blogPostService.findById(3)));  //zad 7

    }
}
