public class Main {
    public static void main(String[] args) {
        checkLoginAndPassword("Makcum_Sh93", "dthysqgfhjkm77", "dthysqgfhjkm77");
    }

    private static void checkLoginAndPassword(String login, String password, String confirmPassword) {

        try {
            checkLogin(login);
            checkPassword(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Проверка логина и пароля завершена");
        }
    }

    private static void checkLogin(String login) throws WrongLoginException {
        if (!login.matches("^[a-zA-Z0-9-_]+$")) {
            throw new WrongLoginException("Ошибка! Логин может содержать в себе только латинские буквы, цифры и знак подчеркивания");
        }

        if (login.length() > 20) {
            throw new WrongLoginException("Ошибка! Логин должен быть равен или меньше 20 символов");
        }
    }

    private static void checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        if (!password.matches("^[a-zA-Z0-9-_]+$")) {
            throw new WrongPasswordException("Ошибка! Пароль может содержать в себе только латинские буквы, цифры и знак подчеркивания");
        }

        if (password.length() > 20) {
            throw new WrongPasswordException("Ошибка! Пароль должен быть равен или меньше 20 символов");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Ошибка! Введенные пароли не совпадают");
        }
    }
}