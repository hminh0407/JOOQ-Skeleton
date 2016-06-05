/**
 * This class is generated by jOOQ
 */
package com.personal.jooq.skeleton.jooq.generator.tables;


import com.personal.jooq.skeleton.jooq.generator.Keys;
import com.personal.jooq.skeleton.jooq.generator.Public;
import com.personal.jooq.skeleton.jooq.generator.tables.records.AuthorRecord;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
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
public class Author extends TableImpl<AuthorRecord> {

    private static final long serialVersionUID = -1027160810;

    /**
     * The reference instance of <code>public.author</code>
     */
    public static final Author AUTHOR = new Author();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AuthorRecord> getRecordType() {
        return AuthorRecord.class;
    }

    /**
     * The column <code>public.author.id</code>.
     */
    public final TableField<AuthorRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.author.first_name</code>.
     */
    public final TableField<AuthorRecord, String> FIRST_NAME = createField("first_name", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

    /**
     * The column <code>public.author.last_name</code>.
     */
    public final TableField<AuthorRecord, String> LAST_NAME = createField("last_name", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>public.author.date_of_birth</code>.
     */
    public final TableField<AuthorRecord, Date> DATE_OF_BIRTH = createField("date_of_birth", org.jooq.impl.SQLDataType.DATE, this, "");

    /**
     * The column <code>public.author.year_of_birth</code>.
     */
    public final TableField<AuthorRecord, Integer> YEAR_OF_BIRTH = createField("year_of_birth", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.author.address</code>.
     */
    public final TableField<AuthorRecord, String> ADDRESS = createField("address", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

    /**
     * Create a <code>public.author</code> table reference
     */
    public Author() {
        this("author", null);
    }

    /**
     * Create an aliased <code>public.author</code> table reference
     */
    public Author(String alias) {
        this(alias, AUTHOR);
    }

    private Author(String alias, Table<AuthorRecord> aliased) {
        this(alias, aliased, null);
    }

    private Author(String alias, Table<AuthorRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<AuthorRecord> getPrimaryKey() {
        return Keys.PK_T_AUTHOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<AuthorRecord>> getKeys() {
        return Arrays.<UniqueKey<AuthorRecord>>asList(Keys.PK_T_AUTHOR);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Author as(String alias) {
        return new Author(alias, this);
    }

    /**
     * Rename this table
     */
    public Author rename(String name) {
        return new Author(name, null);
    }
}
