package com.example.ex6;

import java.util.ArrayList;
import java.util.List;

public class News {
    private String title;
    private float rating;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public News(String title, float rating, String url) {
        this.title = title;
        this.rating = rating;
        this.url=url;
    }

    public News() {
    }

    public List<News> loadNews(){
        List<News> newsList=new ArrayList<>();
        newsList.add(new News("Брауни (brownie)",(float)4.6,"https://eda.ru/recepty/vypechka-deserty/brauni-brownie-20955"));
        newsList.add(new News("Сырники из творога",(float)4.5,"https://eda.ru/recepty/zavtraki/sirniki-iz-tvoroga-18506"));
        newsList.add(new News("Спагетти карбонара с красным луком",(float)4.6,"https://eda.ru/recepty/pasta-picca/spagetti-karbonara-s-krasnym-lukom-17614"));
        newsList.add(new News("Лазанья классическая с мясом",(float)4.5,"https://eda.ru/recepty/pasta-picca/lazanja-klassicheskaja-s-mjasom-31799"));
        newsList.add(new News("Американский тыквенный пирог с корицей",(float)4.4,"https://eda.ru/recepty/vypechka-deserty/amerikanskij-tikvennij-pirog-s-koricej-18811"));
        newsList.add(new News("Цветаевский яблочный пирог",(float)4.6,"https://eda.ru/recepty/vypechka-deserty/cvetaevskij-jablochnij-pirog-15574"));
        newsList.add(new News("Американские блины",(float)4.6,"https://eda.ru/recepty/zavtraki/amerikanskie-bliny-30600"));
        newsList.add(new News("Курица «Пикассо»",(float)4.5,"https://eda.ru/recepty/osnovnye-blyuda/kurica-pikasso-25902"));
        newsList.add(new News("Брускетта с помидорами",(float)4.7,"https://eda.ru/recepty/zakuski/brusketta-s-pomidorami-29566"));
        newsList.add(new News("Фриттата с брокколи и сладким перцем",(float)4.6,"https://eda.ru/recepty/zavtraki/frittata-s-brokkoli-sladkim-percem-17602"));
        newsList.add(new News("Суп вишисуаз",(float)4.7,"https://eda.ru/recepty/supy/sup-vishisuaz-15880"));
        newsList.add(new News("Томатный магрибский суп",(float)4.5,"https://eda.ru/recepty/supy/tomatnij-magribskij-sup-15584"));
        newsList.add(new News("Гуакамоле",(float)4.5,"https://eda.ru/recepty/zakuski/guakamole-30239"));
        newsList.add(new News("Медовик",(float)4.6,"https://eda.ru/recepty/vypechka-deserty/medovik-46974"));
        newsList.add(new News("Чечевичный суп с мятой",(float)4.8,"https://eda.ru/recepty/supy/chechevichnij-sup-s-mjatoj-27007"));

        return newsList;
    }
}
