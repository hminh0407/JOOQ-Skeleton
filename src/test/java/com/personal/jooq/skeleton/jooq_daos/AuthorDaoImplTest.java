package com.personal.jooq.skeleton.jooq_daos;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.generator.ValueGenerators;
import com.ninja_squad.dbsetup.operation.Operation;
import com.personal.jooq.skeleton.daos.AuthorDao;
import com.personal.jooq.skeleton.jooq.generator.tables.Author;
import com.personal.jooq.skeleton.pojos.PAuthor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by minhpham on 6/5/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/spring-config.xml"})
@ActiveProfiles(profiles = "it-test")
public class AuthorDaoImplTest {
    @Resource
    AuthorDao authorDao;

    @Resource
    DataSource dataSource;

    private static final Author AUTHOR_TABLE = Author.AUTHOR;

    private static final Operation DELETE_ALL = Operations.deleteAllFrom(AUTHOR_TABLE.getName());

    private static final Operation DEFAULT_INSERT = Operations.insertInto(AUTHOR_TABLE.getName())
            .withGeneratedValue(AUTHOR_TABLE.ID.getName(), ValueGenerators.sequence().startingAt(1))
            .withGeneratedValue(AUTHOR_TABLE.FIRST_NAME.getName(), ValueGenerators.stringSequence(AUTHOR_TABLE.FIRST_NAME.getName()).startingAt(1))
            .withGeneratedValue(AUTHOR_TABLE.LAST_NAME.getName(), ValueGenerators.stringSequence(AUTHOR_TABLE.LAST_NAME.getName()).startingAt(1))
            .withGeneratedValue(AUTHOR_TABLE.DATE_OF_BIRTH.getName(), ValueGenerators.dateSequence().startingAt("2016-01-01"))
            .withDefaultValue(AUTHOR_TABLE.YEAR_OF_BIRTH.getName(), 1970)
            .withGeneratedValue(AUTHOR_TABLE.ADDRESS.getName(), ValueGenerators.stringSequence(AUTHOR_TABLE.ADDRESS.getName()).startingAt(1))
            .repeatingValues().times(5)
            .build();

    // the tracker is static because JUnit uses a separate Test instance for every test method.
    private static DbSetupTracker dbSetupTracker = new DbSetupTracker();

    @Before
    public void setup() {
        Operation operation = Operations.sequenceOf(DELETE_ALL, DEFAULT_INSERT);
        DbSetup dbSetup = new DbSetup(new DataSourceDestination(dataSource), operation);
        // use the tracker to launch the DbSetup.
        // It's unnecessary to launch the setup after every test case. We can skip the READ-ONLY operation like SELECT
        dbSetupTracker.launchIfNecessary(dbSetup);
    }

    @Test
    public void testFetchOneById() {
        // READ-ONLY operation, does not need to cleanup db
        dbSetupTracker.skipNextLaunch();
        int test_id = 3;
        PAuthor author = authorDao.fetchOneById(3);
        assertThat(author.getId()).isEqualTo(test_id);
    }
}
