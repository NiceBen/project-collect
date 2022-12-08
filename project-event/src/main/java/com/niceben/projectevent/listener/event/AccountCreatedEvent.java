package com.niceben.projectevent.listener.event;

import com.niceben.projectevent.business.event.entity.Account;
import lombok.Data;

@Data
public class AccountCreatedEvent {

    private Account account;

    public AccountCreatedEvent(Account account) {
        this.account = account;
    }
}
