package com.spatiallaser.takehometest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Tommy Chiu
 */
// tag::code[]
public interface DfwDemoRepository extends JpaRepository<DfwDemo, String> { // <1>
    @Query(nativeQuery = true)
    List<DfwDemoDto> findAllForDisp();
}
// end::code[]
