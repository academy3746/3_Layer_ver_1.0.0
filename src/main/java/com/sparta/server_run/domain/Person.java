package com.sparta.server_run.domain;

// Auto Import

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter // Generate getter automatically using Lombok
@Setter // Generate setter automatically using Lombok
@RequiredArgsConstructor // Lombok 기능을 사용하여 비어있는 생성자 자동생성
@Entity // Hey, Java! there is table on this page.

public class Person {

    @Id // This is Primary Key
    @GeneratedValue(strategy = GenerationType.AUTO) // Generate Table ID automatically.
    private Long id;
    // Table No.

    @Column(nullable = false) // This column must have value!
    private String name;
    // 이름

    @Column(nullable = false) // This column must have value!
    private String sex;
    // 성별

    @Column(nullable = false) // This column must have value!
    private int age;
    // 나이

    @Column(nullable = false) // This column must have value!
    private String job;
    // 직업

    @Column(nullable = false) // This column must have value!
    private String addr;
    // 주소

    @Column(nullable = false) // This column must have value!
    private String hobby;
    // 취미

    public Person(Long id, String name, String sex, int age,
                  String job, String addr, String hobby) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.job = job;
        this.addr = addr;
        this.hobby = hobby;
    }

    public Person(PersonRequestDto requestDto) {
        this.id = requestDto.getId();
        this.name = requestDto.getName();
        this.sex = requestDto.getSex();
        this.age = requestDto.getAge();
        this.job = requestDto.getJob();
        this.addr = requestDto.getAddr();
        this.hobby = requestDto.getHobby();
    }

    public void update(PersonRequestDto requestDto) {
        this.id = requestDto.getId();
        this.name = requestDto.getName();
        this.sex = requestDto.getSex();
        this.age = requestDto.getAge();
        this.job = requestDto.getJob();
        this.addr = requestDto.getAddr();
        this.hobby = requestDto.getHobby();
    }

}
