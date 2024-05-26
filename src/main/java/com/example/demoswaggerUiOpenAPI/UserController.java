package com.example.demoswaggerUiOpenAPI;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @Operation(summary = "Get list of users", responses = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
        @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
        @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")
    })
    @GetMapping("/api/users")
    public List<String> getUsers() {
        return Arrays.asList("John Doe", "Jane Doe");
    }

    @Operation(summary = "Get user by ID")
    @GetMapping("/api/users/{id}")
    public String getUserById(@PathVariable("id") String id) {
        return "User " + id;
    }
}
