package AliceCompany;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
class VerifyTest {
    @Mock
    List<String> mockList;

    @Test
    public void whenMockAnnotation() {
        //вызов метода
        String name = mockList.get(10);

        //проверяем вызывался ли метод
        Mockito.verify(mockList).get(10);
    }

    @Test
    public void whenMockAnnotationVerifyPlentyTimes() {
        //вызов метода
        String name1 = mockList.get(1);  //вызов метода
        String name2 = mockList.get(2);  //вызов метода
        String name3 = mockList.get(3);  //вызов метода

        //проверяем вызывался ли метод
        Mockito.verify(mockList, Mockito.times(3)).get(anyInt());
    }
}
