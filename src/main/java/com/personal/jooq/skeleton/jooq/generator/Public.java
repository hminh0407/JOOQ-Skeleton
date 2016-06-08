/**
 * This class is generated by jOOQ
 */
package com.personal.jooq.skeleton.jooq.generator;


import com.personal.jooq.skeleton.jooq.generator.tables.Author;
import com.personal.jooq.skeleton.jooq.generator.tables.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = -484637274;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.author</code>.
     */
    public final Author AUTHOR = com.personal.jooq.skeleton.jooq.generator.tables.Author.AUTHOR;

    /**
     * The table <code>public.book</code>.
     */
    public final Book BOOK = com.personal.jooq.skeleton.jooq.generator.tables.Book.BOOK;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Author.AUTHOR,
            Book.BOOK);
    }
}
