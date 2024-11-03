import java.io.IOError;
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
        team2.put("1", new Employee("Прохоров І.",1));
        team2.put("5", new Employee("Прокопова В.",5));
        team2.put("6", new Employee("Григор'єв А.",6));
        team2.put("4", new Employee("Нечипорук В.",4));

        Map<String,Employee> team3 = new HashMap<>();
        team3.put("7", new Employee("Залізняк О.",7));
        team3.put("5", new Employee("Прокопова В.",5));
        team3.put("6", new Employee("Григор'єв А.",6));
        team3.put("8", new Employee("Гуляйнога С.",8));

        //підрахунок співробітників
       Map<Employee, Integer> employeeCountMap = countEmployeeOccurrences (team1, team2, team3);
       for (var entry : employeeCountMap.entrySet()){
           System.out.println("Працівник: "+entry.getKey() + "згадується "+ entry.getValue()+" разів");
       }
    }
    //метод для підрахунку згадувань співробітників
    public static Map<Employee, Integer> countEmployeeOccurrences(Map<String, Employee>...teams){
        Map<Employee,Integer> employeeCountMap = new HashMap<>();

        for (Map<String, Employee> team : teams){
            for (Employee employee: team.values()){
                //підрахунок згадувань
                if (employeeCountMap.containsKey(employee)){
                    employeeCountMap.put(employee, employeeCountMap.get(employee) +1);
                }else {
                    employeeCountMap.put(employee,1);
                }
            }
        }
        return employeeCountMap;
    }

}