package com.example.finalProject.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {
    private String resultCode;
    private String msg;
    private T data;
    private boolean fail;
    public boolean success;

    public static <T> CommonResponse<T> success(T data, String message) {
        return (CommonResponse<T>) CommonResponse.builder()
                .resultCode("S-1")
                .msg(message)
                .data(data)
                .fail(false)
                .success(true)
                .build();
    }
    public static <T> CommonResponse<T> success(List<T> data, String message) {
        return (CommonResponse<T>) CommonResponse.builder()
                .resultCode("S-1")
                .msg(message)
                .data(data)
                .fail(false)
                .success(true)
                .build();
    }

    public static CommonResponse fail(ErrorCode errorCode) {
        return CommonResponse.builder()
                .resultCode("F-1")
                .msg(errorCode.getErrorMsg())
                .fail(false)
                .success(true)
                .build();
    }
    public static CommonResponse fail(String errorCode) {
        return CommonResponse.builder()
                .resultCode("F-1")
                .msg(errorCode)
                .fail(false)
                .success(true)
                .build();
    }
}
