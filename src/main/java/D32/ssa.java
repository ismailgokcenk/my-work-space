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





------------------ DAY'3 DT-NT -------------------
            ------------------   tekrar ------------------

    CREATE TABLE calisanlar(
            id char(5) PRIMARY KEY, -- NOT NULL,UNIQUE demek. aynı zamanda bu sutun baska tablo ile ilişkilendirirken kullanılacak.
            isim varchar(50) UNIQUE,
    maas int NOT NULL,
    ise_baslama date
); --referenced table/parent table

    CREATE TABLE adresler(
            adres_id char(5),-- asagıda burayı FK yaptık. FK ler NULL olabilir,UNIQUE olmayabilir. DUPICATE olur
    sokak varchar(30),
    cadde varchar(30),
    sehir varchar(20),
    FOREIGN KEY(adres_id) REFERENCES calisanlar(id)
            );--child table


    INSERT INTO calisanlar VALUES('10002', 'Donatello' ,12000, '2018-04-14');
    INSERT INTO calisanlar VALUES('10003', null, 5000, '2018-04-14');
    INSERT INTO calisanlar VALUES('10004', 'Donatello', 5000, '2018-04-14'); --isim unique degil kabul etmez
    INSERT INTO calisanlar VALUES('10005', 'Michelangelo', 5000, '2018-04-14');
    INSERT INTO calisanlar VALUES('10006', 'Leonardo', null, '2019-04-12');
    INSERT INTO calisanlar VALUES('10007', 'Raphael', '', '2018-04-14');
    INSERT INTO calisanlar VALUES('', 'April', 2000, '2018-04-14');--emty null degıl o yuzden kabul eder
    INSERT INTO calisanlar VALUES('', 'Ms.April', 2000, '2018-04-14'); -- iki kez empty olmaz PK den oturu. PK den oturu UNIQUE olmalı
    INSERT INTO calisanlar VALUES('10002', 'Splinter' ,12000, '2018-04-14');--id UNİQUE olmalı kabul etmez
    INSERT INTO calisanlar VALUES( null, 'Fred' ,12000, '2018-04-14'); -- id PK oldugu ıcın not noll dır. bu yuzden kabul etmez
    INSERT INTO calisanlar VALUES('10008', 'Barnie' ,10000, '2018-04-14');
    INSERT INTO calisanlar VALUES('10009', 'Wilma' ,11000, '2018-04-14');
    INSERT INTO calisanlar VALUES('10010', 'Betty' ,12000, '2018-04-14');

    INSERT INTO adresler VALUES('10003','Ninja Sok', '40.Cad.','IST');
    INSERT INTO adresler VALUES('10003','Kaya Sok', '50.Cad.','Ankara');
    INSERT INTO adresler VALUES('10002','Taş Sok', '30.Cad.','Konya');

    INSERT INTO adresler VALUES('10012','Taş Sok', '30.Cad.','Konya');--10012 id li bir çalışan yok.


    INSERT INTO adresler VALUES(NULL,'Taş Sok', '23.Cad.','Konya');
    INSERT INTO adresler VALUES(NULL,'Taş Sok', '33.Cad.','Bursa');

    SELECT * FROM calisanlar;
    SELECT * FROM adresler;


--14-WHERE CONDITION(kosulu)
--calisanlar tablosundan ismi 'Donatello' olanların tüm bilgilerini listeleyelim
    SELECT * FROM calisanlar WHERE isim='Donatello';

--calisanlar tablosundan maası 5000den fazla olanların tüm bilgilerini listeleyelim
    SELECT * FROM calisanlar WHERE maas>5000;


--calisanlar tablosundan ismi 'Donatello' olanların isim ve maaslarını tüm bilgilerini listeleyelim

    SELECT isim,maas FROM calisanlar WHERE maas>5000;

--adresler tablosundan sehiri 'Konya' ve
--adres_id si 10002 olan tüm verileri getir

    SELECT * FROM adresler WHERE sehir = 'Konya' AND adres_id = '10002';


    SELECT cadde,sehir FROM adresler WHERE sehir = 'Konya' OR sehir='Bursa';


--15-DELETE FROM .. WHERE .. (WHERE İLE KONUS BELİRTİYORUZ)
            --bu komutumuz tablodan kosulu saglyan kayıtları siler-- DML kategorisinde yer alır

    CREATE TABLE ogrenciler1
            (
                    id int,
                    isim VARCHAR(50),
    veli_isim VARCHAR(50),
    yazili_notu int
);
    INSERT INTO ogrenciler1 VALUES(122, 'Kerem Can', 'Fatma',75);
    INSERT INTO ogrenciler1 VALUES(123, 'Ali Can', 'Hasan',75);
    INSERT INTO ogrenciler1 VALUES(124, 'Veli Han', 'Ayse',85);
    INSERT INTO ogrenciler1 VALUES(125, 'Kemal Tan', 'Hasan',85);
    INSERT INTO ogrenciler1 VALUES(126, 'Ahmet Ran', 'Ayse',95);
    INSERT INTO ogrenciler1 VALUES(127, 'Mustafa Bak', 'Can',99);
    INSERT INTO ogrenciler1 VALUES(128, 'Mustafa Bak', 'Ali', 99);
    INSERT INTO ogrenciler1 VALUES(129, 'Mehmet Bak', 'Alihan', 89);

    SELECT * FROM ogrenciler1;

