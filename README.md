# ChatAndTabManager
Этот плагин поможет вам в лёгком создании чата и таба для вашего сервера Minecraft.
- [Начало работы с плагином](#Установка)
- [Конфиг плагина и его параметры](#Конфигурация)
## Установка
Плагин разрабатывается в интегрированной среде разработки, а название ей ꟷ [IntelliJ IDEA](https://jetbrains.com/idea/).

TODO: Добавить поддержку PermissionsEx и PlaceholderAPI

Инструкции по IDE:
* [Конфигурация артефакта](https://www.jetbrains.com/help/idea/working-with-artifacts.html#configure_artifact)
## Конфигурация
Изначальный вид конфигурационного файла:
```yaml
playerTabFormat: '{player_nickname}'
joinMessage: '&7{player_nickname} &6зашел на сервер.'
leaveMessage: '&7{player_nickname} &6вышел с сервера.'
joinNotificationsDefault: true
joinNotificationsEnabled: true
leaveNotificationsDefault: true
leaveNotificationsEnabled: true
chat: '&7{player_nickname}&f: {player_message}'
globalChat: '&6[G] &7{player_nickname}&f: {player_message}'
localChat: '&9[L] &7{player_nickname}&f: {player_message}'
ifNoOneHeardTheMessage: '&cВаше сообщение никто не услышал'
globalPrefix: '!'
localRadius: 100
isGlobalEnabled: true
isChatClickable: false
clickableType: 1
clickableValue: /msg {player_nickname}
isChatHover: true
hoverMessage: |-
  &7{player_nickname}
  &9Уровень: &6{player_level}
  &9Смертей: &6{player_deaths}
```

Основные переменные в конфиге:
* `{player_nickname}` - ник игрока
* `{player_message}` - сообщение, которое написал игрок

Теперь-же пройдёмся по строкам:
* `playerTabFormat` - строка, формат отображения игрока в табе, устанавливается при заходе на сервер
* `joinMessage` - строка, формат сообщения о заходе игрока на сервер
* `leaveMessage` - строка, формат сообщения о выходе игрока с сервер
* `joinNotificationsDefault` - логическое выражение. **Примечание: если значение равно `true`, то каждый зашедший игрок будет отображаться в чате**
* `joinNotificationsEnabled` - логическое выражение. **Примечание: если значение равно `false`, то при заходе будет вывод стандартного сообщения о входе**
* `leaveNotificationsDefault` - логическое выражение. **Примечание: если значение равно `true`, то каждый вышедший игрок будет отображаться в чате**
* `leaveNotificationsEnabled` - логическое выражение. **Примечание: если значение равно `false`, то при выходе будет вывод стандартного сообщения о выходе**
* `chat` - строка, формат сообщения при отправке в чат. **Примечание: если значение `isGlobalEnabled` равно `true`, то чат будет форматироваться по значению этого параметра**
* `globalChat` - строка, формат сообщения при отправке в глобальный чат. **Примечание: работает, если значение `isGlobalEnabled` равно `true`, и перед сообщением стоит установленный вами `globalPrefix`**
* `localChat` - строка, формат сообщения при отправке в локальный чат. **Примечание: работает, если значение `isGlobalEnabled` равно `true`, перед сообщением не стоит установленный вами `globalPrefix`, и если в установленном вами радиусе `localRadius` есть хоть два игрока**
* `ifNoOneHeardTheMessage` - строка. **Примечание: отправляется игроку, если в установленном вами радиусе `localRadius` нет ни одного игрока**
* `globalPrefix` - строка, префикс перед сообщением для отправки в глобальный чат
* `localRadius` - целое число
* `isGlobalEnabled` - логическое выражение. **Примечание: если параметр равен `false`, будет использовано форматирование `chat`**
* `isChatClickable` - логическое выражение. **Примечание: если параметр равен `true`, при нажатии на сообщение будет выполнена команда/ссылка**
* `clickableType` - целое число, имеет 3 типа:
  * `RUN_COMMAND` - выполняет строку как команду из `clickableValue`
  * `OPEN_FILE` - выполняет переход по ссылке как файл из `clickableValue`
  * `OPEN_URL` - выполняет переход по ссылке из `clickableValue`
* `isChatHover` - логическое выражение. **Примечание: если параметр равен `true`, при наведении на сообщение будет всплывающее окно с вашим текстом, взятый из `hoverMessage`**
