package pl.sda.livecodingspringcore;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlogPostConfiguration {

    public ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        // objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL); //przykład zastosowania ObjectMappera
        return objectMapper;
    }
}
