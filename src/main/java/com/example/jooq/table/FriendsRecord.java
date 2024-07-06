package com.example.jooq.table;

import org.jooq.impl.UpdatableRecordImpl;

public class FriendsRecord extends UpdatableRecordImpl<FriendsRecord> {
    public FriendsRecord() {
        super(Friends.FRIENDS);
    }
}
