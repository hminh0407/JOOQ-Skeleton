package com.personal.jooq.skeleton.jooq.daos;

import com.personal.jooq.skeleton.daos.BookDao;
import com.personal.jooq.skeleton.jooq.generator.tables.records.BookRecord;
import com.personal.jooq.skeleton.pojos.PBook;
import org.jooq.DSLContext;
import org.jooq.ResultQuery;
import org.sfm.jdbc.JdbcMapper;
import org.sfm.jdbc.JdbcMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.personal.jooq.skeleton.jooq.generator.Tables.BOOK;

/**
 * Created by minhpham on 6/8/16.
 */
@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    DSLContext dslContext;

    @Override
    @Transactional
    public void create(int id, int authorId, String title) {
        // This method has a "bug". It creates the same book twice. The second insert
        // should lead to a constraint violation, which should roll back the whole transaction
        // This method is used to test Spring transaction with JOOQ configuration
        for (int i = 0; i < 2; i++)
            dslContext.insertInto(BOOK)
                    .set(BOOK.ID, id)
                    .set(BOOK.AUTHOR_ID, authorId)
                    .set(BOOK.TITLE, title)
                    .execute();
    }

    @Override
    public List<PBook> fetchManyByAuthorId(int authorId) {
        return dslContext.selectFrom(BOOK).where(BOOK.AUTHOR_ID.eq(authorId)).fetchInto(PBook.class);
    }

}
