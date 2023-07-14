package sri.examples.section16.finals;

public class BaseClass {

    public void recommendedMethod(){
        System.out.println("[BaseClass.recommendedMethod]: Best way to do it");
        optionalMethod();
        mandatoryMethod();
    }
    protected void optionalMethod(){
        System.out.println("[BaseClass.optionalMethod]: Customize optional method");
    }

    private void mandatoryMethod(){
        System.out.println("[BaseClass.mandatoryMethod]: Non-NEGOTIABLE");
    }
}
