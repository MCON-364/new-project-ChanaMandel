package mcon364.las.touro.edu;
import java.util.List;
import java.util.Optional;

public class Main{
    public static void main(String[] args){
        getGreeting("USERNAME");
        getGreeting("NO_SUCH_VAR");
        processValues(List.of(
                List.of(5, 10, 15),
                List.of(20, 0, 25),
                List.of(30, 35, 40),
                List.of(45, 99, 50),
                List.of(55, 60, 65)
        ));
    }

    public static Optional<String> getUserName(String envVariable) {
        System.getenv(envVariable);
        return Optional.ofNullable(envVariable);
    }

    public static String getGreeting(String envVarName){
        var greeting = getUserName(envVarName);

        if(greeting.isPresent()){
            StringBuilder greetingBuilder = new StringBuilder();
            greetingBuilder.append("Hello, ");
            greetingBuilder.append(envVarName);
            return greetingBuilder.toString();
        } else {
            return "Hello";
        }
    }

    public static int processValues(List<List<Integer>> data){
        int ctr = 0;
        outerloop:
        for(int row = 0; row < data.size(); row++){
            for (int subRow = 0; subRow< data.get(row).size(); subRow++){
                if (data.get(row).get(subRow) == 0){
                    continue outerloop;
                }

                if (data.get(row).get(subRow) == 99){
                    break outerloop;
                }
            }

            ctr++;
        }
        return ctr;
    }
}