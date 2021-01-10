package pl.sda.livecodingspringcore;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sda.livecodingspringcore.model.BlogPost;
import pl.sda.livecodingspringcore.service.BlogPostService;

@Component  //commandlinerrunner - zamiast kodu w klasie main
@Slf4j
public class CommandLinePrinter implements CommandLineRunner {

    private final BlogPostService blogPostService;

    public CommandLinePrinter(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @Override
    public void run(String... args) throws Exception {
        blogPostService.save(new BlogPost(1, "tytuł pierwszy", "content pierwszy"));
        blogPostService.save(new BlogPost(2, "      tytuł         drugi          ", "content drugi"));

        log.info("BlogPost o id 2: " + blogPostService.findById(2));
    }
}
