package com.example;

import org.springframework.data.jpa.repository.JpaRepository;



/**
 * Created by dman on 8/27/16.
 */
public interface ReaderRepository
        extends JpaRepository<Reader, String> {
}
