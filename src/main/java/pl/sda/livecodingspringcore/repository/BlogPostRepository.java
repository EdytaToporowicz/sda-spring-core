package pl.sda.livecodingspringcore.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.sda.livecodingspringcore.decorator.StringDecorator;
import pl.sda.livecodingspringcore.model.BlogPost;

import java.util.ArrayList;
import java.util.List;

@Component  //zad 3 - Spring wie że musi utworzyć instancję takiej klasy
public class BlogPostRepository implements DataRepository<BlogPost> {

    private  List<BlogPost> blogPosts = new ArrayList<>();   //udaje bazę danych
    private  StringDecorator stringDecorator;

    public BlogPostRepository(@Qualifier("spaceRemovingDecorator") StringDecorator stringDecorator) {
        this.stringDecorator = stringDecorator;
    }

    public List<BlogPost> findAll() {

        return blogPosts;
    }

    public void save(BlogPost blogPost) {
        blogPost.setTitle(stringDecorator.decorate(blogPost.getTitle()));
        blogPosts.add(blogPost);
    }
}
