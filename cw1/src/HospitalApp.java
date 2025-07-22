public class HospitalApp {
    public static void main(String[] args) {

        Hospital hospital=new Hospital();
        hospital.add(new Doctor("Paweł","Domagała",8500,1200));
        hospital.add(new Nurse("Natalia","Domagała",2200,5));
        hospital.add(new Nurse("Patrycja","Domagała",2800,8));

        System.out.println("Pracownicy szpitala");
        System.out.println(hospital.getInfo());
    }
}
