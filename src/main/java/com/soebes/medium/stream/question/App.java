package com.soebes.medium.stream.question;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;

public class App {

  static List<Employee> employeeList = new ArrayList<>();

  public static void main(String[] args) {

    EmployeeFactory employeeFactory = new EmployeeFactory();
    employeeList = employeeFactory.getAllEmployee();

    // List all distinct project in non-ascending order.
    listAllDistinctProjectInNonAscendingOrder(employeeList);

    // Print full name of any employee whose firstName starts with ‘A’.
    printFullNameOfAnyEmployeeWhoeFirstNameStartsWithA(employeeList);

    // List of all employee who joined in year 2023 (year to be extracted from employee id i.e., 1st 4 characters)
    listAllEmployeeWhoJoinedInYear2023(employeeList);

    // Sort employees based on firstName, for same firstName sort by salary.
    sortEmployeesBasedOnFirstNameForSameFirstNameSortBySalary(employeeList);

    // Print names of all employee with 3rd highest salary. (generalise it for nth highest salary).
    printNamesOfAllEmployeeWith3rdHighestSalary(employeeList,  3);

    // Print min salary.
    printMinSalary(employeeList);

    // Print list of all employee with min salary.
    printListOfAllEmployeeWithMinSalary(employeeList);
    printListOfAllEmployeeWithMinSalary2Nd(employeeList);

    // List of people working on more than 2 projects.
    printListOfPeopleWorkingOnMoreThanTwoProjects(employeeList);

    // Count of total laptops assigned to the employees.
    countTotalOfLaptopsAssignedToTheEmployees(employeeList);

    // Count of all projects with Robert Downey Jr as PM.
    var projectManagerRobertDowneyJr = "Robert Downey Jr";
    countAllProjectsWithRobertDowneyJrASPM(employeeList, projectManagerRobertDowneyJr);

    // List of all projects with Robert Downey Jr as PM.
    listAllProjectWithRoberDowneyJrASPM(employeeList, projectManagerRobertDowneyJr);

    // List of all people working with Robert Downey Jr.
    listAllPeopleWorkingWithRobertDowneyJr(employeeList, projectManagerRobertDowneyJr);

    // Create a map based on this data, they key should be the year of joining, and value should
    // be list of all the employees who joined the particular year. (Hint : Collectors.toMap)
    createMapOfData(employeeList);

    // Create a map based on this data, the key should be year of joining and value should be the count
    // of people joined in that particular year. (Hint : Collectors.groupingBy())
    createMapOfCountJoinedParticularYear(employeeList);
  }

  private static void listAllDistinctProjectInNonAscendingOrder(List<Employee> employeeList) {
    System.out.println("--- 1. List all distinct project in non-ascending order. ---");

    employeeList.stream()
        .flatMap(e -> e.getProjects().stream())
        .sorted(Comparator.comparing(Project::getName, Comparator.reverseOrder()))
        .distinct()
        .forEachOrdered(s -> System.out.println(s.getName()));
  }

  private static void printFullNameOfAnyEmployeeWhoeFirstNameStartsWithA(List<Employee> employeeList) {
    System.out.println("--- 2. Print full name of any employee whose firstName starts with ‘A’. ---");

    employeeList.stream()
        .filter(e -> e.getFirstName().startsWith("A"))
        .forEach(s -> System.out.println(s.getLastName() + ", " + s.getFirstName()));

  }

  private static void listAllEmployeeWhoJoinedInYear2023(List<Employee> employeeList) {
    System.out.println("--- 3. (Simpler) List of all employee who joined in year 2023 (year to be extracted from employee id i.e., 1st 4 characters) ---");
    employeeList.stream()
        .filter(e -> e.getId().startsWith("2023"))
        .forEach(s -> System.out.println(convertToString(s)));
  }

