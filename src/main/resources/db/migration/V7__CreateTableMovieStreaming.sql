CREATE TABLE movie_streaming (
   movie_id INTEGER NOT NULL,
   streaming_id INTEGER NOT NULL,

   PRIMARY KEY (movie_id, streaming_id),

   CONSTRAINT fk_movie_streaming_movie
   FOREIGN KEY (movie_id) REFERENCES movie(id),

   CONSTRAINT fk_movie_streaming_streaming
   FOREIGN KEY (streaming_id) REFERENCES streaming(streaming_id)
);