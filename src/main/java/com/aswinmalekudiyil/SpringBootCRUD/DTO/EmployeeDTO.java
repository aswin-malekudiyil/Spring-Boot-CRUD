package com.aswinmalekudiyil.SpringBootCRUD.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class EmployeeDTO {
    private int employeeId;
    private String employeeName;
    private String email;
    private int departmentId;
    private String departmentName;
    private String departmentCode;
}
