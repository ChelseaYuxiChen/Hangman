package weather;

import java.text.DecimalFormat;

/**
 * A class to do weather forecasting. It calculates the average temperature for the week, the
 * maximum fluctuation in temperature for the week, and generates a weather forecast based on the
 * average temperature. Results are provided in both Celsius and Fahrenheit.
 */
public class WeatherForecast {

  private float[] temperature;

  /**
   * Constructor for the WeatherForecast class.
   *
   * @param monTem Temperature for Monday.
   * @param tueTem Temperature for Tuesday.
   * @param wedTem Temperature for Wednesday.
   * @param thuTem Temperature for Thursday.
   * @param firTem Temperature for Friday.
   * @param satTem Temperature for Saturday.
   * @param sunTem Temperature for Sunday.
   */
  public WeatherForecast(float monTem, float tueTem, float wedTem, float thuTem, float firTem,
                         float satTem, float sunTem) {
    temperature = new float[] {monTem, tueTem, wedTem, thuTem, firTem, satTem, sunTem};
  }

  /**
   * Calculates the average temperature for the week in degrees Celsius. The result is rounded to
   * two decimal places.
   *
   * @return the average temperature for the week
   */
  public float calculateAverageTemperatureInCelsius() {
    float sum = 0;
    for (int i = 0; i < temperature.length; i++) {
      sum = temperature[i] + sum;
    }
    float averageTemperatureInCelsius = sum / temperature.length;
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    return Float.valueOf(decimalFormat.format(averageTemperatureInCelsius));
  }

  /**
   * Calculates the average temperature for the week in degrees Fahrenheit. The result is rounded to
   * two decimal places.
   *
   * @return the average temperature for the week
   */
  public float calculateAverageTemperatureInFahrenheit() {
    float sum = 0;
    for (int i = 0; i < temperature.length; i++) {
      sum = temperature[i] + sum;
    }
    float averageTemperatureInFahrenheit = (sum * 9 / 5) / temperature.length + 32;
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    return Float.valueOf(decimalFormat.format(averageTemperatureInFahrenheit));
  }

  /**
   * Calculates the maximum fluctuation in temperature for the week in degrees Celsius. The
   * fluctuation is the difference between the highest and lowest temperatures for two consecutive
   * days. The result is rounded to two decimal places.
   *
   * @return the maximum fluctuation in temperature for the week
   */
  public float calculateMaxFluctuationInCelsius() {
    float[] difference = new float[6];
    float maxFluctuationInCelsius = 0;
    int i;
    for (i = 0; i < (temperature.length - 1); i++) {
      difference[i] = Math.abs(temperature[i] - temperature[i + 1]);
      if (maxFluctuationInCelsius < difference[i]) {
        maxFluctuationInCelsius = difference[i];
      }
    }
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    return Float.valueOf(decimalFormat.format(maxFluctuationInCelsius));
  }

  /**
   * Calculates the maximum fluctuation in temperature for the week in degrees Fahrenheit. The
   * fluctuation is the difference between the highest and lowest temperatures for two consecutive
   * days. The result is rounded to two decimal places.
   *
   * @return the maximum fluctuation in temperature for the week
   */
  public float calculateMaxFluctuationInFahrenheit() {
    float maxFluctuationInFahrenheit;
    if (this.calculateMaxFluctuationInCelsius() == 0) {
      return maxFluctuationInFahrenheit = 0.00f;
    } else {
      maxFluctuationInFahrenheit = this.calculateMaxFluctuationInCelsius() * 9 / 5;
      DecimalFormat decimalFormat = new DecimalFormat("#.##");
      return Float.valueOf(decimalFormat.format(maxFluctuationInFahrenheit));
    }
  }

  /**
   * Generates a weather forecast based on the average temperature for the week.
   *
   * @return a weather forecast
   */
  public String generateForecast() {
    if (this.calculateAverageTemperatureInCelsius() < 0) {
      return "High risk of frost. Take precautions.";
    } else if (this.calculateAverageTemperatureInCelsius() <= 15) {
      return "Generally cool. Dress in layers.";
    } else if (this.calculateAverageTemperatureInCelsius() <= 25) {
      return "Mild conditions. Enjoy outdoor activities.";
    } else {
      return "Warm weather. Stay hydrated.";
    }
  }

  /**
   * Returns a string representation of the weather data.
   *
   * @return a string representation of the weather data.
   */
  @Override
  public String toString() {
    return String.format(
        "Average temperature: %.2f°C, %.2f°F\nMax fluctuation: %.2f°C, %.2f°F\nForecast: %s",
        this.calculateAverageTemperatureInCelsius(),
        this.calculateAverageTemperatureInFahrenheit(),
        this.calculateMaxFluctuationInCelsius(),
        this.calculateMaxFluctuationInFahrenheit(),
        this.generateForecast());
  }

  /**
   * The main method to test the WeatherForecast class.
   * Creates an instance of WeatherForecast with sample data and prints its string representation.
   *
   * @param args the command-line arguments (not used in this method)
   */
  public static void main(String[] args) {
    WeatherForecast weatherTest =
        new WeatherForecast(20.5f, 21.5f, 22.5f, 23f, 24.5f, 25f, 29.5f);
    System.out.println(weatherTest);
  }
}