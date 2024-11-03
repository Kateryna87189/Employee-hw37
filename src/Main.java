import java.util.HashMap;
import java.util.Map;

/*
Руководство компании решило премировать сотрудников.
Каждый team lead подал список сотрудников для получения премии.
Но получилось так, что некоторые сотрудники работают на нескольких проектах и попали в
списки несколько раз. Для таких сотрудников решено увеличить премию.
Итак, у вас есть несколько списков сотрудников. Ваша задача получить Map<Employee, Integer>
где ключем будет сотрудник, а значением, сколько раз он встретился в списках.
 */
public class Main {
    public static void main(String[] args) {
        Map<String,Employee> team1 = new HashMap<>();
        team1.put("1", new Employee("Прохоров І.",1));
        team1.put("2", new Employee("Хомічова О.",2));
        team1.put("3", new Employee("Красильніков Є.",3));
        team1.put("4", new Employee("Нечипорук В.",4));

        Map<String,Employee> team2 = new HashMap<>();
        team1.put("1", new Employee("Прохоров І.",1));
        team1.put("5", new Employee("Прокопова В.",5));
        team1.put("6", new Employee("Григор'єв А.",6));
        team1.put("4", new Employee("Нечипорук В.",4));

        Map<String,Employee> team3 = new HashMap<>();
        team1.put("7", new Employee("Залізняк О.",7));
        team1.put("5", new Employee("Прокопова В.",5));
        team1.put("6", new Employee("Григор'єв А.",6));
        team1.put("8", new Employee("Гуляйнога С.",8));

        //підрахунок співробітників
       var employeeCountMap = countEmployeeOccurrences (team1, team2, team3);
       for (var entry : employeeCountMap.entrySet()){
           System.out.println("Працівник: "+entry.getKey() + "згадується "+ entry.getValue()+" разів");
       }
    }
    public static Map<Employee, Integer> countEmployeeOccurrences(Map<String, Employee>...teams){
        var employeeCountMap = new HashMap<Employee, Integer>();
        for (var team : teams){
           team.values().forEach(employee -> employeeCountMap.merge(employee, 1, Integer::sum));
        }
        return employeeCountMap;
    }

}