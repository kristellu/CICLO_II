public class App {
    public static void main(String[] args) throws Exception {
        SchoolGradingSystem sgs = new SchoolGradingSystem();
        sgs.loadData();
        System.out.println(sgs.formatOutput(sgs.stat1(sgs.getData())));
        System.out.println(sgs.formatOutput(sgs.stat2(sgs.getData())));
        System.out.println(sgs.formatOutput(sgs.stat3(sgs.getData())));
        System.out.println(sgs.formatOutput(sgs.stat4(sgs.getData())));
    }
}
