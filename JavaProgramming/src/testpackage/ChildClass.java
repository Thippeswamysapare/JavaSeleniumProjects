package testpackage;

public class ChildClass extends ParentClass{
	
	public static void main(String[] arg)
	{
		System.out.println("Global variable from parent class : "+ num);
	
		ParentClass pc= new ParentClass();
		ChildClass cc=new ChildClass();
		
		pc.DisplayNumber();
		cc.DisplayNumber();
		ParentClass polymorphicObj=new ChildClass();	// run time polimorphism	
		//Java uses runtime polymorphism to invoke the method of the actual object type (ChildClass),
		//not the reference type (ParentClass)
		polymorphicObj.DisplayNumber();	
		
	}

	public void DisplayNumber()
	{
		System.out.println("This is Child Class : This is called method over riding");
		
	}

}
