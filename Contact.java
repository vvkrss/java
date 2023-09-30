public record Contact(String name, String email) {
    public Contact(String name) {
        this(name, "default@gmail.com");
    }
    public Contact {
        if (name == null || email == null) {
            throw new IllegalArgumentException("Имя пользователя и адрес электронной почты не могут быть пустыми");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя пользователя не может быть пустым");
        }
        if (!email.endsWith("@gmail.com")) {
            throw new IllegalArgumentException("Адрес электронной почты должен заканчиваться @gmail.com");
        }
    }
    public void sayHello() {
        System.out.println("Привет, " + name);
    }
}
