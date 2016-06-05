package com.personal.jooq.skeleton.jooq.daos;

import com.personal.jooq.skeleton.daos.AuthorDao;
import com.personal.jooq.skeleton.jooq.generator.tables.Author;
import com.personal.jooq.skeleton.pojos.PAuthor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by minhpham on 6/5/16.
 */
@Repository
public class AuthorDaoImpl implements AuthorDao {

    @Resource
    DSLContext dslContext;

    @Override
    public PAuthor fetchOneById(int id) {
        Author authorTable = Author.AUTHOR;
        PAuthor PAuthor = dslContext.select(authorTable.ID, authorTable.FIRST_NAME, authorTable.LAST_NAME)
                .from(authorTable)
                .where(authorTable.ID.equal(id))
                .fetchOneInto(PAuthor.class);
        return PAuthor;
    }
}
