package dev.ansh.movies;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "Movies") //take care of this, otherwise db will give issues
public class Movie {
    @Id
    private ObjectId id;

    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backDrops;

    public Movie() {
    }

    public ObjectId getId() {
        return this.id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getImdbId() {
        return this.imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTrailerLink() {
        return this.trailerLink;
    }

    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }

    public String getPoster() {
        return this.poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public List<String> getGenres() {
        return this.genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getBackDrops() {
        return this.backDrops;
    }

    public void setBackDrops(List<String> backDrops) {
        this.backDrops = backDrops;
    }

    public List<review> getReviewIds() {
        return this.reviewIds;
    }

    public void setReviewIds(List<review> reviewIds) {
        this.reviewIds = reviewIds;
    }

    public Movie(ObjectId id, String imdbId, String title, String releaseDate, String trailerLink, String poster, List<String> genres, List<String> backDrops, List<review> reviewIds) {
        this.id = id;
        this.imdbId = imdbId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.trailerLink = trailerLink;
        this.poster = poster;
        this.genres = genres;
        this.backDrops = backDrops;
        this.reviewIds = reviewIds;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", imdbId='" + getImdbId() + "'" +
            ", title='" + getTitle() + "'" +
            ", releaseDate='" + getReleaseDate() + "'" +
            ", trailerLink='" + getTrailerLink() + "'" +
            ", poster='" + getPoster() + "'" +
            ", genres='" + getGenres() + "'" +
            ", backDrops='" + getBackDrops() + "'" +
            ", reviewIds='" + getReviewIds() + "'" +
            "}";
    }




    @DocumentReference
    private List<review> reviewIds;
}
