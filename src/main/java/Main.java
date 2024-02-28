import application.SkytecApplication;

public class Main
{
    final static int maxThreadCount = 100;

    public static void main(String[] args)
    {
        SkytecApplication app = new SkytecApplication();
        app.createAndFillTables();
        app.startApplication(maxThreadCount);
    }
}
