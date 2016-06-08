package com.personal.jooq.skeleton.jooq_daos;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.generator.ValueGenerators;
import com.ninja_squad.dbsetup.operation.Operation;
import com.personal.jooq.skeleton.config.ApplicationConfig;
import com.personal.jooq.skeleton.daos.BookDao;
import com.personal.jooq.skeleton.pojos.PBook;
import org.assertj.core.api.Assertions;
import org.jooq.DSLContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import java.util.List;

import static com.personal.jooq.skeleton.jooq.generator.Tables.BOOK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by minhpham on 6/5/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class BookDaoImplTest {
    @Autowired
    BookDao bookDao;

    @Autowired
    DataSource dataSource;

    @Autowired
    DSLContext dsl;

    private static final Operation DELETE_ALL = Operations.deleteAllFrom(BOOK.getName());

    private static final Operation DEFAULT_INSERT = Operations.insertInto(BOOK.getName())
            .withGeneratedValue(BOOK.ID.getName(), ValueGenerators.sequence().startingAt(1))
            .withGeneratedValue(BOOK.AUTHOR_ID.getName(), ValueGenerators.sequence().startingAt(1))
            .withGeneratedValue(BOOK.TITLE.getName(), ValueGenerators.stringSequence(BOOK.TITLE.getName()).startingAt(1))
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
    // Test Spring Transaction with JOOQ Config
    public void testCreate() {
        boolean rollback = false;

        try {
            bookDao.create(5, 1, "Book 5");
            Assert.fail();
        } catch (DataAccessException ignore) {
            rollback = true;
        }

        assertEquals(5, dsl.fetchCount(BOOK));
        assertTrue(rollback);
    }

    @Test
    public void testFetchManyByAuthorId() {
        List<PBook> books = bookDao.fetchManyByAuthorId(3);
        Assertions.assertThat(books).hasSize(1);
    }
}
