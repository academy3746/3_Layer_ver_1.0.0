package com.sparta.server_run.service;

// Auto Import

import com.sparta.server_run.domain.Person;
import com.sparta.server_run.domain.PersonRepository;
import com.sparta.server_run.domain.PersonRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service // Hey, Java! This page is Service Scope.
@RequiredArgsConstructor // lombok 기능을 활용하여 기본생성자 자동생성

public class PersonService {

    private final PersonRepository personRepository;
    // @RequiredArgsConstructor make it possible

    @Transactional // Hey, Java! there is SQL Query Request on this page.
    public Long update(Long id, PersonRequestDto requestDto) {
        Person per = personRepository.findById(id).orElseThrow(
                // SELECT ID FROM PERSONS
                // PERSONS 테이블에 해당 ID가 존재하지 않을 시 예외처리 기능 구현
                () -> new IllegalArgumentException("해당 테이블이 존재하지 않습니다!")
        );
        per.update(requestDto);
        return per.getId();
    }

}