--id=123 olan kaydı silelim
    DELETE FROM ogrenciler1 WHERE id=123;

--ismi Ahmet Ran veya Veli Han olan kayıtları silelim
    DELETE FROM ogrenciler1 WHERE isim='Ahmet Ran' OR isim='Veli Han';

--16-a- Tablodaki tüm kayıtları silme
--DELETE FROM students;  bu sekilde kosul belirtmezsek belirttiğimiz tablodaki tüm kayıtlar silinir

--16-b-Tablodaki tüm kayıtları silme : TRUNCATE TABLE ..

    SELECT * FROM doctors;

--doctors tablosundaki tüm kayıtları silelim.

    TRUNCATE TABLE doctors;

--DELETE FROM VE TRUNCATE TABLE nin farklı yok. DELETE FROM da kosul belirtebiliriz. Yani WHERE kullanabiliriz
--TRUNCATE TABLE da WHERE komutu kullanılamaz yani kosul belritemeyiz. Tümünü sileriz.


            --17-
    SELECT * FROM calisanlar; -- parent tablo
    SELECT * FROM adresler; -- child tablo

--calisanalr tablosundaki tüm kayıtları silelim

    DELETE FROM calisanlar; --calismaz. cunku calisanlar parent. bazı kayıtlar adresler tablosunda referans alındıgı ıcın
    DELETE FROM calisanlar WHERE id='10002';  --alttakini yapamdan calismaz. 10002 referanslı
    DELETE FROM  adresler WHERE adres_id='10002';

--adreslerdeki tüm kayıtları silmeden ilişkiyi koparamayız. O yüzden adresleri silmeden calisanlardaki kayıtları silemeyiz
    DELETE FROM adresler;
    DELETE FROM calisanlar;


--18-ON DELETE CASCADE:manuel olarak yaptıgımız kademelei silme islemini(bir onceki adımda) otomatik oalrak yapar

    CREATE TABLE talebeler
            (
                    id int primary key,
                    isim VARCHAR(50),
    veli_isim VARCHAR(50),
    yazili_notu int
);--parent

    CREATE TABLE notlar(
            talebe_id int,
            ders_adi varchar(30),
    yazili_notu int,
    CONSTRAINT notlar_fk FOREIGN KEY (talebe_id) REFERENCES talebeler(id) ON DELETE CASCADE
);--child

    INSERT INTO talebeler VALUES(122, 'Kerem Can', 'Fatma',75);
    INSERT INTO talebeler VALUES(123, 'Ali Can', 'Hasan',75);
    INSERT INTO talebeler VALUES(124, 'Veli Han', 'Ayse',85);
    INSERT INTO talebeler VALUES(125, 'Kemal Tan', 'Hasan',85);
    INSERT INTO talebeler VALUES(126, 'Ahmet Ran', 'Ayse',95);
    INSERT INTO talebeler VALUES(127, 'Mustafa Bak', 'Can',99);
    INSERT INTO talebeler VALUES(128, 'Mustafa Bak', 'Ali', 99);
    INSERT INTO talebeler VALUES(129, 'Mehmet Bak', 'Alihan', 89);

    INSERT INTO notlar VALUES ('123','kimya',75);
    INSERT INTO notlar VALUES ('124', 'fizik',65);
    INSERT INTO notlar VALUES ('125', 'tarih',90);
    INSERT INTO notlar VALUES ('126', 'Matematik',90);
    INSERT INTO notlar VALUES ('127', 'Matematik',90);
    INSERT INTO notlar VALUES (null, 'tarih',90);

    SELECT *FROM talebeler;
    SELECT *FROM notlar;

--notlar tablosundan id:123 (talebe id) olan kaydı silelim
    DELETE FROM notlar WHERE talebe_id=123; --sorun yok cunklu child olan tablodan silerşken sıkıntı  yok

--talebeler tablosundan id=126 olan kaydı silelim
--parent den referanslı kayıt silmek istediğimizde once child sonra parent den siliyorduk. yani kademelei yapıyorduk 17.adımda
--on delete cascade ozelliğini adres tablosundan aktif ettiğimiz icin once notlar tablosundan referanslı kaydı siler,
            --sonra parent dan referansı kaldırılan kaydı siler

    DELETE FROM talebeler WHERE id=126;  --tabloyu olustururken DELETE FROM talebeler WHERE id=126; calıstırmadıgım ıcın hat aldım


    DELETE FROM talebeler;--notlar tablosundan da sadece ref. olan kayıtları siler

--19-Tabloyu silme:tabloyu SCHEMAdan kaldırma
--sairler tablosunu silelim
    DROP TABLE sairler;--DDL
--talebeler tablosunu silelim
    DROP TABLE talebeler;--ilişki hala tanımlı old. için silmez
    DROP TABLE talebeler CASCADE;

--talebeler1 tablosunu silelim
    DROP TABLE IF EXISTS talebeler1;--hata almamak için

