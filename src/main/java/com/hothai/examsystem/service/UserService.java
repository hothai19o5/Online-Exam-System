package com.hothai.examsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hothai.examsystem.domain.dto.RegisterDTO;
import com.hothai.examsystem.domain.entity.Role;
import com.hothai.examsystem.domain.entity.User;
import com.hothai.examsystem.repository.RoleRepository;
import com.hothai.examsystem.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    public User getUserById(int id) {
        return this.userRepository.findOneById(id);
    }

    public User getUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public User getUserByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    public List<User> getAllUserByRole(String roleName) {
        return this.userRepository.findAllByRoleName(roleName);
    }

    public Role getRoleByName(String name) {
        return this.roleRepository.findByName(name);
    }

    public User handleSaveUser(User user) {
        return this.userRepository.save(user);
    }

    public void handleDeleteUser(int id) {
        this.userRepository.deleteById(id);
    }

    public boolean existsByEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }

    public User registerDTOtoUser(RegisterDTO registerUser){
        User user = new User();
        user.setUsername(registerUser.getFirstName() + " " + registerUser.getLastName());
        user.setEmail(registerUser.getEmail());
        user.setPassword(registerUser.getPassword());
        user.setAvatar("img_avatar.jpg");
        return user;
    }
}
