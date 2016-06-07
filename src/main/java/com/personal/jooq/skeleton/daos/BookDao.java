package com.personal.jooq.skeleton.daos;

/**
 * Created by minhpham on 6/8/16.
 */
public interface BookDao {

    /**
     * Create a new book.
     * <p>
     * The implementation of this method has a bug, which causes this method to
     * fail and roll back the transaction.
     * This method is to test if Spring transaction is working probably with JOOQ config
     */
    void create(int id, int authorId, String title);
}
