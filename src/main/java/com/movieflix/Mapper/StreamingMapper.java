package com.movieflix.Mapper;

import com.movieflix.Entity.Streaming;
import com.movieflix.Request.StreamingRequest;
import com.movieflix.Response.StreamingResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest streamingRequest) {
        return Streaming.
                builder()
                .streamingName(streamingRequest.name())
                .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming) {
        return StreamingResponse
                .builder()
                .id(streaming.getStreamingId())
                .name(streaming.getStreamingName())
                .build();
    }
}
