package com.niceben.projectmpa.business.apple.service.impl;

import com.niceben.projectmpa.business.apple.entity.Person;
import com.niceben.projectmpa.business.apple.mapper.PersonMapper;
import com.niceben.projectmpa.business.apple.service.IPersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author NiceBen
 * @since 2022-07-01
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

}
