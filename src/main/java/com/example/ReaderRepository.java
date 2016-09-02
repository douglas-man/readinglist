package com.example;


import org.springframework.data.jpa.repository.JpaRepository;

//import java.io.Reader;

/**
 * Created by dman on 8/30/16.
 */
public interface ReaderRepository extends JpaRepository<Reader, String> {
}
