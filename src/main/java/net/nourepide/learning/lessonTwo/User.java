package net.nourepide.learning.lessonTwo;

class User<F, S> {
    private F name;
    private S password;

    public User(F name, S password) {
        this.name = name;
        this.password = password;
    }

    public F getName() {
        return name;
    }

    public void setName(F name) {
        this.name = name;
    }

    public S getPassword() {
        return password;
    }

    public void setPassword(S password) {
        this.password = password;
    }
}