package sri.examples.section16.finals;


import sri.examples.section16.final_different.ChildClass;

/*
A final method means it can't be overridden by a subclass. A final field means an object's field can't be reassigned or given a different value, after its initialization.
A final static field is a class field that can't be reassigned, or given a different value, after the class's initialization process.
A field declared on an Interface is always public, static and final.
A final class can't be overridden, meaning no class can use it, in the extends clause.
A final variable, in a block of code, means that once it's assigned a value, any remaining code in the block can't change it.
A final method parameter means, we can't assign a different value to that parameter in the method code block.

I'll review all of these uses of the final modifier in more detail.

You can use the final modifier on methods. Using final with methods only makes sense in the context of wanting to restrict what your subclasses can override or hide.
Using final on an instance method means subclasses can't override it.
Using final on a class (static) method means subclasses can't hide it.


 */
public class Main {
    public static void main(String[] args) {
        BaseClass parent= new BaseClass();
        ChildClass child= new ChildClass();
        BaseClass childReferenceToBaseClass= new ChildClass();

        parent.recommendedMethod();
        System.out.println("_____________________________________________");
        childReferenceToBaseClass.recommendedMethod();
        System.out.println("_____________________________________________");
        child.recommendedMethod();
        // run this code,
        //the results are all the same, as you'd expect, for all three instances.
        System.out.println("_____________________________________________");
        //Now, let's say the designer of the child sub class reads our specification, and learns they should override the optionalMethod, if they want some custom functionality.

        //I'll go to the Child class, and use IntelliJ's override tools to generate this method.
        //I'll customize this. I'm ok with the code that's on the BaseClass, but I want to include some extra functionality before that executes.
        //I'll just add a statement that some extra stuff happened.
        //I'll go back to the Main class and re-run this.

        //you can see, for the two child instances, the last two output segments show, that the optionalMethod on Child was executed, and the statements, child, extra stuff here, is printed.




    }
}
