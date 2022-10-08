package homework_2;

import java.util.Objects;

public class Owner {
    private final long ownerId;
    private final String name;
    private final String lastName;
    private final int age;

    public Owner(long ownerId, String name, String lastName, int age) {
        this.ownerId = ownerId;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Owner owner = (Owner) object;
        return ownerId == owner.ownerId;
    }

    @Override
    public int hashCode() { return Objects.hash(ownerId); }

    public Long getId() {
        return ownerId;
    }

    public int getAge() {
        return age;
    }
}
