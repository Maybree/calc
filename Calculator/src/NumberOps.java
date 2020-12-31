import java.util.*;

public class NumberOps {


    private Map<String, Integer> map2 = new HashMap<>();

    public boolean isRoman(String input) {
        List<Character> romanList = new ArrayList<>(Arrays.asList('I','V','X'));
        return romanList.stream().anyMatch(c -> c == input.charAt(0));
    }

    public int ConvertRomanToInt(String input) {
        Map<String, Integer> map = fillMap1();
        int i = 0;
        for (String key : map.keySet()) {
            if (key.equals(input)) {
                i = map.get(key);
            }
        }

        return i;
    }

    public int ConvertArabicToInt(String input) {
        Integer i = 0;
        try {
            i = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            System.err.println("Неправильный формат строки!");
        }
        return i;
    }

    public String ConvertToRoman(int input) {
        int decimals = input / 10;
        int ones = input % 10;
        Map<String, Integer> map1 = fillMap1();
        Map<String, Integer> map2 = fillMap2();
        StringBuilder romanString = new StringBuilder();

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            if (Objects.equals(decimals, entry.getValue())) {
                romanString.append(entry.getKey());
            }
        }
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (Objects.equals(ones, entry.getValue())) {
                romanString.append(entry.getKey());
            }
        }

        return romanString.toString();
    }

    private Map<String, Integer> fillMap1() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("", 0);
        map1.put("I", 1);
        map1.put("II", 2);
        map1.put("III", 3);
        map1.put("IV", 4);
        map1.put("V", 5);
        map1.put("VI", 6);
        map1.put("VII", 7);
        map1.put("VIII", 8);
        map1.put("IX", 9);
        map1.put("X", 10);
        return map1;
    }

    private Map<String, Integer> fillMap2() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("X", 1);
        map1.put("XX", 2);
        map1.put("XXX", 3);
        map1.put("XL", 4);
        map1.put("L", 5);
        map1.put("LX", 6);
        map1.put("LXX", 7);
        map1.put("LXXX", 8);
        map1.put("XC", 9);
        map1.put("C", 10);
        return map1;
    }

}

