package com.niceben.projectevent.business.event.service;

import com.niceben.projectevent.business.event.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author NiceBen
 * @since 2022-12-07
 */
public interface IAccountService extends IService<Account> {

    boolean saveAndEvent(Account account);

    boolean mySave(Account account) throws Exception;

}
