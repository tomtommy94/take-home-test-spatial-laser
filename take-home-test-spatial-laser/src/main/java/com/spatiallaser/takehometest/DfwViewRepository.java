package com.spatiallaser.takehometest;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tommy Chiu
 */
// tag::code[]
public interface DfwViewRepository extends JpaRepository<DfwView, String> { // <1>

}
// end::code[]
