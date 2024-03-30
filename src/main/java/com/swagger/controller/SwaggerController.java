package com.swagger.controller;

import com.swagger.dto.Employee;
import com.swagger.dto.EmployeeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SwaggerController {

    @GetMapping("/employee")
    @Operation(tags = "Employee", description = "Retrieve employees")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK",
    content = @Content(schema = @Schema(implementation = Employee.class)))})
    public ResponseEntity<?> getEmployee(
            @Parameter(required = true)
            @RequestParam int id){
        return ResponseEntity.status(HttpStatus.OK).body(new Employee());
    }

    @PostMapping("/employee")
    @Operation(tags = "Employee", description = "Add a new Employee")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Created",
            content = @Content(schema = @Schema(implementation = EmployeeResponse.class)))})
    public ResponseEntity<?> createEmployee(
            @Parameter(required = true)
            @RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.CREATED).body(new EmployeeResponse(201,
                "Created Successfully"));
    }

    @PutMapping("/employee")
    @Operation(tags = "Employee", description = "Update an existing employee")
    @ApiResponses(value = {@ApiResponse(responseCode = "202", description = "Updated",
            content = @Content(schema = @Schema(implementation = EmployeeResponse.class)))})
    public ResponseEntity<?> updateEmployee(
            @Parameter(required = true)
            @RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new EmployeeResponse(202,
                "Updated Successfully"));
    }

    @DeleteMapping("/employee")
    @Operation(tags = "Employee", description = "Remove an existing employee")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = EmployeeResponse.class)))})
    public ResponseEntity<?> removeEmployee(
            @Parameter(required = true)
            @RequestParam int id){
        return ResponseEntity.status(HttpStatus.CREATED).body(new EmployeeResponse(200,
                "Deleted Successfully"));
    }

}