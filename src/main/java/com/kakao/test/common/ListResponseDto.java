package com.kakao.test.common;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ListResponseDto<T> extends CommonResponseDto {
    private List<T> list;
}
