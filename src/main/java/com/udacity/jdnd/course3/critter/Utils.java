package com.udacity.jdnd.course3.critter;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Configuration;

import com.udacity.jdnd.course3.critter.pet.PetDTO;
import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.user.CustomerDTO;
import com.udacity.jdnd.course3.critter.user.EmployeeDTO;
import com.udacity.jdnd.course3.critter.user.entity.Customer;
import com.udacity.jdnd.course3.critter.user.entity.Employee;

@Configuration
public class Utils {

    public static final String CUSTOMER = "Customer";
    public static final String EMPLOYEE = "Employee";
    public static final String PET = "Pet";
    public static final String SCHEDULE = "Schedule";

    public static final String CUSTOMER_ID = "customerId";

    public static final String EMPLOYEE_ID = "employeeId";

    public static final String PET_ID = "petId";

    public static final String SCHEDULE_ID = "scheduleId";

    public static final String CUSTOMER_TABLE = "customertable";

    public static final String EMPLOYEE_TABLE = "employeetable";

    public static final String PET_TABLE = "pettable";

    public static final String SCHEDULE_TABLE = "scheduletable";

    public static final String CUSTOMER_PETS = "pets";

    public static final String CUSTOMER_SCHEDULES = "schedules";

    public static final String EMPLOYEE_SCHEDULES = "schedules";

    public static final String PET_OWNER = "owner";

    public EmployeeDTO convertEmployeetoEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employee, employeeDTO);
        System.out.println("EmployeeDTO: " + employeeDTO);
        System.out.println("Employee: " + employee);
        return employeeDTO;
    }

    public Employee convertEmployeeDTOtoEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);

        return employee;
    }

    public CustomerDTO convertCustomertoCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);
        return customerDTO;
    }

    public Customer convertCustomerDTOtoCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        return customer;
    }

    public Pet convertPetDTOtoPet(PetDTO petDTO) {
        Pet pet = new Pet();
        BeanUtils.copyProperties(petDTO, pet);
        return pet;
    }

    public PetDTO convertPetToPetDTO(Pet pet) {
        PetDTO petDTO = new PetDTO();
        BeanUtils.copyProperties(pet, petDTO);
        petDTO.setOwnerId(pet.getOwner().getId());
        return petDTO;
    }
}
