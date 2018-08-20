package application;

public class SphereApplication {

	public static void main(String[] args) {
		// Declaration and initialization
		Sphere sphereOne = new Sphere(5.5);

		System.out.printf("The volume of the sphere with radius %.2f is: %.2f", sphereOne.getRadius(),
				sphereOne.calcSphereVolume());
	}

}
