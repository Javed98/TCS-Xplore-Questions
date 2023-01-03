import java.util.*;

class AutonomousCar {
    private int carId;
    private String brand;
    private int noOfTestConducted;
    private int noOfTestsPassed;
    private String environment;
    private String grade;

    AutonomousCar(int carId, String brand, int noOfTestConducted, int noOfTestsPassed, String environment) {
        this.carId = carId;
        this.brand = brand;
        this.noOfTestConducted = noOfTestConducted;
        this.noOfTestsPassed = noOfTestsPassed;
        this.environment = environment;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getCarId() {
        return carId;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setNoOfTestConducted(int noOfTestConducted) {
        this.noOfTestConducted = noOfTestConducted;
    }

    public int getNoOfTestConducted() {
        return noOfTestConducted;
    }

    public void setNoOfTestsPassed(int noOfTestsPassed) {
        this.noOfTestsPassed = noOfTestsPassed;
    }

    public int getNoOfTestsPassed() {
        return noOfTestsPassed;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

}

class Solution {
    public static int findTestPassedByEnv(AutonomousCar[] cars, String environment) {
        int sum = 0;
        for (AutonomousCar autonomousCar : cars) {
            if (autonomousCar.getEnvironment().equalsIgnoreCase(environment)) {
                sum += autonomousCar.getNoOfTestsPassed();
            }
        }
        return sum;
    }

    public static AutonomousCar updateCarGrade(String brand, AutonomousCar[] cars) {
        for (AutonomousCar autonomousCar : cars) {
            if (autonomousCar.getBrand().equalsIgnoreCase(brand)) {
                String g = ((autonomousCar.getNoOfTestsPassed() * 100) / autonomousCar.getNoOfTestConducted() >= 80)
                        ? "A1"
                        : "B2";
                autonomousCar.setGrade(g);
                return autonomousCar;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AutonomousCar[] cars = new AutonomousCar[2];
        for (int i = 0; i < cars.length; i++) {
            AutonomousCar car = new AutonomousCar(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextInt(), sc.next());
            cars[i] = car;
        }
        sc.nextLine();
        String environment = sc.nextLine();
        String brand = sc.nextLine();
        int testPassed = findTestPassedByEnv(cars, environment);
        if (testPassed > 0) {
            System.out.println(testPassed);
        } else {
            System.out.println("There are no test passed in the particular environment");
        }
        AutonomousCar updatedCar = updateCarGrade(brand, cars);
        if (updatedCar != null) {
            System.out.println(updatedCar.getBrand() + "::" + updatedCar.getGrade());
        } else {
            System.out.println("No Car is available with the specified brand");
        }
    }

}
