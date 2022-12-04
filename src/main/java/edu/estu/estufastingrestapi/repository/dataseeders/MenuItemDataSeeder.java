package edu.estu.estufastingrestapi.repository.dataseeders;

import edu.estu.estufastingrestapi.core.repository.dataseeders.abstracts.BaseDataSeeder;
import edu.estu.estufastingrestapi.entities.concretes.MenuItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MenuItemDataSeeder extends BaseDataSeeder<MenuItem, UUID> {

    @Override
    public int getOrder() {
        return 20;
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Override
    public void setData() {
        data.add(new MenuItem(null, "Baklava", 300));
        data.add(new MenuItem(null, "Kremalı Mantar Çorba", 100));
        data.add(new MenuItem(null, "Mamatoğlu Tavuk", 10));
        data.add(new MenuItem(null, "Soslu Spagetti", 5));
        data.add(new MenuItem(null, "Sütlü İrmik Tatlısı", 20));
        data.add(new MenuItem(null, "Et Suyu Çorba", 40));
        data.add(new MenuItem(null, "Nohut Yemeği", 31));
        data.add(new MenuItem(null, "Pirinç Pilavı", 40));
        data.add(new MenuItem(null, "Mevsim Salata", 25));
        data.add(new MenuItem(null, "Tarhana Çorba", 55));
        data.add(new MenuItem(null, "Fırın Köfte", 200));
        data.add(new MenuItem(null, "Arpa Şehriye Pilavı", 300));
        data.add(new MenuItem(null, "Yoğurt", 300));
        data.add(new MenuItem(null, "Mercimek Çorbası", 200));
        data.add(new MenuItem(null, "Taze Fasulye", 100));
        data.add(new MenuItem(null, "Bulgur Pilavı", 35));
        data.add(new MenuItem(null, "Basma Kadayıf", 45));
        data.add(new MenuItem(null, "Yoğurt Çorba", 55));
        data.add(new MenuItem(null, "Etli Kuru Fasulye", 65));
        data.add(new MenuItem(null, "Üç Renkli Salata", 10));
        data.add(new MenuItem(null, "Tel Şehriye Çorba", 45));
        data.add(new MenuItem(null, "Piliç Kavurma", 50));
        data.add(new MenuItem(null, "Ayran", 300));
        data.add(new MenuItem(null, "Elma", 300));
        data.add(new MenuItem(null, "Ezogelin Çorba", 500));
        data.add(new MenuItem(null, "Ekşili Pırasa Yemeği", 300));
        data.add(new MenuItem(null, "Erişte", 200));
        data.add(new MenuItem(null, "Sütlaç", 300));
        data.add(new MenuItem(null, "Havuç Çorba", 300));
        data.add(new MenuItem(null, "Rosto Köfte", 300));
        data.add(new MenuItem(null, "Soslu Bocuk Makarna", 300));
        data.add(new MenuItem(null, "Meyve", 300));
        data.add(new MenuItem(null, "Patlıcan Musakka", 300));
        data.add(new MenuItem(null, "Melek Pilavı", 300));
        data.add(new MenuItem(null, "Ezogelin Çorbası", 300));
    }

}
