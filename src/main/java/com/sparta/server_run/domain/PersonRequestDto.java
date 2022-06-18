package com.sparta.server_run.domain;

// Auto Import

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor // Lombok 기능을 사용하여 비어있는 타입의 생성자 자동생성
@Getter // Generate setter automatically using Lombok lib
@Setter // Generate setter automatically using Lombok lib

public class PersonRequestDto {
    // DTO: Data Transfer Object
    // Final is necessarily required data.

    private final Long id;
    private final String name;
    private final String sex;
    private final int age;
    private final String job;
    private final String addr;
    private final String hobby;

}
