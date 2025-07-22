public class SchoolTest {
    public static void main(String[] args)   {
        School school=new School(2);
        try {
            school.add(new Student(1,"Jan","Kowalski"));
            school.add(new Student(2,"Marta","Zawadzka"));
            school.add(new Student(3,"Krystian","Niezbędny"));
        } catch (NoMoreSpaceException e) {
            System.out.println(e.getMessage());;
        }


            Student student = school.find("Krzysztof","Zawadzki");
            System.out.println("Nzaleziony student id "+student.getStudentId());


    }


}
