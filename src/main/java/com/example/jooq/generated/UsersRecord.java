package com.example.jooq.generated;

import com.example.jooq.generated.Users;
import org.jooq.impl.UpdatableRecordImpl;


public class UsersRecord extends UpdatableRecordImpl<UsersRecord> {

    private static final long serialVersionUID = -763644399;

    public UsersRecord() {
        super(Users.USERS);
    }

    public Integer getId() {
        return (Integer) get(0);
    }

    public void setId(Integer value) {
        set(0, value);
    }

    public String getUsername() {
        return (String) get(1);
    }

    public void setUsername(String value) {
        set(1, value);
    }

    public String getEmail() {
        return (String) get(2);
    }

    public void setEmail(String value) {
        set(2, value);
    }

    public Integer getAge() {
        return (Integer) get(3);
    }

    public void setAge(Integer value) {
        set(3, value);
    }
}
