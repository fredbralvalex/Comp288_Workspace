package application;

public class ShapeTest {
	public static void main(String[] args) {
		// Declaration and initialization
		Shape standardShape = new Shape("Standard Shape","Blue");
		//Circle
		Circle circleShape = new Circle("Default Circle", "Magenta", 5.5);

		Cylinder cylinder = new Cylinder("Default Cilinder", "Green", 5.5, 10);

		//Declare an array of shapes
		Shape[] shapeList = new Shape[3];
		shapeList[0] = standardShape;
		shapeList[1] = circleShape;
		shapeList[2] = cylinder;

		for (Shape shape : shapeList) {
			System.out.println(shape);
		}

		Shape newShape = new Shape("New Shape","Red");
		//Polymorphism
		Shape newCircleShape = circleShape;

		//calculates the area
		double circleArea = circleShape.calcArea();
		double cylinderArea = cylinder.calcArea();

		//print the information for standard
		standardShape.printInformation();
		//print information for circle
		circleShape.printInformation();
		//print information for cylinder
		cylinder.printInformation();

		System.out.printf("\nArea of circle is %.2f.", circleArea);
		System.out.printf("\nArea of cilinder is %.2f.", cylinderArea);

	}
}
