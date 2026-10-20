
CREATE TABLE streaming_category (
                                    streaming_id INTEGER NOT NULL,
                                    category_id INTEGER NOT NULL,

                                    CONSTRAINT pk_streaming_category
                                        PRIMARY KEY (streaming_id, category_id),

                                    CONSTRAINT fk_streaming_category_streaming
                                        FOREIGN KEY (streaming_id)
                                            REFERENCES streaming(streaming_id),

                                    CONSTRAINT fk_streaming_category_category
                                        FOREIGN KEY (category_id)
                                            REFERENCES category(category_id)
);

CREATE TABLE streaming_movie (
                                 streaming_id INTEGER NOT NULL,
                                 movie_id INTEGER NOT NULL,

                                 CONSTRAINT pk_streaming_movie
                                     PRIMARY KEY (streaming_id, movie_id),

                                 CONSTRAINT fk_streaming_movie_streaming
                                     FOREIGN KEY (streaming_id)
                                         REFERENCES streaming(streaming_id),

                                 CONSTRAINT fk_streaming_movie_movie
                                     FOREIGN KEY (movie_id)
                                         REFERENCES movie(id)
);
