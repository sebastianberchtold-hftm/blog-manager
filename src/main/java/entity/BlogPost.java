package entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@MongoEntity(collection = "blogs")
public class BlogPost extends PanacheMongoEntity {
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private List<Comment> comments;
}