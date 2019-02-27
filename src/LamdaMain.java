import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toCollection;

public class LamdaMain {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<Employee>() {{
            add(new Employee("Alice", "London", 200));
            add(new Employee("Charles", "London", 150));
            add(new Employee("Bob", "New York", 160));
            add(new Employee("Dorothy", "Hong Kong", 190));
            add(new Employee("100", "200", 10));
            add(new Employee("200", "200", 10));
        }};

        List<String> list = new ArrayList<>();
        employees.forEach(a -> {
            if (!list.contains(a.getCity()) || !list.contains(a.getName())) {
                list.add(a.getCity());
                list.add(a.getName());
            }
        });

        //List<String> categoryTypeList = employees.stream().map(e -> e.getName()|e.getCity()).collect(Collectors.toList());

        employees.stream().filter(item -> item.getName() != null || item.getCity() != null);


        // 从指定数组中获取指定列属性并拼接
        String joined = employees.parallelStream().map(Employee::getName).filter(e -> e.indexOf("e") > -1).collect(Collectors.joining("|"));

        // 按照指定名称分组
        Map<String, List<Employee>> employeesByCity = employees.stream().collect(groupingBy(Employee::getCity));

        // 根据某个属性分组计数
        Map<String, Long> numEmployeesByCity =
                employees.stream().collect(groupingBy(Employee::getCity, counting()));

        // 根据整个实体对象分组计数,当其为String时常使用
        Map<Employee, Long> numEmployeesByEmployee = employees.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // 据分组的key值对结果进行排序、放进另一个map中并输出
        Map<String, Long> xMap = new HashMap<>();
        numEmployeesByCity.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByKey().reversed()) //reversed不生效
                .forEachOrdered(x -> xMap.put(x.getKey(), x.getValue()));


        // 分组，并统计其中一个属性值得sum或者avg:id总和
        Map<String, Integer> result3 = employees.stream().collect(
                Collectors.groupingBy(Employee::getCity, Collectors.summingInt(Employee::getSales))
        );


        Map<Boolean, Map<String, Long>> result =
                employees.stream().collect(partitioningBy(e -> e.getSales() > 150,
                        groupingBy(Employee::getCity, counting())));

        System.out.println(xMap);
        System.err.print(employeesByCity);
    }
}
