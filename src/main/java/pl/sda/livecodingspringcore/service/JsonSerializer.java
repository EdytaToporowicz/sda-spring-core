package pl.sda.livecodingspringcore.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.sda.livecodingspringcore.model.BlogPost;

@Component
@Slf4j
public class JsonSerializer {
    private ObjectMapper objectMapper;

    public JsonSerializer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String serializeBlogPost(BlogPost blogPost) {
        try {
            return objectMapper.writeValueAsString(blogPost);
        } catch (JsonProcessingException e) {
            log.info("cannot serialize blog post", e);
        }
        return "";
    }
}