  private static void sortEmployeesBasedOnFirstNameForSameFirstNameSortBySalary(List<Employee> employeeList) {
    System.out.println("--- 4. Sort employees based on firstName, for same firstName sort by salary. ---");
    employeeList.stream()
        .sorted(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getSalary))
        .forEachOrdered(s -> System.out.println(convertToString(s)));
  }


  private static void printNamesOfAllEmployeeWith3rdHighestSalary(List<Employee> employeeList, long nThHighest) {
    //TODO: Check nThHighest to be >= 2.

    System.out.println("--- 5. Print names of all employee with 3rd highest salary. ---");

    employeeList.stream()
        .sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()))
        .limit(nThHighest)
        .skip(nThHighest - 1)
        .findFirst()
        .ifPresent(nThHighestEmployee -> employeeList.stream()
            .filter(e -> e.getSalary() == nThHighestEmployee.getSalary())
            .forEach(k -> System.out.println(convertToString(k)))
        );
  }

  private static void printMinSalary(List<Employee> employeeList) {
    System.out.println("--- 6. Print min salary. ---");

    employeeList.stream()
        .min(Comparator.comparing(Employee::getSalary))
        .ifPresent(e -> System.out.println("Min Salary: " + e.getSalary()));
  }

  private static void printListOfAllEmployeeWithMinSalary(List<Employee> employeeList) {
    System.out.println("--- 7. Print list of all employee with min salary. ---");

    var collect = employeeList.stream()
        .collect(Collectors.groupingBy(Employee::getSalary));

    collect.entrySet().stream()
        .sorted(comparingByKey())
        .limit(1)
        .flatMap(s -> s.getValue().stream())
        .forEachOrdered(e -> System.out.println(convertToString(e)));
  }

  private static void printListOfAllEmployeeWithMinSalary2Nd(List<Employee> employeeList) {
    System.out.println("--- 7a  Print list of all employee with min salary. (2) ---");

    employeeList.stream()
        .sorted(Comparator.comparing(Employee::getSalary))
        .limit(1)
        .findFirst()
        .ifPresent(nThHighestEmployee -> employeeList.stream()
            .filter(e -> e.getSalary() == nThHighestEmployee.getSalary())
            .forEach(k -> System.out.println(convertToString(k)))
        );

  }

  private static void printListOfPeopleWorkingOnMoreThanTwoProjects(List<Employee> employeeList) {
    System.out.println("--- 8. List of people working on more than 2 projects. ---");

    var listOfPeopleWorkingOnMoreThanTwoProjects = employeeList.stream()
        .filter(s -> s.getProjects().size() > 2)
        .collect(Collectors.toList());

    listOfPeopleWorkingOnMoreThanTwoProjects.forEach(s -> System.out.println(convertToString(s)));


  }

  private static void countTotalOfLaptopsAssignedToTheEmployees(List<Employee> employeeList) {
    System.out.println("--- 9. Count of total laptops assigned to the employees. ---");

    var totalNumberOfLaptops = employeeList.stream()
        .mapToInt(Employee::getTotalLaptopsAssigned)
        .sum();

    System.out.println("totalNumberOfLaptops = " + totalNumberOfLaptops);

  }

  private static void countAllProjectsWithRobertDowneyJrASPM(List<Employee> employeeList, String projectManager) {
    System.out.println("--- 10. Count of all projects with " + projectManager + " as PM. ---");

    var numberOfProjectsOfPM = employeeList.stream()
        .flatMap(employee -> employee.getProjects().stream())
        .filter(project -> projectManager.equalsIgnoreCase(project.getProjectManager()))
        .distinct()
        .count();

    System.out.println("numberOfProjectsOfPM = " + numberOfProjectsOfPM);

  }

  // List of all projects with Robert Downey Jr as PM.
  private static void listAllProjectWithRoberDowneyJrASPM(List<Employee> employeeList, String projectManager) {
    System.out.println("--- 11. List of all projects with " + projectManager + " as PM. ---");

    employeeList.stream()
        .flatMap(employee -> employee.getProjects().stream())
        .filter(project -> projectManager.equalsIgnoreCase(project.getProjectManager()))
        .distinct()
        .forEach(p -> System.out.println(convertToString(p)));
  }

  // List of all people working with Robert Downey Jr.
  private static void listAllPeopleWorkingWithRobertDowneyJr(List<Employee> employeeList, String projectManager) {
    System.out.println("--- 12. List of all people working with " + projectManager + " ---");

    var allPeopleWorkingWith = employeeList.stream()
        .filter(employee -> employee.getProjects().stream().anyMatch(project -> projectManager.equalsIgnoreCase(project.getProjectManager())))
        .collect(Collectors.toList());

    allPeopleWorkingWith.forEach(e -> System.out.println(convertToString(e)));
  }

  // Create a map based on this data, they key should be the year of joining, and value should
  // be list of all the employees who joined the particular year. (Hint : Collectors.toMap)
  private static void createMapOfData(List<Employee> employeeList) {
    System.out.println("--- 13. Create a map based on this data, they key should be the year of joining ---");

    Map<String, List<Employee>> createData = employeeList.stream()
        .collect(Collectors.groupingBy(s -> s.getId().substring(0, 4), Collectors.toList()));

    createData.entrySet().stream()
        .sorted(Map.Entry.comparingByKey())
        .forEachOrdered(entry -> {
      System.out.println("Year: " + entry.getKey());
      entry.getValue().forEach(e -> System.out.println("  " + convertToString(e)));
    });

  }


  // Create a map based on this data, the key should be year of joining and value should be the count
  // of people joined in that particular year. (Hint : Collectors.groupingBy())
  private static void createMapOfCountJoinedParticularYear(List<Employee> employeeList) {
    System.out.println("--- 14. Create a map based on this data, the key should be year of joining and value should be the count ---");
    var createData = employeeList.stream()
        .collect(Collectors.groupingBy(employee -> employee.getId().substring(0, 4), Collectors.counting()));

    createData.entrySet().stream()
        .sorted(Map.Entry.comparingByKey())
        .forEachOrdered(entry -> System.out.println("Year: " + entry.getKey() + " count:" + entry.getValue()));
  }


  private static String convertToString(Project project) {
    return String.format("%-12s PM: %20s Team:%s", project.getName(), project.getProjectManager(), project.getTeam());
  }
  private static String convertToString(Employee employee) {
    return String.format("id: %-12s sal:%8d fn:%-8s ln:%-10s", employee.getId(), employee.getSalary(), employee.getFirstName(), employee.getLastName());
  }

  private static String convertToStringWithProjects(Employee employee) {
    return String.format("id: %-12s sal:%8d fn:%-8s ln:%-10s%n" +
                         "    {%s}%n", employee.getId(), employee.getSalary(), employee.getFirstName(), employee.getLastName(), employee.getProjects());
  }
}
