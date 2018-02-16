package com.tom.service.impl;

import com.tom.model.UserRole;
import com.tom.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = {Exception.class})
public class UserRoleServiceImpl extends BasicServiceImpl<UserRole> implements UserRoleService {

}
