package com.example.jooq.table;

import org.jooq.TableField;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

public class Friends extends TableImpl<FriendsRecord> {
    public static final Friends FRIENDS = new Friends();

    public final TableField<FriendsRecord, Long> USER_ONE = createField("user_one", SQLDataType.BIGINT, this);
    public final TableField<FriendsRecord, Long> USER_TWO = createField("user_two", SQLDataType.BIGINT, this);

    public Friends() {
        super("friends");
    }
}