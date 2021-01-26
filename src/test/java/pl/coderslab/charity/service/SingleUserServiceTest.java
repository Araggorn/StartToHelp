//package pl.coderslab.charity.service;
//
//import org.junit.Before;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.platform.commons.logging.Logger;
//import org.junit.platform.commons.logging.LoggerFactory;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import pl.coderslab.charity.converter.TimeConverter;
//import pl.coderslab.charity.entity.SingleUser;
//import pl.coderslab.charity.repository.SingleUserRepository;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.mock;
//
//class SingleUserServiceTest {
//    private static final Logger log =
//            LoggerFactory.getLogger(SingleUserServiceTest.class);
//
//
//    private SingleUserService service;
//    private SingleUserRepository repository;
//    private PasswordEncoder passwordEncoder;
//
//    @Before
//    public void setUp() {
//        repository = mock(SingleUserRepository.class);
//        service = new SingleUserServiceImpl(repository);
//        passwordEncoder = mock(PasswordEncoder.class);
//
//
//        }
//
//
//    @Test
//    @DisplayName("findByID method test")
//    public void test2() {
//// given
//        SingleUser first = new SingleUser(1L, "Araggorn", "coderslab", TimeConverter.timeNowLong(), TimeConverter.timeNowLong(), null, "olek3lo@o2.pl", true, "system", "Mróz", null);
//// when
//        SingleUser user = service.findById(1L);
//// then
//        assertEquals(first.getId(), user.getId());
//    }
//    @Test
//    @DisplayName("findByID method test 2")
//    public void test3() {
//// given
//        SingleUser first = new SingleUser(1L, "Araggorn", "coderslab", TimeConverter.timeNowLong(), TimeConverter.timeNowLong(), null, "olek3lo@o2.pl", true, "system", "Mróz", null);
//// when
//        SingleUser user = service.findById(1L);
//// then
//        Assertions.assertNotEquals(first.getId(), user.getId());
//    }
//}

