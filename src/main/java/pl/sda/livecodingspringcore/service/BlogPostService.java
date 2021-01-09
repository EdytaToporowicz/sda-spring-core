package pl.sda.livecodingspringcore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.livecodingspringcore.model.BlogPost;
import pl.sda.livecodingspringcore.repository.BlogPostRepository;

@Component  //zad 3 - Spring wie że musi utworzyć instancję takiej klasy
public class BlogPostService {

    // @Autowired  //wstrzykiwanie przez POLE
    private BlogPostRepository blogPostRepository;


    @Autowired  //zad 3 -może być adnotacja, ale nie musi = wstrzykiwanie przez KONSTRUKTOR-PREFEROWANE
    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    public void save(BlogPost blogPost) {
        blogPostRepository.save(blogPost);
    }

    public BlogPost findById(long id) {
        return blogPostRepository.findAll().stream()
                .filter(blogPost -> blogPost.getId() == id)
                .findFirst()
                .orElse(new BlogPost(-1, "default post", "default content"));
    }


    // @Autowired   // wstrzykiwanie przez SETTER
    public void setBlogPostRepository(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }
}
