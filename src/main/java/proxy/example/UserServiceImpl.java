package proxy.example;

public class UserServiceImpl implements UserService {
    @Override
    public void save(String username) {
        System.out.println("Saving user: " + username);
    }

    @Override
    public void update(String username) {
        System.out.println("Updating user: " + username);
    }
}
