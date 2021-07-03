package com.kakao.test.common;


import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter @Setter
public class CommonResponseDto<T> {

    private boolean success = true;
    private ErrorDto error = null;
}
