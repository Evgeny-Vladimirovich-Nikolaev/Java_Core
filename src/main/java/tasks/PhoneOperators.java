package tasks;

import utils.ResourcesReader;

import java.util.ArrayList;


public class PhoneOperators {

    private static ArrayList<String> lines;
    private static int distance;
    private static int city;
    private static int[][] operator1 = new int[8][2];
    private static int[][] operator2 = new int[8][2];
    private static ArrayList<Double> counter1 = new ArrayList<>();
    private static ArrayList<Double> counter2 = new ArrayList<>();
    private static int result;
    private static int prestige;

    public static void main(String[] args) {
        lines = ResourcesReader.readByLines("input.txt");
        parseLines(lines);
        fillCounter(operator1, counter1);
        fillCounter(operator2, counter2);
        defineResult();
        definePrestige();
        printResult();
    }

    private static void parseLines(ArrayList<String> lines) {
        fillConstanse(lines.get(0));
        fillArrays();
    }

    private static void fillConstanse(String line) {
        String dist = "";
        String c = "";
        int i = 0;
        while(line.charAt(i) != 32) {
            dist += line.charAt(i++);
        }
        while(++i < line.length()) {
            c += line.charAt(i);
        }
        distance = Integer.parseInt(dist);
        city = Integer.parseInt(c);
    }

    private static void fillArrays() {
        fill(operator1, 1);
        fill(operator2, 9);
    }

    private static void fill(int[][] arr, int ind) {
        for(int i = 0; i < 8; i++) {
            parseLine(lines.get(ind++), arr, i);
        }
    }

    private static void parseLine(String line, int[][] arr, int i) {
        int fst, snd;
        int ind = 0;
        String f = "";
        String s = "";
        while(line.charAt(ind) != 32) {
            f += line.charAt(ind++);
        }
        while(++ind < line.length()) {
            s += line.charAt(ind);
        }
        try {
            fst = Integer.parseInt(f);
            snd = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            fst = snd = 0;
            e.printStackTrace();
        }
        arr[i][0] = fst;
        arr[i][1] = snd;
    }

    private static void fillCounter(int[][] arr, ArrayList<Double> cnt) {
        for(int i = 0; i < 8; i++) {
            double a = Math.pow(arr[i][0], 2);
            double b = Math.pow(arr[i][1], 2);
            double c = Math.sqrt(a + b);
            if(c >= distance) {
                cnt.add(c);
            }
        }
        cnt.sort((o1, o2) -> 0);
    }

    private static void defineResult() {
        if(counter1.get(0) < counter2.get(0)) {
            result = 1;
        } else if(counter1.get(0) > counter2.get(0)) {
            result = 2;
        } else {
            result = 0;
        }
    }

    private static void definePrestige() {
        if(result == 1) {
            countPrestige(counter1, counter2.get(0));
        } else if(result == 2) {
            countPrestige(counter2, counter1.get(0));
        } else {
            prestige = 0;
        }
    }

    private static void countPrestige(ArrayList<Double> cnt, double dist) {
        prestige = 0;
        for(int i = 0; i < 8; i++) {
            if(cnt.get(i) < dist) {
                prestige++;
            }
        }
    }

    private static void printResult() {
        System.out.println(result);
        System.out.print(prestige);
    }

}