--20-IN CONDITION:liste içinde ise TRUE

    CREATE TABLE musteriler  (
            urun_id int,
            musteri_isim varchar(50),
    urun_isim varchar(50)
);
    INSERT INTO musteriler VALUES (10, 'Mark', 'Orange');
    INSERT INTO musteriler VALUES (10, 'Mark', 'Orange');
    INSERT INTO musteriler VALUES (20, 'John', 'Apple');
    INSERT INTO musteriler VALUES (30, 'Amy', 'Palm');
    INSERT INTO musteriler VALUES (20, 'Mark', 'Apple');
    INSERT INTO musteriler VALUES (10, 'Adem', 'Orange');
    INSERT INTO musteriler VALUES (40, 'John', 'Apricot');
    INSERT INTO musteriler VALUES (20, 'Eddie', 'Apple');

    SELECT * FROM musteriler;

--Müşteriler tablosundan ürün ismi 'Orange', 'Apple' veya 'Apricot' olan verileri listeleyiniz.
            SELECT *
    FROM musteriler
    WHERE urun_isim='Orange' OR urun_isim='Apple' OR urun_isim='Apricot';

--2.yol
    SELECT *
    FROM musteriler
    WHERE urun_isim IN ('Orange', 'Apple', 'Apricot')

--Müşteriler tablosundan ürün ismi 'Orange', 'Apple' ve 'Apricot' olmayan verileri listeleyiniz.

            SELECT *
    FROM musteriler
    WHERE urun_isim NOT IN ('Orange', 'Apple', 'Apricot');


--21-BETWEEN .. AND .. komutu

--Müşteriler tablosunda urun_id 20 ile 40(dahil) arasinda olan urunlerin tum bilgilerini listeleyiniz
    SELECT *
    FROM musteriler
    WHERE urun_id>=20 AND urun_id<=40;
--2.yol
    SELECT *
    FROM musteriler
    WHERE urun_id BETWEEN 20 AND 40;--20 ve 40 dahil

--Müşteriler tablosunda urun_id 20 den küçük veya 30(dahil değil) dan büyük olan urunlerin tum bilgilerini listeleyiniz
    SELECT *
    FROM musteriler
    WHERE urun_id<20 OR urun_id>30;

--2.yol
    SELECT *
    FROM musteriler
    WHERE urun_id NOT BETWEEN 20 AND 30;

--22-AGGREGATE Fonk.

    CREATE TABLE calisanlar3 (
            id int,
            isim VARCHAR(50),
    sehir VARCHAR(50),
    maas int,
    isyeri VARCHAR(20)
);

    INSERT INTO calisanlar3 VALUES(123456789, 'Ali Seker', 'Istanbul', 2500, 'Vakko');
    INSERT INTO calisanlar3 VALUES(234567890, 'Ayse Gul', 'Istanbul', 1500, 'LCWaikiki');
    INSERT INTO calisanlar3 VALUES(345678901, 'Veli Yilmaz', 'Ankara', 3000, 'Vakko');
    INSERT INTO calisanlar3 VALUES(456789012, 'Veli Yilmaz', 'Izmir', 1000, 'Pierre Cardin');
    INSERT INTO calisanlar3 VALUES(567890123, 'Veli Yilmaz', 'Ankara', 7000, 'Adidas');
    INSERT INTO calisanlar3 VALUES(456789012, 'Ayse Gul', 'Ankara', 1500, 'Pierre Cardin');
    INSERT INTO calisanlar3 VALUES(123456710, 'Fatma Yasa', 'Bursa', 2500, 'Vakko');

    CREATE TABLE markalar
            (
                    marka_id int,
                    marka_isim VARCHAR(20),
    calisan_sayisi int
);

    INSERT INTO markalar VALUES(100, 'Vakko', 12000);
    INSERT INTO markalar VALUES(101, 'Pierre Cardin', 18000);
    INSERT INTO markalar VALUES(102, 'Adidas', 10000);
    INSERT INTO markalar VALUES(103, 'LCWaikiki', 21000);

    SELECT * FROM markalar;
    SELECT * FROM calisanlar3;

--calisanlar3 tablosunda max maaşı görüntüleyiniz
    SELECT MAX(maas) FROM calisanlar3;
--calisanlar3 tablosunda min maaşı görüntüleyiniz
    SELECT MIN(maas) FROM calisanlar3;
--calisanlar3 tablosunda toplam maaşı görüntüleyiniz
    SELECT SUM(maas) FROM calisanlar3;
--calisanlar3 tablosunda ortalama maaşı görüntüleyiniz
    SELECT AVG(maas) FROM calisanlar3;
    SELECT ROUND(AVG(maas),2) FROM calisanlar3;
--calisanlar3 tablosundaki kayıt sayısını görüntüleyiniz
    SELECT COUNT(*) FROM calisanlar3;
    SELECT COUNT(maas) FROM calisanlar3;

--calisanlar3 tablosundaki maaşı 2500 olanların sayısını görüntüleyiniz
    SELECT COUNT(maas) FROM calisanlar3 WHERE maas=2500;














}
