package com.websitesi.websitesi.Response;

import lombok.Data;

@Data
public class Response {
    String message;
    Boolean isSuccess;
    Object data;
    public Response(String message, Boolean isSuccess) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public Response() {
    }


}
