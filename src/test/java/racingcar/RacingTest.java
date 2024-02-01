package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class RacingTest {
    private static final int FORWARD_THRESHOLD = 4;
    @Test
    void 자동차_등록_테스트() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("test"));
        Car firstCar = cars.get(0);
        assertThat(firstCar.getName()).isEqualTo("test");
    }

    @Test
    void 경주_진행시_자동차_이동_테스트() {
        ArrayList<Car> cars = new ArrayList<>();
        for(int i=0; i<10; i++) {
            cars.add(new Car("test"));
            cars.get(i).move(FORWARD_THRESHOLD);
            assertThat(cars.get(i).getMoveDistance()).isEqualTo(1);
        }
    }

    @Test
    void 우승자_선정_결과_테스트() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("test1"));
        cars.add(new Car("test2"));
        cars.add(new Car("test3"));
        cars.get(0).move(FORWARD_THRESHOLD);
        cars.get(1).move(FORWARD_THRESHOLD);
        ArrayList<String> winners = RacingGameManager.findWinner(cars);
        assertThat(winners).containsExactly("test1", "test2");
    }
}
