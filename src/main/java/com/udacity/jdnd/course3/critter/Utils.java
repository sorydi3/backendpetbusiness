package com.udacity.jdnd.course3.critter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.udacity.jdnd.course3.critter.dayofweek.entity.Day;
import com.udacity.jdnd.course3.critter.dayofweek.service.DayService;
import com.udacity.jdnd.course3.critter.employeeskill.service.EmployeeSkillService;
import com.udacity.jdnd.course3.critter.pet.PetDTO;
import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.pet.service.PetService;
import com.udacity.jdnd.course3.critter.schedule.ScheduleDTO;
import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;
import com.udacity.jdnd.course3.critter.schedule.service.ScheduleService;
import com.udacity.jdnd.course3.critter.user.CustomerDTO;
import com.udacity.jdnd.course3.critter.user.EmployeeDTO;
import com.udacity.jdnd.course3.critter.user.entity.Customer;
import com.udacity.jdnd.course3.critter.user.entity.Employee;

@Configuration
public class Utils {

    @Autowired
    EmployeeSkillService employeeSkillService;

    @Autowired
    PetService petService;

    @Autowired
    ScheduleService schedule;

    @Autowired
    DayService dayService;

    @Autowired
    ScheduleService scheduleService;

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
        employeeDTO.setSkills(employeeSkillService.getEmployeeSkills(employee));

        schedule.getAllSchedulesByEmployee(employee).forEach(schedule -> {
            if (employeeDTO.getDaysAvailable() == null) {
                employeeDTO.initDaysAvailable();
                employeeDTO.getDaysAvailable().add(schedule.getDayOfWeek().getDayOfWeek());
            } else {
                employeeDTO.getDaysAvailable().add(schedule.getDayOfWeek().getDayOfWeek());
            }

        });
        return employeeDTO;
    }

    public Employee convertEmployeeDTOtoEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);

        return employee;
    }

    public CustomerDTO convertCustomertoCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        if (customer != null) {
            BeanUtils.copyProperties(customer, customerDTO);
            petService.getAllPetsByOwner(customer.getId()).forEach(pet -> customerDTO.getPetIds().add(pet.getId()));
            return customerDTO;
        } else {
            return null;
        }
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
        if (pet.getOwner() != null) {
            petDTO.setOwnerId(pet.getOwner().getId());
        }
        return petDTO;
    }

    public Schedule scheduleDTOtoSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();
        BeanUtils.copyProperties(scheduleDTO, schedule);
        return schedule;
    }

    public ScheduleDTO scheduleToScheduleDTO(Schedule schedule) {
        List<Long> employeeIds = new ArrayList<>();
        List<Long> petIds = new ArrayList<>();

        ScheduleDTO scheduleDTO = new ScheduleDTO();

        return scheduleDTO;
    }

    public ScheduleDTO covertScheduleToScheduleDTO(LocalDate date) {
        List<Long> employeeIds = new ArrayList<>();
        List<Long> petIds = new ArrayList<>();
        Day day = dayService.findByDayOfWeek(date.getDayOfWeek());
        schedule.getAllSchedulesByDay(day).forEach(schedule_aux -> {
            Employee employee = schedule_aux.getEmployee();

            /// System.out.println("employee: " + employee);
            employeeIds.add(employee.getId());
            petService.getAllPets().forEach(pet -> {

            });
            // Customer customer =
            // petService.getAllPetsByOwner(employee.getId()).forEach(pet ->
            // petIds.add(pet.getId()));

        });

        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setEmployeeIds(employeeIds);
        scheduleDTO.setPetIds(petIds);
        scheduleDTO.setDate(date);
        return scheduleDTO;
    }

    public List<ScheduleDTO> convertScheduleListToScheduleDTOList(Iterable<Schedule> schedules) {
        List<ScheduleDTO> scheduleDTOs = new ArrayList<>();
        schedules.forEach(schedule -> scheduleDTOs.add(scheduleToScheduleDTO(schedule)));
        return scheduleDTOs;
    }
}
