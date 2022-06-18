package com.sparta.server_run.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    // This page is Interface not a class
    // PersonRepository is abstract class
    // PersonRepository (child) inherit JAVA JpaRepository<> (parent)
}
