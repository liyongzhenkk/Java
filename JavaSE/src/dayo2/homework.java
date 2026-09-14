package dayo2;//定义一个类MyDate,代表生日,类中定义三个属性,分别为 year  month  day,并为三个属性赋值

public class homework {
    public static void main(String[] args) {
        MyDate mydate = new MyDate();
        mydate.year = 2004;
        mydate.month = 12;
        mydate.day = 1;
        System.out.println(mydate.toString());
    }

}

class MyDate {
    int year;
    int month;
    int day;

    @Override
    public String toString() {
        return "dayo2.MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}


