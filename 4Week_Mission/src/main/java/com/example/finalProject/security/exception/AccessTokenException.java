package com.example.finalProject.security.exception;

import com.example.finalProject.common.response.CommonResponse;
import com.google.gson.Gson;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class AccessTokenException extends RuntimeException {

    TOKEN_ERROR token_error;

    public enum TOKEN_ERROR {
        UNACCEPT(401,"토큰이 없거나 토큰의 길이가 잘못 되었습니다"),
        BADTYPE(401, "토큰타입이 Bearer가 아닙니다"),
        MALFORM(403, "Malformed Token"),
        BADSIGN(403, "토큰 Signature 오류"),
        EXPIRED(403, "토큰 유효기간이 만료 되었습니다");

        private int status;
        private String msg;

        TOKEN_ERROR(int status, String msg){
            this.status = status;
            this.msg = msg;
        }

        public int getStatus() {
            return this.status;
        }

        public String getMsg() {
            return this.msg;
        }
    }

    public AccessTokenException(TOKEN_ERROR error){
        super(error.name());
        this.token_error = error;
    }

    public void sendResponseError(HttpServletResponse response){

        response.setStatus(token_error.getStatus());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");

        Gson gson = new Gson();

        String responseStr = gson.toJson(CommonResponse.fail(token_error.getMsg()));

        try {
            response.getWriter().println(responseStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
