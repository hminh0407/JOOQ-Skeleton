package com.personal.jooq.skeleton.utils;

import org.joda.time.DateTime;
import org.jooq.Converter;

import java.sql.Timestamp;

/**
 * Created by minhpham on 6/4/16.
 */
public class TimestampConverter implements Converter<Timestamp, DateTime> {

    @Override
    public DateTime from(Timestamp timestamp) {
        return timestamp == null ? null : new DateTime(timestamp);
    }

    @Override
    public Timestamp to(DateTime dateTime) {
        return dateTime == null ? null : new Timestamp(dateTime.getMillis());
    }

    @Override
    public Class<Timestamp> fromType() {
        return Timestamp.class;
    }

    @Override
    public Class<DateTime> toType() {
        return DateTime.class;
    }
}
