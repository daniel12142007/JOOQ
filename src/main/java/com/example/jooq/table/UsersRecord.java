package com.example.jooq.table;

import org.jooq.impl.UpdatableRecordImpl;


public class UsersRecord extends UpdatableRecordImpl<UsersRecord> {

    public UsersRecord() {
        super(Users.USERS);
    }
}