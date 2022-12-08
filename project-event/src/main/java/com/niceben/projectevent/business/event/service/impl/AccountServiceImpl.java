package com.niceben.projectevent.business.event.service.impl;

import com.niceben.projectevent.business.event.entity.Account;
import com.niceben.projectevent.business.event.mapper.AccountMapper;
import com.niceben.projectevent.business.event.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niceben.projectevent.listener.event.AccountCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author NiceBen
 * @since 2022-12-07
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

    /**
     * 注入 ApplicationEventPublisher
     */
    @Autowired
    private ApplicationEventPublisher publisher;

    /**
     * 使用同步事件，主事件和监听器，任意出现问题都会造成回滚操作
     * 使用Asyc异步事件，监听器需要使用 @ListenerEvent，带有事件的监听器，需要配置为@TransactionalListenerEvent
     * @param account
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveAndEvent(Account account) {

        // 插入数据
        this.baseMapper.insert(account);

        System.out.println(Thread.currentThread().getName() + "======" + "AccountEventServiceImpl#sendEvent 被调用！");
        // 发布事件
        publisher.publishEvent(new AccountCreatedEvent(account));

        if (true) {
            throw new RuntimeException();
        }

        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean mySave(Account account) throws Exception {
        this.baseMapper.insert(account);
        if (true) {
            throw new Exception("mySave内部异常");
        }
        return false;
    }
}
