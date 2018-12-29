/**
 * @ClassName: Employee
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2018/12/28 13:30
 * @Version 1.0
 */
public class Employee {
    private  String name;
    private  String City;
    private  int Sales;

    public Employee(String name, String city, int sales) {
        this.name = name;
        City = city;
        Sales = sales;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getSales() {
        return Sales;
    }

    public void setSales(int sales) {
        Sales = sales;
    }
}
