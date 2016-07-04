package com.personal.jooq.skeleton.daos;

import com.personal.jooq.skeleton.pojos.PAuthor;

/**
 * Created by minhpham on 6/5/16.
 */
public interface AuthorDao {
    PAuthor fetchOneById(int id);
}
