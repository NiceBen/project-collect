package com.niceben.projectevent.business.event.controller;

import com.niceben.projectevent.business.event.entity.Account;
import com.niceben.projectevent.business.event.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author NiceBen
 * @since 2022-12-07
 */
@RestController
@RequestMapping("/event/account")
public class AccountController {

    @Autowired
    private IAccountService iAccountService;

    @GetMapping("/save")
    public String saveAndEvent() {
        Account account = new Account();
        account.setId(1L);
        account.setName("张三");
        boolean result = iAccountService.saveAndEvent(account);
        return result ? "success" : "fail";
    }

    @GetMapping("/mySave")
    public String mySave() throws Exception {
        Account account = new Account();
        account.setId(99L);
        account.setName("李四");
        boolean b = iAccountService.mySave(account);
        return b ? "success" : "fail";
    }
}
