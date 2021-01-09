package pl.sda.livecodingspringcore.repository;

import org.springframework.stereotype.Component;
import pl.sda.livecodingspringcore.model.BlogPost;

import java.util.ArrayList;
import java.util.List;

@Component  //zad 3 - Spring wie że musi utworzyć instancję takiej klasy
public class BlogPostRepository {
    private List<BlogPost> blogPosts = new ArrayList<>();   //udaje bazę danych

    public List<BlogPost> findAll() {

        return blogPosts;
    }

    public void save(BlogPost blogPost) {
        blogPosts.add(blogPost);
    }
}
