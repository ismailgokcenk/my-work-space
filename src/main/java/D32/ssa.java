package D32;

public class ssa {

    --------------DAY'4 NT-------------------
            --23-ALIASES  : Etiket/Rumuz : tablo veya sütunlara gecici isimler verebiliriz.

    CREATE TABLE workers(
            calisan_id char(9),
    calisan_isim varchar(50),
    calisan_dogdugu_sehir varchar(50)
);

    INSERT INTO workers VALUES(123456789, 'Ali Can', 'Istanbul');
    INSERT INTO workers VALUES(234567890, 'Veli Cem', 'Ankara');
    INSERT INTO workers VALUES(345678901, 'Mine Bulut', 'Izmir');

    SELECT * FROM workers;

    SELECT calisan_id AS id  FROM workers;  --sütunun ismi degismedi sadece id olarak goruntuledik
    SELECT calisan_id FROM workers;  --bu da aynı sonucu verir

    SELECT calisan_id || ' - ' || calisan_isim AS id_and_isim FROM workers;  -- || ile biriki sütunu birleştiriyoruz
																			--  ' - ' || ile bosluk koyuyoruz

    SELECT * FROM workers AS w ; -- best practis kısaltmada ilk harf. aynı harfle baska tabloalr varsa bir kaç harf ile kısaltılır




--24-SUBQUERY--NESTED QUERY

--24-a-SUBQUERY: WHERE ile kullanımı

    SELECT *FROM calisanlar3; -- onceki derslte olusturdugumuz tablo 3.günde
    SELECT * FROM markalar ;  -- onceki derslte olusturdugumuz tablo 3.günde

--marka_id si 100 olan markada çalışanları listeleyiniz.
            --1.yol)
    SELECT marka_isim FROM markalar WHERE marka_id=100; --Vakko

    SELECT * FROM calisanlar3 WHERE isyeri='Vakko';


--2.yol)  bu yol daha dinamik
    SELECT * FROM calisanlar3 WHERE isyeri = (SELECT marka_isim FROM markalar WHERE marka_id=100);  --parantez ici ile daha dinamik yaptık
		--OUTERQUERY							-- BURASI ALT SORGU --> SUBQUERY


--INTERVIEW QUESTION:calisanlar3 tablosunda max maaşı alan çalışanın tüm fieldlarını listeleyiniz.
            SELECT * FROM calisanlar3  WHERE maas = (SELECT MAX(maas) FROM calisanlar3);

    SELECT MAX(maas) FROM calisanlar3; -- bu max maası veriyor


--Interview Question:calisanlar3 tablosunda ikinci en yüksek maaşı gösteriniz.ÖDEV

    SELECT MAX(maas)
    FROM calisanlar3
    WHERE maas<(SELECT MAX(maas) FROM calisanlar3)


            --calisanlar3 tablosunda ikinci en yüksek maaşı alan çalışanı gösteriniz.
            SELECT *
    FROM calisanlar3
    WHERE maas=(SELECT MAX(maas)
    FROM calisanlar3
    WHERE maas<(SELECT MAX(maas)
    FROM calisanlar3))



            --SELECT * FROM calisanlar3  WHERE maas = (SELECT  MAX(maas) FROM calisanlar3);  ip ucu :7000 hariç

--calisanlar3 tablosunda max veya min maaşı alan çalışanların
-- tüm fieldlarını gösteriniz.

            SELECT * FROM calisanlar3  WHERE maas = (SELECT MAX(maas) FROM calisanlar3) OR maas= (SELECT MIN(maas) FROM calisanlar3);

--bunun birde IN ile cozumu var

-- Ankara'da calisani olan markalarin marka id'lerini ve calisan sayilarini listeleyiniz.

            SELECT marka_id,calisan_sayisi
    FROM markalar
    WHERE marka_isim IN('Pierre Cardin', 'Vakko', 'Adidas'  );

--2.yol  -- dinamik olan bu
    SELECT marka_id,calisan_sayisi
    FROM markalar
    WHERE marka_isim IN(SELECT isyeri FROM calisanlar3 WHERE sehir='Ankara' );


--marka_id'si 101’den büyük olan marka çalişanlarinin isim, maaş ve şehirlerini listeleyiniz.


    SELECT isim,maas,sehir
    FROM calisanlar3
    WHERE isyeri IN (SELECT marka_isim FROM markalar WHERE marka_id>101)

-- Çalisan sayisi 15.000’den cok olan markalarin isimlerini ve
--bu markada calisanlarin isimlerini ve maaşlarini listeleyiniz.
            SELECT isim,maas,isyeri
    FROM calisanlar3
    WHERE isyeri IN (SELECT marka_isim FROM markalar WHERE calisan_sayisi>15000)









--24-b-SUBQUERY: SELECT komutundan sonra kullanımı

