package aboo.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by admin on 2017/5/12.
 */
public class Dog {

    @NotNull(message = "Dog's id is not null")
    private String id;

    @Min(value = 2,message = "Dog's age min value:2")
    @Max(value = 10,message = "Dog's age max value:10")
    private int age;

    public Dog() {
    }

    public Dog(String id, int age) {
        this.id = id;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", age='" + age + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getage() {
        return age;
    }

    public void setage(int age) {
        this.age = age;
    }
}

