package dachuk.snow.service;

import dachuk.snow.model.User;
import org.graalvm.compiler.lir.LIRInstruction;

import java.util.ArrayList;

public interface UserService {
    User login(User user);
    User registration(User user);

    User update(User user);

    User approveStatus(User User);

    User findById(int id);
    ArrayList<User> findAll();
}
