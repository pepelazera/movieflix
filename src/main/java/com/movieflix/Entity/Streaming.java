package com.movieflix.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Entity
@Table(name = "streaming")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Streaming {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "streaming_seq_generator")

    @SequenceGenerator(name = "streaming_seq_generator",
            sequenceName = "streaming_seq",
            schema = "public",
            allocationSize = 1)
    private Long streamingId;

    @Column(name = "streaming_name")
    private String streamingName;

    @ManyToMany
    @JoinTable(
            name = "streaming_category",
            joinColumns = @JoinColumn(name = "streamingId"),
            inverseJoinColumns = @JoinColumn(name = "categoryId")
    )
    private List<Category> categories;

    @ManyToMany
    @JoinTable(
            name = "streaming_movie",
            joinColumns = @JoinColumn(name = "streamingId"),
            inverseJoinColumns = @JoinColumn(name = "movieId")
    )
    private List<Movie> movies;

}
