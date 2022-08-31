package com.spring.rediscurd.modal;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

	private static final long serialVersionUID = 1050131662637552112L;
	
	private Integer empId;
    private String empName;
    private Double empSalary;
}
