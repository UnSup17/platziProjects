package com.example.springboot.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.springboot.entity.User;
import com.example.springboot.repository.interfaces.IUserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    private final Log LOG = LogFactory.getLog(this.getClass());
    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveTransactional(List<User> users) {
        users.stream()
                .peek(user -> LOG.info("Usuario insertado :" + user))
                .forEach(userRepository::save);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User save(User newUser) {
        return userRepository.save(newUser);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(Long id, User newUser) {
        return userRepository.findById(id).map(user -> {
            user.setEmail(newUser.getEmail());
            user.setBirthDate(newUser.getBirthDate());
            user.setName(newUser.getName());
            return userRepository.save(user);
        }).orElse(null);
    }

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
