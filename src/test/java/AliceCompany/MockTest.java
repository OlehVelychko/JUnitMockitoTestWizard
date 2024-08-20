package AliceCompany;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MockTest {
    @Mock
    List mockList;

    @Test
    public void whenNotUseMockAnnotation_thenCorrect() {
        // эти методы не будут ничего делать – это заглушки
        mockList.add("aaa");
        mockList.add("bbb");
        mockList.forEach(System.out::println);
    }
}