-- Her markanin id'sini, ismini ve toplam kaç şehirde bulunduğunu listeleyen bir SORGU yaziniz.


    SELECT marka_id, marka_isim, (SELECT COUNT(DISTINCT(sehir))
    FROM calisanlar3
    WHERE isyeri=marka_isim) AS sehir_sayisi
    FROM markalar--correlated subquery

--SELECT DISTINCT(sehir) FROM calisanlar3;--sadece farklı olanları listeler

--view olusturma (goruntu olusturma)

    CREATE VIEW marka_sehir_sayisi AS
    SELECT marka_id, marka_isim, (SELECT COUNT(DISTINCT(sehir))
    FROM calisanlar3
    WHERE isyeri=marka_isim) AS sehir_sayisi
    FROM markalar

-- Her markanin ismini, calisan sayisini ve o markaya ait calisanlarin maksimum maaşini listeleyen bir Sorgu yaziniz.

    SELECT marka_isim,calisan_sayisi,(SELECT MAX(maas) FROM calisanlar3 WHERE isyeri=marka_isim) max_maas   -- bu max_maas gecici tablo ismi
    FROM markalar;

-- Her markanin ismini, calisan sayisini ve o markaya ait calisanlarin maksimum ve min maaşini listeleyen bir Sorgu yaziniz.

    SELECT marka_isim,calisan_sayisi,(SELECT MAX(maas) FROM calisanlar3 WHERE isyeri=marka_isim) max_maas,
            (SELECT MIN(maas) FROM calisanlar3 WHERE isyeri=marka_isim) min_maas   -- bu max_maas gecici tablo ismi
    FROM markalar;  --burada sutunları sıralıyoruz konus yazmıyoruz o yuzden AND ile baglayamayız



--25-EXISTS Cond.

            --Bir SQL sorgusunda alt sorgunun sonucunun boş olup olmadığını kontrol etmek için kullanılır.
--Eğer alt sorgu sonucu boş değilse, koşul sağlanmış sayılır ve sorgunun geri kalanı işletilir.
--Alt sorgu en az bir satır döndürürse sonucu EXISTS doğrudur.
            --Alt sorgunun satır döndürmemesi durumunda, sonuç EXISTS yanlıştır.


    CREATE TABLE mart
            (
                    urun_id int,
                    musteri_isim varchar(50),
    urun_isim varchar(50)
);

    INSERT INTO mart VALUES (10, 'Mark', 'Honda');
    INSERT INTO mart VALUES (20, 'John', 'Toyota');
    INSERT INTO mart VALUES (30, 'Amy', 'Ford');
    INSERT INTO mart VALUES (20, 'Mark', 'Toyota');
    INSERT INTO mart VALUES (10, 'Adam', 'Honda');
    INSERT INTO mart VALUES (40, 'John', 'Hyundai');
    INSERT INTO mart VALUES (20, 'Eddie', 'Toyota');

    CREATE TABLE nisan
            (
                    urun_id int ,
                    musteri_isim varchar(50),
    urun_isim varchar(50)
);

    INSERT INTO nisan VALUES (10, 'Hasan', 'Honda');
    INSERT INTO nisan VALUES (10, 'Kemal', 'Honda');
    INSERT INTO nisan VALUES (20, 'Ayse', 'Toyota');
    INSERT INTO nisan VALUES (50, 'Yasar', 'Volvo');
    INSERT INTO nisan VALUES (20, 'Mine', 'Toyota');

    select * from mart;
    select * from nisan;

--Mart ayında 'Toyota' satışı yapılmış ise Nisan ayındaki tüm ürünlerin bilgilerini listeleyiniz.

            SELECT *
    FROM nisan
    WHERE EXISTS (SELECT urun_isim FROM mart WHERE urun_isim='Toyota')

--Mart ayında 'Volvo' satışı yapılmış ise Nisan ayındaki tüm ürünlerin bilgilerini listeleyiniz.
            SELECT *
    FROM nisan
    WHERE EXISTS (SELECT urun_isim FROM mart WHERE urun_isim='Volvo')



--Mart ayında satılan ürünün urun_id ve musteri_isim'lerini, eğer Nisan ayında da satılmışsa, listeleyen bir sorgu yazınız.

    SELECT urun_id,musteri_isim
    FROM mart
    WHERE EXISTS (SELECT urun_isim FROM nisan WHERE nisan.urun_isim=mart.urun_isim);

--tablolar için alias kullanalım
    SELECT urun_id,musteri_isim
    FROM mart AS m
    WHERE EXISTS (SELECT urun_isim FROM nisan AS n WHERE n.urun_isim=m.urun_isim);


---Her iki ayda birden satılan ürünlerin URUN_ISIM'lerini ve bu ürünleri
            --NİSAN ayında satın alan MUSTERI_ISIM'lerini listeleyen bir sorgu yazınız

    SELECT urun_isim,musteri_isim
    FROM nisan n
    WHERE EXISTS (SELECT urun_isim FROM mart m WHERE m.urun_isim=n.urun_isim )


