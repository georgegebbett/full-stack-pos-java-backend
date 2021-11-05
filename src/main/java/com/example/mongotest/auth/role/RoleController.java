package com.example.mongotest.auth.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    RoleRepository roleRepo;

    @RequestMapping(method = RequestMethod.GET)
    public List<Role> getAllRoles() {
        List<Role> allRoles = roleRepo.findAll();
        return allRoles;
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    Role createNewRole(@RequestBody Role roleData) {
        System.out.println(roleData);
        return roleRepo.insert(roleData);
    }

    @RequestMapping(value = "/{roleId}", method = RequestMethod.GET)
    Optional<Role> get(@PathVariable String roleId) {
        return roleRepo.findById(roleId);
    }
    @RequestMapping(value = "/{roleId}", method = RequestMethod.DELETE)
    String delete(@PathVariable String roleId) {
        if (roleRepo.findById(roleId).isPresent()) {
            roleRepo.deleteById(roleId);
            return "Successfully deleted";
        }
        return "No such role";
    }

}
