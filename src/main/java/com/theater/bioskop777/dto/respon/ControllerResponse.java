package com.theater.bioskop777.dto.respon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ControllerResponse<T> {
    private String status;
    private String message;
    private T data;
}