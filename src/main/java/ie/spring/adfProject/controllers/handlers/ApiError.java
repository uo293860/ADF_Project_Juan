package ie.spring.adfProject.controllers.handlers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class ApiError {
        private LocalDateTime timestamp;
        private String message;
        private int status;
    }
