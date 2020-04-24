package pl.meklad;

import java.io.*;

class Main {
    private static final String[] dayName = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public static void main(String[] args) throws java.lang.Exception {
        int day, month, year;
        int t;
        int lastDay;
        final int dayPerYear = 365;
        String[] temp;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("The number of test cases?");
        try {
            t = Integer.parseInt(bufferedReader.readLine());
            if (t < 1 || t > 100) {
                throw new Exception("Out of range 1 <= t <= 100");
            }
            for (int i = 0; i < t; i++) {
                temp = bufferedReader.readLine().split(" ");

                year = Integer.parseInt(temp[2]);
                month = Integer.parseInt(temp[1]);
                lastDay = dayPerMonth(month, year);
                day = Integer.parseInt(temp[0]);

                if (year < 2012 || year > 3000) {
                    throw new Exception("Out of range 2012 to 3000");
                } else if (month < 1 || month > 12) {
                    throw new Exception("Out of range 1 to 12");
                } else if (day < 1 || day > lastDay) {
                    throw new Exception("Out of range 1 to " + lastDay);
                } else if (year == 2012 && month == 1 && day < 11) {
                    throw new Exception("Out of range 11 1 2012");
                }

                int numberOfDays = 0;
                for (int j = 2012; j < year; j++) {
                    numberOfDays += dayPerYear;
                    if (isLeap(j))
                        numberOfDays++;
                }
                for (int k = 1; k < month; k++) {
                    numberOfDays += dayPerMonth(k, year);
                }
                numberOfDays += (day - 1);
                System.out.println(dayName[numberOfDays % 7]);
            }
            bufferedReader.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static boolean isLeap(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }

    static int dayPerMonth(int month, int year) {
        int result;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                result = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                result = 30;
                break;
            case 2:
                if (isLeap(year)) {
                    result = 29;
                } else result = 28;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + month);
        }
        return result;
    }
}

//package pl.meklad;
//
//        import java.io.*;
//
//class Main {
//    private static final String[] dayName = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
//
//    public static void main(String[] args) throws java.lang.Exception {
//        int day, month, year;
//        int t;
//        int lastDay;
//        final int dayPerYear = 365;
//        String[] temp, output;
//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("The number of test cases?");
//        try {
//            t = Integer.parseInt(bufferedReader.readLine());
//            if (t < 1 || t > 100) {
//                throw new Exception("Out of range 1 <= t <= 100");
//            }
//            output = new String[t];
//            for (int i = 0; i < t; i++) {
//                temp = bufferedReader.readLine().split(" ");
//
//                year = Integer.parseInt(temp[2]);
//                month = Integer.parseInt(temp[1]);
//                lastDay = dayPerMonth(month, year);
//                day = Integer.parseInt(temp[0]);
//
//                if (year < 2012 || year > 3000) {
//                    throw new Exception("Out of range 2012 to 3000");
//                } else if (month < 1 || month > 12) {
//                    throw new Exception("Out of range 1 to 12");
//                } else if (day < 1 || day > lastDay) {
//                    throw new Exception("Out of range 1 to " + lastDay);
//                } else if (year == 2012 && month == 1 && day < 11) {
//                    throw new Exception("Out of range 11 1 2012");
//                }
//
//                int numberOfDays = 0;
//                for (int j = 2012; j < year; j++) {
//                    numberOfDays += dayPerYear;
//                    if (isLeap(j))
//                        numberOfDays++;
//                }
//                for (int k = 1; k < month; k++) {
//                    numberOfDays += dayPerMonth(k, year);
//                }
//                numberOfDays += (day - 1);
//                output[i] = dayName[numberOfDays % 7];
//            }
//            bufferedReader.close();
//            for (String dayNameTab : output) {
//                System.out.println(dayNameTab);
//            }
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    static boolean isLeap(int year) {
//        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
//    }
//
//    static int dayPerMonth(int month, int year) {
//        int result;
//        switch (month) {
//            case 1:
//            case 3:
//            case 5:
//            case 7:
//            case 8:
//            case 10:
//            case 12:
//                result = 31;
//                break;
//            case 4:
//            case 6:
//            case 9:
//            case 11:
//                result = 30;
//                break;
//            case 2:
//                if (isLeap(year)) {
//                    result = 29;
//                } else result = 28;
//                break;
//            default:
//                throw new IllegalStateException("Unexpected value: " + month);
//        }
//        return result;
//    }
//}
//
