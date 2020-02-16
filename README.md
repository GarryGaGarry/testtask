testtask
=========================
Для запуска тестов требуется:

Java
https://www.java.com/

Maven for mac os
```shell
brew install maven
```

Для запуска тестов используйте

```shell
mvn test
```

Существуют параметры:

logLevel -  Уровень логирования. Значения: ALL/DEBUG/INFO/WARN/ERROR/FATAL/OFF. По умолчанию: ALL

browser - Браузер для прогона автотестов. Значения: chrome/ie/firefox/safari/htmlunits/phantomjs/opera. По умолчанию: chrome.
Для использование браузера у вас должен быть драйвер для него

browserSize - Размеры для окна браузера. По умолчанию: 1280x1024

url - Юрл для тестирования. По умолчанию: https://mail.ru

Параметры задаются таким образом:

```shell
mvn test -D logLevel=info -D browserSize=960x800
```