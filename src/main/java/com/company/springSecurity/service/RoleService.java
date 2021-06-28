package com.company.springSecurity.service;

import com.company.springSecurity.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role getRoleByID(long id);
}