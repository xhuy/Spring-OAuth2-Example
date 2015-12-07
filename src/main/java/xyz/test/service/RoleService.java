package xyz.test.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import xyz.test.model.RoleModel;
import xyz.test.pojo.Role;

public class RoleService {
    @Transactional
    public Role findByPrimaryKey(int id) {
	return RoleModel.findByPrimaryKey(id);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public int create(Role role) {
	return RoleModel.create(role);
    }

    @Transactional(readOnly = false)
    public void update(Role role) {
	RoleModel.update(role);
    }

    @Transactional(readOnly = false)
    public void delete(Role role) {
	RoleModel.delete(role);
    }
    
    public Set<ConstraintViolation<Role>> isValidForCreate(Role role){
	return RoleModel.isValidForCreate(role);
    }
    
    public Set<ConstraintViolation<Role>> isValidForUpdate(Role role){
	return RoleModel.isValidForUpdate(role);
    }

}
