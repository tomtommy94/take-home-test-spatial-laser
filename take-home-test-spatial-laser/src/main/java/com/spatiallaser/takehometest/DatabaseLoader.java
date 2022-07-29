package com.spatiallaser.takehometest;

import java.sql.Clob;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Tommy Chiu
 */
// tag::code[]
@Component // <1>
public class DatabaseLoader implements CommandLineRunner { // <2>

	private final DfwDemoRepository dfwDemoRepository;
	private final DfwViewRepository dfwViewrepository;

	@Autowired // <3>
	public DatabaseLoader(DfwDemoRepository dfwDemoRepository, DfwViewRepository dfwViewrepository) {
		this.dfwDemoRepository = dfwDemoRepository;
		this.dfwViewrepository = dfwViewrepository;
	}

	@Override
	public void run(String... strings) throws Exception { // <4>
		List<DfwView> dfwList = dfwViewrepository.findAll();
	}
}
// end::code[]
