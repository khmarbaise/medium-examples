package com.soebes.medium.stream.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeFactory {

  ArrayList<Employee> employees = new ArrayList<>();

  public List<Employee> getAllEmployee(){

    Project delta = new Project("Delta Model", "Login", "Robert Downey Jr");
    Project Beta = new Project("Beta Enhancement", "Authentication", "Chris");
    Project TwoFactorAuth = new Project("Two Factor Authentication", "Authentication", "MSD");
    Project CommonUI = new Project("Common UI", "UI", "Robert Downey Jr");
    Project Pegasus = new Project("Pegasus Model", "Data", "Vikram");
    Project CustomerOnboarding = new Project("Customer Onboarding", "Ads", "Vedha");
    Project Verification = new Project("Source Verification", "Data", "Pablo");
    Project RemoveUsers = new Project("Remove Invalid User", "Proxy", "Jeetu");
    Project SiteReliability = new Project("Site Reliability", "Admin", "Zaheer Khan");
    Project DataTransition = new Project("Data Transition", "Data", "Atif Aslam");
    Project TwoPhaseDeployment =new Project("Two Phase Deployment", "Deployment", "Shaktiman");

    employees.add(new Employee("2020Emp0234", "Bhaskar", "Sharan", 900000, 1, Arrays.asList(delta, Beta)));
    employees.add(new Employee("2012Emp1923", "Dev", "Sharma", 3500000, 3, Arrays.asList(Pegasus, CustomerOnboarding, Beta, SiteReliability)));
    employees.add(new Employee("2017Emp0721", "Priti", "Kabir", 1800000, 3, Arrays.asList(TwoFactorAuth, Beta, CommonUI)));
    employees.add(new Employee("2017Emp00031", "Chris", "Martin", 2200000, 2, Arrays.asList(delta, TwoFactorAuth)));
    employees.add(new Employee("2013Emp0872", "Sanjay", "Singhania", 2200000, 3, Arrays.asList(Pegasus, delta, RemoveUsers, DataTransition)));
    employees.add(new Employee("2022Emp0087", "Babu", "Rao", 900000, 1, Arrays.asList(TwoFactorAuth)));
    employees.add(new Employee("2019Emp0050", "Dev", "Anand", 1300000, 1, Arrays.asList(RemoveUsers, CommonUI)));
    employees.add(new Employee("2023Emp0934", "Shruti", "Sen", 1100000, 1, Arrays.asList(Pegasus)));
    employees.add(new Employee("2023Emp1033", "Akshay", "Kumar", 1200000, 0, Arrays.asList(delta)));
    employees.add(new Employee("2015Emp0009", "Babu", "Dutt", 2600000, 2, Arrays.asList(Verification, RemoveUsers, TwoPhaseDeployment)));

    return employees;
  }
}
