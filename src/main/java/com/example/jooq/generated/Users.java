package com.example.jooq.generated;

import io.r2dbc.spi.Parameter;
import org.jooq.TableField;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

public class Users extends TableImpl<UsersRecord> {
    public static final Users USERS = new Users();

    public final TableField<UsersRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER, this, "");
    public final TableField<UsersRecord, String> USERNAME = createField("username", org.jooq.impl.SQLDataType.VARCHAR, this, "");
    public final TableField<UsersRecord, String> EMAIL = createField("email", org.jooq.impl.SQLDataType.VARCHAR, this, "");
    public final TableField<UsersRecord, Integer> AGE = createField("age", SQLDataType.INTEGER, this, "");

    public Users() {
        super("users");
    }
}