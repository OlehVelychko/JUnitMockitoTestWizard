package AliceCompany;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DoThrowTest {
    @Mock
    List mockList;

    @Test
    public void whenMockAnnotation() {
        Mockito.when(mockList.size()).thenThrow(IllegalStateException.class);
        mockList.size(); // тут кинется исключение
    }
}
