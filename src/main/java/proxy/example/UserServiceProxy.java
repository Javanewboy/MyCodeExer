package proxy.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserServiceProxy implements InvocationHandler {
    private Object target;

    // 绑定委托对象，并返回代理类
    public Object bind(Object target) {
        this.target = target;
        // 通过Proxy.newProxyInstance方法返回代理类对象
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method: " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("After method: " + method.getName());
        return result;
    }
    public static void main(String[] args) {
        // 创建原始对象
        UserService userService = new UserServiceImpl();
        // 创建代理对象
        UserService proxy = (UserService) new UserServiceProxy().bind(userService);
        // 使用代理对象调用方法
        proxy.save("Alice");
        proxy.update("Bob");
    }
}
