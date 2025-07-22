package pl.filip;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Integer personId;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;


    public Integer getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
