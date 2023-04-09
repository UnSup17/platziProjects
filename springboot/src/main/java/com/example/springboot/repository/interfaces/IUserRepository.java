package com.example.springboot.repository.interfaces;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springboot.dto.UserDTO;
import com.example.springboot.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Query("Select u from User u where u.name like %?1%")
    List<User> findAndSort(String name, Sort sort);

    List<User> findByNameContainingIgnoreCase(String name);

    @Query("SELECT new com.example.springboot.dto.UserDTO(u.id, u.name, u.birthDate) " +
            "FROM User u " +
            "WHERE u.birthDate=:prmFecha " +
            "AND u.email=:prmEmail")
    Optional<UserDTO> getAllByBirthDateAndEmail(@Param("prmFecha") LocalDate date, @Param("prmEmail") String email);
}
