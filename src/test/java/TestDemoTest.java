import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoTest {
	
	private TestDemo testDemo = new TestDemo(); // creating local instance variable
	
	public static Stream<Arguments>argumentsForAddPositive() {
		return Stream.of(
				Arguments.of(2, 4, 6, false),
				Arguments.of(5, 5, 10, false),
				Arguments.of(0, 4, 6, true),
				Arguments.of(-3, 4, 0, true),
				Arguments.of(-3, 4, 0, false)
				);
	}
	

	@BeforeEach
	void setUp() throws Exception {
	}

	@ParameterizedTest
	@MethodSource ("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectFailure) { //expect failure true, don't expect false
		if(!expectFailure) {
			  assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else{ 
			assertThatThrownBy(() -> 
			 testDemo.addPositive(a, b))
	        .isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
	
	
	
} // end of testdemotest
