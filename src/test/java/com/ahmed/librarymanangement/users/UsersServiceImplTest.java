package com.ahmed.librarymanangement.users;

import com.ahmed.librarymanangement.utils.Result;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.BDDMockito;
import static org.mockito.BDDMockito.willReturn;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UsersServiceImplTest {

  @InjectMocks private UsersServiceImpl usersService;

  @Mock private UsersDao usersDao;

  @Before
  public void setUp() {}

  @Test
  public void testGetUserWithUserIdShouldCallMethodGetUsersById() {
    // Given
    willReturn(new Users()).given(usersDao).getUsersById(anyInt());

    // When
    usersService.getUser(1, null);

    // Then
    verify(usersDao, times(1)).getUsersById(anyInt());
  }

  @Test
  public void testGetUserWithCnicShouldCallMethodGetUsersByCnic() {
    // Given
    willReturn(new Users()).given(usersDao).getUsersByCnic(anyString());

    // When
    usersService.getUser(null, "37450123456789");

    // Then
    verify(usersDao, times(1)).getUsersByCnic(anyString());
  }

  @Test
  public void testGetUserWithNullIdAndCnicShouldReturnNullData() {
    //When
    Result result =usersService.getUser(null, null);

    //then
    assertEquals(result.getData(), null);
  }
}
