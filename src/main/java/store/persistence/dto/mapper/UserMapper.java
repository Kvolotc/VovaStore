package store.persistence.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import store.persistence.dto.UserDTO;
import store.persistence.entity.User;
import store.persistence.entity.enums.Gender;

public class UserMapper {

	public static User userDTOToUser(UserDTO dto) {
		
		User user = new User();
		
		user.setActivated(dto.isActivated());
		user.setDate(dto.getDate());
		user.seteMail(dto.geteMail());
        user.setFirstName(dto.getFirstName());
        user.setGender(Gender.valueOf(dto.getGender()));
        user.setLastName(dto.getLastName());
        user.setLogged(dto.isLogged());
        user.setPassword(dto.getPassword());
        
        return user;
	}

	public static UserDTO userToUserDTO(User user) {

		UserDTO dto = new UserDTO();

		dto.setActivated(user.isActivated());
		dto.setDate(user.getDate());
		dto.seteMail(user.geteMail());
		dto.setFirstName(user.getFirstName());
		dto.setGender(user.getGender().toString());
		dto.setLastName(user.getLastName());
		dto.setLogged(user.isLogged());
		dto.setPassword(user.getPassword());
		
		return dto;
	}
	
	public static List<User> userDTOListToUserlist(List<UserDTO> dtos) {
		
		return dtos.stream().map(dto -> userDTOToUser(dto)).collect(Collectors.toList());
	}
	
	public static List<UserDTO> userListToUserDTOlist(List<User> users) {
		
		return users.stream().map(user -> userToUserDTO(user)).collect(Collectors.toList());
	}


	private UserMapper() {

	}
	
}
