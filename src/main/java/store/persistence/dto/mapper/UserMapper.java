package store.persistence.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import store.persistence.dto.UserDTO;
import store.persistence.entity.User;
import store.persistence.entity.enums.Gender;
import store.persistence.entity.enums.Role;

public class UserMapper {

	public static User userDTOToUser(UserDTO dto) {

		User user = new User();

		user.setActivated(dto.isActivated());
		user.setBirthDate(dto.getBirthDate());
		user.setRegistrationDate(dto.getRegistrationDate());
		user.setEmail(dto.getEmail());
		user.setFirstName(dto.getFirstName());
		user.setGender(Gender.valueOf(dto.getGender()));
		user.setLastName(dto.getLastName());
		user.setLogged(dto.isLogged());
		user.setPassword(dto.getPassword());
		user.setRole(Role.valueOf(dto.getRole()));

		return user;
	}

	public static UserDTO userToUserDTO(User user) {

		UserDTO dto = new UserDTO();

		dto.setActivated(user.isActivated());
		dto.setBirthDate(user.getBirthDate());
		dto.setRegistrationDate(user.getRegistrationDate());
		dto.setEmail(user.getEmail());
		dto.setFirstName(user.getFirstName());
		dto.setGender(user.getGender().toString());
		dto.setLastName(user.getLastName());
		dto.setLogged(user.isLogged());
		dto.setPassword(user.getPassword());
		dto.setRole(user.getRole().role);

		return dto;
	}

	public static List<User> userDTOListToUserList(List<UserDTO> dtos) {

		return dtos.stream().map(dto -> userDTOToUser(dto)).collect(Collectors.toList());
	}

	public static List<UserDTO> userListToUserDTOList(List<User> users) {

		return users.stream().map(user -> userToUserDTO(user)).collect(Collectors.toList());
	}

	private UserMapper() {

	}

}
