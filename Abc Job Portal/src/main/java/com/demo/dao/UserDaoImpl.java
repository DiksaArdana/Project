/*
 * package com.demo.dao;
 * 
 * import java.sql.ResultSet; import java.sql.SQLException; import
 * java.util.List;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.dao.DataAccessException; import
 * org.springframework.jdbc.core.JdbcTemplate; import
 * org.springframework.jdbc.core.ResultSetExtractor; import
 * org.springframework.jdbc.core.RowMapper;
 * 
 * import com.demo.model.User; import com.demo.model.UserDto;
 * 
 * public class UserDaoImpl implements UserDao {
 * 
 * @Autowired JdbcTemplate jdbcTemplate;
 * 
 * public int register(User user) { String sql =
 * "insert into users (firstName,lastName,email,pass,role) values(?,?,?,?,DEFAULT)"
 * ;
 * 
 * //return the query with the user object return jdbcTemplate.update(sql, new
 * Object[] { user.getFirstName(), user.getLastName(), user.getEmail(),
 * user.getPass()}); }
 * 
 * public User login(UserDto loginDto) { //query to search user with given email
 * and password String selectQuery = "Select * from users where email = '" +
 * loginDto.getEmailId() + "' and pass = '" + loginDto.getPassword() + "'";
 * 
 * //this time we use ResultSetExtractor, another way of mapping than RowMapper
 * User response = jdbcTemplate.query(selectQuery, new
 * ResultSetExtractor<User>() { //need to implement the ResultSet to extract the
 * data public User extractData(ResultSet rs) throws SQLException,
 * DataAccessException { //if found the record, return the user object if
 * (rs.next()) { User user = new User(); user.setUserID(rs.getLong("userID"));
 * user.setFirstName(rs.getString("firstName"));
 * user.setLastName(rs.getString("lastName"));
 * user.setEmail(rs.getString("email")); user.setPass(rs.getString("pass"));
 * user.setAddress(rs.getString("address"));
 * user.setWorkexp(rs.getString("workexp"));;
 * user.setEducation(rs.getString("education"));
 * user.setCerificate(rs.getString("cerificate"));
 * user.setSkill(rs.getString("skill")); user.setRole(rs.getInt("role")); return
 * user; } //else return null object return null; } });
 * System.out.println(response); return response; } // for user update their own
 * profile public int updateProfile(User user) {
 * 
 * String sql =
 * "update users set firstName=?,lastName=?,address=?,workexp=?,education=?,cerificate=?,skill=? where userID=?"
 * ;
 * 
 * try { int counter = jdbcTemplate.update(sql, new Object[] {
 * user.getFirstName(), user.getLastName(),user.getAddress()
 * ,user.getWorkexp(),user.getEducation(),user.getCerificate(),user.getSkill(),
 * user.getUserID() });
 * 
 * return counter;
 * 
 * } catch (Exception e) { e.printStackTrace(); return 0; } } //for Admin update
 * user data public int updateUser(User user) {
 * 
 * //prepare the query String sql =
 * "update users set firstName=?,lastName=?,email=?,pass=?,address=?,workexp=?,education=?,cerificate=?,skill=? where userID=?"
 * ;
 * 
 * //try to execute the query with the user object try { int counter =
 * jdbcTemplate.update(sql, new Object[] { user.getFirstName(),
 * user.getLastName(), user.getEmail(), user.getPass(),user.getAddress()
 * ,user.getWorkexp(),user.getEducation(),user.getCerificate(),user.getSkill(),
 * user.getUserID() });
 * 
 * return counter;
 * 
 * } catch (Exception e) { e.printStackTrace(); return 0; } }
 * 
 * public long deleteUser(long id) {
 * 
 * //delete record in database using paramater id String sql
 * ="DELETE FROM `users` WHERE `userID`=?"; return jdbcTemplate.update(sql, id);
 * }
 * 
 * public List<User> searchUser(String inp) {
 * 
 * //query search person with input parameter where it could be in some column
 * String selectQuery = "Select * from users where '" + inp +
 * "' IN(firstName, lastName)"; //this time we mapped it separately by calling
 * the custom class that implement RowMapper class List<User> data =
 * jdbcTemplate.query(selectQuery, new UserMapper()); return data;
 * 
 * }
 * 
 * 
 * public List<User> findUserById(long id) {
 * 
 * //query from database with parameter to find user by their id List<User>
 * userList = jdbcTemplate.query("SELECT * FROM users where userID=?", new
 * Object[] { id }, new RowMapper<User>() {
 * 
 * public User mapRow(ResultSet rs, int rowNum) throws SQLException { User user
 * = new User();
 * 
 * user.setUserID(rs.getLong("userID"));
 * user.setFirstName(rs.getString("firstName"));
 * user.setLastName(rs.getString("lastName"));
 * user.setEmail(rs.getString("email"));
 * user.setAddress(rs.getString("address"));
 * user.setWorkexp(rs.getString("workexp"));;
 * user.setEducation(rs.getString("education"));
 * user.setCerificate(rs.getString("cerificate"));
 * user.setSkill(rs.getString("skill"));
 * 
 * return user; }
 * 
 * }); return userList; }
 * 
 * list all user from database to show in dashboard
 * 
 * public List<User> showAllUsers() { //query from database and store it List
 * array List<User> userList = jdbcTemplate.query("SELECT * FROM users", new
 * RowMapper<User>() {
 * 
 * //using row mapper to mapped the column with the object public User
 * mapRow(ResultSet rs, int rowNum) throws SQLException { User user = new
 * User();
 * 
 * user.setUserID(rs.getLong("userID"));
 * user.setFirstName(rs.getString("firstName"));
 * user.setLastName(rs.getString("lastName"));
 * user.setEmail(rs.getString("email"));
 * user.setAddress(rs.getString("address"));
 * user.setWorkexp(rs.getString("workexp"));;
 * user.setEducation(rs.getString("education"));
 * user.setCerificate(rs.getString("cerificate"));
 * user.setSkill(rs.getString("skill")); user.setRole(rs.getInt("role"));
 * 
 * return user; } }); return userList; }
 * 
 * @Override public int resetPassword(UserDto userDto) { //prepare the query
 * String sql = "update users set pass=? where email=?";
 * 
 * //try to execute the query with the user object try { int counter =
 * jdbcTemplate.update(sql, new Object[] {userDto.getPassword(),
 * userDto.getEmailId() });
 * 
 * return counter;
 * 
 * } catch (Exception e) { e.printStackTrace(); return 0; } }
 * 
 * @Override public UserDto findByEmail(String email) { // UserDto userList =
 * jdbcTemplate.query("SELECT * FROM users where email=?", new Object[] { email
 * }); // //new UserDtoMapper());
 * 
 * String selectQuery = "SELECT * FROM users where email='" + email + "'";
 * UserDto response = jdbcTemplate.query(selectQuery, new
 * ResultSetExtractor<UserDto>(){ public UserDto extractData(ResultSet rs)
 * throws SQLException, DataAccessException { //if found the record, return the
 * user object if (rs.next()) { UserDto user = new UserDto();
 * user.setEmailId(rs.getString("email")); return user; } //else return null
 * object return null; } }); return response; }
 * 
 * @Override public int resetTokenPassword(UserDto userDto) { //prepare the
 * query String sql = "update users set reset_password_token=? where email=?";
 * //try to execute the query with the user object try { int counter =
 * jdbcTemplate.update(sql, new Object[] {userDto.getResetPasswordToken(),
 * userDto.getEmailId() });
 * 
 * return counter;
 * 
 * } catch (Exception e) { e.printStackTrace(); return 0; } }
 * 
 * @Override public UserDto findByResetTokenPassword(String token) { String
 * selectQuery = "SELECT * FROM users where reset_password_token='" + token +
 * "'"; UserDto response = jdbcTemplate.query(selectQuery, new
 * ResultSetExtractor<UserDto>(){ public UserDto extractData(ResultSet rs)
 * throws SQLException, DataAccessException { //if found the record, return the
 * user object if (rs.next()) { UserDto user = new UserDto();
 * user.setResetPasswordToken(rs.getString("reset_password_token"));
 * user.setEmailId(rs.getString("email")); return user; } //else return null
 * object return null; } }); return response; } }
 * 
 * 
 * the custom class implement of RowMapper
 * 
 * class UserMapper implements RowMapper<User> {
 * 
 * public User mapRow(ResultSet rs, int arg1) throws SQLException { User user =
 * new User();
 * 
 * user.setUserID(rs.getLong("userID"));
 * user.setFirstName(rs.getString("firstName"));
 * user.setLastName(rs.getString("lastName"));
 * user.setEmail(rs.getString("email")); user.setPass(rs.getString("pass"));
 * user.setAddress(rs.getString("address"));
 * user.setWorkexp(rs.getString("workexp"));;
 * user.setEducation(rs.getString("education"));
 * user.setCerificate(rs.getString("cerificate"));
 * user.setSkill(rs.getString("skill")); user.setRole(rs.getInt("role")); return
 * user; }
 * 
 * }
 * 
 * class UserDtoMapper implements RowMapper<UserDto> {
 * 
 * public UserDto mapRow(ResultSet rs, int arg1) throws SQLException { UserDto
 * user = new UserDto();
 * 
 * user.setEmailId(rs.getString("email"));
 * user.setPassword(rs.getString("pass")); user.getResetPasswordToken(); return
 * user; }
 * 
 * }
 * 
 */