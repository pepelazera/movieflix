CREATE TABLE category_movie (
                                category_id INTEGER NOT NULL,
                                movie_id INTEGER NOT NULL,

                                CONSTRAINT pk_category_movie
                                    PRIMARY KEY (category_id, movie_id),

                                CONSTRAINT fk_category_movie_category
                                    FOREIGN KEY (category_id)
                                        REFERENCES category(category_id),

                                CONSTRAINT fk_category_movie_movie
                                    FOREIGN KEY (movie_id)
                                        REFERENCES movie(id)
);

CREATE TABLE category_streaming (
                                    category_id INTEGER NOT NULL,
                                    streaming_id INTEGER NOT NULL,

                                    CONSTRAINT pk_category_streaming
                                        PRIMARY KEY (category_id, streaming_id),

                                    CONSTRAINT fk_category_streaming_category
                                        FOREIGN KEY (category_id)
                                            REFERENCES category(category_id),

                                    CONSTRAINT fk_category_streaming_streaming
                                        FOREIGN KEY (streaming_id)
                                            REFERENCES streaming(streaming_id)
);