package de.telran.lesson_28_20240617;

@BadCode(fullname = "Iryna", commentary = "Incorrect class")
public class Student {
    private String name;
    private String group;
    @BadCode(fullname = "Iryna", commentary = "incorrect format")
    private int age;

    public Student(String name, String group, int age) {
        this.name = name;
        this.group = group;
        this.age = age;
    }

    public void introduction() {
        System.out.println("My name is " + name + ". My group is " + group + ". I am " + age);
    }

    @BadCode(fullname = "Iryna", commentary = "incorrect age")
    private boolean isDrinking() {
        return age >= 21;
    }

    @BadCode(fullname = "Iryna", commentary = "discromination")
    void party() {
        System.out.println(isDrinking() ? "Можна наливать alcohol" : "Не наливать alcohol");
    }

    public static void main(String[] args) {
        Student student1 = new Student("Ivan", "211123-OP", 21);
        Student student2 = new Student("Olga", "21020-OP", 16);

        Class<? extends Student> studentClass = student1.getClass();
       if (studentClass.isAnnotationPresent(BadCode.class)){
           System.out.println(studentClass.getSimpleName() + " ;");
           BadCode badCode = studentClass.getAnnotation(BadCode.class);
           System.out.println(badCode.fullname() +", "+ badCode.commentary());
       }

       

    }
}
