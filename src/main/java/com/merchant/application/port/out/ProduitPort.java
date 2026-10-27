package com.example.demo.application.port.out;

import java.util.List;

import com.example.demo.domain.model.Employe;

public interface EmployePort {
    List<Employe> findByIds(List<Integer> ids);
}