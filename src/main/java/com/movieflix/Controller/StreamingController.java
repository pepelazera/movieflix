package com.movieflix.Controller;

import com.movieflix.Entity.Streaming;
import com.movieflix.Mapper.StreamingMapper;
import com.movieflix.Request.StreamingRequest;
import com.movieflix.Response.StreamingResponse;
import com.movieflix.Service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/streaming")
@RequiredArgsConstructor
public class StreamingController {

    private final StreamingService streamingService;

    @GetMapping
    public ResponseEntity<List<StreamingResponse>> searchAllStreaming() {
        List<StreamingResponse> streaming = streamingService.searchStreaming()
                .stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList();

        return ResponseEntity.ok(streaming);
    }

    @GetMapping("{id}")
    public ResponseEntity<StreamingResponse> searchStreamingById(@PathVariable Long id) {
        return streamingService.searchStreamingById(id)
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<StreamingResponse> saveStreaming(@RequestBody StreamingRequest streamingRequest) {
        Streaming newStreaming = StreamingMapper.toStreaming(streamingRequest);
        Streaming savedStreaming = streamingService.saveStreaming(newStreaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(savedStreaming));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStreamingById(@PathVariable Long id) {

        if (streamingService.searchStreamingById(id).isPresent()) {
            streamingService.deleteStreamingById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
