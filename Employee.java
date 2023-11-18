import java.util.Comparator;

public class Employee implements Comparable<Employee> {
    private String name;
    private String surname;
    private String city;
    private int age;
    private int salary;

    public static final Comparator<Employee> AGE_SALARY_COMPARATOR = Comparator
            .comparingInt(Employee::getAge)
            .thenComparingInt(Employee::getSalary);

    public static final Comparator<Employee> PASSPORT_COMPARATOR = Comparator
            .comparing(Employee::getName, String.CASE_INSENSITIVE_ORDER)
            .thenComparing(Employee::getSurname)
            .thenComparing(Employee::getCity);

    public static final Comparator<Employee> FULL_COMPARATOR = Comparator
            .comparing(Employee::getName, String.CASE_INSENSITIVE_ORDER)
            .thenComparing(Employee::getSurname)
            .thenComparing(Employee::getCity)
            .thenComparingInt(Employee::getAge)
            .thenComparingInt(Employee::getSalary);

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee other) {
        int nameComparison = this.name.compareToIgnoreCase(other.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        return Integer.compare(this.age, other.age);
    }
}