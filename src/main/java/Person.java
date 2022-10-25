public class Person {
    private String Name;
    public int Age;
    private double Salary;

    public Person(String name, int age, double salary){
        Name = name;
        Age = age;
        Salary = salary;
    }

    public double getSalary(){
        return Salary;
    }
    public String getName(){
        return Name;
    }

}
