delete from review where book_id in (select id from book where isbn = '978-8491879565 #TEST');
delete from review where book_id in (select id from book where isbn = '978-8445012796 #TEST');
delete from review where book_id in (select id from book where isbn = '978-8435064057 #TEST');
delete from review where book_id in (select id from book where isbn = '978-8411312486 #TEST');
delete from review where book_id in (select id from book where isbn = '978-8467948530 #TEST');

delete from book where isbn = '978-8491879565 #TEST';
delete from book where isbn = '978-8445012796 #TEST';
delete from book where isbn = '978-8435064057 #TEST';
delete from book where isbn = '978-8411312486 #TEST';
delete from book where isbn = '978-8467948530 #TEST';

INSERT INTO book (author, cover, isbn, name, published)
	values ('Pierce Brown', 'https://m.media-amazon.com/images/I/61Xtkbld+6L.jpg', '978-8491879565 #TEST', 'Amanecer rojo 2. Hijo dorado', '20220217');
INSERT INTO review (author, created, book_id, description)
	values ('Fernando Arévalo', '20230116', (select id from book where isbn = '978-8491879565 #TEST'),
        'Al final del libro predecesor, Darrow terminó la primera etapa de suformación de manera victoriosa, en una posición privilegiada que lepermitiría acercarse al Archigobernador de Marte, el mismo hombreresponsable de la muerte de su esposa. Sin embargo, para llegar a ese punto,tuvo que hacer enemigos poderosos. Dos años después, las circunstanciascambian y Darrow está a punto de perder su status ante la posibilidadde ser vendido. Por lo tanto, su vida corre peligro ante aquellos quebuscan venganza, pues no desaprovecharán la oportunidad deeliminarlo.');
INSERT INTO book (author, cover, isbn, name, published)
	values ('J. R. R. Tolkien', 'https://m.media-amazon.com/images/I/91wA4QqjNDL.jpg', '978-8445012796 #TEST', 'El Silmarillion', '19770915');
INSERT INTO review (author, created, book_id, description)
	values ('Fernando Arévalo', '20221221', (select id from book where isbn = '978-8445012796 #TEST'),
        'El mundo de John Ronald Reuel Tolkien es tan conocido y se ha hablado tanto de su obra que es difícil añadir algo nuevo. Prácticamente todo el mundo conoce algo de su legendarium y su impacto cultural fue tan fuerte, en parte por las películas de hace 20 años, que es poco probable encontrar a alguien que no haya oído hablar de Frodo, Aragorn o Gandalf. Sin embargo, en ese reconocimiento universal a la grandeza de lo escrito por Tolkien hay una grieta para mucha gente. Y es que El Silmarillion (1977), publicado y editado por su hijo Christopher después de su fallecimiento, es rechazado por algunos por su dificultad o es tildado de aburrido. Me lo he releído después de muchos años y más que una reseña voy a hacer una defensa de este libro, ya que la historia es bastante conocida.');
INSERT INTO book (author, cover, isbn, name, published)
	values ('Ander Terrones Arellano', 'https://m.media-amazon.com/images/I/81sKLsews4L.jpg', '978-8435064057 #TEST', 'La hija del loto', '20221012');
INSERT INTO review (author, created, book_id, description)
	values ('Raquel San Martín Rodriguez', '20221229', (select id from book where isbn = '978-8435064057 #TEST'),
        'Cae la tarde. Los cerezos ya han florecido. Todos buscan en el clan del cerezo a la pequeña Tomoe, pero ésta ha sido raptada por el señor de Sakura, renace ya en el clan de la montaña. Bajo la tutela de su maestro Kigei, su futuro se anuncia claro como una noche estrellada. Haruki será su sombra, atraerá sobre sí todas las desgracias que el destino tenga reservado a su señora y la seguirá en la muerte; Shioda, heredero de la Montaña, su esposo. Y ella, bajo el férreo código de honor feudal, se convertirá en el mejor samurái del imperio del sol naciente. Pero, cuando la rivalidad entre clanes estalla, la batalla de Sekigahara pondrá fin no sólo a la paz, también a sus sueños. Y, entonces, el amor no correspondido, la soledad, el odio, el sentido del deber y una marca que le señala el rostro la abocarán a cumplir un extraño designio escrito en las estrellas mucho antes de su nacimiento.');
INSERT INTO book (author, cover, isbn, name, published)
	values ('Leslie G', 'https://m.media-amazon.com/images/I/61Xtkbld+6L.jpg', '978-8411312486 #TEST', 'Erawol: La última leyenda', '20221115');
INSERT INTO review (author, created, book_id, description)
	values ('Ander Terrones Arellano', '20230102', (select id from book where isbn = '978-8411312486 #TEST'),
        'Leslie G. es una autora cubana afincada en Brasil nacida en 1982. Seguidora de la literatura fantástica, comenzó su particular construcción de universo con la saga “Leyendas del bosque azul”. “Erawol: La última leyenda” (2022) es el cierre de esta historia, a la que se puede acceder sin conocimiento previo de los tomos anteriores pues es una historia autónoma ambientada en el mismo mundo: Erawol.');
INSERT INTO book (author, cover, isbn, name, published)
	values ('Filipe Melo / Juan Cavia', 'https://m.media-amazon.com/images/I/81QKQ6xHSSL.jpg', '978-8467948530 #TEST', 'Balada para Sophie', '20221101');
INSERT INTO review (author, created, book_id, description)
	values ('Beatriz Mabbut', '20230113', (select id from book where isbn = '978-8467948530 #TEST'),
        'Hoy os recomiendo Balada para Sophie, una novela gráfica que llegó a mis manos de una manera curiosa. Resulta que estudio portugués desde hace algún tiempo y fue precisamente en clase donde nos hablaron de un club de lectura en el que se leían y comentaban obras en la lengua lusa. En su momento no me atreví a unirme porque consideré que no tenía el nivel necesario, pero resultó que en ese momento el libro seleccionado era este cómic y pensé que podría echarle un tiento. Tuvo que prestármelo una compañera ya que ni siquiera estaba disponible en nuestro país. Todavía a día de hoy le estoy agradecida, porque que me encantó.');