--Martta satılıp Nisanda satilmayan ürünlerin URUN_ISIM'lerini ve bu ürünleri
            --MART ayında satın alan MUSTERI_ISIM'lerini listeleyen bir sorgu yazınız.

    SELECT urun_isim,musteri_isim
    FROM mart m
    WHERE NOT EXISTS (SELECT urun_isim FROM nisan n WHERE n.urun_isim=m.urun_isim)

    CREATE TABLE ogrenciler (
            id INTEGER PRIMARY KEY,
            isim VARCHAR(50),
    adres VARCHAR(100),
    sinav_notu INTEGER
);

--veya

    CREATE TABLE ogrenciler (
            id INTEGER ,
            isim VARCHAR(50),
    adres VARCHAR(100),
    sinav_notu INTEGER
    CONSTRAINT std_pk PRIMARY KEY (id)
);


--2 PK olursa:
    CREATE TABLE ogrenciler (
            id INTEGER ,
            isim VARCHAR(50),
    adres VARCHAR(100),
    sinav_notu INTEGER
    CONSTRAINT std_pk2 PRIMARY KEY (id,isim)
);

/*

neden composite pk ya ihtiyac duyarız?
2023064120 gibi composite PK dusunelim. (ogrenci no)
2023 ogrenci kayıt yılı, 064 fakülte kodu , 120 ogrenci kayıt sırası


*/


    CREATE TABLE ogrenciler (
            id INTEGER ,
            isim VARCHAR(50),
    adres VARCHAR(100),
    sinav_notu INTEGER CHECK(sinav_notu>0 AND sinav_notu<100)
    CONSTRAINT std_pk2 PRIMARY KEY (id,isim)
);

--Tabloya veri ekleme
    INSERT INTO ogrenciler VALUES (1,'Ali Can','Istanbul',80);

    INSERT INTO ogrenciler(id,isim,adres,sinav_notu) VALUES
(2,'Zeki Bey','Izmir',90),
        (3,'Veli Can','Trabzon',65),
        (4, 'Mirac','Bursa',45),
        (5,'Yavuz Bal','Antalya',55);

    INSERT INTO ogrenciler(id,isim,sinav_notu) VALUES
(6,'Bilal Degirmen',95),
        (7,'Fahri Ersöz',92);

    SELECT * FROM ogrenciler;

-- SORU1: ogrenciler tablosundaki id ve isim bilgileri ile tum recordlari getirelim :
    SELECT id,isim FROM ogrenciler

-- SORU2: Sinav notu 80'den buyuk olan ogrencilerin tum bilgilerini listele
    SELECT * FROM ogrenciler WHERE sinav_notu>80;

-- SORU3: Adresi Ankara olan ogrencilerin tum bilgilerini listele
    SELECT * FROM ogrenciler WHERE adres='Ankara';

-- SORU4: Sinav notu 80 ve adresi Istanbul olan ogrenci ismini listele
    SELECT isim FROM ogrenciler WHERE adres='Istanbul' AND sinav_notu=80;

-- SORU5: Sinav notu 55 veya 100 olan ogrencilerin tum bilgilerini listele
    SELECT * FROM ogrenciler WHERE sinav_notu=55 OR sinav_notu=100;
    SELECT * FROM ogrenciler WHERE sinav_notu in (55,100);

-- SORU6: Sinav notu 65 ve 85 arasinda olan ogrencilerin tum bilgilerini listele
    SELECT * FROM ogrenciler WHERE sinav_notu between 65 and 85;

-- SORU7: id'si 3 ve 5 arasinda olmayan ogrencilerin isim ve sinav notu listele
    SELECT isim,sinav_notu FROM ogrenciler WHERE id not between 3 and 5;

-- SORU8: En yuksek sinav puani nedir
    SELECT MAX(sinav_notu) FROM ogrenciler;

-- SORU9: İzmir'de yaşayan ve sınav notu 50'den yuksek olan öğrencilerin listesi:
    SELECT * FROM ogrenciler WHERE adres='Izmir' AND sinav_notu>50;

-- SORU10: Öğrenci sayısı ve ortalama sınav notu:
    SELECT COUNT(*), AVG(sinav_notu) FROM ogrenciler;
    SELECT COUNT(*), ROUND(AVG(sinav_notu),1) FROM ogrenciler;

-- SORU11: sinav_notu 55 olan satiri siliniz
    DELETE FROM ogrenciler WHERE sinav_notu=55;
    SELECT * from ogrenciler;

-- SORU12: ismi Derya Soylu veya Cemal Dogan olan satirlari siliniz
    DELETE FROM ogrenciler WHERE isim='Derya Soylu' OR isim='Cemal Dogan';
    DELETE FROM ogrenciler WHERE isim IN('Derya Soylu','Cemal Dogan');

-- SORU13 : Ogrenciler tablosunn icerigini siliniz
    DELETE FROM ogrenciler;
    TRUNCATE TABLE ogrenciler

--SORU14 : Ogrenciler Tablosunu siliniz
    DROP TABLE ogrenciler














}
