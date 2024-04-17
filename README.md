# Javaの練習用リポジトリ 01

## 1. 実行環境
コマンド`java -version`によって確認。

```
java version "22" 2024-03-19
Java(TM) SE Runtime Environment (build 22+36-2370)
Java HotSpot(TM) 64-Bit Server VM (build 22+36-2370, mixed mode, sharing)
```
## 2. ファイル
- [ImageEditor2D.java](#ImageEditor2D)

### 2.1. <a id="ImageEditor2D"></a>ImageEditor2D.java
- `ImageEditor2D`(クラス)
	- `readImage`(メソッド)   
	画像ファイルの読み込み
	- `writeImage`(メソッド)  
	画像ファイルの保存
	- `resizeImage`(メソッド)  
	画像サイズ変更。横縦を指定
	- `scaleImage`(メソッド)
	画像の拡大/縮小。倍率または、縦/横(+ ption)を指定

