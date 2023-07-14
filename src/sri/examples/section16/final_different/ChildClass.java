package sri.examples.section16.final_different;

import sri.examples.section16.finals.BaseClass;

public class ChildClass extends BaseClass {
    @Override
    protected void optionalMethod() {
        System.out.println("[ChildClass.optionalMethod]: Some extra stuff here");
        super.optionalMethod();
    }
}
