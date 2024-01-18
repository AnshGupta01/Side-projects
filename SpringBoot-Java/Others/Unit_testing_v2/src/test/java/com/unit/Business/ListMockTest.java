package com.unit.Business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {
    List<String> mock = mock(List.class);
    @Test
    public void size_basic(){
        when(mock.size()).thenReturn(5);
        assertEquals(5,mock.size());
    }
    @Test
    public void returnDifferentValues(){

        //Here first time it returns 5, then the second time it will return 10
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameters(){
        when(mock.get(0)).thenReturn("AnshGupta");
        when(mock.get(1)).thenReturn("Ansh.gupta");
        assertEquals("AnshGupta",mock.get(0));
        assertEquals("Ansh.gupta",mock.get(1));
    }

    @Test
    public void returnGenericParameters(){
        //This is called an Argument Matcher: anyInt()
        //Here at any int the returning value will always be "AnshGupta"
        when(mock.get(anyInt())).thenReturn("AnshGupta");
        assertEquals("AnshGupta",mock.get(0));
        assertEquals("AnshGupta",mock.get(1));
    }

    @Test
    public void verification_testing(){
        String value = mock.get(0);
        String value2 = mock.get(1);

        //Verify to check specific method calling specific values
        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void MultipleArgumentCapturing(){
        //SUT
        mock.add("SomeString1");
        mock.add("SomeString2");

        //Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());
        List<String> allValues = captor.getAllValues();
        assertEquals("SomeString1",allValues.get(0));
        assertEquals("SomeString2",allValues.get(1));
    }

    @Test
    public void mocking(){

        //A mock does not retain behaviour of the original class
        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0)); //null
        System.out.println(arrayListMock.size()); //0
        arrayListMock.add("Test");
        arrayListMock.add("Test1");
        System.out.println(arrayListMock.size()); // still 0 as it is a mock

        //Here it will work
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size()); //5
    }

    @Test
    public void spying(){
        //Basic logic is to let the action be perfomed and then keep a check on it

        //A SPY retains behaviour of the original class
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test0");
        System.out.println(arrayListSpy.get(0)); //null
        System.out.println(arrayListSpy.size()); //0
        arrayListSpy.add("Test1");
        arrayListSpy.add("Test2");
        System.out.println(arrayListSpy.size()); // still 0 as it is a mock

        //Here it will bind it to 5 size
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size()); //5

        //we can also call verify methods here
        arrayListSpy.add("Test4");
        System.out.println(arrayListSpy.size()); //still gives 5
        verify(arrayListSpy).add("Test4");

    }

}
