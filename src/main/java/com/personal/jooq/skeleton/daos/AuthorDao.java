package com.personal.jooq.skeleton.daos;

import com.personal.jooq.skeleton.pojos.PAuthor;

/**
 * Created by minhpham on 6/5/16.
 */
public interface AuthorDao {
    public PAuthor fetchOneById(int id);
}
