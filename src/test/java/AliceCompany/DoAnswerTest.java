package AliceCompany;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class DoAnswerTest {
    @Mock
    List mockList;

    @Test
    public void whenMockAnnotation() {
        Mockito.doAnswer(invocation -> {
            int parameter = invocation.getArgument(0);
            return parameter * parameter;
        }).when(mockList).get(anyInt());

        assertEquals(100, mockList.get(10));
        assertEquals(25, mockList.get(5));
    }
}
