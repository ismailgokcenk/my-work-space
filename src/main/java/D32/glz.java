package D32;

public class glz {

    --------------DAY'7---------------------
            --JOINS--BİRLEŞTİRME
--JOIN:ilişkili tablolarda ortak bir sütun baz alınarak(tipik olarak PK ve FK)
--bir veya daha fazla tablodaki sütunların birleştirilmesini sağlar.


    CREATE TABLE sirketler(
            sirket_id int,
            sirket_isim varchar(20)
);
    INSERT INTO sirketler VALUES(100, 'IBM');
    INSERT INTO sirketler VALUES(101, 'GOOGLE');
    INSERT INTO sirketler VALUES(102, 'MICROSOFT');
    INSERT INTO sirketler VALUES(103, 'APPLE');

    SELECT * FROM sirketler;

    CREATE TABLE siparis(
            siparis_id int,
            sirket_id int,
            siparis_tarihi date
    );
    INSERT INTO siparis VALUES(11, 101, ' 2023-02-17');
    INSERT INTO siparis VALUES(22, 102, ' 2023-02-18');
    INSERT INTO siparis VALUES(33, 103, ' 2023-01-19');
    INSERT INTO siparis VALUES(44, 104, ' 2023-01-20');
    INSERT INTO siparis VALUES(55, 105, ' 2022-12-21');

    SELECT * FROM siparis;




--33-INNER JOIN:baz aldığımız sütundaki sadece ortak değerleri gösterir.

--iki tablodaki şirket id'si aynı olanların şirket id,şirket ismi,
            --sipariş tarihini,sipariş idsini  listeleyiniz.


    SELECT sirketler.sirket_id,sirket_isim,siparis_id,siparis_tarihi
    FROM sirketler
    INNER JOIN siparis
    ON sirketler.sirket_id=siparis.sirket_id

    SELECT sirketler.sirket_id,sirket_isim,siparis_id,siparis_tarihi
    FROM siparis
    INNER JOIN sirketler
    ON sirketler.sirket_id=siparis.sirket_id

--NOT:INNER JOIN ile tablolardaki ortak kayıtlar birleştiği için tablo sırası farketmez.




--34-LEFT JOIN:Sol tablodaki(ilk tablodaki) tüm verileri getirir.
            --RIGHT JOIN:Sağ tablodaki(ikinci tablodaki) tüm verileri getirir.


            --sadece şirketler tablosundaki tüm kayıtların şirket id,şirket ismi,
--sipariş tarihini,sipariş idsini  listeleyiniz.

    SELECT sirketler.sirket_id,sirket_isim,siparis_id,siparis_tarihi
    FROM sirketler LEFT JOIN siparis   --SAGDA KALAN RİGHT TABLE, SOLDA KALAN LEFT TABLE
    ON sirketler.sirket_id=siparis.sirket_id



--35-FULL JOIN:iki tablodaki baz alınan sütundaki tüm kayıtları getirir.

    SELECT sirketler.sirket_id AS sirketler_id,sirket_isim,
    siparis.sirket_id AS siparis_sirket_id,siparis_id,siparis_tarihi
    FROM siparis FULL JOIN sirketler
    ON sirketler.sirket_id=siparis.sirket_id



--36-SELF JOIN : tablonun kendi içindeki bir sütunu baz alarak INNER JOIN yapılmasını sağlar.

    CREATE TABLE personeller  (
            id int,
            isim varchar(20),
    title varchar(60),
    yonetici_id int
);
    INSERT INTO personeller VALUES(1, 'Ali Can', 'SDET',     2);
    INSERT INTO personeller VALUES(2, 'Veli Cem', 'QA',      3);
    INSERT INTO personeller VALUES(3, 'Ayse Gul', 'QA Lead', 4);
    INSERT INTO personeller VALUES(4, 'Fatma Can', 'CEO',    null);

    SELECT * FROM personeller;



--herbir personelin ismi ile birlikte yöneticisinin ismini de veren bir sorgu oluşturunuz.

