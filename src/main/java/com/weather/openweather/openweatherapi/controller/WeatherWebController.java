package com.weather.openweather.openweatherapi.controller;

import com.weather.openweather.openweatherapi.exception.LocationNotFoundException;
import com.weather.openweather.openweatherapi.model.WeatherObject;
import com.weather.openweather.openweatherapi.model.WeatherResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class WeatherWebController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Value("${API_KEY}")
    private String API_KEY;

    Logger webLogger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(path = "/")
    public String getIndexPage() {
        return "redirect:/search";
    }

    @GetMapping(path = "/search")
    public String showWeatherInfoPage() {
        return "index";
    }

    @PostMapping(value = "/search", params = "city")
    public ModelAndView postWeatherInfoByCity(@RequestParam("city") String cityName, Model model) {
        String uriOfApi = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&APPID=" + API_KEY +
                "&units=metric";

        ModelAndView weatherInfo = getWeatherInfo(uriOfApi, model);
        return weatherInfo;
    }

    @PostMapping(value = "/search", params = {"zip", "country"})
    public ModelAndView postWeatherInfoByZipCountry(@RequestParam("zip") Long zip, @RequestParam("country") String country, Model model) {
        String uriOfApi = "https://api.openweathermap.org/data/2.5/weather?zip=" + zip + "," + country + "&APPID=" +
                API_KEY + "&units=metric";
        ModelAndView weatherInfo = getWeatherInfo(uriOfApi, model);
        return weatherInfo;
    }



    @GetMapping(path = "/weather/city/{cityName}")
    public ModelAndView getWeatherForCity(@PathVariable String cityName, Model model) {
        String uriOfApi = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&APPID=" + API_KEY +
                "&units=metric";

        ModelAndView weatherInfo = getWeatherInfo(uriOfApi, model);
        return weatherInfo;
    }




    @GetMapping(path = "/weather/{country}/{zip}")
    public ModelAndView getWeatherByZip(@PathVariable String country, @PathVariable Integer zip, Model model) {
        String uriOfApi = "https://api.openweathermap.org/data/2.5/weather?zip=" + zip + "," + country + "&APPID=" +
                API_KEY + "&units=metric";

        ModelAndView weatherInfo = getWeatherInfo(uriOfApi, model);
        return weatherInfo;
    }



    public ModelAndView getWeatherInfo(String uriOfApi, Model model) {
        try {
            //Getting the value from the API and assigning it to WeatherObject
            WeatherObject weather = webClientBuilder.build()
                    .get()
                    .uri(uriOfApi)
                    .retrieve()
                    .bodyToMono(WeatherObject.class)
                    .block();

            webLogger.info("Received Weather info from: " + uriOfApi);

            //Creating a response handler to send weather info
            WeatherResponseHandler responseHandler = new WeatherResponseHandler();

            /**
             * Again, same for getting the temperatures. The values are inside Hash Map of
             * 'main' which has key temp, feels_like, temp_min, temp_max, pressure and  humidity
             */
            Map<String, String> mainMap = weather.getMain();
            for (Map.Entry<String, String> entry : mainMap.entrySet()) {
                if (entry.getKey().equals("temp")) {
                    responseHandler.setTemperature(Double.parseDouble(entry.getValue()));
                }
                if (entry.getKey().equals("feels_like")) {
                    responseHandler.setFeelsLike(Double.parseDouble(entry.getValue()));
                }
                if (entry.getKey().equals("pressure")) {
                    responseHandler.setPressure(Double.parseDouble(entry.getValue()));
                }
                if (entry.getKey().equals("humidity")) {
                    responseHandler.setHumidity(Double.parseDouble(entry.getValue()));
                }
            }
            /**
             * We get the response of Weather with 13 key values of JSON object. One of
             * which is 'weather' which contains id, main, description and icon inside
             * a hash map. So, we are checking if the key 'main' matches so, we are
             * assigning the value to the responseHandler.
             */
            Map<String, String> weatherMap = weather.getWeather().get(0);
            for (Map.Entry<String, String> entry : weatherMap.entrySet()) {
                if (entry.getKey().equals("main")) {
                    responseHandler.setMain(entry.getValue());
                } else if (entry.getKey().equals("description")) {
                    responseHandler.setDescription(entry.getValue());
                }
            }


            /**
             * Now, for wind, we have speed and deg
             */
            Map<String, String> windMap = weather.getWind();
            for (Map.Entry<String, String> entry : windMap.entrySet()) {
                if (entry.getKey().equals("speed")) {
                    responseHandler.setWindSpeed(Double.parseDouble(entry.getValue()));
                }
            }

            /**
             * Now, for getting Country, we have type, id, country, sunrise and sunset inside 'sys'
             */
            Map<String, String> sysMap = weather.getSys();
            for (Map.Entry<String, String> entry : sysMap.entrySet()) {
                if (entry.getKey().equals("country")) {
                    responseHandler.setCountry(entry.getValue());
                }
            }

            responseHandler.setTimeZone(weather.getTimezone());
            responseHandler.setCity(weather.getName());

            List<WeatherResponseHandler> listWeatherObject = new ArrayList<>();

            ModelAndView modelAndView = new ModelAndView();
            listWeatherObject.add(responseHandler);
            modelAndView.addObject("weatherObject", listWeatherObject);
            modelAndView.setViewName("weatherinfo");

            model.addAttribute("cityName", weather.getName() + ", " + responseHandler.getCountry());

            return modelAndView;

        } catch (WebClientRequestException exception) {
            webLogger.error("Couldn't receive Weather! Please check the url! : " + uriOfApi);
            throw new LocationNotFoundException("Couldn't connect to database! Check connection!");
        }
    }
}
