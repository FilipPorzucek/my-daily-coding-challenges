public class Person {
    String firstName;
    String lastName;
    int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

   String toJson(){
        return STR.
                """
                {
                "firstName":"\{firstName}",
                "lastName":"\{lastName}",
                "age":"\{age}"
                }
                """;
    }

    String toXML(){
        return STR.
                """
                <person>
                    <firstName>\{firstName}<firstName>
                    <lastName>\{lastName}<lastName>
                    <age>\{age}<age>
                <person>
                        """;
    }

    @Override
    public String toString() {
        return firstName+" "+lastName+" "+age;
    }
}