    SELECT p.isim AS personel,m.isim AS yonetici
    FROM personeller p
    INNER JOIN personeller m
    ON p.yonetici_id=m.id




--37-LIKE Cond.:WHERE komutu ile kullanılır,
--Sorgular belirli bir karakter dizisini(desen-pattern) kullanarak filtreleme yapmamızı sağlar
--ILIKE:LIKE gibi ancak CASE INSENSITIVE dir.


    CREATE TABLE words
            (
                    word_id int UNIQUE,
                    word varchar(50) NOT NULL,
    number_of_letters int
);

    INSERT INTO words VALUES (1001, 'hot', 3);
    INSERT INTO words VALUES (1002, 'hat', 3);
    INSERT INTO words VALUES (1003, 'Hit', 3);
    INSERT INTO words VALUES (1004, 'hbt', 3);
    INSERT INTO words VALUES (1008, 'hct', 3);
    INSERT INTO words VALUES (1005, 'adem', 4);
    INSERT INTO words VALUES (1006, 'selim', 6);
    INSERT INTO words VALUES (1007, 'yusuf', 5);
    INSERT INTO words VALUES (1009, 'hAt', 3);
    INSERT INTO words VALUES (1010, 'yaf', 5);
    INSERT INTO words VALUES (1011, 'ahata', 3);

    SELECT * FROM words;


    SELECT *
    FROM words
    WHERE word LIKE '%t'



            --37-REGEXP_LIKE(~):belirli bir karakter desenini içeren dataları regex
--kullanarak filtrelememizi sağlar


--[] : içerisindeki  harflerden en az birini temsil eder

--words tablosu çalışalım
--h harfinden sonra a veya i harfini sonra ise t harfini
--içeren kelimelerin tum bilgilerini yazdiran QUERY yaziniz.


            SELECT *
    FROM words
    WHERE word ~ 'h[ai]t'--hat,hit

    SELECT *
    FROM words
    WHERE word ~* 'h[ai]t'--hat,hit INSENSITIVE

--küçük/büyük harf hassasiyeti olmasın:~*

            --[-]:iki harf arasındaki harflerden birini temsil eder

--h harfinden sonra, a ile k arasindaki harflerden birini, sonra da t harfini
-- içeren kelimelerin tum bilgilerini  yazdiran QUERY yaziniz.

            SELECT *
    FROM words
    WHERE word ~* 'h[a-k]t'--hat,hbt,hct

-- Icinde m veya i olan kelimelerin tum bilgilerini yazdiran QUERY yazin

    SELECT *
    FROM words
    WHERE word ~* '[mi]'

            --^:başlangıcı gösterir, $:bitişi gösterir
--a ile baslayan kelimelerin tum bilgilerini yazdiran QUERY yazin

    SELECT *
    FROM words
    WHERE word ~* '^a'


            --a veya s ile baslayan kelimelerin tum bilgilerini yazdiran QUERY yazin

    SELECT *
    FROM words
    WHERE word ~* '^[as]'

            --m biten kelimelerin tum bilgilerini yazdiran QUERY yazin

    SELECT *
    FROM words
    WHERE word ~* 'm$'

            -- (.*)-->0 veya daha fazla karakteri temsil eder
--   . -->sadece 1 karakteri temsil eder

--y ile başlayıp f ile biten kelimelerin tum bilgilerini yazdiran QUERY yazin

    SELECT *
    FROM words
    WHERE word ~* '^y.*f$'--yf

    SELECT *
    FROM words
    WHERE word ~* '^y(.*)f$'--yf

--y ile başlayıp f ile biten 3 harfli kelimelerin tum bilgilerini yazdiran QUERY yazin

    SELECT *
    FROM words
    WHERE word ~* '^y.f$'

            --NOT LIKE:verilen karakter desenine benzemeyenleri filtreler
-- !~     :verilen karakter desenine benzemeyenleri filtreler

-- ilk harfi h veya H olmayan kelimelerin tum bilgilerini yazdiran QUERY yaziniz.

    SELECT *
    FROM words
    WHERE word NOT ILIKE 'h%'

    SELECT *
    FROM words
    WHERE word !~* '^h'

            --2. harfi e,i veya o olmayan kelimelerin tum bilgilerini yazdiran QUERY yazin.ÖDEV





}
