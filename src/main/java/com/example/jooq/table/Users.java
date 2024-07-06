package com.example.jooq.table;

import org.jooq.TableField;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

public class Users extends TableImpl<UsersRecord> {
    public static final Users USERS = new Users();
    public final TableField<UsersRecord, Long> ID = createField("id", SQLDataType.BIGINT, this);
    public final TableField<UsersRecord, String> USERNAME = createField("username", org.jooq.impl.SQLDataType.VARCHAR, this);
    public final TableField<UsersRecord, String> EMAIL = createField("email", org.jooq.impl.SQLDataType.VARCHAR, this);
    public final TableField<UsersRecord, Short> AGE = createField("age", SQLDataType.SMALLINT, this);

    public Users() {
        super("users");
    }
}