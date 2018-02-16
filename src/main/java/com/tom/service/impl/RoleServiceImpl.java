package com.tom.service.impl;

import com.tom.model.Role;
import com.tom.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = {Exception.class})
public class RoleServiceImpl extends BasicServiceImpl<Role> implements RoleService {

}
