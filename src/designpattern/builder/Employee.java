package designpattern.builder;

public class Employee {
    String name;
    int age;
    String designation;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", designation='" + designation + '\'' +
                '}';
    }

    static EmployeeBuilder builder() {
        return new EmployeeBuilder();
    }

    public Employee() {
    }

    public Employee(String name, int age, String designation) {
        this.name = name;
        this.age = age;
        this.designation = designation;
    }


      static class EmployeeBuilder {
          String name;
          int age;
          String designation;

          public EmployeeBuilder() {
          }

          EmployeeBuilder name(String name) {
              this.name = name;
              return this;
          }
          EmployeeBuilder age(int age) {
              this.age = age;
              return this;
          }

          EmployeeBuilder designation(String designation) {
              this.designation = designation;
              return this;
          }


          Employee build() {
             return new Employee(name, age, designation);
         }

    }

    public static void main(String[] args) {
        Employee employee = Employee.builder().build();
        System.out.println(employee);

        Employee employee1 = Employee.builder()
                .name("some name")
                .age(1)
                .build();

        System.out.println(employee1);
    }
}
