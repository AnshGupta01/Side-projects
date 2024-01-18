package dev.ansh.movies;

import org.bson.types.ObjectId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class review {
    private ObjectId id;
    private String body;

    public review(String body) {
        this.body = body;
    }
}
