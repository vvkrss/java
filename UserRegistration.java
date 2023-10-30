public class UserRegistration {
    public static boolean registerUser(String login, String password, String confirmPassword) {
        try {
            if (login.length() >= 20 || !login.matches("^[a-zA-Z0-9_]+$")) {
                throw new WrongLoginException("Неправильный логин");
            }
            if (password.length() >= 20 || !password.matches("^[a-zA-Z0-9_]+$") || !password.equals(confirmPassword)) {
                throw new WrongPasswordException("Неправильный пароль");
            }
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        String login = "user111111";
        String password = "password11111";
        String confirmPassword = "password11111";

        if (registerUser(login, password, confirmPassword)) {
            System.out.println("Регистрация прошла успешно.");
        } else {
            System.out.println("Регистрация прошла неуспешно.");
        }
    }
}