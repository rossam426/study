[回答]と記載のある箇所へ、1〜10の各課題内容に沿ったSQL文を記述しなさい。

-- 1. 商品テーブルから価格が20000円以上の商品の商品コードと商品名、価格を取得して下さい。
SELECT goods_code,goods_name,price FROM goods_table WHERE price >=20000;

-- 2. 店舗情報を店舗名のABC順に抽出して下さい。
SELECT * FROM store_table ORDER BY store_nameAbc ASC;

-- 3. 在庫テーブルに店舗テーブル、商品テーブルを「内部結合」し、店舗名・商品名・在庫数をすべて取得して下さい。
SELECT sr.store_name, g.goods_name, sc.quantity 
FROM stock_table sc 
JOIN store_table sr ON sc.store_code = sr.store_code
JOIN goods_table g ON sc.goods_code = g.goods_code;

-- 4. 商品テーブルから全商品の価格の平均値を抽出して下さい。
SELECT AVG(price) FROM goods_table;

-- 5. 店舗コード（'EA03'）の店舗に関連する在庫情報（商品コード、在庫数）を取得して下さい。
SELECT goods_code,quantity FROM stock_table WHERE store_code = 'EA03';

-- 6. 商品テーブルに「商品コード='M001'、商品名='マフラー'、価格=4500円、更新日付=本日日付」のデータを追加して下さい。
INSERT INTO goods_table
VALUES('M001','マフラー',4500,'2025-10-01');

-- 7. 店舗テーブルに下記の3つのデータを同時に追加して下さい。
「店舗コード='EA09'、店舗名='新宿店'、店舗名(アルファベット)='SHINJUKUTEN'、更新日='2012-08-01'」
「店舗コード='WE03'、店舗名='梅田店'、店舗名(アルファベット)='UMEDETEN'、更新日='2013-02-01'」
「店舗コード='WE04'、店舗名='福岡店'、店舗名(アルファベット)='FUKUOKATEN'、更新日='2014-05-01'」
----------- 【回答】------------
INSERT INTO store_table
VALUES
('EA09','新宿店','SHINJUKUTEN','2012-08-01'),
('WE03','梅田店','UMEDETEN','2013-02-01'),
('WE04','福岡店','FUKUOKATEN','2014-05-01');

-- 8. 在庫テーブルの在庫数が20以上の商品の在庫数を50に更新して下さい。
UPDATE stock_table 
SET quantity=50
WHERE quantity >= 20;

-- 9. 在庫テーブルの商品（'S987'）かつ、店舗（'EA01'）の在庫数を10増やす更新を行って下さい。
UPDATE stock_table
SET quantity = quantity + 10
WHERE goods_code ='S987' AND store_code = 'EA01';

-- 10. 商品コード（'Z939'）かつ、店舗コード（'EA04'）に関連する在庫情報を在庫テーブルから削除して下さい。
DELETE FROM stock_table
WHERE goods_code = 'Z939' AND store_code = 'EA04';