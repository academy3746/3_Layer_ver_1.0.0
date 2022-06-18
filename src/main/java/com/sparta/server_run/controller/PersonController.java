package com.sparta.server_run.controller;

// Auto Import

import com.sparta.server_run.domain.Person;
import com.sparta.server_run.domain.PersonRepository;
import com.sparta.server_run.domain.PersonRequestDto;
import com.sparta.server_run.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // lombok lib 기능을 사용하여 기본생성자 자동생성
@RestController // Hey, Java! this page is optional REST Controller section.

public class PersonController {
    // Final is necessarily required data.
    private final PersonRepository personRepository;
    private final PersonService personService;

    @GetMapping("/api/persons")
    // READ
    public List<Person> getPersons() {
        return personRepository.findAll();
        // SELECT * FROM PERSONS;
    }

    @PostMapping("/api/persons")
    // CREATE
    public Person createPerson(@RequestBody PersonRequestDto requestDto) {
        // requestDto means Request Query.
        // PERSONS 테이블을 "생성"하기 위해서는 Person 클래스에서 선언한 변수들의 값이 요구된다.
        // 해당 데이터들을 load 하는 역활!

        Person person = new Person(requestDto);
        // Caution!: 저장되는 값은 requestDto 가 아니라 Person 이다.
        // 따라서 requestDto 의 데이터를 Person 에 저장해야 한다.
        // 초기화를 해주는 새로운 생성자 DIY!

        return personRepository.save(person);
        // JPA 기능을 활용하여 결과값을 DB에 저장하고, 값을 반환하는 역활
    }

    @PutMapping("/api/persons/{id}")
    // UPDATE
    // 특정 테이블만을 수정하기 위해 {id} 제한자를 둔다.
    public Long updatePerson(@PathVariable Long id, @RequestBody PersonRequestDto requestDto) {
        return personService.update(id, requestDto);
    }

    @DeleteMapping("/api/persons/{id}")
    // DELETE
    // 특정 테이블만을 삭제하기 위해 {id} 제한자를 둔다.
    public Long deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
        // Caution!: 비몽사몽에 *.deleteAll() 메서드를 insert 해주면 돌이킬 수 없는 대참사가 일어날 수 있으니 주의할 것!
        return id;
    }

}
