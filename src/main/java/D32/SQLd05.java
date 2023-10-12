--------------DAY'7 NT---------------------
        --29-GROUP BY clause:

        CREATE TABLE manav
        (
        isim varchar(50),
        urun_adi varchar(50),
        urun_miktar int
        );

        INSERT INTO manav VALUES( 'Ali', 'Elma', 5);
        INSERT INTO manav VALUES( 'Ayse', 'Armut', 3);
        INSERT INTO manav VALUES( 'Veli', 'Elma', 2);
        INSERT INTO manav VALUES( 'Hasan', 'Uzum', 4);
        INSERT INTO manav VALUES( 'Ali', 'Armut', 2);
        INSERT INTO manav VALUES( 'Ayse', 'Elma', 3);
        INSERT INTO manav VALUES( 'Veli', 'Uzum', 5);
        INSERT INTO manav VALUES( 'Ali', 'Armut', 2);
        INSERT INTO manav VALUES( 'Veli', 'Elma', 3);
        INSERT INTO manav VALUES( 'Ayse', 'Uzum', 2);


        SELECT * FROM manav;

        --Manav tablosundaki tüm isimleri ve her bir isim için toplam ürün miktarını görüntüleyiniz.

        SELECT isim,SUM(urun_miktar)
        FROM manav
        GROUP BY isim

        --Manav tablosundaki tüm isimleri ve her bir isim için toplam ürün miktarını,
        --toplam ürün miktarına göre AZALAN sıralayınız.

        SELECT isim,SUM(urun_miktar) toplam_kg
        FROM manav
        GROUP BY isim
        ORDER BY SUM(urun_miktar) DESC

        --Her bir ismin aldığı her bir ürünün toplam miktarını isme göre sıralı görüntüleyiniz.
        SELECT isim,urun_adi,SUM(urun_miktar)
        FROM manav
        GROUP BY isim,urun_adi
        ORDER BY isim

        --NOT:group by ile gruplama yapıldığında SELECTden sonra sadece gruplanan sütun adı veya
        --herhangi bir sütunun AGGREGATE fonk. ile kullanımı mümkündür.

        SELECT isim,urun_adi,SUM(urun_miktar)
        FROM manav
        GROUP BY isim--hata verir

        --NOT : GROUP BY dan sonraki sütun sırası önemli, ilk sütundan başlayarak gruplar, AGGREGATE fonk. kullanıldığında
        --en son (en içteki) gruba göre hesaplanır.

        --ürün ismine göre her bir ürünü alan toplam kişi sayısı gösteriniz.
        SELECT urun_adi,COUNT(DISTINCT isim) kisi_sayisi
        FROM manav
        GROUP BY urun_adi

        --Isme göre alınan toplam ürün miktarı ve ürün çeşit miktarını bulunuz
        SELECT isim,SUM(urun_miktar) toplam_kg,COUNT(DISTINCT urun_adi) urun_cesidi
        FROM manav
        GROUP BY isim

        --Alinan ürün miktarina gore musteri sayisinı ,
        --musteri sayisina göre artan sıralayınız.

        SELECT urun_miktar, COUNT(DISTINCT isim) musteri_sayisi
        FROM manav
        GROUP BY urun_miktar
        ORDER BY musteri_sayisi


        --30-HAVING clause:group by komutundan sonra filtrelemek için aggregate fonk ile birlikte kullanılır

        DROP TABLE personel;

        CREATE TABLE personel  (
        id int,
        isim varchar(50),
        sehir varchar(50),
        maas int,
        sirket varchar(20)
        );

        INSERT INTO personel VALUES(123456789, 'Ali Yilmaz', 'Istanbul', 5500, 'Honda');
        INSERT INTO personel VALUES(234567890, 'Veli Sahin', 'Istanbul', 4500, 'Toyota');
        INSERT INTO personel VALUES(345678901, 'Mehmet Ozturk', 'Ankara', 3500, 'Honda');
        INSERT INTO personel VALUES(456789012, 'Mehmet Ozturk', 'Izmir', 6000, 'Ford');
        INSERT INTO personel VALUES(567890123, 'Mehmet Ozturk', 'Ankara', 7000, 'Tofas');
        INSERT INTO personel VALUES(678901245, 'Veli Sahin', 'Ankara', 4500, 'Ford');
        INSERT INTO personel VALUES(123456710, 'Hatice Sahin', 'Bursa', 4500, 'Honda');

        SELECT * FROM personel;

        --Her bir şirketin MIN maas bilgisini, bu bilgi eğer 4000 den fazla ise görüntüleyiniz.

        SELECT sirket,MIN(maas) min_maas
        FROM personel
        GROUP BY sirket
        HAVING MIN(maas)>4000

        --Maaşı 4000 den fazla olan çalışanlardan, her bir şirketin MIN maas bilgisini görüntüleyiniz.
        SELECT sirket, MIN(maas) min_maas
        FROM personel
        WHERE maas>4000
        GROUP BY sirket


        --NOT:gruplama yaptıktan sonra sonuçları filtrelemek için HAVING aggregate fonk ile
        --gruplamadan önce mevcut kayıtları filtrelemek için ise WHERE kullanılır.

        --Her bir ismin aldığı toplam gelir 10000 liradan fazla ise ismi ve toplam maasi gösteren sorgu yaziniz.

        SELECT isim, SUM(maas) toplam_gelir
        FROM personel
        GROUP BY isim
        HAVING SUM(maas)>10000

        --Eğer bir şehirde çalışan personel(id) sayısı 1’den çoksa sehir ismini ve personel sayısını veren sorgu yazınız

        SELECT sehir, COUNT(DISTINCT id) AS personel_sayisi
        FROM personel
        GROUP BY sehir
        HAVING COUNT(DISTINCT id)>1

        --Eğer bir şehirde alınan MAX maas 5000’den düşükse sehir ismini ve MAX maasi veren sorgu yazınız.ÖDEV

        --31-UNION:iki farklı sorgu sonucunu birleştirerek görüntülemeyi sağlar