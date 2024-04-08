package com.kshrd.thymeleaf_testing03.repository;

import com.kshrd.thymeleaf_testing03.model.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeRepository {
    @Select("SELECT * FROM employee_tb")
    @Results(
            id = "empMapper",
            value = {
                    @Result(property = "firstName", column = "first_name"),
                    @Result(property = "lastName", column = "last_name")
            }
    )
    List<Employee> findAll();

    @Select("SELECT  * FROM employee_tb WHERE id = #{empId}")
    @ResultMap("empMapper")
    Employee findById(Integer empId);

    @Delete("DELETE FROM employee_tb WHERE id = #{empId}")
    void remove(Integer empId);

    @Insert("INSERT INTO employee_tb(first_name, last_name, email) " +
            "VALUES (#{request.firstName}, #{request.lastName}, #{request.email})")
    void save(@Param("request") Employee employee);

    @Update("UPDATE employee_tb SET " +
            "first_name = #{update.firstName}," +
            "last_name = #{update.lastName}," +
            "email = #{update.email} WHERE id = #{update.id}")
    void edit(@Param("update") Employee employee);

}
