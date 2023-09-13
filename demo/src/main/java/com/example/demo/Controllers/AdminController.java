package com.example.demo.Controllers;/*package com.example.demo.Controllers;

import com.example.demo.Collection.Admin;
import com.example.demo.Logic.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admins")
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping
    public List<Admin> fetchAllAdmins(){
        return adminService.getAllAdmins();}

    @GetMapping("/admin{employeeID}")
    public Admin getAdmin(@PathVariable String employeeID) {
        return adminService.getAdmin(employeeID);}

    @PostMapping
    public void addAdmin(@RequestBody Admin admin){
        adminService.addAdmin(admin);}

    @DeleteMapping("/{employeeID}")
    public void deleteAdmin(@PathVariable String employeeID){
        adminService.deleteAdmin(employeeID);}

   }


*/
