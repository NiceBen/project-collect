package com.niceben.projectevent.listener;

import com.niceben.projectevent.business.event.entity.Account;
import com.niceben.projectevent.business.event.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import com.niceben.projectevent.listener.event.AccountCreatedEvent;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * 账号监听，处理账号创建成功的后续逻辑
 */
@Slf4j
@Component
public class AccountListener {

    @Autowired
    private IAccountService iAccountService;

    /**
     * 1. 发送邮件、短信
     */
    @EventListener
    public void processAccountCreatedEvent1(AccountCreatedEvent event) {
        Account account = event.getAccount();
        Account account1 = new Account();
        BeanUtils.copyProperties(account, account1);

        // TODO
        System.out.println(Thread.currentThread().getName() + "======"
                + "processAccountCreatedEvent1() 被调用！" + "======"
                + "Account=[" + account.toString() + "]");

        account1.setId(account.getId() + 10L);
        account1.setName(account.getName() + "one");
        iAccountService.save(account1);

    }

    /**
     * 2. 添加积分等，@Order(100) 用来设定执行顺序
     */
    @EventListener
    @Order(100)
    public void processAccountCreatedEvent2(AccountCreatedEvent event) throws Exception {
        Account account = event.getAccount();
        // TODO
        System.out.println(Thread.currentThread().getName() + "======"
                + "processAccountCreatedEvent2() 被调用！" + "======"
                + "Account=[" + account.toString() + "]");
    }

    /**
     * 3. 创建 lucene 索引等，@Async 用来标记为异步线程池中执行
     */
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
//    @EventListener
    @Async
    public void processAccountCreatedEvent3(AccountCreatedEvent event) throws Exception {
        Account account = event.getAccount();
        Account account1 = new Account();
        BeanUtils.copyProperties(account, account1);

        account1.setId(account.getId() + 20L);
        account1.setName(account.getName() + "two");
        iAccountService.save(account1);


        System.out.println("================");






        Account account2 = new Account();
        BeanUtils.copyProperties(account, account2);

        account2.setId(account.getId() + 30L);
        account2.setName(account.getName() + "three");

        iAccountService.mySave(account2);
        // TODO
        System.out.println(Thread.currentThread().getName() + "======"
                + "processAccountCreatedEvent3() 被调用！" + "======"
                + "Account=[" + account.toString() + "]");

        throw new RuntimeException("listener异常");
    }
}
