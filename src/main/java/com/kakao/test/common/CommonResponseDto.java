package com.kakao.test.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class CommonResponseDto {
    /*
    public CommonResponseDto(){
        setTimestamp(new Timestamp(System.currentTimeMillis()));
    }

    @JsonFormat(timezone ="Asia/Seoul", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Timestamp timestamp;
    */

    private int status;

    private String message ="";

    private String param = "";

    private String error = "";
}
