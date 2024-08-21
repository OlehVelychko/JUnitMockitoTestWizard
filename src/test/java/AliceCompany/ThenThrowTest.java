package AliceCompany;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ThenThrowTest {
    @Mock
    List mockList;

    @Test
    public void whenMockAnnotation() {
        //задаем поведение метода (нужно только для демонстрации)
        Mockito.when(mockList.size()).thenThrow(IllegalStateException.class);

        //проверяем бросится ли IllegalStateException при вызове метода size
        assertThrows(IllegalStateException.class, () -> mockList.size());
    }
}
