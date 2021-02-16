# openweather-api
Using [OpenWeather API](https://openweathermap.org/api) to fetch current weather info.

* Deployed to Heroku:
You can visit the site without cloning the repository. Link: https://rt-weather.herokuapp.com/

# How to install:

1. First you need to get the API Key from OpenWeather.
2. Clone this repo. In terminal:
````
git clone https://github.com/ritish78/openweather-api.git
````

Then, open in IDE of your choice. Then in terminal of IDE:
````
mvn clean install
````
3. Then add the key in [application.properties](https://github.com/ritish78/openweather-api/blob/master/src/main/resources/application.properties)

After maven loads changes, then you can start the Spring Boot Application.
To do so, in terminal enter:
````
mvn spring-boot:run
````

Tomcat should start the server in Port `8000`.


# Usage:

1. In browser, go to the url: [http://localhost:8000/search](http://localhost:8000/search).
2. You can get weather info by searching city name.
![1  Get weather by city name](https://user-images.githubusercontent.com/36816476/106403518-381f4980-6483-11eb-83c3-76f869f8f707.PNG)

3. Then the weather info for the city loads up
![2  Weather for city loads up](https://user-images.githubusercontent.com/36816476/106403536-5127fa80-6483-11eb-8f12-fff71c563a6d.PNG)

4. You can also get weather info by zip code and country code.
![3  Getting weather by zip code](https://user-images.githubusercontent.com/36816476/106403571-7a488b00-6483-11eb-9c97-130fac44da6e.PNG)

5. Then the weather info for the city by zip code loads up
![4  Weather for zip code loads up](https://user-images.githubusercontent.com/36816476/106403579-86344d00-6483-11eb-843f-337d0c9d6246.PNG)

6. You can also use Postman or other client to fetch from api. It will return back JSON of weather info.
![5  Using Postman to fetch from API for city](https://user-images.githubusercontent.com/36816476/106403633-c4317100-6483-11eb-8efd-28c6cfc38f36.PNG)
