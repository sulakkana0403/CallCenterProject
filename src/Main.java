public class Main {
    public static void main(String[] args) {

        CallCenterSystem c1 = new CallCenterSystem();


        Caller caller1 = new Caller(1, "Alice", "Internet not working");
        Caller caller2 = new Caller(2, "Bob", "Billing issue");
        Caller caller3 = new Caller(3, "Charlie", "Password reset");
        Caller caller4 = new Caller(4, "Ann", "Password reset");
        c1.addCaller(caller1);
        c1.addCaller(caller2);
        c1.addCaller(caller3);
        c1.addCaller(caller4);


        c1.displayQueue();


        c1.serveCaller();
        c1.serveCaller();

        c1.displayQueue();
    }
}
