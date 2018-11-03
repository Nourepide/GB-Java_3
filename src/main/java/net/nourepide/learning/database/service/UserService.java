package net.nourepide.learning.database.service;

import net.nourepide.learning.database.enity.Users;
import net.nourepide.learning.database.repository.UsersRepository;

import java.io.IOException;
import java.util.List;

public final class UserService extends AbstractService {
    private final UsersRepository usersRepository;

    public UserService() throws IOException {
        usersRepository = sqlSession.getMapper(UsersRepository.class);
    }

    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    public List<String> ids() {
        return usersRepository.ids();
    }

    public Users findOne(String id) {
        return usersRepository.findOne(id);
    }

    public void insert(Users users) {
        usersRepository.insert(users);
    }

    public void update(Users users) {
        usersRepository.update(users);
    }

    public void clear() {
        usersRepository.clear();
    }
}
