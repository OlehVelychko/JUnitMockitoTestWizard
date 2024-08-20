package AliceCompany;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ParamsTest {
    @Mock
    List mockList;

    @Test
    public void whenMockAnnotation() {
        // добавление первого правила
        Mockito.doReturn("Иван").when(mockList).get(10);
        // добавление второго правила
        Mockito.doReturn("Марья").when(mockList).get(500);

        assertEquals("Иван", mockList.get(10));
        assertEquals("Марья", mockList.get(500));
    }
}
