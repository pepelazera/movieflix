package com.movieflix.Entity;

import jakarta.persistence.*;
import lombok.*;

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

}
