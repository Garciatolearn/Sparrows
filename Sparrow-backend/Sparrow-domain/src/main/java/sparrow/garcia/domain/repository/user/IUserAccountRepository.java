package sparrow.garcia.domain.repository.user;

import sparrow.garcia.domain.model.entity.user.UserDTO;

public interface IUserAccountRepository {
    UserDTO selectUserByEmailOrUsername(String email, String username);

    int insertUserAccount(UserDTO userDTO);
}
