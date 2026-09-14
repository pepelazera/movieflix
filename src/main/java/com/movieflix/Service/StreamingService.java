package com.movieflix.Service;

import com.movieflix.Entity.Streaming;
import com.movieflix.Repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {

    private final StreamingRepository streamingRepository;

    public List<Streaming> searchStreaming() {
        return streamingRepository.findAll();
    }

    public Optional<Streaming> searchStreamingById(Long id) {
        return streamingRepository.findById(id);
    }

    public Streaming saveStreaming(Streaming streaming) {
        return streamingRepository.save(streaming);
    }

    public void deleteStreamingById(Long id) {
        streamingRepository.deleteById(id);
    }
}
