package pl.sda.livecodingspringcore.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ContentAnalyser {

    private List<String> forbiddenWords;

    public ContentAnalyser(@Value("${blog.post.forbidden}") String[] forbiddenWords) {
        this.forbiddenWords = Arrays.asList(forbiddenWords);
    }

    public boolean analyse(String content) {
        String[] split = content.split("\\s+");
        List<String> contentAsWords = Arrays.asList(split);
        if (!contentAsWords.isEmpty()) {
            return forbiddenWords.stream().anyMatch(forbidddenWord -> contentAsWords.stream().map(s -> s.toLowerCase()).anyMatch(word -> word.equalsIgnoreCase(forbidddenWord)));
        }
        return false;
    }
}
