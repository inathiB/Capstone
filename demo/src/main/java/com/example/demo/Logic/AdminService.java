package com.example.demo.Logic;

import com.example.demo.Collection.Admin;
import com.example.demo.Repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdmin(String employeeID) {
        Optional<Admin> optionalAdmin = adminRepository.findAdminByEmployeeID(employeeID);
        return optionalAdmin.orElse(null);
    }

    public void addAdmin(Admin admin) {
        adminRepository.insert(admin);
    }

    public void deleteAdmin(String employeeID) {
        Optional<Admin> optionalAdmin = adminRepository.findAdminByEmployeeID(employeeID);
        adminRepository.deleteById(employeeID);
    }
}
