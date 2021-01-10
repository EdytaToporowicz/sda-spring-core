package pl.sda.livecodingspringcore.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.sda.livecodingspringcore.decorator.StringDecorator;
import pl.sda.livecodingspringcore.model.BlogPost;
import pl.sda.livecodingspringcore.repository.DataRepository;

@Component  //zad 3 - Spring wie że musi utworzyć instancję takiej klasy
public class BlogPostService {

    // @Autowired  //wstrzykiwanie przez POLE
    // private BlogPostRepository blogPostRepository;
    private  DataRepository<BlogPost> dataRepository;  //zad 4
    private  StringDecorator stringDecorator;  //zad 5


    public BlogPostService(final DataRepository dataRepository,@Qualifier("uppercaseDecorator") final StringDecorator stringDecorator) { //zad 4 //zad 5
        this.dataRepository = dataRepository;
        this.stringDecorator = stringDecorator;
    }
    // @Autowired  //zad 3 -może być adnotacja, ale nie musi = wstrzykiwanie przez KONSTRUKTOR-PREFEROWANE
    //    public BlogPostService(BlogPostRepository blogPostRepository) {
    //        this.blogPostRepository = blogPostRepository;
    //    }


    public void save(BlogPost blogPost) {

        dataRepository.save(blogPost);
    }

    public BlogPost findById(long id) {
        return dataRepository.findAll().stream()
                .filter(blogPost -> blogPost.getId() == id)
                .map(blogPost -> {          //zad 5
                     blogPost.setTitle(stringDecorator.decorate(blogPost.getTitle()));
                     return blogPost;
                })
                .findFirst()
                .orElse(new BlogPost(-1, "default post", "default content"));
    }


    // @Autowired   // wstrzykiwanie przez SETTER
//    public void setBlogPostRepository(BlogPostRepository blogPostRepository) {
//        this.dataRepository = blogPostRepository;
//    }
}
