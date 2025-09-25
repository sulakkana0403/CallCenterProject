import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CallCenterSystem {
    private Queue<Caller> callQueue;

    public CallCenterSystem() {
        callQueue = new LinkedList<>();
    }

    // Add new caller to the queue
    public void addCaller(Caller caller) {
        callQueue.add(caller);
        System.out.println("📞 " + caller.name + " has joined the call queue.");
    }

    // Serve next caller
    public void serveCaller() {
        if (callQueue.isEmpty()) {
            System.out.println("✅ No callers in the queue.");
        } else {
            Caller c = callQueue.poll();
            System.out.println("🎧 Serving: " + c);
            System.out.println("✅ Issue resolved for " + c.name);
        }
    }

    // Display current call queue
    public void displayQueue() {
        if (callQueue.isEmpty()) {
            System.out.println("📭 Call queue is empty.");
        } else {
            System.out.println("📋 Current Call Queue:");
            for (Caller c : callQueue) {
                System.out.println("   → " + c);
            }
        }
    }

    // Main Simulation
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CallCenterSystem center = new CallCenterSystem();

        int choice;
        int callerId = 1;

        do {
            System.out.println("\n=== 📞 CALL CENTER MENU ===");
            System.out.println("1. Add Caller");
            System.out.println("2. Serve Next Caller");
            System.out.println("3. Show Call Queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter caller name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter issue: ");
                    String issue = scanner.nextLine();
                    center.addCaller(new Caller(callerId++, name, issue));
                    break;

                case 2:
                    center.serveCaller();
                    break;

                case 3:
                    center.displayQueue();
                    break;

                case 4:
                    System.out.println("👋 Exiting Call Center System...");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

