package net.projecteuler.level001;

/*
 * You are given the following information, but you may prefer to do some research for yourself.
 *
 * - 1 Jan 1900 was a Monday.
 *
 * - Thirty days has September, April, June and November.
 *
 * - All the rest have thirty-one,
 * - Saving February alone,
 * - Which has twenty-eight, rain or shine.
 * - And on leap years, twenty-nine.
 * - A leap year occurs on any year evenly divisible by 4, but not on a century unless it is
 * divisible by 400.
 *
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31
 * Dec 2000)?
 */
public class Problem0019 {

  public static void main(String[] args) {

    /*
     * mon : 0
     * tue : 1
     * wed : 2
     * thu : 3
     * fri : 4
     * sat : 5
     * sun : 6
     */
    int weekday = 0; // mon : 1, tue : 2

    int sun_cnt = 0;

    int[] month_len = new int[13];
    /*
     * 30 : 9, 4, 6, 11 -> 4
     * 28 or 29 : 2 -> 1
     * 31 : 1, 3, 5, 7, 8, 10, 12 -> 7
     */
    month_len[9] = month_len[4] = month_len[6] = month_len[11] = 30;
    month_len[1] = month_len[3] =
        month_len[5] = month_len[7] = month_len[8] = month_len[10] = month_len[12] = 31;

    for (int year = 1900; year <= 2000; year++) {
      if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
        month_len[2] = 29;
      } else {
        month_len[2] = 28;
      }
      for (int month = 1; month <= 12; month++) {

        for (int day = 1; day <= month_len[month]; day++) {

          if (weekday == 6) {

            if (year >= 1901 && day == 1) {
              sun_cnt++;
            }
            weekday = -1;
          }
          weekday++;
        }
      }

    }

    System.out.println(sun_cnt);
  }

}
