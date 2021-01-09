package pl.sda.livecodingspringcore.model;

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
}
