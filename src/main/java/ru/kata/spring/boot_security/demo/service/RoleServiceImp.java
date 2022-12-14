package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleServiceImp implements RoleService {


    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    private final RoleRepository roleRepository;

    @Override
    public List<Role> allRoles() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role getRole(int id) {
        Role role = null;
        Optional<Role> optional = roleRepository.findById(id);
        if (optional.isPresent()) {
            role = optional.get();
        }
        return role;
    }

    @Override
    @Transactional
    public void deleteRole(int id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Optional<Role> findByRole(String role) {
        Optional<Role> roleOptional = roleRepository.findByRole(role);
        return roleOptional;
    }

    @Override
    public Optional<Role> getRoles(String role) {
        return roleRepository.findByRole(role);
    }
}
