/**
 * This class is generated by jOOQ
 */
package com.personal.jooq.skeleton.jooq.generator;


import com.personal.jooq.skeleton.jooq.generator.tables.Author;
import com.personal.jooq.skeleton.jooq.generator.tables.records.AuthorRecord;

import javax.annotation.Generated;

import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships between tables of the <code>public</code> 
 * schema
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AuthorRecord> PK_T_AUTHOR = UniqueKeys0.PK_T_AUTHOR;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<AuthorRecord> PK_T_AUTHOR = createUniqueKey(Author.AUTHOR, "pk_t_author", Author.AUTHOR.ID);
    }
}