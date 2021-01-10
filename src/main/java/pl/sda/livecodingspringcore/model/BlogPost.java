package pl.sda.livecodingspringcore.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   //wszystko konstr, getery i setery, equals, hash, string
@AllArgsConstructor //konstr z wszystkimi arg
@NoArgsConstructor  //konstr bezargument
public class BlogPost {
    private long id;
    private String title;
    private String content;
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss.SSS")
    private String created;

    public BlogPost(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
