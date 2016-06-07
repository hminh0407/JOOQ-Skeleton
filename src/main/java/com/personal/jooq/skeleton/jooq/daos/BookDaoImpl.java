package com.personal.jooq.skeleton.jooq.daos;

import com.personal.jooq.skeleton.daos.BookDao;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        for (int i = 0; i < 2; i++)
            dslContext.insertInto(BOOK)
                    .set(BOOK.ID, id)
                    .set(BOOK.AUTHOR_ID, authorId)
                    .set(BOOK.TITLE, title)
                    .execute();
    }
}
