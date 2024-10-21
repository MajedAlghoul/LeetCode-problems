class Solution {

    public int daysBetweenDates(String date1, String date2) {
        String[] d1;
        String[] d2;
        switch (whichDateLater(date1, date2)) {
            case 1:
                d1 = date1.split("-");
                d2 = date2.split("-");
                break;
            case 2:
                d1 = date2.split("-");
                d2 = date1.split("-");
                break;
            default:
                return 0;
        }

        int year1 = Integer.parseInt(d1[0]);
        int month1 = Integer.parseInt(d1[1]);
        int day1 = Integer.parseInt(d1[2]);
        int year2 = Integer.parseInt(d2[0]);
        int month2 = Integer.parseInt(d2[1]);
        int day2 = Integer.parseInt(d2[2]);

        int daysPeriod = 0;

        for (int i = year2; i <= year1; i++) {
            if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                daysPeriod += 366;
            } else {
                daysPeriod += 365;
            }

        }

        if (daysPeriod == 0) {
            daysPeriod = 365;
        }
        int tempMonth = day2;
        month2--;
        while (month2 >= 1) {
            tempMonth += convertMonthsToDays(year2, month2);
            month2--;
        }

        tempMonth += (convertMonthsToDays(year1, month1) - day1);
        month1++;
        while (month1 <= 12) {
            tempMonth += convertMonthsToDays(year1, month1);
            month1++;
        }

        daysPeriod -= tempMonth;
        if (daysPeriod < 0) {
            return 365 + daysPeriod;
        }
        return daysPeriod;

    }

    private int whichDateLater(String date1, String date2) {
        String[] d1 = date1.split("-");
        String[] d2 = date2.split("-");
        int year1 = Integer.parseInt(d1[0]);
        int month1 = Integer.parseInt(d1[1]);
        int day1 = Integer.parseInt(d1[2]);
        int year2 = Integer.parseInt(d2[0]);
        int month2 = Integer.parseInt(d2[1]);
        int day2 = Integer.parseInt(d2[2]);
        if (year1 > year2) {
            return 1;
        } else if (year1 < year2) {
            return 2;
        } else {
            if (month1 > month2) {
                return 1;
            } else if (month1 < month2) {
                return 2;
            } else {
                if (day1 > day2) {
                    return 1;
                } else if (day1 < day2) {
                    return 2;
                } else {
                    return 0;
                }
            }
        }
    }

    private int convertMonthsToDays(int year, int months) {
        if (months == 1 || months == 3 || months == 5 || months == 7 || months == 8 || months == 10 || months == 12) {
            return 31;
        } else if (months == 4 || months == 6 || months == 9 || months == 11) {
            return 30;
        } else if (months == 2) {
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                return 29;
            }
            return 28;
        }
        return 0;
    }
}
