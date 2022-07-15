public class Application {
    public static void main(String[] args) {
        TimeCycle.startCycle(15000, new TimeExporter());
    }
}