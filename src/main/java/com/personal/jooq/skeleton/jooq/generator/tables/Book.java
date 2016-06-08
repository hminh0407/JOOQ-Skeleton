/**
 * This class is generated by jOOQ
 */
package com.personal.jooq.skeleton.jooq.generator.tables;


import com.personal.jooq.skeleton.jooq.generator.Keys;
import com.personal.jooq.skeleton.jooq.generator.Public;
import com.personal.jooq.skeleton.jooq.generator.tables.records.BookRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


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
public class Book extends TableImpl<BookRecord> {

    private static final long serialVersionUID = -902075963;

    /**
     * The reference instance of <code>public.book</code>
     */
    public static final Book BOOK = new Book();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BookRecord> getRecordType() {
        return BookRecord.class;
    }

    /**
     * The column <code>public.book.id</code>.
     */
    public final TableField<BookRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.book.author_id</code>.
     */
    public final TableField<BookRecord, Integer> AUTHOR_ID = createField("author_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.book.title</code>.
     */
    public final TableField<BookRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR.length(400).nullable(false), this, "");

    /**
     * Create a <code>public.book</code> table reference
     */
    public Book() {
        this("book", null);
    }

    /**
     * Create an aliased <code>public.book</code> table reference
     */
    public Book(String alias) {
        this(alias, BOOK);
    }

    private Book(String alias, Table<BookRecord> aliased) {
        this(alias, aliased, null);
    }

    private Book(String alias, Table<BookRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<BookRecord> getPrimaryKey() {
        return Keys.PK_T_BOOK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<BookRecord>> getKeys() {
        return Arrays.<UniqueKey<BookRecord>>asList(Keys.PK_T_BOOK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<BookRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<BookRecord, ?>>asList(Keys.BOOK__FK_T_BOOK_AUTHOR_ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book as(String alias) {
        return new Book(alias, this);
    }

    /**
     * Rename this table
     */
    public Book rename(String name) {
        return new Book(name, null);
    }
}
