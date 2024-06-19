import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import weather.WeatherForecast;

/**
 * Created by Chelsea on 2024-05-24.
 * Test class for the WeatherForecast class.
 */
public class WeatherForecastTest {

  private WeatherForecast weatherForecastTest;
  private WeatherForecast weatherForecastTestZeroCase;

  /**
   * Sets up the test fixture.
   */
  @Before
  public void setUp() {
    weatherForecastTest = new WeatherForecast(20.5f, 21.5f, 22.5f, 23f, 24.5f, 25f, 29.5f);
    weatherForecastTestZeroCase = new WeatherForecast(20f, 20f, 20f, 20f, 20f, 20f, 20f);

  }

  /**
   * Tests the calculateAverageTemperatureInCelsius method.
   * Verifies that the method correctly calculates the average temperature in Celsius.
   */
  @Test
  public void calculateAverageTemperatureInCelsius() {
    assertEquals(23.79f, weatherForecastTest.calculateAverageTemperatureInCelsius(), 0.0f);
  }

  /**
   * Tests the calculateAverageTemperatureInFahrenheit method.
   * Verifies that the method correctly calculates the average temperature in Fahrenheit.
   */
  @Test
  public void calculateAverageTemperatureInFahrenheit() {
    assertEquals(74.81f, weatherForecastTest.calculateAverageTemperatureInFahrenheit(), 0.0);
  }

  /**
   * Tests the calculateMaxFluctuationInCelsius method.
   * Verifies that the method correctly calculates the maximum temperature fluctuation in Celsius.
   */
  @Test
  public void calculateMaxFluctuationInCelsius() {
    assertEquals(4.50f, weatherForecastTest.calculateMaxFluctuationInCelsius(), 0.0);
  }

  /**
   * Tests the calculateMaxFluctuationInFahrenheit method.
   * Verifies that the method correctly calculates the maximum
   * temperature fluctuation in Fahrenheit.
   */
  @Test
  public void calculateMaxFluctuationInFahrenheit() {
    assertEquals(8.10f, weatherForecastTest.calculateMaxFluctuationInFahrenheit(), 0.0);
    assertEquals(0.00f, weatherForecastTestZeroCase.calculateMaxFluctuationInFahrenheit(), 0.0);
  }

  /**
   * Tests the generateForecast method.
   * Verifies that the method correctly generates the forecast based on the average temperature.
   */
  @Test
  public void generateForecast() {
    assertEquals("Mild conditions. Enjoy outdoor activities.",
        weatherForecastTest.generateForecast());
  }

  /**
   * Tests the toString method.
   * Verifies that the method correctly generates the string representation
   * of the WeatherForecast instance.
   */
  @Test
  public void testToString() {
    assertEquals("Average temperature: 23.79°C, 74.81°F\n"
        + "Max fluctuation: 4.50°C, 8.10°F\n"
        + "Forecast: Mild conditions. Enjoy outdoor activities.", weatherForecastTest.toString());
  }
}