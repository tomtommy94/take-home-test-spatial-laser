package com.spatiallaser.takehometest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Tommy Chiu
 */
// tag::code[]
public interface DfwViewInputRepository extends JpaRepository<DfwViewInput, String> { // <1>

}
// end::code[]
