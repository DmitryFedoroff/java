public class Converter {
    static int convertToKm(int steps) {
        return (steps * 75) / 100000; // Преобразование шагов в км, учитывая, что 1 шаг = 75 см
    }

    static int convertStepsToKilocalories(int steps) {
        return (steps * 50) / 1000; // Преобразование шагов в килокалории, учитывая, что 1 шаг = 50 калорий
    }
}
