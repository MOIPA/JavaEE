package com.tr.util;

public class ResponseFactory<T> {
    public static final int CODE_OK=0;

    private ResponseFactory() {}

    public static <T>Response<T> OkResponse(Object obj) {
        return new Response(0,obj);
    }

}
