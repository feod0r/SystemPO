# Системное ПО

Лабораторные работы 1-5 студента группы ИКБО-04-15 Лебедева Фёдора.

# Пример выполнения кода программы
исходные данных
```sh
a = 100 + 200 - 300; b = a + 100; _set items; _put items 10;
```
вывод
```sh
VAR a
ASSIGN_OP =
NUM 100
OP +
NUM 200
OP -
NUM 300
END ;
VAR b
ASSIGN_OP =
VAR a
OP +
NUM 100
END ;
MYST _set
VAR items
END ;
MYST _put
VAR items
NUM 10
END ;
Выражение завершено
Выражение завершено
мое выражение завершено
мое выражение завершено
Все проверки пройдены
0 VAR a
1 ASSIGN_OP =
2 NUM 100
3 NUM 200
4 OP +
5 NUM 300
6 OP -
7 VAR b
8 ASSIGN_OP =
9 VAR a
10 NUM 100
11 OP +
12 MYST _set
13 VAR items
14 END ;
15 MYST _put
16 VAR items
17 NUM 10
18 END ;


a 0.0
b 100.0
items HashSet{n=20, hashset=[Bucket{bucket=m_l_list{first=Link{data2=10.0, nextLink=null}}}, Bucket{bucket=m_l_list{first=null}}, Bucket{bucket=m_l_list{first=null}}, Bucket{bucket=m_l_list{first=null}}, Bucket{bucket=m_l_list{first=null}}, Bucket{bucket=m_l_list{first=null}}, Bucket{bucket=m_l_list{first=null}}, Bucket{bucket=m_l_list{first=null}}, Bucket{bucket=m_l_list{first=null}}, Bucket{bucket=m_l_list{first=null}}, Bucket{bucket=m_l_list{first=null}}, Bucket{bucket=m_l_list{first=null}}, Bucket{bucket=m_l_list{first=null}}, Bucket{bucket=m_l_list{first=null}}, Bucket{bucket=m_l_list{first=null}}, Bucket{bucket=m_l_list{first=null}}, Bucket{bucket=m_l_list{first=null}}, Bucket{bucket=m_l_list{first=null}}, Bucket{bucket=m_l_list{first=null}}, Bucket{bucket=m_l_list{first=null}}]}

```

### Todos

 - Написать больше тестов
 - Добавить темную тему
