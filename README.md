VibrationTest01
====
画面中央に表示されている線をこするとスマホが振動するだけのアプリ。

スマホの振動モータを使った振動にはタイムラグがあり、
それがどの程度触覚に影響するかを考察するために作成。

Google Play Store
  * https://play.google.com/store/apps/details?id=net.sabamiso.android.vibrationtest01

メモ
----
タイムラグが生じる原因はどこにあるか？
  * タッチパネルのセンシング速度
  * mouseMoveイベントがプログラムに届くまでの遅れ
  * プログラム内での処理
  * 振動子が振動を出力するまでの遅れ

振動子について
  * 振動モータを使う場合は、停止状態から回転数が上がるまでの間にディレイが生じる
    * 数十～数百ms の時間遅れが生じるらしい(※1)
  * リニア振動アクチュエータは応答性に優れているらしい (※1)
      * 動作原理はスピーカーに近い？
      * http://akizukidenshi.com/catalog/g/gP-06838/
  * 制御に音声を使う場合は、音声バッファ分ディレイが生じる？
    * http://tactilelabs.com/products/haptics/haptuator-mark-ii-v2/
    * ASIOを利用すると改善するとか？
      * http://ja.wikipedia.org/wiki/ASIO

参考
  *※1 http://kaji-lab.jp/ja/index.php?plugin=attach&pcmd=open&file=EC2014_Projection-basedWholeBodyTactileDisplay.pdf&refer=uematsu



